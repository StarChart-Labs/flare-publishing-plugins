/*
 * Copyright (C) 2017 The StarChart-Labs@github.com Authors
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */
package org.starchartlabs.flare.publishing.plugin

import java.util.concurrent.Callable

import org.gradle.api.Action
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.internal.file.FileOperations
import org.gradle.api.tasks.Sync
import org.gradle.internal.reflect.Instantiator
import org.starchartlabs.flare.publishing.model.DockerContainerSpec
import org.starchartlabs.flare.publishing.task.ContainerBuildTask
import org.starchartlabs.flare.publishing.task.ContainerCleanTask

/**
 * Configuration plug-in which adds assembly and build tasks for defined docker containers
 *
 * @author romeara
 * @since 0.2.0
 */
public class DockerBuildPlugin implements Plugin<Project> {

    private final Instantiator instantiator

    private final FileOperations fileOperations

    @Override
    public void apply(Project project) {
        project.apply plugin: 'org.starchartlabs.flare.docker-base'

        Task assembleAllTask = project.getTasks().create('assembleContainer');
        Task buildAllTask = project.getTasks().create('buildContainer');
        Task cleanAllTask = project.getTasks().create('cleanContainer');

        assembleAllTask.group = 'Build'
        assembleAllTask.description = 'Assemble files for building all images specified in the containers DSL'

        buildAllTask.group = 'Build'
        buildAllTask.description = 'Generates container images specified in the containers DSL'

        cleanAllTask.group = 'Build'
        cleanAllTask.description = 'Removes container images specified in the containers DSL'

        project.containers.all({
            Task assembleTask = configureAssembleTask(project, it)
            Task buildTask = configureBuildTask(project, it)
            Task cleanTask = configureCleanTask(project, it)

            buildTask.dependsOn assembleTask

            assembleAllTask.dependsOn assembleTask
            buildAllTask.dependsOn buildTask
            cleanAllTask.dependsOn cleanTask
        } as Action)

        // When the base plug-in is applied, attach to the assemble and clean tasks
        project.pluginManager.withPlugin('base', {plugin ->
            project.tasks.assemble.dependsOn assembleAllTask
            project.tasks.clean.dependsOn cleanAllTask
        });
    }

    /**
     * Sets up a task which will assemble various resources into a build directory that a docker container may be constructed from
     * @param project The project the task is being added to
     * @param container Data structure describing the container the task will assemble for later building
     * @return The created task for assembling resources for construction of a docker container
     */
    private Task configureAssembleTask(Project project, DockerContainerSpec container){
        Sync installTask = project.getTasks().create("assemble${container.name.capitalize()}Container", Sync.class);
        installTask.with(container.getContents());
        installTask.into({ return container.getPath() } as Callable);

        installTask.group = 'Build'
        installTask.description = "Assembles files for use with docker build to generate an image from the ${container.name} specification"

        return installTask
    }

    /**
     * Sets up a task which will run the "docker build" command within a directory assembled to contain various resources for inclusion in the container
     * @param project The project the task is being added to
     * @param container Data structure describing the container the task will build
     * @return The created task for building a docker container
     */
    private Task configureBuildTask(Project project, DockerContainerSpec container){
        ContainerBuildTask buildTask = project.getTasks().create("build${container.name.capitalize()}Container", ContainerBuildTask.class);
        buildTask.container = container

        return buildTask
    }

    /**
     * Sets up a task which will run the "docker rmi" command to remove a built container
     * @param project The project the task is being added to
     * @param container Data structure describing the container the task will remove
     * @return The created task for removing a docker container
     */
    private Task configureCleanTask(Project project, DockerContainerSpec container){
        ContainerCleanTask cleanTask = project.getTasks().create("clean${container.name.capitalize()}Container", ContainerCleanTask.class);
        cleanTask.container = container

        return cleanTask
    }

}
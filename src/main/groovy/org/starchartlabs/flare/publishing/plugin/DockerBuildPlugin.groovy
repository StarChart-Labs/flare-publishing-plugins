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

        project.containers.all({
            Task assembleTask = configureAssembleTask(project, it)
            Task buildTask = configureBuildTask(project, it)

            buildTask.dependsOn assembleTask

            assembleAllTask.dependsOn assembleTask
            buildAllTask.dependsOn buildTask
        } as Action)
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

        return installTask
    }

    /**
     * Sets up a task which will run the "docker build" command within a directory assembled to contain various resources for incluion in the container
     * @param project The project the task is being added to
     * @param container Data structure describing the container the task will build
     * @return The created task for building a docker container
     */
    private Task configureBuildTask(Project project, DockerContainerSpec container){
        ContainerBuildTask buildTask = project.getTasks().create("build${container.name.capitalize()}Container", ContainerBuildTask.class);
        buildTask.container = container

        return buildTask
    }
}
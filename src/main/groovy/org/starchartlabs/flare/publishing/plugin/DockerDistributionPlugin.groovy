/*
 * Copyright (C) 2017 The StarChart-Labs@github.com Authors
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */
package org.starchartlabs.flare.publishing.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.distribution.Distribution
import org.starchartlabs.flare.publishing.task.DockerBuildTask

//TODO romeara sanity tests, use doc
/**
 * Plug-in which integrates creation of a docker container into the Gradle distribution pattern
 *
 * <p>
 * Follow conventions established by the <a href="https://docs.gradle.org/current/userguide/distribution_plugin.html">Distribution plug-in</a>
 *
 * @author romeara
 * @since 0.2.0
 */
public class DockerDistributionPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        //distribution: Provides configuration for distributions and parent task
        project.apply plugin: 'distribution'

        // Setup distDocker and make the assemble task depend on it. Naming conventions come from the distribution plug-in
        project.distributions.forEach{ dist -> configureDistribution(project, dist) }

        //Make sure any distributions configured after this plug-in is applied are handled consistently
        project.distributions.whenObjectAdded{ dist -> configureDistribution(project, dist) }
    }

    private void configureDistribution(Project project, Distribution dist){
        String distName = null
        Task assembleTask = null
        Task installTask = null

        if(dist.name == 'main'){
            distName = 'distDocker'
            assembleTask = project.getTasks().findByName('assembleDist')
            installTask = project.getTasks().findByName('installDist')
        }else{
            distName = "${dist.name}DistDocker"
            assembleTask = project.getTasks().findByName("assemble${dist.name.capitalize()}Dist")
            installTask = project.getTasks().findByName("install${distribution.name.capitalize()}Dist")
        }

        DockerBuildTask distTask = project.getTasks().create("${distName}", DockerBuildTask.class);
        distTask.configure{
            dependsOn installTask
            dockerPath project.file("${project.buildDir}/install/${dist.name}")
        }

        assembleTask.dependsOn distTask
    }
}
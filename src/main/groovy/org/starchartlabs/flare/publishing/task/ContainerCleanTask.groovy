/*
 * Copyright (C) 2017 The StarChart-Labs@github.com Authors
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */
package org.starchartlabs.flare.publishing.task

import org.gradle.api.tasks.Exec
import org.starchartlabs.flare.publishing.model.DockerContainerSpec

/**
 * Task configured to run a <a href="https://docs.docker.com/engine/reference/commandline/build/">docker rmi command</a> on a specified directory
 *
 * @author romeara
 * @since 0.3.0
 */
@SuppressWarnings("unchecked")
public class ContainerCleanTask extends Exec {

    private DockerContainerSpec container

    public ContainerCleanTask(){
        super()

        configure{
            group = 'Build'
            description = 'Runs docker rmi to remove an image'

            executable 'docker'

            ignoreExitValue true

            doLast {
                if(execResult.exitValue == 0) {
                    project.logger.lifecycle("Removed image ${container.baseName}:${project.version}")
                } else {
                    project.logger.lifecycle("No existing image ${container.baseName}:${project.version} to remove (${execResult.exitValue})")
                }
            }
        }
    }

    public void setContainer(DockerContainerSpec container){
        this.container = container

        if(container != null) {
            description = "Runs docker rmi to remove an image described by the ${container.name} specification"
        }
    }

    public DockerContainerSpec getContainer(){
        return container
    }

    protected void exec(){
        List<String> currentArgs = getArgs()
        currentArgs.add(0, 'rmi')
        currentArgs.add('-f')
        currentArgs.add("${container.baseName}:${project.version}")

        setArgs(currentArgs)

        logger.lifecycle("Command: ${executable}")
        logger.lifecycle("Arguments: ${args}")

        super.exec()
    }
}
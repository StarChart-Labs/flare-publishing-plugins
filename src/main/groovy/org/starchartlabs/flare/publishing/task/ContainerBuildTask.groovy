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
 * Task configured to run a <a href="https://docs.docker.com/engine/reference/commandline/build/">docker build command</a> on a specified directory
 *
 * @author romeara
 * @since 0.2.0
 */
@SuppressWarnings("unchecked")
public class ContainerBuildTask extends Exec {

    private DockerContainerSpec container

    public ContainerBuildTask(){
        super()

        configure{ executable 'docker' }
    }

    public void setContainer(DockerContainerSpec container){
        this.container = container
    }

    public File getContainer(){
        return container
    }

    protected void exec(){
        List<String> currentArgs = getArgs()
        currentArgs.add(0, 'build')
        currentArgs.add("--tag=${container.baseName}:${project.version}")
        currentArgs.add("${container.path}")

        setArgs(currentArgs)

        logger.lifecycle("Command: ${executable}")
        logger.lifecycle("Arguments: ${args}")

        super.exec()
    }
}
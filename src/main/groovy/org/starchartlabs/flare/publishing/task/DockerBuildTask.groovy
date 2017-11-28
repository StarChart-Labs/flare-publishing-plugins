/*
 * Copyright (C) 2017 The StarChart-Labs@github.com Authors
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */
package org.starchartlabs.flare.publishing.task

import org.gradle.api.tasks.Exec

/**
 * Task configured to run a <a href="https://docs.docker.com/engine/reference/commandline/build/">docker build command</a> on a specified directory
 *
 * @author romeara
 * @since 0.2.0
 */
@SuppressWarnings("unchecked")
public class DockerBuildTask extends Exec {

    private File dockerPath

    public DockerBuildTask(){
        super()

        configure{ executable 'docker' }
    }

    public void setDockerPath(File dockerPath){
        this.dockerPath = dockerPath
    }

    public File getDockerPath(){
        return dockerPath
    }

    protected void exec(){
        configure {
            args.add(0, 'build')
            args.add(args.size - 1, "${dockerPath.absolutePath}")
        }

        super.exec()
    }
}
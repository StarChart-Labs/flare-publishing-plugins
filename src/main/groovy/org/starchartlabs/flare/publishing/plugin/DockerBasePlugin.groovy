/*
 * Copyright (C) 2017 The StarChart-Labs@github.com Authors
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */
package org.starchartlabs.flare.publishing.plugin

import javax.inject.Inject

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.internal.reflect.Instantiator
import org.starchartlabs.flare.publishing.model.DockerContainerSpec

/**
 * Configuration plug-in that adds structures for defining docker containers to be assembled from artifacts and resources within a project
 *
 * @author romeara
 * @since 0.2.0
 */
public class DockerBasePlugin implements Plugin<Project> {

    private final Instantiator instantiator

    @Inject
    public DockerBasePlugin(Instantiator instantiator) {
        this.instantiator = instantiator
    }

    @Override
    public void apply(Project project) {
        def containers = project.container(DockerContainerSpec.class, { name ->
            return new DockerContainerSpec(name, project)
        })

        project.extensions.add('containers', containers)
    }
}
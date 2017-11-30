/*
 * Copyright (C) 2017 The StarChart-Labs@github.com Authors
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */
package org.starchartlabs.flare.publishing.model

import org.gradle.api.Project
import org.gradle.api.internal.AbstractNamedDomainObjectContainer
import org.gradle.api.internal.file.FileOperations
import org.gradle.internal.reflect.Instantiator

/**
 * Container for docker container specification(s) within a project
 *
 * @author romeara
 * @since 0.2.0
 */
public class DockerContainerSpecContainer extends AbstractNamedDomainObjectContainer<DockerContainerSpec> {

    private final FileOperations fileOperations

    private final Project project

    public DockerContainerSpecContainer(Class<DockerContainerSpec> type, Instantiator instantiator, FileOperations fileOperations, Project project) {
        super(type, instantiator)
        this.fileOperations = fileOperations
        this.project = project
    }

    @Override
    protected DockerContainerSpec doCreate(String name) {
        return getInstantiator().newInstance(DockerContainerSpec.class, name, fileOperations.copySpec(), project)
    }
}
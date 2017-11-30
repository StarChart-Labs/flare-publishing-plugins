/*
 * Copyright (C) 2017 The StarChart-Labs@github.com Authors
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */
package org.starchartlabs.flare.publishing.model

import org.gradle.api.Action
import org.gradle.api.Named
import org.gradle.api.Project
import org.gradle.api.file.CopySpec

/**
 * Data structure describing resources to make available for a single docker container's construction
 *
 * @author romeara
 * @since 0.2.0
 */
public class DockerContainerSpec implements Named {

    private final String name

    private final CopySpec contents

    private String baseName

    private File path

    public DockerContainerSpec(String name, CopySpec contents, Project project){
        this.name = name
        this.baseName = "${project.name}/${name}"
        this.contents = contents
        this.path = new File(project.getBuildDir(), "containers/${name}")
    }

    @Override
    public String getName() {
        return name;
    }

    /**
     * @return The name to apply as the generated container's tag, without version information
     * @since 0.2.0
     */
    public String getBaseName() {
        return baseName;
    }

    /**
     * @param baseName The name to apply as the generated container's tag, without version information
     * @since 0.2.0
     */
    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    /**
     * @return The directory to build the container in/from. Defaults to ${buildDir}/containers/${container.name}
     * @since 0.2.0
     */
    public File getPath() {
        return path;
    }

    /**
     * @param path The directory to build the container in/from. Defaults to ${buildDir}/containers/${container.name}
     * @since 0.2.0
     */
    public void setPath(File path) {
        this.path = path;
    }

    /**
     * @return The specification of files/resources to include in available resources for docker container construction
     * @since 0.2.0
     */
    public CopySpec getContents(){
        return contents
    }

    /**
     * @param action Operation to apply to the copy specification that defines files/resources to include in docker container construction
     * @return The configured copy specification
     * @since 0.2.0
     */
    public CopySpec contents(Action<? super CopySpec> action){
        action.execute(contents)
        return contents
    }
}
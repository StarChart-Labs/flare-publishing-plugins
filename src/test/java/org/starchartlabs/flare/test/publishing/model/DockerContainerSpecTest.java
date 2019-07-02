/*
 * Copyright (c) Nov 29, 2017 StarChart Labs Authors.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    romeara - initial API and implementation and/or initial documentation
 */
package org.starchartlabs.flare.test.publishing.model;

import java.io.File;

import org.gradle.api.Project;
import org.gradle.testfixtures.ProjectBuilder;
import org.starchartlabs.flare.publishing.model.DockerContainerSpec;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DockerContainerSpecTest {

    private Project project;

    @BeforeClass
    public void setupProject() {
        project = ProjectBuilder.builder().build();
    }

    @Test
    public void construct() throws Exception {
        DockerContainerSpec result = new DockerContainerSpec("name", project);

        Assert.assertEquals(result.getName(), "name");
        Assert.assertEquals(result.getBaseName(), project.getName() + "/name");
        Assert.assertNotNull(result.getContents());
        Assert.assertEquals(result.getPath(), new File(project.getBuildDir(), "containers/name"));
    }

}

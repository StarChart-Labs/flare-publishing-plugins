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
package org.starchartlabs.flare.test.publishing.plugin;

import org.gradle.api.Project;
import org.gradle.api.Task;
import org.gradle.testfixtures.ProjectBuilder;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DockerBuildPluginTest {

    private static final String PLUGIN_ID = "org.starchartlabs.flare.docker-build";

    private Project project;

    @BeforeClass
    public void setupProject() {
        project = ProjectBuilder.builder().build();
        project.getPluginManager().apply(PLUGIN_ID);
    }

    @Test
    public void dockerBasePluginApplied() throws Exception {
        Assert.assertTrue(project.getPluginManager().hasPlugin("org.starchartlabs.flare.docker-base"));
    }

    @Test
    public void assembleContainerTaskAdded() throws Exception {
        Task task = project.getTasks().getByName("assembleContainer");
        Assert.assertNotNull(task);
    }

    @Test
    public void buildContainerTaskAdded() throws Exception {
        Task task = project.getTasks().getByName("buildContainer");
        Assert.assertNotNull(task);
    }

    @Test
    public void cleanContainerTaskAdded() throws Exception {
        Task task = project.getTasks().getByName("cleanContainer");
        Assert.assertNotNull(task);
    }

}

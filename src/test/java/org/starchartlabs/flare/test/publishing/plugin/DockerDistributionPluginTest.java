/*
 * Copyright (c) Jun 27, 2017 Corona IDE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    "romeara" - initial API and implementation and/or initial documentation
 */
package org.starchartlabs.flare.test.publishing.plugin;

import org.gradle.api.Project;
import org.gradle.api.Task;
import org.gradle.testfixtures.ProjectBuilder;
import org.starchartlabs.flare.publishing.task.DockerBuildTask;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DockerDistributionPluginTest {

    private static final String PLUGIN_ID = "org.starchartlabs.flare.docker-distribution";

    private Project project;

    @BeforeClass
    public void setupProject() {
        project = ProjectBuilder.builder().build();
        project.getPluginManager().apply(PLUGIN_ID);
    }

    @Test
    public void distributionPluginApplied() throws Exception {
        Assert.assertTrue(project.getPluginManager().hasPlugin("distribution"));
    }

    @Test
    public void distDockerTaskAdded() throws Exception {
        Task task = project.getTasks().getByName("distDocker");
        Assert.assertTrue(task instanceof DockerBuildTask);

        Task installTask = project.getTasks().getByName("installDist");

        Assert.assertTrue(task.getDependsOn().contains(installTask));
    }

    @Test
    public void assembleDistDependsOnDockerDist() throws Exception {
        Task assembleTask = project.getTasks().getByName("assembleDist");
        Task task = project.getTasks().getByName("distDocker");

        Assert.assertTrue(assembleTask.getDependsOn().contains(task));
    }

}

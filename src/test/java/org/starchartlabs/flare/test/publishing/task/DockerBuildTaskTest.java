/*
 * Copyright (c) Nov 27, 2017 StarChart Labs Authors.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    romeara - initial API and implementation and/or initial documentation
 */
package org.starchartlabs.flare.test.publishing.task;

import org.gradle.api.Project;
import org.gradle.testfixtures.ProjectBuilder;
import org.starchartlabs.flare.publishing.task.DockerBuildTask;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DockerBuildTaskTest {

    @Test
    public void configure() throws Exception {
        Project project = ProjectBuilder.builder().build();
        DockerBuildTask task = project.getTasks().create("dockerBuildTest", DockerBuildTask.class);

        Assert.assertEquals(task.getExecutable(), "docker");
    }

}

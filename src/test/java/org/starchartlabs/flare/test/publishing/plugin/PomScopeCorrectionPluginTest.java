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
import org.gradle.testfixtures.ProjectBuilder;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PomScopeCorrectionPluginTest {

    private static final String PLUGIN_ID = "org.starchartlabs.flare.pom-scope-correction";

    private Project project;

    @BeforeClass
    public void setupProject() {
        project = ProjectBuilder.builder().build();
        project.getPluginManager().apply(PLUGIN_ID);
    }

    @Test
    public void mavenPublishPluginApplied() throws Exception {
        Assert.assertTrue(project.getPluginManager().hasPlugin("maven-publish"));
    }

}

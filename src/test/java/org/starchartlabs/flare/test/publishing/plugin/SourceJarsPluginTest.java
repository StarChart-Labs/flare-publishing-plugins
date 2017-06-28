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

import java.util.ArrayList;
import java.util.Collection;

import org.gradle.api.Project;
import org.gradle.api.Task;
import org.gradle.api.tasks.bundling.Jar;
import org.gradle.testfixtures.ProjectBuilder;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SourceJarsPluginTest {

    private static final String PLUGIN_ID = "org.starchartlabs.flare.source-jars";

    private Project project;

    @BeforeClass
    public void setupProject() {
        project = ProjectBuilder.builder().build();
        project.getPluginManager().apply(PLUGIN_ID);
    }

    @Test
    public void javaPluginApplied() throws Exception {
        Assert.assertTrue(project.getPluginManager().hasPlugin("java"));
    }

    @Test
    public void sourceJarTaskAdded() throws Exception {
        Task task = project.getTasks().getByName("sourcesJar");
        Assert.assertTrue(task instanceof Jar);

        Jar jarTask = (Jar) task;

        Assert.assertEquals(jarTask.getClassifier(), "sources");

        Task classesTask = project.getTasks().getByName("classes");

        Assert.assertTrue(task.getDependsOn().contains(classesTask));
    }

    @Test
    public void javadocJatTaskAdded() throws Exception {
        Task task = project.getTasks().getByName("javadocJar");
        Assert.assertTrue(task instanceof Jar);

        Jar jarTask = (Jar) task;

        Assert.assertEquals(jarTask.getClassifier(), "javadoc");

        Task javadocTask = project.getTasks().getByName("javadoc");

        Assert.assertTrue(task.getDependsOn().contains(javadocTask));
    }

    @Test
    public void jarsAddedToArtifacts() throws Exception {
        Collection<String> archives = new ArrayList<>();
        project.getConfigurations().findByName("archives").getAllArtifacts()
        .forEach(input -> archives
                        .add(input.getType() + ":" + input.getClassifier()));

        Assert.assertEquals(archives.size(), 3);
        Assert.assertTrue(archives.contains("jar:"));
        Assert.assertTrue(archives.contains("jar:sources"));
        Assert.assertTrue(archives.contains("jar:javadoc"));

        archives.forEach(input -> System.out.println(input));
    }

}

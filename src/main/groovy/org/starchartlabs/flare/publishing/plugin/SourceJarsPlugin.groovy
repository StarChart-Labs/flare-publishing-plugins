package org.starchartlabs.flare.publishing.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.bundling.Jar

/**
 * Plug-in which adds Jar tasks which contain the source code and JavaDoc of the project
 *
 * @author romeara
 * @since 0.1.0
 */
public class SourceJarsPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        //java: Provides jar task, dependent tasks
        project.apply plugin: 'java'

        Jar sourcesJarTask = project.getTasks().create('sourcesJar', Jar.class);
        Jar javadocJarTask = project.getTasks().create('javadocJar', Jar.class);

        sourcesJarTask.configure{
            classifier = 'sources'
            from project.sourceSets.main.allSource
            dependsOn project.tasks.classes
        }

        javadocJarTask.configure{
            classifier = 'javadoc'
            from project.javadoc.destinationDir
            dependsOn project.tasks.javadoc
        }

        project.artifacts {
            archives sourcesJarTask
            archives javadocJarTask
        }
    }
}
package org.starchartlabs.flare.publishing.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.publish.maven.MavenPublication

/**
 * Plug-in which modifies MavenPublication instances to add sources and JavaDoc artifacts
 *
 * @author romeara
 * @since 0.1.0
 */
public class PomSourceJarArtifactsPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        //maven-publish: Provides publishing configuration
        //org.starchartlabs.flare.source-jars: add default source and javaDoc jar tasks
        project.apply plugin: 'maven-publish'
        project.apply plugin: 'org.starchartlabs.flare.source-jars'

        //Find all MavenPublications, and add a correction to compile dependencies to be of compile scope
        project.publishing{
            publications.withType(MavenPublication.class).all{ pub -> addArtifacts(project, pub) }
        }
    }

    /**
     * Updates a publication to have sources/JavaDoc artifacts
     * @param project The project the plug-in is being applied to
     * @param pub Representation of the MavenPublication being processed
     */
    private void addArtifacts(Project project, MavenPublication pub){
        pub.artifact project.tasks.sourcesJar { classifier 'sources' }
        pub.artifact project.tasks.javadocJar { classifier 'javadoc' }
    }

}
package org.starchartlabs.flare.publishing.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Plug-in which applies behavior for the generated MavenPublication POM and artifacts
 *
 * @author romeara
 * @since 0.1.0
 */
public class PublishedProjectPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        //org.starchartlabs.flare.source-jars: Adds sourcesJar and javadocJar tasks
        //org.starchartlabs.flare.published-info-base: Applies publishedInfo extension
        //org.starchartlabs.flare.pom-scope-correction: Fixes scope of compile configuration dependencies
        //org.starchartlabs.flare.pom-source-jar-artifacts: Adds source and javadoc jar artifacts to publication
        //org.starchartlabs.flare.pom-published-info: Adds info from publishedInfo to POM
        project.apply plugin: 'org.starchartlabs.flare.source-jars'
        project.apply plugin: 'org.starchartlabs.flare.published-info-base'
        project.apply plugin: 'org.starchartlabs.flare.pom-scope-correction'
        project.apply plugin: 'org.starchartlabs.flare.pom-source-jar-artifacts'
        project.apply plugin: 'org.starchartlabs.flare.pom-published-info'
    }
}
package org.starchartlabs.flare.publishing.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.publish.maven.MavenPublication

/**
 * Plug-in which modifies MavenPublication instances with a fix that sets compile-configuration dependencies to the "compile" Maven scope
 *
 * @author romeara
 * @since 0.1.0
 */
public class PomScopeCorrectionPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        //maven-publish: Provides publishing configuration
        project.apply plugin: 'maven-publish'

        //Find all MavenPublications, and add a correction to compile dependencies to be of compile scope
        project.publishing{
            publications.withType(MavenPublication.class).all{ pub ->
                pub.pom.withXml {
                    project.configurations.compile.resolvedConfiguration.firstLevelModuleDependencies.each { dep ->
                        asNode().dependencies[0].dependency.find {
                            it.artifactId[0].text() == dep.moduleName && it.groupId[0].text() == dep.moduleGroup
                        }?.scope[0]?.value = 'compile'
                    }

                    project.logger.info("Applying compile configuration correction to maven publication '${pub.name}'")
                }
            }
        }
    }

}
/*
 * Copyright (C) 2017 The StarChart-Labs@github.com Authors
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */
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
        // GH-31: Warn of deprecation and eventual removal
        project.logger.lifecycle("WARNING: org.starchartlabs.flare.pom-scope-correction is deprecated as of Gradle 5.0, as are the associated nebula plug-ins. It is recommended to switch to Gradle's built-in dependency contraint system")

        //maven-publish: Provides publishing configuration
        project.apply plugin: 'maven-publish'

        //Find all MavenPublications, and add a correction to compile dependencies to be of compile scope
        project.publishing{
            publications.withType(MavenPublication.class).all{ pub -> updateScope(project, pub) }
        }
    }

    /**
     * Updates the scope of any compile class path dependencies to the Maven compile scope
     * @param project The project the plug-in is being applied to
     * @param pub Representation of the MavenPublication being processed
     */
    private void updateScope(Project project, MavenPublication pub){
        pub.pom.withXml {
            project.configurations.compile.resolvedConfiguration.firstLevelModuleDependencies.each { dep ->
                if(asNode().dependencies[0] != null) {
                    asNode().dependencies[0].dependency.find {
                        it.artifactId[0].text() == dep.moduleName && it.groupId[0].text() == dep.moduleGroup
                    }?.scope[0]?.value = 'compile'
                }
            }

            project.logger.info("Applying compile configuration correction to maven publication '${pub.name}'")
        }
    }

}
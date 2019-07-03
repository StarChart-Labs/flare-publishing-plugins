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
import org.starchartlabs.flare.publishing.model.PublishedInfo

/**
 * Plug-in which modifies MavenPublication instances to add information from the publishedInfo configuration extension
 *
 * @author romeara
 * @since 0.1.0
 */
public class PomPublishedInfoPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        //maven-publish: Provides publishing configuration
        //org.starchartlabs.flare.published-info-base: Applies publishedInfo extension
        project.apply plugin: 'maven-publish'
        project.apply plugin: 'org.starchartlabs.flare.published-info-base'

        PublishedInfo publishedInfo = project.extensions.publishedInfo

        //Find all MavenPublications, and add a correction to compile dependencies to be of compile scope
        project.publishing{
            publications.withType(MavenPublication.class).all{ pub ->
                addProjectInfo(project, publishedInfo, pub)
                addScmInfo(project, publishedInfo, pub)
                addLicenseInfo(project, publishedInfo, pub)
                addDeveloperInfo(project, publishedInfo, pub)
            }
        }
    }

    /**
     * Adds project information to the generated POM
     * @param project The project the plug-in is being applied to
     * @param info The published information to apply project information from
     * @param pub The publication the project information is being added to
     */
    private void addProjectInfo(Project project, PublishedInfo info, MavenPublication pub){
        if(info.url != null){
            pub.pom{ url = "${info.url}" }
        }
    }

    /**
     * Adds scm information to the generated POM
     * @param project The project the plug-in is being applied to
     * @param info The published information to apply scm information from
     * @param pub The publication the scm information is being added to
     */
    private void addScmInfo(Project project, PublishedInfo info, MavenPublication pub){
        if(info.scm.url != null || info.scm.connection != null || info.scm.developerConnection != null){
            pub.pom{
                scm {
                    if(info.scm.connection != null){
                        connection = "${info.scm.connection}"
                    }

                    if(info.scm.developerConnection != null){
                        developerConnection = "${info.scm.developerConnection}"
                    }
                    if(info.scm.url != null){
                        url = "${info.scm.url}"
                    }
                }
            }
        }
    }

    /**
     * Adds license information to the generated POM
     * @param project The project the plug-in is being applied to
     * @param info The published information to apply license information from
     * @param pub The publication the license information is being added to
     */
    private void addLicenseInfo(Project project, PublishedInfo info, MavenPublication pub){
        if(!info.licenses.isEmpty()){
            pub.pom{
                licenses {
                    info.licenses.each { lic ->
                        license {
                            name = "${lic.name}"
                            url = "${lic.url}"
                            distribution = "${lic.distribution}"
                        }
                    }
                }
            }
        }
    }

    /**
     * Adds developer information to the generated POM
     * @param project The project the plug-in is being applied to
     * @param info The published information to apply developer information from
     * @param pub The publication the developer information is being added to
     */
    private void addDeveloperInfo(Project project, PublishedInfo info, MavenPublication pub){
        if(!info.developers.isEmpty()){
            pub.pom{
                developers {
                    info.developers.each{ dev ->
                        developer {
                            id = "${dev.id}"
                            name = "${dev.name}"
                            email = "${dev.url}"
                        }
                    }
                }
            }
        }
    }

}
package org.starchartlabs.flare.publishing.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.starchartlabs.flare.publishing.model.PublishedInfo

/**
 * Applies configuration to a project to specify publication information
 *
 * @author romeara
 * @since 0.1.0
 */
public class PublishedInfoBasePlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        project.extensions.create('publishedInfo', PublishedInfo)
    }
}
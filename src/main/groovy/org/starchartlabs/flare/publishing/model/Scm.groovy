/*
 * Copyright (C) 2017 The StarChart-Labs@github.com Authors
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */
package org.starchartlabs.flare.publishing.model

/**
 * Information about thesoruce control used for the project, as per the
 * <a href="https://maven.apache.org/ref/3.0.4/maven-model/maven.html#class_scm">Maven POM scm spec</a>
 *
 * @author romeara
 * @since 0.1.0
 */
public class Scm {

    private String url

    private String connection

    private String developerConnection

    /**
     * Configures this Scm instance via the provided closure
     * @param closure Closure with configuration operations for the scm. Applied to this Scm instance
     * @return This (updated) scm instance
     * @since 0.1.0
     */
    public Scm configure(@DelegatesTo(Scm) Closure closure){
        closure.delegate = this
        closure()

        return this
    }

    /**
     * Configures SCM fields based on GitHub conventions
     *
     * <p>
     * The url is set to the project's GitHub address, the connection is set to the project's "git" repository location,
     * and the developerConnection is set to the repository's "ssh" repository location
     *
     * @param owner The Organization or User which owns the repository
     * @param repo The name of the repository on GitHub
     * @since 0.1.0
     */
    public void github(String owner, String repo){
        url = "https://github.com/${owner}/${repo}"
        connection = "scm:git:git://github.com/${owner}/${repo}.git"
        developerConnection = "scm:git:ssh://github.com/${owner}/${repo}.git"
    }

    /**
     * @return The URL to the project's browsable SCM repository
     * @since 0.1.0
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url The URL to the project's browsable SCM repository
     * @since 0.1.0
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return The source control management system URL that describes the repository and how to connect to the repository
     * @since 0.1.0
     */
    public String getConnection() {
        return connection;
    }

    /**
     * @param connection The source control management system URL that describes the repository and how to connect to the repository
     * @since 0.1.0
     */
    public void setConnection(String connection) {
        this.connection = connection;
    }

    /**
     * @return Just like connection, but for developers, i.e. this scm connection will not be read only.
     * @since 0.1.0
     */
    public String getDeveloperConnection() {
        return developerConnection;
    }

    /**
     * @param developerConnection Just like connection, but for developers, i.e. this scm connection will not be read only.
     * @since 0.1.0
     */
    public void setDeveloperConnection(String developerConnection) {
        this.developerConnection = developerConnection;
    }
}
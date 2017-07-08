/*
 * Copyright (C) 2017 The StarChart-Labs@github.com Authors
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */
package org.starchartlabs.flare.publishing.model

/**
 * Represents a collection of developers who are the primary contacts for a project
 *
 * <p>
 * Based on <a href="https://maven.apache.org/pom.html#Developers">Maven POM's developers section<a>
 *
 * @author romeara
 * @since 0.1.0
 */
public class DeveloperContainer {

    private Collection<Developer> developers

    /**
     * Constructs a new, empty developer container
     * @since 0.1.0
     */
    public DeveloperContainer(){
        developers = new ArrayList<>()
    }

    /**
     * Configures this developer container via closure
     * @param closure Operations to apply to the container
     * @return This updated developer container
     * @since 0.1.0
     */
    public DeveloperContainer configure(@DelegatesTo(DeveloperContainer) Closure closure){
        closure.delegate = this
        closure()

        return this
    }

    /**
     * @return All the developers configured against the project
     * @since 0.1.0
     */
    public Collection<Developer> getDevelopers(){
        return developers
    }

    /**
     * @param developers The collection of developers for the project
     * @since 0.1.0
     */
    public void setDevelopers(Collection<Developer> developers){
        this.developers = developers
    }

    /**
     * Adds a developer
     * @param id The unique ID of the developer in the SCM
     * @param name The full name of the contributor
     * @param url The URL for the homepage of the contributor
     * @since 0.1.0
     */
    public void developer(String id, String name, String url){
        developers.add(new Developer(id, name, url))
    }

    /**
     * Adds a developer
     * @param closure Closure to configure a {@link Developer} instance
     * @since 0.1.0
     */
    public void developer(Closure closure){
        developers.add(new Developer().configure(closure))
    }

    /**
     * Adds a developer configured using the convention of a user on GitHub (url will be their GitHub page based on the
     * provided ID)
     *
     * @param id The developer's GitHub ID
     * @param name The developer's full name
     * @since 0.1.0
     */
    public void github(String id, String name){
        developers.add(new Developer(id, name, "https://github.com/${id}"))
    }

    /**
     * Adds a developer configured using the convention of a user on GitHub (url will be their GitHub page based on the
     * provided ID)
     *
     * @param closure Closure to configure a {@link Developer} instance - if url is not set, GitHub url convention is used
     * @since 0.1.0
     */
    public void github(@DelegatesTo(Developer) Closure closure){
        Developer developer = new Developer()
        developer.configure(closure)

        if(developer.id != null && developer.url == null){
            developer.url = "https://github.com/${developer.id}"
        }

        developers.add(developer)
    }
}
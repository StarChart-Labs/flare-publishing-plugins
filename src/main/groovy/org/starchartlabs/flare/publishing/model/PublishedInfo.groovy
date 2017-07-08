/*
 * Copyright (C) 2017 The StarChart-Labs@github.com Authors
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */
package org.starchartlabs.flare.publishing.model

/**
 * Represents information which is intended to be made publicly visible in publications of the project
 *
 * @author romeara
 * @since 0.1.0
 */
public class PublishedInfo {

    private String url

    private Scm scm

    private LicenseContainer licenses

    private DeveloperContainer developers

    /**
     * Creates an empty instance of published information
     * @since 0.1.0
     */
    public PublishedInfo(){
        scm = new Scm()
        licenses = new LicenseContainer()
        developers = new DeveloperContainer()
    }

    /**
     * @return The homepage for the project
     * @since 0.1.0
     */
    public String getUrl(){
        return url
    }

    /**
     * @param url The homepage for the project
     * @since 0.1.0
     */
    public void setUrl(String url){
        this.url = url
    }

    /**
     * @return Information on the source control utilized by the project
     */
    public Scm getScm(){
        return scm
    }

    /**
     * Configures SCM information via closure
     * @param closure The closure to apply to the {@link Scm} information for the project
     * @since 0.1.0
     */
    public void scm(@DelegatesTo(Scm) Closure closure){
        scm.configure(closure)
    }

    /**
     * @return A collection of the licenses a user may utilize the project under
     * @since 0.1.0
     */
    public Collection<License> getLicenses(){
        return licenses.licenses
    }

    /**
     * Applies a closure to configure the licenses represented in the published information
     * @param closure The closure to apply to the managing {@link LicenseContainer} to configure the license list
     * @since 0.1.0
     */
    public void licenses(@DelegatesTo(LicenseContainer) Closure closure){
        licenses.configure(closure)
    }

    /**
     * @return A collection of the developers (primary contacts) for the project
     * @since 0.1.0
     */
    public Collection<Developer> getDevelopers(){
        return developers.developers
    }

    /**
     * Applies a closure to configure the developers represented in the published information
     * @param closure The closure to apply to the managing {@link DeveloperContainer} to configure the developer list
     * @since 0.1.0
     */
    public void developers(@DelegatesTo(DeveloperContainer) Closure closure){
        developers.configure(closure)
    }
}
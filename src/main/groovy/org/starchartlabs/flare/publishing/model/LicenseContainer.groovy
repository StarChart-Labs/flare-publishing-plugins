/*
 * Copyright (C) 2017 The StarChart-Labs@github.com Authors
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 */
package org.starchartlabs.flare.publishing.model

/**
 * Represents a collection of licenses which the project may be used under
 *
 * <p>
 * Based on <a href="https://maven.apache.org/pom.html#Licenses">Maven POM's developers section<a>
 *
 * @author romeara
 * @since 0.1.0
 */
public class LicenseContainer {

    private Collection<License> licenses

    /**
     * Constructs a new, empty license container
     * @since 0.1.0
     */
    public LicenseContainer(){
        licenses = new ArrayList<>()
    }

    /**
     * Configures this license container via closure
     * @param closure Operations to apply to the container
     * @return This updated license container
     * @since 0.1.0
     */
    public LicenseContainer configure(@DelegatesTo(LicenseContainer) Closure closure){
        closure.delegate = this
        closure()

        return this
    }

    /**
     * @return The collection of licenses for the project
     * @since 0.1.0
     */
    public Collection<License> getLicenses(){
        return licenses
    }

    /**
     * @param licenses The collection of licenses for the project
     * @since 0.1.0
     */
    public void setLicenses(Collection<License> licenses){
        this.licenses = licenses
    }

    /**
     * Adds a license to the project
     * @param name The full legal name of the license
     * @param tag Shorthand used to reference the license. (ex: "MIT" for The MIT License)
     * @param url The official url for the license text
     * @param distribution The primary method by which this project may be distributed. "repo" for projects distributed via
     * Maven Central, "manual" for manual download
     * @since 0.1.0
     */
    public void license(String name, String tag, String url, String distribution){
        licenses.add(new License(name, tag, url, distribution))
    }

    /**
     * Adds a license to the project
     * @param closure Closure to configure a {@link License} instance
     * @since 0.1.0
     */
    public void license(@DelegatesTo(License) Closure closure){
        licenses.add(new License().configure(closure))
    }

    /**
     * Adds the MIT license to the licenses the project may be used under
     * @param distribution The distribution method ("repo" or "manual") the project may use with this license
     * @since 0.1.0
     */
    public void mit(String distribution){
        licenses.add(new License('The MIT License', 'MIT', 'https://opensource.org/licenses/MIT', distribution))
    }

    /**
     * Adds the EPL 1.0 license to the licenses the project may be used under
     * @param distribution The distribution method ("repo" or "manual") the project may use with this license
     * @since 0.1.0
     */
    public void epl(String distribution){
        licenses.add(new License('Eclipse Public License 1.0', 'EPL', 'https://opensource.org/licenses/EPL-1.0', distribution))
    }
}
package org.starchartlabs.flare.publishing.model

/**
 * Information about one of the licenses of a project, as per the
 * <a href="https://maven.apache.org/ref/3.0.4/maven-model/maven.html#class_license">Maven POM license spec</a>
 *
 * @author romeara
 * @since 0.1.0
 */
public class License {

    private String name

    private String tag

    private String url

    private String distribution

    /**
     * Creates a new, empty license representation
     * @since 0.1.0
     */
    public License(){
    }

    /**
     * @param name The full legal name of the license
     * @param tag Shorthand used to reference the license. (ex: "MIT" for The MIT License)
     * @param url The official url for the license text
     * @param distribution The primary method by which this project may be distributed. "repo" for projects distributed via
     * Maven Central, "manual" for manual download
     * @since 0.1.0
     */
    public License(String name, String tag, String url, String distribution){
        this.name = name
        this.tag = tag
        this.url = url
        this.distribution = distribution
    }

    /**
     * Configures this license instance via the provided closure
     * @param closure Closure with configuration operations for the license. Applied to this License instance
     * @return This (updated) license instance
     * @since 0.1.0
     */
    public License configure(@DelegatesTo(License) Closure closure){
        closure.delegate = this
        closure()

        return this
    }

    /**
     * @return The full legal name of the license.
     * @since 0.1.0
     */
    public String getName() {
        return name
    }

    /**
     * @param name The full legal name of the license.
     * @since 0.1.0
     */
    public void setName(String name) {
        this.name = name
    }

    /**
     * @return Shorthand used to reference the license. (ex: "MIT" for The MIT License)
     * @since 0.1.0
     */
    public String getTag() {
        return tag;
    }

    /**
     * @param tag Shorthand used to reference the license. (ex: "MIT" for The MIT License)
     * @since 0.1.0
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * @return The official url for the license text
     * @since 0.1.0
     */
    public String getUrl() {
        return url
    }

    /**
     * @param url The official url for the license text
     * @since 0.1.0
     */
    public void setUrl(String url) {
        this.url = url
    }

    /**
     * @return The primary method by which this project may be distributed. "repo" for projects distributed via
     * Maven Central, "manual" for manual download
     * @since 0.1.0
     */
    public String getDistribution() {
        return distribution
    }

    /**
     * @param distribution The primary method by which this project may be distributed. "repo" for projects distributed via
     * Maven Central, "manual" for manual download
     * @since 0.1.0
     */
    public void setDistribution(String distribution) {
        this.distribution = distribution
    }
}
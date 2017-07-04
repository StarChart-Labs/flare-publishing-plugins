package org.starchartlabs.flare.publishing.model

/**
 * Information about one of the committers on a project, as per the
 * <a href="https://maven.apache.org/ref/3.0.4/maven-model/maven.html#class_developer">Maven POM developer spec</a>
 *
 * @author romeara
 * @since 0.1.0
 */
public class Developer{

    private String id

    private String name

    private String url

    /**
     * Creates a new, empty developer representation
     * @since 0.1.0
     */
    public Developer(){
    }

    /**
     * @param id The unique ID of the developer in the SCM
     * @param name The full name of the contributor
     * @param url The URL for the homepage of the contributor
     * @since 0.1.0
     */
    public Developer(String id, String name, String url){
        this.id = id
        this.name = name
        this.url = url
    }

    /**
     * Configures this developer instance via the provided closure
     * @param closure Closure with configuration operations for the developer. Applied to this Developer instance
     * @return This (updated) developer instance
     * @since 0.1.0
     */
    public Developer configure(@DelegatesTo(Developer) Closure closure){
        closure.delegate = this
        closure()

        return this
    }
    /**
     * @return The unique ID of the developer in the SCM
     * @since 0.1.0
     */
    public String getId() {
        return id
    }

    /**
     * @param id The unique ID of the developer in the SCM
     * @since 0.1.0
     */
    public void setId(String id) {
        this.id = id
    }

    /**
     * @return The full name of the contributor
     * @since 0.1.0
     */
    public String getName() {
        return name
    }

    /**
     * @param name The full name of the contributor
     * @since 0.1.0
     */
    public void setName(String name) {
        this.name = name
    }

    /**
     * @return The URL for the homepage of the contributor
     * @since 0.1.0
     */
    public String getUrl() {
        return url
    }

    /**
     * @param url The URL for the homepage of the contributor
     * @since 0.1.0
     */
    public void setUrl(String url) {
        this.url = url
    }
}
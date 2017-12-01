# org.starchartlabs.flare.published-project

The `published-project` plug-in is a convention plug-in which is intended to apply standard behavior affecting MavenPublication operations. It aggregates behavior from other Flare Publishing Plug-ins into a single application. Overall, this plug-in:

 - Adds a `publishedInfo` configuration, as described in [published-info-base](./published-info-base.md)
 - Add tasks for generation of source and JavaDoc jars, as described in [source-jars](./source-jars.md)
 - Adds to the artifacts associated with MavenPublications, as described in [pom-source-jar-artifacts](./pom-source-jar-artifacts.md)
 - Adds to the generated Maven POM file as described in [pom-scope-correction](./pom-scope-correction.md) and [pom-published-info](./pom-published-info.md)

It is assumed that all projects are using Gradle's `maven-publish` plug-in.

## Application

Apply the plug-in via the buildscript classpath:

```
buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath group: 'org.starchartlabs.flare', name: 'flare-publishing-plugins', version: '0.2.0'
    }
}

apply plugin: 'org.starchartlabs.flare.published-project'
```

## Replaced Boilerplate

The plug-in has the effect of replacing the boilerplate:

```
apply plugin: 'org.starchartlabs.flare.source-jars'
apply plugin: 'org.starchartlabs.flare.published-info-base'
apply plugin: 'org.starchartlabs.flare.pom-scope-correction'
apply plugin: 'org.starchartlabs.flare.pom-source-jar-artifacts'
apply plugin: 'org.starchartlabs.flare.pom-published-info'
```

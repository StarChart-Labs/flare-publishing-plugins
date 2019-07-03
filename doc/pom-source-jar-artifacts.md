# org.starchartlabs.flare.pom-source-jar-artifacts

The `pom-source-jar-artifacts` plug-in is a convention plug-in which is intended to apply a standard behavior of including `sources` and `javadoc` artifacts in MavenPublications

It is assumed that all projects are using Gradle's `maven-publish` plug-in.

## Application

Apply the plug-in via the buildscript classpath:

```
buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath group: 'org.starchartlabs.flare', name: 'flare-publishing-plugins', version: '2.0.0'
    }
}

apply plugin: 'org.starchartlabs.flare.pom-source-jar-artifacts'
```

## Replaced Boilerplate

The plug-in has the effect of replacing the boilerplate:

```
apply plugin: 'org.starchartlabs.flare.source-jars'

project.publishing{
    publications.withType(MavenPublication.class).all{ pub ->
      artifact sourcesJar {
          classifier 'sources'
      }
      artifact javadocJar {
          classifier 'javadoc'
      }
    }
}
```

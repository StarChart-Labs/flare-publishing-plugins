# org.starchartlabs.flare.pom-scope-correction

*WARNING: org.starchartlabs.flare.pom-scope-correction is deprecated as of Gradle 5.0, as are the associated nebula plug-ins. It is recommended to switch to Gradle's built-in dependency contraint system*

The `pom-scope-correction` plug-in is a convention plug-in which is intended to apply a standard behavior of dependencies from the `compile` configuration having the Maven `compile` scope

It is assumed that all projects are using Gradle's `maven-publish` plug-in.

## Application

Apply the plug-in via the buildscript classpath:

```
buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath group: 'org.starchartlabs.flare', name: 'flare-publishing-plugins', version: '2.0.2'
    }
}

apply plugin: 'org.starchartlabs.flare.pom-scope-correction'
```

## Replaced Boilerplate

The plug-in has the effect of replacing the boilerplate:

```
project.publishing{
    publications.withType(MavenPublication.class).all{ pub ->
        pub.pom.withXml {
            project.configurations.compile.resolvedConfiguration.firstLevelModuleDependencies.each { dep ->
                asNode().dependencies[0].dependency.find {
                    it.artifactId[0].text() == dep.moduleName && it.groupId[0].text() == dep.moduleGroup
                }?.scope[0]?.value = 'compile'
            }

            project.logger.info("Applying compile configuration correction to maven publication '${pub.name}'")
        }
    }
}
```

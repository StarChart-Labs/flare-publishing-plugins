# org.starchartlabs.flare.source-jars

The `source-jars` plug-in is a convention plug-in which is intended to apply two custom tasks to a project. The `sourcesJar` task creates a jar containing the source code of the project, and the `javadocJar` task creates a jar containing the javadoc of the project.

It is assumed that the target project is a java project, or a language that uses an extension of the Gradle Java plug-in.

## Application

Apply the plug-in via the buildscript classpath:

```
buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath group: 'org.starchartlabs.flare', name: 'flare-publishing-plugins', version: '2.0.1'
    }
}

apply plugin: 'org.starchartlabs.flare.source-jars'
```

## Use

Applying the plug-in automatically add the tasks to the project, and adds their outputs to the `archives` configuration's `artifacts`

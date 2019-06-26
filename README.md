# flare-publishing-plugins

[![Travis CI](https://img.shields.io/travis/com/StarChart-Labs/flare-publishing-plugins.svg?branch=master)](https://travis-ci.com/StarChart-Labs/flare-publishing-plugins) [![Code Coverage](https://img.shields.io/codecov/c/github/StarChart-Labs/flare-publishing-plugins.svg)](https://codecov.io/github/StarChart-Labs/flare-publishing-plugins) [![Black Duck Security Risk](https://copilot.blackducksoftware.com/github/repos/StarChart-Labs/flare-publishing-plugins/branches/master/badge-risk.svg)](https://copilot.blackducksoftware.com/github/repos/StarChart-Labs/flare-publishing-plugins/branches/master) [![Changelog validated by Chronicler](https://chronicler.starchartlabs.org/images/changelog-chronicler-success.png)](https://chronicler.starchartlabs.org/) [![Maven Central](https://img.shields.io/maven-central/v/org.starchartlabs.flare/flare-publishing-plugins.svg)](https://mvnrepository.com/artifact/org.starchartlabs.flare/flare-publishing-plugins) [![License](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT)

* [Legal](#legal)
* [Contributing](#contributing)
* [Recommended Usage](#recommendedusage)
* [Plugins](#plugins)
    * [org.starchartlabs.flare.published-project](#org.starchartlabs.flare.published-project)
    * [org.starchartlabs.flare.pom-scope-correction](#org.starchartlabs.flare.pom-scope-correction)
    * [org.starchartlabs.flare.source-jars](#org.starchartlabs.flare.source-jars)
    * [org.starchartlabs.flare.published-info-base](#org.starchartlabs.flare.published-info-base)
    * [org.starchartlabs.flare.pom-source-jar-artifacts](#org.starchartlabs.flare.pom-source-jar-artifacts)
    * [org.starchartlabs.flare.pom-published-info](#org.starchartlabs.flare.pom-published-info)
    * [org.starchartlabs.flare.docker-base](#org.starchartlabs.flare.docker-base)
    * [org.starchartlabs.flare.docker-build](#org.starchartlabs.flare.docker-build)
    
For information on migrating between major plug-in versions, see the [migration guide](./docs/MIGRATIONS.md)

## Legal

The Flare Publishing Plug-ins are distributed under the [MIT License](https://opensource.org/licenses/MIT). There are no requirements for using it in your own project (a line in a NOTICES file is appreciated but not necessary for use)

The requirement for a copy of the license being included in distributions is fulfilled by a copy of the [LICENSE](./LICENSE) file being included in constructed JAR archives

## Contributing

Information for how to contribute to the Flare Publishing Plugins can be found in [the contribution guidelines](CONTRIBUTING.md)

## Supported Gradle Versions

### Gradle 3.2.1 through 3.5.1 (Inclusive)

_Supported by plug-in version 0.x_

### Gradle 4.x 

_Supported by plug-in version 1.x_

### Gradle 5.x 

_Supported by plug-in version 1.x and 2.x_

## Migrating Gradle Versions

### Gradle 3.x to 4.x

- Upgrade to plug-in version 1.x

### Gradle 4.x to 5.x

- Upgrade to plug-in version 2.x

## Recommended Usage

It is recommended projects apply the `org.starchartlabs.flare.published-project` to any modules which will be externally published to binary repositories - this plug-in contains all the behavior available in the other individual plug-ins

## Plug-ins

### org.starchartlabs.flare.published-project

Introduces standard behavior for Maven Publications via the individual plug-ins detailed below

See the [usage documentation](./doc/published-project.md) for information and requirements for applying the plug-in

### org.starchartlabs.flare.pom-scope-correction

Introduces standard behavior for Maven Publications where compile configuration dependencies are assigned the compile scope in generate POM files

See the [usage documentation](./doc/pom-scope-correction.md) for information and requirements for applying the plug-in

### org.starchartlabs.flare.source-jars

Introduces standard behavior for generating "sources" and "javadoc" jars

See the [usage documentation](./doc/source-jars.md) for information and requirements for applying the plug-in

### org.starchartlabs.flare.published-info-base

Introduces a standard configuration extension `publishedInfo` for specifying published project values

See the [usage documentation](./doc/published-info-base.md) for information and requirements for applying the plug-in

### org.starchartlabs.flare.pom-source-jar-artifacts

Introduces standard behavior for sources and JavaDoc artifacts in MavenPublications

See the [usage documentation](./doc/pom-source-jar-artifacts.md) for information and requirements for applying the plug-in

### org.starchartlabs.flare.pom-published-info

Introduces standard behavior for POM information MavenPublications

See the [usage documentation](./doc/pom-published-info.md) for information and requirements for applying the plug-in

### org.starchartlabs.flare.docker-base

Introduces a standard configuration extension `containers` for specifying docker container values

See the [usage documentation](./doc/docker-base.md) for information and requirements for applying the plug-in

### org.starchartlabs.flare.docker-build

Introduces a standard configuration of tasks for `containers` for building docker containers

See the [usage documentation](./doc/docker-build.md) for information and requirements for applying the plug-in

## Collaborators

Information for collaborators, including the release process, can be found in the [collaborator documention](./COLLABORATORS.md)

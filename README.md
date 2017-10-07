# flare-publishing-plugins

[![Travis CI](https://img.shields.io/travis/StarChart-Labs/flare-publishing-plugins.svg?branch=master)](https://travis-ci.org/StarChart-Labs/flare-publishing-plugins) [![Code Coverage](https://img.shields.io/codecov/c/github/StarChart-Labs/flare-publishing-plugins.svg)](https://codecov.io/github/StarChart-Labs/flare-publishing-plugins) [![Black Duck Security Risk](https://copilot.blackducksoftware.com/github/repos/StarChart-Labs/flare-publishing-plugins/branches/master/badge-risk.svg)](https://copilot.blackducksoftware.com/github/repos/StarChart-Labs/flare-publishing-plugins/branches/master) [![Maven Central](https://img.shields.io/maven-central/v/org.starchartlabs.flare/flare-publishing-plugins.svg)](https://mvnrepository.com/artifact/org.starchartlabs.flare/flare-publishing-plugins) [![License](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT)

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

## Legal

The Flare Publishing Plug-ins are distributed under the [MIT License](https://opensource.org/licenses/MIT). There are no requirements for using it in your own project (a line in a NOTICES file is appreciated but not necessary for use)

The requirement for a copy of the license being included in distributions is fulfilled by a copy of the [LICENSE](./LICENSE) file being included in constructed JAR archives

## Contributing

Information for how to contribute to the Flare Publishing Plugins can be found in [the contribution guidelines](CONTRIBUTING.md)

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

## Collaborators

Information for collaborators, including the release process, can be found in the [collaborator documention](./COLLABORATORS.md)

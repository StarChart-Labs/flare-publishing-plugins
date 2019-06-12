# Change Log
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/)
and this project adheres to [Semantic Versioning](http://semver.org/).

## [Unreleased]
### Added
- GH-17 Add DSL and task support for building with Docker labels applied
- GH-12 Add task for cleaning built docker images, and hook build/clean into base assemble/clean tasks
- GH-7 Add ability to specify non-default DockerFile for docker build command

## [0.2.0]
### Added
- Add a plug-in which integrates a Docker "distribution" into Gradle's established "distribution" plug-in pattern

## [0.1.0]
### Added
- Create a plug-in which corrects the scope of compile dependencies in generated POM files
- Create a plug-in which adds standard behavior for sources and javadoc jars
- Create a plug-in which applies a configuration for specifying published information about a project
- Create a plug-in which adds standard behavior for sources/JavaDoc artifacts in MavenPublications
- Create a plug-in which applies publishedInfo to generated POM files

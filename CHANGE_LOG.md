# Change Log
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](http://keepachangelog.com/)
and this project adheres to [Semantic Versioning](http://semver.org/).

## [Unreleased]

## [2.0.0]
### Changed
- (GH-30) Update minimum required Gradle version to 5.0
- (GH-16) Simplified containers DSL setup to remove use of internal API, and by extension use of API deprecated in Gradle 5.0 
- (GH-31) Deprecated org.starchartlabs.flare.pom-scope-correction
- (GH-29) Switch from assemble depending on the container build task to depending on the container assemble task, which doesn't require docker and is more appropriate
- (GH-36) Fixed issue with application of Maven POM information in Gradle 5.0+ projects

## [1.0.0]
### Changed
- (GH-25) Update minimum required Gradle version to 4.0
- (GH-24) Switch clean container tasks from ignoring error input to skipping based on docker images command 
- Add dependency on `buildContainer` task for default `assemble` task

## [0.3.0]
### Added
- GH-17 Add DSL and task support for building with Docker labels applied
- GH-12 Add task for cleaning built docker images, and hook build/clean into base assemble/clean tasks
- GH-7 Add ability to specify non-default DockerFile for docker build command
- GH-15 Add group and description values for all contributed tasks

### Changed
- GH-14 Fixed error which occurred on non-java Maven publications trying to reference dependency POM elements which don't exist

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

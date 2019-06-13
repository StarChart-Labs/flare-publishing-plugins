# Collaborator information

## Release Process

* Run a full build via `./gradlew clean build`
* Run a `publish` to deploy artifact locally for test project
* Manually run a build and publish on the test project `flare-pub-gradle-test` to verify basic functionality in a real project setup
* Update the version number to remove the "-SNAPSHOT" designation. All version numbers should be a fully-qualified semantic version of form `<major>.<minor>.<micro>`
* Change the header "Unreleased" in CHANGE_LOG.md to the target release number, and create a new "Unreleased" header above it
* Update the version number in the examples in ./doc/*.md files
* Commit the version number, README, and CHANGE_LOG updates
* Tag the git repository with the fully-qualified semantic version number, preceded by 'v' (ex: `v1.0.0`)
* Upload artifacts to bintray via `./gradlew bintrayUpload -PremoteDeploy -Dbintray_user=<username> -Dbintray_key=<API Key>`
* Verify all artifacts were correctly uploaded - check that POM.xml scopes and version numbers are correct
* Change version number to `<released version> + 1 micro` + `-SNAPSHOT`
* Commit to git
* Push changes and tag to GitHub
* Publish artifacts on BinTray
* [Synchronize BinTray artifacts to Maven central](https://bintray.com/docs/usermanual/uploads/uploads_syncingwiththirdpartyplatforms.html)
* Verify artifacts are present on Maven central
* Create a release on GitHub with a link to the BinTray page where Jars may be downloaded

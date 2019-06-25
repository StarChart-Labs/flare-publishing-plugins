# org.starchartlabs.flare.docker-build

The `docker-build` plug-in is a configuration plug-in which is intended to apply assembly and build tasks for docker container specifications defined in a `containers` extension

## Application

Apply the plug-in via the buildscript classpath:

```
buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath group: 'org.starchartlabs.flare', name: 'flare-publishing-plugins', version: '1.0.0'
    }
}

apply plugin: 'org.starchartlabs.flare.docker-build'
```

## Applied Tasks

### Per-Container tasks

For an example configuration (see [docker-base plug-in documentation](./docker-base.md) for more details on the `containers` DSL):

```
containers{
    main{
        ...
    }
}
```

Which has a container of name "main", the build plug-in will apply two tasks:

- assembleMainContainer (`assemble${container.name.captialize}Container`)
  - Copies files specified in the contents of the container to the output path
- buildMainContainer (`build${container.name.captialize}Container`)
  - Runs the `docker build` command within the output directory
  - Depends on the `assembleMainContainer` task
- cleanMainContainer (`clean${container.name.captialize}Container`)
  - Runs the `docker rmi` command for the specified container
  
### Project Level tasks

Aside from the per-container tasks, the plug-in applies two other tasks:

- assembleContainer
  - Depends on all per-container assemble tasks, assembling all specified containers
- buildContainer
  - Depends on all per-container build tasks, building all specified containers
  - Is set as a dependency of the `base` plug-in `assemble` task
- cleanContainer
  - Depends on all per-container clean tasks, cleaning all specified container images
  - Is set as a dependency of the `base` plug-in `clean` task

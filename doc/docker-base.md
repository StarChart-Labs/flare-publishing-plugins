# org.starchartlabs.flare.docker-base

The `docker-base` plug-in is a configuration plug-in which adds a standard DSL extension `containers` to describe resources used in building docker containers, which convention plug-ins may build upon

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

apply plugin: 'org.starchartlabs.flare.docker-base'
```

## Use

To specify docker container information, the DSL breaks down into 5 parts:

```
containers{
    main{
        baseName='container/name'
        
        path=file("${buildDir}/location")
        
        contents{
          from ( "${projectDir}/src/main/resources" ) { into '' }
          from (configurations.runtime) { into 'libs' }
          from (jar) { into 'libs' }
        }
        
        dockerFile='DockerFile'
        
        labels (
            "label1": "one",
            "label2": "two"
        )
    }
}
```

This defines a container with the name `main`

### baseName

```
baseName='container/name'
```

The name to apply to the container, without version information. Defaults to `"${project.name}/${name}"`

### path

```
path=file("${buildDir}/location")
```

The path is the location files in the `contents` block will be placed within for operation on by docker commands. Default is `"${buildDir}/containers/${name}"`

### contents

```
contents{
  from ( "${projectDir}/src/main/resources" ) { into '' }
  from (configurations.runtime) { into 'libs' }
  from (jar) { into 'libs' }
}
```

Defines the file resources to make available the docker build process. "into" directories are relative to the path defined in the container

### dockerFile

```
dockerFile='DockerFile'
```

Allows specifying a non-default DockerFile for use with the `docker build` command

### labels

```
labels (
    "label1": "one",
    "label2": "two"
)
```

Defines Docker labels to apply to the built container as meta-data. Translates to command arguments `--label "label1=one" --label "label2=two"`

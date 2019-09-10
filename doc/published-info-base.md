# org.starchartlabs.published-info-base

The `published-info-base` plug-in is a configuration plug-in which adds a standard DSL extension `publishedInfo` to describe published information, which convention plug-ins may build upon

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

apply plugin: 'org.starchartlabs.flare.published-info-base'
```

## Use

To specify the publication information, the DSL breaks down into 4 parts:

```
publishedInfo{
  url = 'http://...'

  scm{
    url 'http://...'
    connection 'git://...'
    developerConnection 'ssh://...'
  }

  licenses{
    license 'name', 'tag', 'url', 'distribution'
  }

  developers{
    developer 'id', 'name', 'url'
  }
}
```

### url

```
url = 'http://...'
```

Specifies the homepage URL of the project

### scm

```
scm{
  url 'http://...'
  connection 'git://...'
  developerConnection 'ssh://...'
}
```

Provides information about the source control of the project. Can be specified manually as shown, with a URL to the source control's UI, a read-only connection, and a read/write developer connection.

#### Presets

If using GitHub, the scm configuration has a preset which may be used:

```
scm{
  github 'owner', 'repository'
}
```

Where `owner` is the Organization or User who owns the repository, and `repository` is the name of the repository on GitHub. The URL is the project's GitHub page,  the connection is the `git` connection URL, and the developer connection is the `ssh` connection URL

### licenses

```
licenses{
  license 'name', 'tag', 'url', 'distribution'
}
```

Provides information on one or more licenses the project may be used under. Can be specified manually as shown, with the license's legal name, the abbreviation typically used for it, the URL of the license text, and the distribution method. The distribution method, pre the Maven POM specification, is usually `repo`, for projects distributed via Maven Central, or `manual`, for projects which must be downloaded manually

#### Presets

Some license's information has been added to the SCM DSL for convenience (pull requests to add new licenses to this set are always welcome!). All pre-set licenses still require that the distribution method be specified

```
licenses{
  mit('distribution')
  epl('distribution')
}
```

 - `mit`: The MIT license
 - `epl`: The Eclipse Public License, v1.0

### developers

```
developers{
  developer 'id', 'name', 'url'
}
```

Provides information on one or more developers who may be contacted about the project. Can be specified manually with the developer's SCM ID, name, and a URL to the developer's website

#### Presets

If using GitHub, a pre-set has been added to the developers DSL to reduce the required configuration:

```
developers{
  github 'id', 'name'
}
```

The `url` field will be set to the user's GitHub page

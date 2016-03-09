# gradle-imgcat-plugin

Gradle plugin port of the iTerm2 imgcat script (with added Giphy goodness)

* https://www.iterm2.com/images.html
* https://raw.githubusercontent.com/gnachman/iTerm2/master/tests/imgcat

NOTE: this requires the use of iTerm 2.9 or later.


### Add it to your gradle project

```
apply plugin: 'at.maui.gradle.plugin.imgcat'

buildscript {
    repositories {
        jCenter()
    }
    dependencies {
        classpath 'at.maui:gradle-imgcat-plugin:0.0.1'
    }
}
```

### Use the imgcat task

```
imgcat {
    source "giphy"
    value "android" // optional, omit for totally random giphy goodness
}
```

or

```
imgcat {
    source "remote"
    value "http://www.kizoa.com/img/e8nZC.gif"
}
```

or

```
imgcat {
    source "file"
    value "/home/you/amazing_gif_1337.gif"
}
```

And finally add the imgcat task to your build process

```
assemble.dependsOn "imgcat"
```

### License

Licensed under the terms of the Apache 2.0 License

### License

Please see CONTRIBUTING.md for details on how to contribute to this project

### Disclaimer

This is not an official Google product

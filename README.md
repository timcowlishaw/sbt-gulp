# About

A plugin to allow use of the Gulp JS build tool from within SBT - shamelessly
forked and search-and-replaced from [Joseph Price's Grunt Plugin](https://github.com/joprice/sbt-grunt).



# Installation

Clone this repo, start sbt in the plugin's directory and run
```
  publish-local
```
to install the plugin locally.

Add this line to plugins.sbt:
```scala
  addSbtPlugin("uk.co.timcowlishaw" % "gulp-plugin" % "0.0.1")
```
and to build.sbt, the following:
```scala
  import uk.co.timcowlishaw.GulpPlugin.GulpKeys._

  seq(gulpSettings: _*)
```
# Configuration

Currently only one setting is exposed:
```scala
  SettingKey[String]("gulp-app-base")
```
This defines the directory in which the 'gulp' command is called. The
default is "src/main/webapp". This should be the folder where Gulpfile.js
is located.

Override it with
```scala
  gulpAppBase := "path/to/webapp"
```

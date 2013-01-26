# About

A plugin to allow use of the Grunt JS build tool from within SBT.

# Installation

Clone this repo, start sbt in the plugin's directory and run

  publish-local

to install the plugin locally.

Add this line to plugins.sbt:

  addSbtPlugin("com.joprice" % "grunt-plugin" % "0.0.1")

and to build.sbt, the following:

  import com.joprice.GruntPlugin.GruntKeys._

  seq(gruntSettings: _*)

# Configuration

Currently only one setting is exposed: 

  SettingKey[String]("grunt-app-base")

This defines the directory in which the 'grunt' command is called. The
default is "src/main/webapp". This should be the folder where grunt.js
is located.

Override it with 

  gruntAppBase := "path/to/webapp"


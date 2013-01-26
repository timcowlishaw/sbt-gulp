package com.joprice

import sbt._
import Keys._

object GruntPlugin extends Plugin {
  object GruntKeys {
    val grunt = InputKey[Unit]("grunt")
    val gruntAppBase = SettingKey[String]("grunt-app-base")
  }

  import GruntKeys._

  lazy val gruntSettings = Seq(
    gruntTask,
    gruntAppBase := "src/main/webapp"
  )

  lazy val gruntTask = grunt <<= inputTask { (argTask: TaskKey[Seq[String]]) =>
    (argTask, baseDirectory, gruntAppBase) map { (args: Seq[String], baseDirectory:File, gruntAppBase:String) =>
      Process("grunt %s" format args.mkString(" "), new File(baseDirectory.toString, gruntAppBase)) !
    }
  }

}


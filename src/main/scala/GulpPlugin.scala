package uk.co.timcowlishaw

import sbt._
import Keys._

object GulpPlugin extends Plugin {
  object GulpKeys {
    val gulp = InputKey[Unit]("gulp")
    val gulpAppBase = SettingKey[String]("gulp-app-base")
  }

  import GulpKeys._

  lazy val gulpSettings = Seq(
    gulpTask,
    gulpAppBase := "src/main/webapp"
  )

  lazy val gulpTask = gulp <<= inputTask { (argTask: TaskKey[Seq[String]]) =>
    (argTask, baseDirectory, gulpAppBase) map { (args: Seq[String], baseDirectory:File, gulpAppBase:String) =>
      Process("gulp %s" format args.mkString(" "), new File(baseDirectory.toString, gulpAppBase)) !
    }
  }

}


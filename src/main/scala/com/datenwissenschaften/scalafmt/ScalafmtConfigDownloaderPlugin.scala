package com.datenwissenschaften.scalafmt

import sbt.Keys.*
import sbt.*

import java.net.URL
import java.nio.file.{Files, Paths, StandardCopyOption}

// noinspection ScalaUnusedSymbol
object ScalafmtConfigDownloaderPlugin extends AutoPlugin {

  // noinspection ScalaWeakerAccess
  object autoImport {
    lazy val downloadScalafmtConfig: TaskKey[Unit] = taskKey[Unit]("Download .scalafmt.conf file from the specified URL")
    lazy val scalafmtConfigUrl: SettingKey[String] = settingKey[String]("URL of the .scalafmt.conf file")
    lazy val scalafmtOverwrite: SettingKey[Boolean] = settingKey[Boolean]("Overwrite existing .scalafmt.conf file if it exists")
  }

  import autoImport.*

  override def projectSettings: Seq[Def.Setting[_]] = Seq(
    scalafmtConfigUrl := "https://raw.githubusercontent.com/datenwissenschaften/scalafmt-rules/main/.scalafmt.conf",
    scalafmtOverwrite := false,
    downloadScalafmtConfig := Def.task {
      val log = streams.value.log
      val url = new URL(scalafmtConfigUrl.value)
      val targetPath = Paths.get(".scalafmt.conf")

      if (Files.exists(targetPath) && !scalafmtOverwrite.value) {
        log.info(".scalafmt.conf already exists. Delete the file or set `scalafmtOverwrite := true` to overwrite it.")
      } else {
        log.info(s"Downloading .scalafmt.conf from $url")
        Files.copy(url.openStream(), targetPath, StandardCopyOption.REPLACE_EXISTING)
        log.info(".scalafmt.conf downloaded successfully!")
      }
    }.value
  )
}

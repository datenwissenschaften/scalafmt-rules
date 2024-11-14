package com.datenwissenschaften.scalafmt

import sbt.*
import sbt.Keys.*

import java.net.URL
import java.nio.file.{Files, Paths}

// noinspection ScalaUnusedSymbol
object ScalafmtConfigDownloaderPlugin extends AutoPlugin {

  // noinspection ScalaWeakerAccess
  object autoImport {
    lazy val downloadScalafmtConfig = taskKey[Unit]("Download .scalafmt.conf file from GitHub")
    lazy val scalafmtConfigUrl = settingKey[String]("URL of the .scalafmt.conf file")
  }

  import autoImport.*

  override def projectSettings: Seq[Def.Setting[_]] = Seq(
    scalafmtConfigUrl := "https://raw.githubusercontent.com/datenwissenschaften/scalafmt-rules/main/.scalafmt.conf",
    downloadScalafmtConfig := {
      val url = new URL(scalafmtConfigUrl.value)
      val targetPath = Paths.get(".scalafmt.conf")

      if (!Files.exists(targetPath)) {
        streams.value.log.info(s"Downloading .scalafmt.conf from $url")
        Files.copy(url.openStream(), targetPath)
        streams.value.log.info(".scalafmt.conf downloaded successfully!")
      } else {
        streams.value.log.info(".scalafmt.conf already exists. Delete the file if you want to download it again.")
      }
    }
  )
}

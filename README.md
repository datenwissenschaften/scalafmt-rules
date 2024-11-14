
# 📐 Scalafmt Rules SBT Plugin

Welcome to the **datenwissenschaften/scalafmt-rules** repository! This SBT plugin makes it easy to download and apply the latest version of your Scalafmt configuration, helping maintain consistent code formatting across your Scala projects.

## 🚀 Overview

The **scalafmt-rules** plugin automates the download of a predefined Scalafmt config file, ensuring that all projects are aligned with the latest standards and format guidelines. This helps teams to streamline code formatting, eliminate manual updates, and keep codebases consistently formatted.

## ✨ Features

- **Automatic Config Updates**: Always use the latest version of your Scalafmt config without manual effort.
- **Seamless Integration**: Ideal for projects aiming for uniform code style in collaborative settings.
- **Easy Setup**: Simple configuration in `build.sbt` to activate the plugin.

## 🔧 Getting Started

To use the **scalafmt-rules** plugin, add the following line to your `project/plugins.sbt`:

```scala
resolvers += "GitHub Packages" at "https://maven.pkg.github.com/datenwissenschaften/scalafmt-rules"
addSbtPlugin("datenwissenschaften" % "scalafmt-rules" % "1.1.0")
```

### Example Usage

After installing the plugin, add the following configuration in your `build.sbt` to ensure the latest Scalafmt config is downloaded during the compile process:

```scala
scalafmtOverwrite := true // Overwrite the existing Scalafmt configuration
(compile in Compile) := ((compile in Compile) dependsOn downloadScalafmtConfig).value
```

## 🤝 Contributing

Contributions are welcome! If you have improvements or additional features in mind, please feel free to open a pull request.

## 📜 License

This project is licensed under the Apache License 2.0. For more information, see the [LICENSE](LICENSE) file.

---

✨ Keep your Scala code clean, consistent, and up-to-date with **datenwissenschaften/scalafmt-rules**! 🚀

resolvers += "Sonatype snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"

addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.6.0")

addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "4.0.0")

// See https://github.com/orrsella/sbt-sublime

addSbtPlugin("com.orrsella" % "sbt-sublime" % "1.1.1")

// See https://github.com/jrudolph/sbt-dependency-graph

addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.8.0")

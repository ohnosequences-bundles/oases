package ohnosequencesBundles.statika

import ohnosequences.statika._, bundles._, instructions._
import java.io.File

abstract class Oases(val version: String) extends Bundle(compressinglibs, cdevel) {

  val usrbin = "/usr/bin/"

  final def install: Results = {
    Seq("wget", s"http://s3-eu-west-1.amazonaws.com/resources.ohnosequences.com/oases/${version}/oases_${version}.tar.gz") ->-
    Seq("tar", "-xvf", s"oases_${version}.tar.gz") ->- {
      val oasesDir: String = new File("oases").getAbsolutePath.toString
      val velvetDir: String = new File("oases/velvet").getAbsolutePath.toString
      Seq("make", "-C", "'MAXKMERLENGTH=99'", "'CATEGORIES=5'", velvetDir) ->-
      Seq("make", "-C", "'MAXKMERLENGTH=99'", oasesDir)  -&-
      Seq("ln", "-sf", s"${oasesDir}/oases", usrbin) ->-
      Seq("cp", s"${velvetDir}/velveth", usrbin) ->-
      Seq("cp", s"${velvetDir}/velvetg", usrbin)
    } ->-
    success(s"${bundleName} is installed")
  }
}

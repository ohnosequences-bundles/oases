package ohnosequencesBundles.statika

import ohnosequences.statika._, bundles._, instructions._
import java.io.File

abstract class Oases(val version: String) extends Bundle(compressinglibs, cdevel) {

  final def install: Results = {
    Seq("wget", s"http://s3-eu-west-1.amazonaws.com/resources.ohnosequences.com/oases/${version}/oases_${version}.tar.gz") ->-
    Seq("tar", "-xvf", s"oases_${version}.tar.gz") ->- {
      val oasesDir: String = new File("oases").getAbsolutePath.toString
      Seq("make", "-C", oasesDir)  -&-
      Seq("ln", "-sf", s"${oasesDir}/oases", "/usr/bin/")
    } ->-
    success(s"${bundleName} is installed")
  }
}

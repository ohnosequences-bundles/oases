package ohnosequencesBundles.statika

import ohnosequences.statika._, bundles._, instructions._

abstract class oases(val velvet: Velvet) extends Bundle(velvet, compressinglibs, cdevel, git) {

  final def install: Results = {
    git.clone("git://github.com/dzerbino/oases.git", "./oases/") -&-
    //Seq("git", "clone", "git://github.com/dzerbino/oases.git", "./oases/") -&-
    Seq("cd", "./oases/") -&-
    //TODO check how to access v.?
    Seq("make", s"'VELVET_DIR=${velvet.folder}'", s"'MAXKMERLENGTH=${velvet.maxKmerLength}'") -&-
    Seq("ln", "-sf", "oases", "/usr/bin/") ->-
    success(s"${bundleName} is installed")
  }
}

case object defaultOases extends oases(velvet = DefaultVelvet)


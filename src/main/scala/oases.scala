package ohnosequencesBundles.statika

import ohnosequences.statika._, bundles._, instructions._


case object oases {

			case class oases(v: anyVelvet, maxKmerLength: Int) extends Bundle(velvet, compressinglibs, cdevel, git) {

			  def install: Results = {
			    Git.clone("git://github.com/dzerbino/oases.git", "./oases/") -&-
			    //Seq("git", "clone", "git://github.com/dzerbino/oases.git", "./oases/") -&-
			    Seq("cd", "./oases/") -&-
			    //TODO check how to access v.directory
			    Seq("make", "'VELVET_DIR=${v.directory}'", "'MAXKMERLENGTH=${maxKmerLength}'") -&-
			    Seq("ln", "-sf", "oases", "/usr/bin/") ->-
			    success(s"${bundleName} is installed")
			  }

			}

}


case object defaultOases extends oases(v = , maxKmerLength = 99) {

}

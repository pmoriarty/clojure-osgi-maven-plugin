# Clojure OSGi Maven Plugin

Updates an OSGi MANIFEST.MF Import-Package and Export-Package headers based on ns declarations in clojure source files.

## Usage

Goal:
   check-manifest - adds missing imports and exports to the manifest
Parameters:
   baseDir - location of Clojure source files (defaults to src/main/clojure)
   manifest - location of MANIFEST.MF file (defaults to src/main/resources/META-INF/MANIFEST.MF)
   ignore - list of packages to ignore (space separated)

## License

Copyright © 2012 Annadale Technologies Ltd.

Licensed under the EPL. (See the file epl.html.)

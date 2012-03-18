# Clojure OSGi Maven Plugin

Updates an OSGi MANIFEST.MF Import-Package and Export-Package headers based on ns declarations in clojure source files.

## Usage

Example: To add missing clojure packages to the Import-Package and Export-Package headers of an existing manifest (eg. as created by maven-bundle-plugin).

```
<plugin>
    <groupId>com.annadaletech</groupId>
    <artifactId>clojure-osgi-maven-plugin</artifactId>
    <version>0.1.3</version>
    <configuration>
        <manifest>${project.build.outputDirectory}/META-INF/MANIFEST.MF</manifest>
    </configuration>
    <executions>
        <execution>
            <id>check-manifest</id>
            <goals>
                <goal>check-manifest</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

See https://gist.github.com/2052857 for a detailed example.


Goals:
   check-manifest - adds missing imports and exports to the manifest

Parameters:  
   baseDir - location of Clojure source files (defaults to src/main/clojure)  
   manifest - location of MANIFEST.MF file (defaults to src/main/resources/META-INF/MANIFEST.MF)  
   ignore - list of packages to ignore (space separated)  

## License

Copyright © 2012 Annadale Technologies Ltd.

Licensed under the EPL. (See the file epl.html.)

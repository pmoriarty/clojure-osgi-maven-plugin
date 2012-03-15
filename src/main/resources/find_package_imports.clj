(ns user)

(use 'clojure.pprint)
(use 'clojure.java.io)
(use 'com.annadaletech.clojure.osgi.utils)

(defn check [dir manifest-filename ignore-list]
  (let [ignore-list (map str (read-string (str "[" ignore-list "]")))
        manifest (read-manifest manifest-filename)
        missing-imports (find-missing-imports (file dir) manifest ignore-list)
        manifest (add-package-imports manifest missing-imports)
        missing-exports (find-missing-exports (file dir) manifest ignore-list)
        manifest (add-package-exports manifest missing-exports)]
    (when (seq missing-imports)
      (println "[INFO] Adding clojure packages to Import-Package header in " manifest-filename \newline (sort missing-imports)))
    (when (seq missing-exports)
      (println "[INFO] Adding clojure packages to Export-Package header in " manifest-filename \newline (sort missing-exports)))
    (write-manifest manifest manifest-filename)
    true))
(ns user)

(use 'clojure.pprint)
(use 'clojure.java.io)
(use 'com.annadaletech.clojure.osgi.utils)

(defn check [dir manifest ignore-list]
  (let [ignore-list (map str (read-string (str "[" ignore-list "]")))
        missing (find-missing-imports (file dir) (slurp manifest) ignore-list)]
    (if (seq missing)
      (do
        (println "[ERROR]" manifest "is missing some imported packages: " \newline (with-out-str (pprint (sort missing))))
        false)
      true)))

;(let [[dir manifest & ignore-list] *command-line-args*
;      missing (find-missing-imports (file dir) (slurp manifest) ignore-list)]
;  (if (seq missing)
;    (do
;      (println "[ERROR]" manifest "is missing some imported packages: " \newline (with-out-str (pprint (sort missing))))
;      false)
;    true))



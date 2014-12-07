(ns combinator.main
  (:require [combinator.core :as combinator]))

(defn -main [& args]
  (doseq [arg args]
    (println (str arg "! = " (combinator/factorial (read-string arg))))))

(ns lo-cash.core
  (:require [clojure.browser.repl :as repl]))

(defn -main []
  (.log js/console "connecting...")
  (repl/connect "http://localhost:9000/repl"))


(defn obj-select
  "Selects the given keys from a JS object and returns a keywordized map"
  [obj & keys]
  (into {}
    (map (fn [k]
           [(keyword k) (aget obj (name k))])
         keys)))

(defn obj-selectv
  "Selects the given keys from a JS object and returns a vector of their values"
  [obj & keys]
  (mapv #(aget obj (name %)) keys))

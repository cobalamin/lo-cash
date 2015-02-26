(ns lo-cash.dev)

(def -jslog
  "Not really a helper fn, just an alias for console.log bound to console"
  (.bind (.-log js/console) js/console))

(defn log
  "Logs to console, without having to use (.log js/console)"
  [& args]
  (apply -jslog args))

(defn prlog
  "Logs string representations of Clojure data structures"
  [& args]
  (apply log (map pr-str args)))

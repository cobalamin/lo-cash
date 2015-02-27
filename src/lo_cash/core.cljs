(ns lo-cash.core)

(defn obj-select
  "Selects the given keys from a JS object and returns a keywordized map"
  [obj [& keys]]
  (into {}
    (map #([(keyword k) (aget obj k)])
         keys)))

(defn obj-selectv
  "Selects the given keys from a JS object and returns a vector of their values"
  [obj [& keys]]
  (mapv #(aget obj k) keys))

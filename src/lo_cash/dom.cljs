(ns lo-cash.dom
  (:require [goog.events :as events]
            [goog.dom :as gdom]
            [cljs.core.async :as async :refer [chan]]))

(defn by-tag-name
  "Gets all elements by tag name, either inside a DOM node or globally"
  ([tag-name (get-by-tag-name tag-name nil)])
  ([tag-name node] (array-seq (gdom/getElementsByTagNameAndClass tag-name nil node))))

(defn events-as-chan
  "Creates a channel that emits event objects of the types fired from the DOM node"
  [node & ev-types]
  (let [c (chan)]
    (dorun (for [type types]
             (events/listen el type #(put! c %))))
    c))

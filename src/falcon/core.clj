(ns falcon.core
  (:import [org.jsoup Jsoup]
           [org.jsoup.nodes Document]
           [org.jsoup.select Elements]))

(defn parse-string
  "Parse HTML from provided string"
  [html-string]
  (Jsoup/parse html-string))

(defn parse
  "Parse HTML from provided URL or File"
  [url]
  (parse-string (slurp url)))

(defn read-element
  "Get the targeted data from Elements"
  [element]
  {:text (.text element)
   :html (.html element)
   :attrs (reduce
           (fn [attrs el]
             (merge
              attrs
              (hash-map (keyword (.getKey el))
                        (.getValue el))))
           {}
           (-> element .attributes .asList))
   :children (map read-element
                  (.children element))})

(defn select
  "Uses JSoup CSS style syntax to select
  elements from parsed HTML"
  [parsed selector]
  (map read-element (.select parsed selector)))

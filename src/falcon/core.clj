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

(defn sel
  "Uses JSoup CSS style syntax to select
  elements from parsed HTML"
  [parsed selector]
  (.select parsed selector))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

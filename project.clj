(defproject falcon "0.1.0"
  :description "Simple CSS-based selectors for HTML"
  :url "https://github.com/ThomasMeier"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.jsoup/jsoup "1.8.3"]]
  :profiles {:test {:resource-paths ["test/test_resources"]}})

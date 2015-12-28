(defproject falcon "0.1.0-SNAPSHOT"
  :description "Fast and simple CSS-based syntax selectors for HTML"
  :url "https://github.com/ThomasMeier"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.jsoup/jsoup "1.8.3"]]
  :main ^:skip-aot falcon.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})

(ns falcon.core-test
  (:require [clojure.test :refer :all]
            [falcon.core :as falcon]
            [clojure.java.io :as io]))

(def test-01-html (falcon/parse
                   (io/resource "test_01.html")))

(def test-01-string (falcon/parse-string
                     (slurp
                      (io/resource "test_01.html"))))

(deftest parse-test
  (testing "Selecting h1"
    (is
     (= "Hello 01!"
        (-> (falcon/select test-01-html "h1")
            first
            :text)))))

(deftest parse-string-test
  (testing "Selecting classes from parsed string"
    (is
     (= 2
        (count
         (-> (falcon/select test-01-string ".test-p")))))))

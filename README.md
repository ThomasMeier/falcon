# falcon

[![Build Status](https://travis-ci.org/ThomasMeier/falcon.svg?branch=master)](https://travis-ci.org/ThomasMeier/falcon)

Easy CSS-style selectors for HTML using [JSoup][1].

[1]: http://jsoup.org/

## Installation

Add to dependencies in `project.clj`:

    [falcon "0.1.0"]

## Usage

##### 1. Parse

First, you need some HTML parsed.

```clj
(ns (:require [falcon.core :as falcon]))

(def parsed-html (falcon/parse "http://google.com"))
```

Or, if you have a string of HTML,

```clj
(def parsed-html
  (falcon/parse-string
    "<div><p class='hi' data-x="1"><b>Stuff</b></p></div>"))
```

##### 2. Select
Then select using the parsed HTML and a CSS-style selector.

```clj
(def elements
  (first
    (falcon/select parsed-html ".hi")))
```

Check out all the possible selectors at [JSoup Selector Syntax][2].

[2]: http://jsoup.org/cookbook/extracting-data/selector-syntax

##### 3. Use

The result is a simplified Clojure data structure.

```clj
({:text "Stuff"
  :html "<b>Stuff</b>"
  :attrs {:class "hi"
          :data-x "1"}
  :children ({:text "Stuff"
              ...}))
```

## Example

```clj
repl> (falcon/select
       (falcon/parse "https://reddit.com/r/clojure")
       "h1.redditname a")

({:text "Clojure"
     ...})
```

## License

Copyright © 2015 Thomas Meier

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.

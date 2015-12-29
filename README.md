# falcon

Fast and simple CSS-style selectors for HTML using [JSoup][1].

[1]: http://jsoup.org/

## Installation

After release, add to your dependencies in `project.clj`:

    [falcon "0.1.0"]

## Usage

##### 1. Parse

First you need some HTML to pass through the parser.

```clj
(ns (:require [falcon.core :as falcon]))

(def parsed-html (falcon/parse "http://google.com"))
```

Or, if you have a string of HTML you'd like to parse

```clj
(def parsed-html
  (falcon/parse-string
    "<div><p class='hi' data-x="1"><b>Stuff</b></p></div>"))
```

##### 2. Select
Then you may select using the parsed HTML.

```clj
(def elements
  (first
    (falcon/select parsed-html ".hi")))
```

Check out all the selector options at [JSoup Selector Syntax][2]. Most selectors
return collections.

[2]: http://jsoup.org/cookbook/extracting-data/selector-syntax

##### 3. Use

The result is a Clojure data structure. Children remain JSoup Elements.

```clj
({:text "Stuff"
  :html "<b>Stuff</b>"
  :attrs {:class "h1"
          :data-x "1"}
  :children ({:text "Stuff"
              ...}))
```

## License

Copyright © 2015 Thomas Meier

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.

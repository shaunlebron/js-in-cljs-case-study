(ns my.app
  (:require
    ["codemirror" :as codemirror]
    ["parinfer-codemirror" :as parinfer-codemirror]))

(let [cm (codemirror js/document.body)]
  (parinfer-codemirror/init cm))

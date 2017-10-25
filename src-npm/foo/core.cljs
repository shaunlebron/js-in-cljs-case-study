(ns foo.core
  (:require
    [codemirror]
    [parinfer-codemirror]))

(let [cm (codemirror js/document.body)]
  (parinfer-codemirror/init cm))

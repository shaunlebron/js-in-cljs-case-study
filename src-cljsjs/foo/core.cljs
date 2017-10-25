(ns foo.core
  (:require
    [cljsjs.codemirror]
    [cljsjs.parinfer-codemirror]))

(let [cm (js/CodeMirror js/document.body)]
  (js/parinferCodeMirror.init cm))

(ns my.app
  (:require
    [cljsjs.codemirror]
    [cljsjs.parinfer]
    [cljsjs.parinfer-codemirror]))

(let [cm (js/CodeMirror js/document.body)]
  (js/parinferCodeMirror.init cm))

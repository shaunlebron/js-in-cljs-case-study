(ns my.app
  (:require
    ["codemirror" :as codemirror]
    ["parinfer" :as parinfer]
    ["parinfer-codemirror" :as parinfer-codemirror]))

;; until I setup parinfer-codemirror to properly depend on parinfer
(set! js/parinfer parinfer)

(let [cm (codemirror js/document.body)]
  (parinfer-codemirror/init cm))

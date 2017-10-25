(require '[cljs.build.api :as b])

(b/build "src-cljsjs"
  {:main 'foo.core
   :asset-path "js/out"
   :output-to "public/js/main.js"
   :output-dir "public/js/out"
   :verbose true})

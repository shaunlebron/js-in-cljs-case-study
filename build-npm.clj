(require '[cljs.build.api :as b])

(b/build "src-npm"
  {:main 'foo.core
   :asset-path "js/out"
   :output-to "public/js/main.js"
   :output-dir "public/js/out"
   :verbose true
   :npm-deps {:codemirror "5.31.0"
              :parinfer-codemirror "1.4.2"}})

(require '[cljs.build.api :as b])

(b/build "src-npm"
  {:main 'foo.core
   :asset-path "js/out"
   :output-to "public/js/main.js"
   :output-dir "public/js/out"
   :verbose true
   :foreign-libs [{:file "node_modules/codemirror/lib/codemirror.js"
                   :provides ["codemirror"]
                   :global-exports '{codemirror CodeMirror}}

                  {:file "node_modules/parinfer/parinfer.js"
                   :provides ["parinfer"]
                   :global-exports '{parinfer parinfer}}

                  {:file "node_modules/parinfer-codemirror/parinfer-codemirror.js"
                   :provides ["parinfer-codemirror"]
                   :global-exports '{parinfer-codemirror parinferCodeMirror}
                   :requires ["parinfer"]}]})

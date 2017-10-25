(defproject foo "0.1.0"
  :dependencies [[org.clojure/clojurescript "1.9.946"]]

  ; only include for build-cljsjs since they can interfere with npm-deps
  :profiles {:cljsjs {:dependencies [[cljsjs/parinfer-codemirror "1.4.1-2"]
                                     [cljsjs/codemirror "5.31.0-0"]]}}

  :aliases
  {"build-cljsjs" ["with-profile" "cljsjs" "trampoline" "run" "-m" "clojure.main" "build-cljsjs.clj"]
   "build-npm"                            ["trampoline" "run" "-m" "clojure.main" "build-npm.clj"]}

  :clean-targets ["target" "public/js/out"])

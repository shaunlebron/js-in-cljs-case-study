# Using Parinfer and CodeMirror in ClojureScript

__NOTE:__ currently does not build in latest shadow-cljs due to it deprecating
`foreign-libs` in favor of npm module processing ([see here](https://code.thheller.com/blog/shadow-cljs/2017/09/15/js-dependencies-going-forward.html)),
but should work for boot-cljs, lein-cljsbuild, etc.  I'm exploring a shadow-cljs
fix in the `npm` branch.

Example integration of the following dependencies:

- [parinfer] through [cljsjs/parinfer]
- [codemirror] through [cljsjs/codemirror]
- [parinfer-codemirror] through [cljsjs/parinfer-codemirror]

[parinfer]:https://github.com/shaunlebron/parinfer/tree/master/lib
[cljsjs/parinfer]:https://github.com/cljsjs/packages/tree/master/parinfer
[codemirror]:https://github.com/codemirror/codemirror
[cljsjs/codemirror]:https://github.com/cljsjs/packages/tree/master/codemirror
[parinfer-codemirror]:https://github.com/shaunlebron/parinfer-codemirror
[cljsjs/parinfer-codemirror]:https://github.com/cljsjs/packages/tree/master/parinfer-codemirror

__CodeMirror__ is not a proper npm package, which makes integration weird for us.
It is only usable from the browser through a global `CodeMirror` var.

__Parinfer__ is a proper npm package.

__Parinfer-CodeMirror__ must adopt the weirdness of CodeMirror by not being a
proper package.  It must assume its dependencies are global vars: `parinfer` and
`CodeMirror`.

# Using Parinfer and CodeMirror in ClojureScript

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

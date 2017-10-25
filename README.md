_I'm writing this because I've fallen behind on how JS libs can be used from
ClojureScript._

# Case Study: JS libs in ClojureScript

My motivation is to recommend a path for setting up Parinfer/CodeMirror in cljs.
These are JS libraries, so I'm testing out different options for using them from
cljs.

## JS libs we need

We need to include the following libraries, either through [npm] or [cljsjs].

| npm                   | cljsjs                       |
|:----------------------|:-----------------------------|
| [codemirror]          | [cljsjs/codemirror]          |
| [parinfer-codemirror] | [cljsjs/parinfer-codemirror] |
| [parinfer]            | [cljsjs/parinfer]            |

cljsjs is a curated repository of cljs wrappers for popular JS libraries.
I believe most of them use `:foreign-libs`.

npm is the standard repository for JS libraries.  We can use `:npm-deps` or
have shadow-cljs look in `package.json`.

[npm]:https://www.npmjs.com/
[cljsjs]:http://cljsjs.github.io/

[parinfer]:https://github.com/shaunlebron/parinfer/tree/master/lib
[cljsjs/parinfer]:https://github.com/cljsjs/packages/tree/master/parinfer
[codemirror]:https://github.com/codemirror/codemirror
[cljsjs/codemirror]:https://github.com/cljsjs/packages/tree/master/codemirror
[parinfer-codemirror]:https://github.com/shaunlebron/parinfer-codemirror
[cljsjs/parinfer-codemirror]:https://github.com/cljsjs/packages/tree/master/parinfer-codemirror

## Different build methods

| dep type        | src          | `cljs.build.api`       | `shadow-cljs`               |
|:----------------|:-------------|:-----------------------|:----------------------------|
| `:foreign-libs` | [src-cljsjs] | ✔️ `lein build-cljsjs`  | N/A                         |
| `:foreign-libs` | [src-npm]    | ❌ `lein build-foreign` | N/A                         |
| `:npm-deps`     | [src-npm]    | ❌ `lein build-npm`     | N/A                         |
| `package.json`  | [src-npm]    | N/A                    | ✔️ `shadow-cljs compile app` |

[src-cljsjs]:src-cljsjs/foo/core.cljs
[src-npm]:src-npm/foo/core.cljs

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

Some of these are not working, probably because I'm doing it wrong.

| dep type        | src          | `cljs.build.api`                           | `shadow-cljs`               |
|:----------------|:-------------|:-------------------------------------------|:----------------------------|
| `:foreign-libs` | [src-cljsjs] | ✔️ `lein build-cljsjs`                      | N/A ([migration path])      |
| `:foreign-libs` | [src-npm]    | ❌ `lein build-foreign`                     | N/A ([migration path])      |
| `:npm-deps`     | [src-npm]    | ❌ `lein build-npm`                         | ✔️ `shadow-cljs compile app` |
| `/node_modules` | [src-npm]    | ❌ `lein build-npm` (with npm-deps removed) | ✔️ `shadow-cljs compile app` |

[migration path]:https://code.thheller.com/blog/shadow-cljs/2017/09/15/js-dependencies-going-forward.html#breaking-change-removing-foreign-libs-support

## Brain dump

- cljs.build.api will check `/node_modules` first to resolve dependencies, then will check `:foreign-libs` if not found there.
- `deps.cljs` - putting `:npm-deps` in this file allows you to specify js dependencies for cljs libraries
  - shadow-cljs supports this, but not in the shadow-cljs.edn file.
- I thought cljs.build.api supported reading directly from node_modules without npm-deps, but having trouble recreating now.

[src-cljsjs]:src-cljsjs/foo/core.cljs
[src-npm]:src-npm/foo/core.cljs

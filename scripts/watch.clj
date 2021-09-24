(require '[cljs.build.api :as b])

(b/watch "src"
  {:main 'spike-mies-2.core
   :output-to "out/spike_mies_2.js"
   :output-dir "out"})

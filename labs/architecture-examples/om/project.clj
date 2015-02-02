(defproject todomvc "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  :jvm-opts ^:replace ["-Xms4g" "-Xmx4g" "-server"]

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2760"]
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                 [secretary "0.4.0"]
                 [org.omcljs/om "0.8.8"]]

  :plugins [[lein-cljsbuild "1.0.4-SNAPSHOT"]]

  :source-paths ["src"]

  :clean-targets ["out" "out-adv" "app.js"]

  :cljsbuild { 
    :builds [{:id "dev"
              :source-paths ["src"]
              :compiler {
                :main todomvc.app
                :output-to "app.js"
                :output-dir "out"
                :optimizations :none
                :source-map true}}
             {:id "release"
              :source-paths ["src"]
              :compiler {
                :output-to "app.js"
                :output-dir "out-adv"
                :optimizations :advanced
                :elide-asserts true
                :pretty-print false
                :output-wrapper false}}]})

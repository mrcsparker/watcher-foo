(ns watcher-foo.core
  (:require [clojure-watch.core :refer [start-watch]]))


(defn run
  []
  (start-watch [{:path "./files/"
                 :event-types [:create :modify :delete]
                 :bootstrap (fn [path] (println "Starting to watch " path))
                 :callback (fn [event filename] (println event filename))
                 :options {:recursive true}}]))

(defn -main
  []
  (run))

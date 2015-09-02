(ns watcher-foo.core
  (:require [clojure-watch.core :refer [start-watch]]
            [clojure.pprint :refer [pprint]]
            [yesql.core :refer [defquery defqueries]]))

(def db-spec {:classname "org.h2.Driver"
              :subprotocol "h2"
              :subname "./watcher-foo"
              })

(defquery create-file! "sql/create-file.sql")
(defquery find-file-by-name "sql/find-file-by-name.sql")

(defn run
  []
  (start-watch [{:path "./files/"
                 :event-types [:create :modify :delete]
                 :bootstrap (fn [path] (println "Starting to watch " path))
                 :callback (fn [event filename] (println event filename))
                 :options {:recursive true}}]))

(defn -main
  []
  (find-file-by-name db-spec "file")
  (run))

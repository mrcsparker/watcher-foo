(defproject watcher-foo "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :main watcher-foo.core
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [clojure-watch "LATEST"]
                 [yesql "0.4.2"]
                 [com.h2database/h2 "1.4.188"]
                 [migratus "0.8.4"]]

  :plugins [[migratus-lein "0.1.7"]]

  :migratus {:store :database
             :migration-dir "migrations/"
             :db {:classname "org.h2.Driver"
                  :subprotocol "h2"
                  :subname (str (.getName (clojure.java.io/file ".")) "/watcher-foo")}})

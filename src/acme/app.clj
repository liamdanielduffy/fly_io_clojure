(ns acme.app
  (:require [hiccup2.core :refer [html]]
            [org.httpkit.server :as server])
  (:gen-class))

(def port (or (some-> (System/getenv "PORT")
                      parse-long)
              8080))

(defn -main [& _args]
  (server/run-server
   (fn [_req]
     {:body
      (str (html
            [:html
             [:body
              [:h1 "Hello world!"]
              [:p (str "This site is running with clojure v"
                       (clojure-version))]]]))})
   {:port port})
  (println "Site running on" (str "http://localhost:" port)))


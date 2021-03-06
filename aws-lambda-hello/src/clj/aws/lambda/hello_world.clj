(ns aws.lambda.hello-world
  (:require [clojure.data.json :as json]
            [clojure.string :as s]
            [clojure.java.io :as io])
  (:gen-class
   :init init
   :constructors {[] []}   
   :implements [com.amazonaws.services.lambda.runtime.RequestStreamHandler]))


(defn key->keyword [key-string]
  (-> key-string
      (s/replace #"([a-z])([A-Z])" "$1-$2")
      (s/replace #"([A-Z]+)([A-Z])" "$1-$2")
      (s/lower-case)
      (keyword)))


(defn -init
  ;; matches empty constructor
  ([][[] (do (println "Lambda Setup."))]))


(defn handle-request [request-map]
  (let [sz-input (prn-str request-map)]
  (do
    (println "Process Request")
    (prn request-map))
  ;; some response
  {:return 0
   :input sz-input
   :message "Hello World"}))


;; implements interface RequestStreamHandler
;; [see](https://github.com/aws/aws-lambda-java-libs/blob/master/aws-lambda-java-core/src/main/java/com/amazonaws/services/lambda/runtime/RequestStreamHandler.java)
(defn -handleRequest [this is os context]
  (let [w (io/writer os)]
    (->
     ;; parse input to clojure map
     (json/read (io/reader is) :key-fn key->keyword)
     ;; pass request to handle-request
     (handle-request)
     ;; pass return of handle-request to json writer
     (json/write w))
    ;; flush output stream
    (.flush w)))

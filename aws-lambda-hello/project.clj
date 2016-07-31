(defproject aws-lambda-hello-world "0.1.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/data.json "0.2.6"]
                 ;; AWS
                 [com.amazonaws/aws-lambda-java-core "1.1.0"] ;; core
                 ;;[com.amazonaws/aws-java-sdk-lambda "1.10.76"] ;; λ
                 ;;[com.amazonaws/aws-java-sdk-s3 "1.11.7"]   ;; S3
                 ;;[com.amazonaws/aws-java-sdk-sqs "1.11.7"] ;; SQS
                 ;;[com.amazonaws/aws-java-sdk-sns "1.11.7"] ;; SNS
                 ;;[com.amazonaws/aws-java-sdk-kms "1.11.7"] ;; kms
                 ]
  :java-source-paths ["src/java"]
  :source-paths ["src/clj"]
  :test-paths ["test/clj"]
  :aot :all)

(ns open-api-definition.specs.go-term
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def go-term-data
  {
   (ds/opt :name) string?
   (ds/opt :id) string?
   })

(def go-term-spec
  (ds/spec
    {:name ::go-term
     :spec go-term-data}))

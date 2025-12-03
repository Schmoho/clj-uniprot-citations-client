(ns open-api-definition.specs.keyword-id
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def keyword-id-data
  {
   (ds/opt :name) string?
   (ds/opt :id) string?
   })

(def keyword-id-spec
  (ds/spec
    {:name ::keyword-id
     :spec keyword-id-data}))

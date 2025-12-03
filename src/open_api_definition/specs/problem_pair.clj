(ns open-api-definition.specs.problem-pair
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def problem-pair-data
  {
   (ds/opt :code) int?
   (ds/opt :message) string?
   })

(def problem-pair-spec
  (ds/spec
    {:name ::problem-pair
     :spec problem-pair-data}))

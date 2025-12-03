(ns open-api-definition.specs.taxonomy-inactive-reason
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def taxonomy-inactive-reason-data
  {
   (ds/opt :inactiveReasonType) string?
   (ds/opt :mergedTo) int?
   })

(def taxonomy-inactive-reason-spec
  (ds/spec
    {:name ::taxonomy-inactive-reason
     :spec taxonomy-inactive-reason-data}))

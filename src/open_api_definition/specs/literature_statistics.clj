(ns open-api-definition.specs.literature-statistics
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def literature-statistics-data
  {
   (ds/opt :computationallyMappedProteinCount) int?
   (ds/opt :communityMappedProteinCount) int?
   (ds/opt :largeScale) boolean?
   (ds/opt :reviewedProteinCount) int?
   (ds/opt :unreviewedProteinCount) int?
   })

(def literature-statistics-spec
  (ds/spec
    {:name ::literature-statistics
     :spec literature-statistics-data}))

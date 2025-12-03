(ns open-api-definition.specs.taxonomy-statistics
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def taxonomy-statistics-data
  {
   (ds/opt :referenceProteomeCount) int?
   (ds/opt :proteomeCount) int?
   (ds/opt :reviewedProteinCount) int?
   (ds/opt :unreviewedProteinCount) int?
   })

(def taxonomy-statistics-spec
  (ds/spec
    {:name ::taxonomy-statistics
     :spec taxonomy-statistics-data}))

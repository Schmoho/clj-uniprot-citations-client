(ns open-api-definition.specs.statistics
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def statistics-data
  {
   (ds/opt :reviewedProteinCount) int?
   (ds/opt :unreviewedProteinCount) int?
   })

(def statistics-spec
  (ds/spec
    {:name ::statistics
     :spec statistics-data}))

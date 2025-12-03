(ns open-api-definition.specs.cross-reference-citation-database
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [open-api-definition.specs.property :refer :all]
            )
  (:import (java.io File)))


(def cross-reference-citation-database-data
  {
   (ds/opt :properties) (s/coll-of property-spec)
   (ds/opt :id) string?
   (ds/opt :database) string?
   })

(def cross-reference-citation-database-spec
  (ds/spec
    {:name ::cross-reference-citation-database
     :spec cross-reference-citation-database-data}))

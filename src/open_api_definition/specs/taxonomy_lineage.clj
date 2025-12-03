(ns open-api-definition.specs.taxonomy-lineage
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def taxonomy-lineage-data
  {
   (ds/opt :hidden) boolean?
   (ds/opt :rank) string?
   (ds/opt :taxonId) int?
   (ds/opt :scientificName) string?
   (ds/opt :commonName) string?
   (ds/opt :synonyms) (s/coll-of string?)
   })

(def taxonomy-lineage-spec
  (ds/spec
    {:name ::taxonomy-lineage
     :spec taxonomy-lineage-data}))

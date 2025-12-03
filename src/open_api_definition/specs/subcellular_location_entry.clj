(ns open-api-definition.specs.subcellular-location-entry
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [open-api-definition.specs.subcellular-location-entry :refer :all]
            [open-api-definition.specs.subcellular-location-entry :refer :all]
            [open-api-definition.specs.go-term :refer :all]
            [open-api-definition.specs.statistics :refer :all]
            [open-api-definition.specs.keyword-id :refer :all]
            )
  (:import (java.io File)))


(def subcellular-location-entry-data
  {
   (ds/opt :name) string?
   (ds/opt :id) string?
   (ds/opt :definition) string?
   (ds/opt :content) string?
   (ds/opt :links) (s/coll-of string?)
   (ds/opt :partOf) (s/coll-of subcellular-location-entry-spec)
   (ds/opt :note) string?
   (ds/opt :isA) (s/coll-of subcellular-location-entry-spec)
   (ds/opt :synonyms) (s/coll-of string?)
   (ds/opt :geneOntologies) (s/coll-of go-term-spec)
   (ds/opt :references) (s/coll-of string?)
   (ds/opt :statistics) statistics-spec
   (ds/opt :category) string?
   (ds/opt :keyword) keyword-id-spec
   })

(def subcellular-location-entry-spec
  (ds/spec
    {:name ::subcellular-location-entry
     :spec subcellular-location-entry-data}))

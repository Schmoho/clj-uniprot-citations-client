(ns open-api-definition.specs.taxonomy-entry
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [open-api-definition.specs.taxonomy :refer :all]
            [open-api-definition.specs.taxonomy-lineage :refer :all]
            [open-api-definition.specs.taxonomy-strain :refer :all]
            [open-api-definition.specs.taxonomy :refer :all]
            [open-api-definition.specs.taxonomy-statistics :refer :all]
            [open-api-definition.specs.taxonomy-inactive-reason :refer :all]
            )
  (:import (java.io File)))


(def taxonomy-entry-data
  {
   (ds/opt :hidden) boolean?
   (ds/opt :parent) taxonomy-spec
   (ds/opt :active) boolean?
   (ds/opt :links) (s/coll-of string?)
   (ds/opt :rank) string?
   (ds/opt :otherNames) (s/coll-of string?)
   (ds/opt :lineages) (s/coll-of taxonomy-lineage-spec)
   (ds/opt :strains) (s/coll-of taxonomy-strain-spec)
   (ds/opt :hosts) (s/coll-of taxonomy-spec)
   (ds/opt :statistics) taxonomy-statistics-spec
   (ds/opt :inactiveReason) taxonomy-inactive-reason-spec
   (ds/opt :mnemonic) string?
   (ds/opt :taxonId) int?
   (ds/opt :scientificName) string?
   (ds/opt :commonName) string?
   (ds/opt :synonyms) (s/coll-of string?)
   })

(def taxonomy-entry-spec
  (ds/spec
    {:name ::taxonomy-entry
     :spec taxonomy-entry-data}))

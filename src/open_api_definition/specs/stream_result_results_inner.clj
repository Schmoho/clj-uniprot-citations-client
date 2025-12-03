(ns open-api-definition.specs.stream-result-results-inner
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [open-api-definition.specs.keyword-entry :refer :all]
            [open-api-definition.specs.keyword-entry :refer :all]
            [open-api-definition.specs.go-term :refer :all]
            [open-api-definition.specs.literature-statistics :refer :all]
            [open-api-definition.specs.keyword-id :refer :all]
            [open-api-definition.specs.taxonomy :refer :all]
            [open-api-definition.specs.taxonomy-lineage :refer :all]
            [open-api-definition.specs.taxonomy-strain :refer :all]
            [open-api-definition.specs.taxonomy :refer :all]
            [open-api-definition.specs.taxonomy-inactive-reason :refer :all]
            [open-api-definition.specs.subcellular-location-entry :refer :all]
            [open-api-definition.specs.subcellular-location-entry :refer :all]
            [open-api-definition.specs.disease-cross-reference :refer :all]
            [open-api-definition.specs.keyword-id :refer :all]
            [open-api-definition.specs.citation :refer :all]
            )
  (:import (java.io File)))


(def stream-result-results-inner-data
  {
   (ds/opt :definition) string?
   (ds/opt :children) (s/coll-of keyword-entry-spec)
   (ds/opt :parents) (s/coll-of keyword-entry-spec)
   (ds/opt :links) (s/coll-of string?)
   (ds/opt :accession) string?
   (ds/opt :synonyms) (s/coll-of string?)
   (ds/opt :geneOntologies) (s/coll-of go-term-spec)
   (ds/opt :statistics) literature-statistics-spec
   (ds/opt :category) string?
   (ds/opt :keyword) keyword-id-spec
   (ds/opt :name) string?
   (ds/opt :id) string?
   (ds/opt :linkType) string?
   (ds/opt :abbrev) string?
   (ds/opt :pubMedId) string?
   (ds/opt :doiId) string?
   (ds/opt :servers) (s/coll-of string?)
   (ds/opt :dbUrl) string?
   (ds/opt :hidden) boolean?
   (ds/opt :parent) taxonomy-spec
   (ds/opt :active) boolean?
   (ds/opt :rank) string?
   (ds/opt :otherNames) (s/coll-of string?)
   (ds/opt :lineages) (s/coll-of taxonomy-lineage-spec)
   (ds/opt :strains) (s/coll-of taxonomy-strain-spec)
   (ds/opt :hosts) (s/coll-of taxonomy-spec)
   (ds/opt :inactiveReason) taxonomy-inactive-reason-spec
   (ds/opt :mnemonic) string?
   (ds/opt :taxonId) int?
   (ds/opt :scientificName) string?
   (ds/opt :commonName) string?
   (ds/opt :content) string?
   (ds/opt :partOf) (s/coll-of subcellular-location-entry-spec)
   (ds/opt :note) string?
   (ds/opt :isA) (s/coll-of subcellular-location-entry-spec)
   (ds/opt :references) (s/coll-of string?)
   (ds/opt :acronym) string?
   (ds/opt :crossReferences) (s/coll-of disease-cross-reference-spec)
   (ds/opt :keywords) (s/coll-of keyword-id-spec)
   (ds/opt :alternativeNames) (s/coll-of string?)
   (ds/opt :citation) citation-spec
   })

(def stream-result-results-inner-spec
  (ds/spec
    {:name ::stream-result-results-inner
     :spec stream-result-results-inner-data}))

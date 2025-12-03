(ns open-api-definition.specs.keyword-entry
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [open-api-definition.specs.keyword-entry :refer :all]
            [open-api-definition.specs.keyword-entry :refer :all]
            [open-api-definition.specs.go-term :refer :all]
            [open-api-definition.specs.statistics :refer :all]
            [open-api-definition.specs.keyword-id :refer :all]
            )
  (:import (java.io File)))


(def keyword-entry-data
  {
   (ds/opt :definition) string?
   (ds/opt :children) (s/coll-of keyword-entry-spec)
   (ds/opt :parents) (s/coll-of keyword-entry-spec)
   (ds/opt :links) (s/coll-of string?)
   (ds/opt :accession) string?
   (ds/opt :synonyms) (s/coll-of string?)
   (ds/opt :geneOntologies) (s/coll-of go-term-spec)
   (ds/opt :statistics) statistics-spec
   (ds/opt :category) string?
   (ds/opt :keyword) keyword-id-spec
   })

(def keyword-entry-spec
  (ds/spec
    {:name ::keyword-entry
     :spec keyword-entry-data}))

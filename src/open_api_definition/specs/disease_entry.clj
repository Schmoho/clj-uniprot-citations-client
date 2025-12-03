(ns open-api-definition.specs.disease-entry
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [open-api-definition.specs.disease-cross-reference :refer :all]
            [open-api-definition.specs.keyword-id :refer :all]
            [open-api-definition.specs.statistics :refer :all]
            )
  (:import (java.io File)))


(def disease-entry-data
  {
   (ds/opt :name) string?
   (ds/opt :id) string?
   (ds/opt :definition) string?
   (ds/opt :acronym) string?
   (ds/opt :crossReferences) (s/coll-of disease-cross-reference-spec)
   (ds/opt :keywords) (s/coll-of keyword-id-spec)
   (ds/opt :alternativeNames) (s/coll-of string?)
   (ds/opt :statistics) statistics-spec
   })

(def disease-entry-spec
  (ds/spec
    {:name ::disease-entry
     :spec disease-entry-data}))

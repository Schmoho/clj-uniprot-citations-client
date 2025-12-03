(ns open-api-definition.specs.search-result
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [open-api-definition.specs.stream-result-results-inner :refer :all]
            [open-api-definition.specs.facet :refer :all]
            [open-api-definition.specs.term-info :refer :all]
            [open-api-definition.specs.suggestion :refer :all]
            [open-api-definition.specs.problem-pair :refer :all]
            )
  (:import (java.io File)))


(def search-result-data
  {
   (ds/opt :results) (s/coll-of stream-result-results-inner-spec)
   (ds/opt :facets) (s/coll-of facet-spec)
   (ds/opt :matchedFields) (s/coll-of term-info-spec)
   (ds/opt :suggestions) (s/coll-of suggestion-spec)
   (ds/opt :warnings) (s/coll-of problem-pair-spec)
   })

(def search-result-spec
  (ds/spec
    {:name ::search-result
     :spec search-result-data}))

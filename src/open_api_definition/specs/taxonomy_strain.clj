(ns open-api-definition.specs.taxonomy-strain
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def taxonomy-strain-data
  {
   (ds/opt :name) string?
   (ds/opt :synonyms) (s/coll-of string?)
   })

(def taxonomy-strain-spec
  (ds/spec
    {:name ::taxonomy-strain
     :spec taxonomy-strain-data}))

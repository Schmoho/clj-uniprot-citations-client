(ns open-api-definition.specs.taxonomy
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def taxonomy-data
  {
   (ds/opt :mnemonic) string?
   (ds/opt :taxonId) int?
   (ds/opt :scientificName) string?
   (ds/opt :commonName) string?
   (ds/opt :synonyms) (s/coll-of string?)
   })

(def taxonomy-spec
  (ds/spec
    {:name ::taxonomy
     :spec taxonomy-data}))

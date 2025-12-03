(ns open-api-definition.specs.cross-ref-entry
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [open-api-definition.specs.statistics :refer :all]
            )
  (:import (java.io File)))


(def cross-ref-entry-data
  {
   (ds/opt :name) string?
   (ds/opt :id) string?
   (ds/opt :statistics) statistics-spec
   (ds/opt :category) string?
   (ds/opt :linkType) string?
   (ds/opt :abbrev) string?
   (ds/opt :pubMedId) string?
   (ds/opt :doiId) string?
   (ds/opt :servers) (s/coll-of string?)
   (ds/opt :dbUrl) string?
   })

(def cross-ref-entry-spec
  (ds/spec
    {:name ::cross-ref-entry
     :spec cross-ref-entry-data}))

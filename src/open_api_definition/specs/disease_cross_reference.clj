(ns open-api-definition.specs.disease-cross-reference
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def disease-cross-reference-data
  {
   (ds/opt :properties) (s/coll-of string?)
   (ds/opt :id) string?
   (ds/opt :databaseType) string?
   })

(def disease-cross-reference-spec
  (ds/spec
    {:name ::disease-cross-reference
     :spec disease-cross-reference-data}))

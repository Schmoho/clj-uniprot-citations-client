(ns open-api-definition.specs.property
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def property-data
  {
   (ds/opt :key) string?
   (ds/opt :value) string?
   })

(def property-spec
  (ds/spec
    {:name ::property
     :spec property-data}))

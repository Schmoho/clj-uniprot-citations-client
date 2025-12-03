(ns open-api-definition.specs.facet-item
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def facet-item-data
  {
   (ds/opt :label) string?
   (ds/opt :value) string?
   (ds/opt :count) int?
   })

(def facet-item-spec
  (ds/spec
    {:name ::facet-item
     :spec facet-item-data}))

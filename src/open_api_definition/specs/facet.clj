(ns open-api-definition.specs.facet
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [open-api-definition.specs.facet-item :refer :all]
            )
  (:import (java.io File)))


(def facet-data
  {
   (ds/opt :label) string?
   (ds/opt :name) string?
   (ds/opt :allowMultipleSelection) boolean?
   (ds/opt :values) (s/coll-of facet-item-spec)
   })

(def facet-spec
  (ds/spec
    {:name ::facet
     :spec facet-data}))

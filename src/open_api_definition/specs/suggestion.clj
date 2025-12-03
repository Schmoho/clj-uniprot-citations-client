(ns open-api-definition.specs.suggestion
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def suggestion-data
  {
   (ds/opt :query) string?
   (ds/opt :hits) int?
   })

(def suggestion-spec
  (ds/spec
    {:name ::suggestion
     :spec suggestion-data}))

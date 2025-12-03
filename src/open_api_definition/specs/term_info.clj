(ns open-api-definition.specs.term-info
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            )
  (:import (java.io File)))


(def term-info-data
  {
   (ds/opt :name) string?
   (ds/opt :hits) int?
   })

(def term-info-spec
  (ds/spec
    {:name ::term-info
     :spec term-info-data}))

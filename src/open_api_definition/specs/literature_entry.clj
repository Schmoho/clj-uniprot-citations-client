(ns open-api-definition.specs.literature-entry
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [open-api-definition.specs.literature-statistics :refer :all]
            [open-api-definition.specs.citation :refer :all]
            )
  (:import (java.io File)))


(def literature-entry-data
  {
   (ds/opt :statistics) literature-statistics-spec
   (ds/opt :citation) citation-spec
   })

(def literature-entry-spec
  (ds/spec
    {:name ::literature-entry
     :spec literature-entry-data}))

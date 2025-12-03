(ns open-api-definition.specs.electronic-article
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [open-api-definition.specs.cross-reference-citation-database :refer :all]
            )
  (:import (java.io File)))


(def electronic-article-data
  {
   (ds/opt :locator) string?
   (ds/opt :journal) string?
   (ds/opt :id) string?
   (ds/opt :citationCrossReferences) (s/coll-of cross-reference-citation-database-spec)
   (ds/opt :publicationDate) string?
   (ds/opt :authoringGroups) (s/coll-of string?)
   (ds/opt :authors) (s/coll-of string?)
   (ds/opt :title) string?
   })

(def electronic-article-spec
  (ds/spec
    {:name ::electronic-article
     :spec electronic-article-data}))

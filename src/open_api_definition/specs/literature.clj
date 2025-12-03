(ns open-api-definition.specs.literature
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [open-api-definition.specs.cross-reference-citation-database :refer :all]
            )
  (:import (java.io File)))


(def literature-data
  {
   (ds/opt :literatureAbstract) string?
   (ds/opt :completeAuthorList) boolean?
   (ds/opt :pubmedId) int?
   (ds/opt :doiId) string?
   (ds/opt :lastPage) string?
   (ds/opt :firstPage) string?
   (ds/opt :volume) string?
   (ds/opt :journal) string?
   (ds/opt :id) string?
   (ds/opt :citationCrossReferences) (s/coll-of cross-reference-citation-database-spec)
   (ds/opt :publicationDate) string?
   (ds/opt :authoringGroups) (s/coll-of string?)
   (ds/opt :authors) (s/coll-of string?)
   (ds/opt :title) string?
   })

(def literature-spec
  (ds/spec
    {:name ::literature
     :spec literature-data}))

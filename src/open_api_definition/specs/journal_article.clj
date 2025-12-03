(ns open-api-definition.specs.journal-article
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [open-api-definition.specs.cross-reference-citation-database :refer :all]
            )
  (:import (java.io File)))


(def journal-article-data
  {
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

(def journal-article-spec
  (ds/spec
    {:name ::journal-article
     :spec journal-article-data}))

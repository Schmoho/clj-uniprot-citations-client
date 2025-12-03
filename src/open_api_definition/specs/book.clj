(ns open-api-definition.specs.book
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [open-api-definition.specs.cross-reference-citation-database :refer :all]
            )
  (:import (java.io File)))


(def book-data
  {
   (ds/opt :address) string?
   (ds/opt :lastPage) string?
   (ds/opt :firstPage) string?
   (ds/opt :bookName) string?
   (ds/opt :editors) (s/coll-of string?)
   (ds/opt :publisher) string?
   (ds/opt :volume) string?
   (ds/opt :id) string?
   (ds/opt :citationCrossReferences) (s/coll-of cross-reference-citation-database-spec)
   (ds/opt :publicationDate) string?
   (ds/opt :authoringGroups) (s/coll-of string?)
   (ds/opt :authors) (s/coll-of string?)
   (ds/opt :title) string?
   })

(def book-spec
  (ds/spec
    {:name ::book
     :spec book-data}))

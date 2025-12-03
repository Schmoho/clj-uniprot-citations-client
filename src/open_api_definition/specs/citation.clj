(ns open-api-definition.specs.citation
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [open-api-definition.specs.cross-reference-citation-database :refer :all]
            )
  (:import (java.io File)))


(def citation-data
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
   (ds/opt :locator) string?
   (ds/opt :journal) string?
   (ds/opt :literatureAbstract) string?
   (ds/opt :completeAuthorList) boolean?
   (ds/opt :pubmedId) int?
   (ds/opt :doiId) string?
   (ds/opt :patentNumber) string?
   (ds/opt :submissionDatabase) string?
   (ds/opt :institute) string?
   (ds/opt :citationType) string?
   })

(def citation-spec
  (ds/spec
    {:name ::citation
     :spec citation-data}))

(ns open-api-definition.api.taxonomy
  (:require [open-api-definition.core :refer [call-api check-required-params with-collection-format *api-context*]]
            [clojure.spec.alpha :as s]
            [spec-tools.core :as st]
            [orchestra.core :refer [defn-spec]]
            [open-api-definition.specs.taxonomy-statistics :refer :all]
            [open-api-definition.specs.literature-statistics :refer :all]
            [open-api-definition.specs.patent :refer :all]
            [open-api-definition.specs.literature-entry :refer :all]
            [open-api-definition.specs.book :refer :all]
            [open-api-definition.specs.journal-article :refer :all]
            [open-api-definition.specs.stream-result :refer :all]
            [open-api-definition.specs.keyword-entry :refer :all]
            [open-api-definition.specs.taxonomy :refer :all]
            [open-api-definition.specs.go-term :refer :all]
            [open-api-definition.specs.taxonomy-inactive-reason :refer :all]
            [open-api-definition.specs.facet-item :refer :all]
            [open-api-definition.specs.literature :refer :all]
            [open-api-definition.specs.taxonomy-strain :refer :all]
            [open-api-definition.specs.cross-ref-entry :refer :all]
            [open-api-definition.specs.problem-pair :refer :all]
            [open-api-definition.specs.subcellular-location-entry :refer :all]
            [open-api-definition.specs.thesis :refer :all]
            [open-api-definition.specs.disease-entry :refer :all]
            [open-api-definition.specs.property :refer :all]
            [open-api-definition.specs.electronic-article :refer :all]
            [open-api-definition.specs.stream-result-results-inner :refer :all]
            [open-api-definition.specs.term-info :refer :all]
            [open-api-definition.specs.citation :refer :all]
            [open-api-definition.specs.search-result :refer :all]
            [open-api-definition.specs.suggestion :refer :all]
            [open-api-definition.specs.disease-cross-reference :refer :all]
            [open-api-definition.specs.taxonomy-lineage :refer :all]
            [open-api-definition.specs.cross-reference-citation-database :refer :all]
            [open-api-definition.specs.submission :refer :all]
            [open-api-definition.specs.taxonomy-entry :refer :all]
            [open-api-definition.specs.keyword-id :refer :all]
            [open-api-definition.specs.facet :refer :all]
            [open-api-definition.specs.statistics :refer :all]
            )
  (:import (java.io File)))


(defn-spec get-by-id-with-http-info any?
  "Get taxonomy entry by a single taxon id.
  Search taxonomy entry by id to return all data associated with that entry. Specify <tt>fields</tt> to return only data for specific sections of that entry that are of interest to you"
  ([taxonId string?, ] (get-by-id-with-http-info taxonId nil))
  ([taxonId string?, {:keys [fields]} (s/map-of keyword? any?)]
   (check-required-params taxonId)
   (call-api "/taxonomy/{taxonId}" :get
             {:path-params   {"taxonId" taxonId }
              :header-params {}
              :query-params  {"fields" fields }
              :form-params   {}
              :content-types []
              :accepts       ["application/json" "text/plain;format=tsv" "text/plain;format=list" "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" "application/rdf+xml"]
              :auth-names    []})))

(defn-spec get-by-id taxonomy-entry-spec
  "Get taxonomy entry by a single taxon id.
  Search taxonomy entry by id to return all data associated with that entry. Specify <tt>fields</tt> to return only data for specific sections of that entry that are of interest to you"
  ([taxonId string?, ] (get-by-id taxonId nil))
  ([taxonId string?, optional-params any?]
   (let [res (:data (get-by-id-with-http-info taxonId optional-params))]
     (if (:decode-models *api-context*)
        (st/decode taxonomy-entry-spec res st/string-transformer)
        res))))


(defn-spec search-with-http-info any?
  "Retrieve taxonomy entries by a search query.
  The search endpoint uses a request query to return all entries associated with the search term in a paginated list of entries. Use ‘size’ to specify the number of entries per page of results. Specify <tt>fields</tt> to return only data for specific sections of that entry that are of interest to you"
  ([query string?, ] (search-with-http-info query nil))
  ([query string?, {:keys [sort fields size]} (s/map-of keyword? any?)]
   (check-required-params query)
   (call-api "/taxonomy/search" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"query" query "sort" sort "fields" fields "size" size }
              :form-params   {}
              :content-types []
              :accepts       ["application/json" "text/plain;format=tsv" "text/plain;format=list" "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"]
              :auth-names    []})))

(defn-spec search search-result-spec
  "Retrieve taxonomy entries by a search query.
  The search endpoint uses a request query to return all entries associated with the search term in a paginated list of entries. Use ‘size’ to specify the number of entries per page of results. Specify <tt>fields</tt> to return only data for specific sections of that entry that are of interest to you"
  ([query string?, ] (search query nil))
  ([query string?, optional-params any?]
   (let [res (:data (search-with-http-info query optional-params))]
     (if (:decode-models *api-context*)
        (st/decode search-result-spec res st/string-transformer)
        res))))


(defn-spec stream-with-http-info any?
  "Download taxonomy entries retrieved by a search query.
  The stream endpoint uses a request query to return all entries associated with the search term in a single download. Specify <tt>fields</tt> to return only data for specific sections of that entry that are of interest to you"
  ([query string?, ] (stream-with-http-info query nil))
  ([query string?, {:keys [sort fields download]} (s/map-of keyword? any?)]
   (check-required-params query)
   (call-api "/taxonomy/stream" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"query" query "sort" sort "fields" fields "download" download }
              :form-params   {}
              :content-types []
              :accepts       ["application/json" "text/plain;format=tsv" "text/plain;format=list" "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" "application/rdf+xml"]
              :auth-names    []})))

(defn-spec stream stream-result-spec
  "Download taxonomy entries retrieved by a search query.
  The stream endpoint uses a request query to return all entries associated with the search term in a single download. Specify <tt>fields</tt> to return only data for specific sections of that entry that are of interest to you"
  ([query string?, ] (stream query nil))
  ([query string?, optional-params any?]
   (let [res (:data (stream-with-http-info query optional-params))]
     (if (:decode-models *api-context*)
        (st/decode stream-result-spec res st/string-transformer)
        res))))



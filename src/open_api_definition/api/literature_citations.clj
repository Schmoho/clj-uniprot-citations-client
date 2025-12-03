(ns open-api-definition.api.literature-citations
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


(defn-spec get-by-literature-id-with-http-info any?
  "Get literature citation entry by a single accession.
  Search literature citation entry by id to return all data associated with that entry. Specify <tt>fields</tt> to return only data for specific sections of that entry that are of interest to you"
  ([citationId string?, ] (get-by-literature-id-with-http-info citationId nil))
  ([citationId string?, {:keys [fields]} (s/map-of keyword? any?)]
   (check-required-params citationId)
   (call-api "/citations/{citationId}" :get
             {:path-params   {"citationId" citationId }
              :header-params {}
              :query-params  {"fields" fields }
              :form-params   {}
              :content-types []
              :accepts       ["application/json" "text/plain;format=tsv" "text/plain;format=list" "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" "application/rdf+xml"]
              :auth-names    []})))

(defn-spec get-by-literature-id literature-entry-spec
  "Get literature citation entry by a single accession.
  Search literature citation entry by id to return all data associated with that entry. Specify <tt>fields</tt> to return only data for specific sections of that entry that are of interest to you"
  ([citationId string?, ] (get-by-literature-id citationId nil))
  ([citationId string?, optional-params any?]
   (let [res (:data (get-by-literature-id-with-http-info citationId optional-params))]
     (if (:decode-models *api-context*)
        (st/decode literature-entry-spec res st/string-transformer)
        res))))


(defn-spec search4-with-http-info any?
  "Retrieve literature citation entries by a search query.
  The search endpoint uses a request query to return all entries associated with the search term in a paginated list of entries. Use ‘size’ to specify the number of entries per page of results. Specify <tt>fields</tt> to return only data for specific sections of that entry that are of interest to you"
  ([query string?, ] (search4-with-http-info query nil))
  ([query string?, {:keys [sort fields size]} (s/map-of keyword? any?)]
   (check-required-params query)
   (call-api "/citations/search" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"query" query "sort" sort "fields" fields "size" size }
              :form-params   {}
              :content-types []
              :accepts       ["application/json" "text/plain;format=tsv" "text/plain;format=list" "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"]
              :auth-names    []})))

(defn-spec search4 search-result-spec
  "Retrieve literature citation entries by a search query.
  The search endpoint uses a request query to return all entries associated with the search term in a paginated list of entries. Use ‘size’ to specify the number of entries per page of results. Specify <tt>fields</tt> to return only data for specific sections of that entry that are of interest to you"
  ([query string?, ] (search4 query nil))
  ([query string?, optional-params any?]
   (let [res (:data (search4-with-http-info query optional-params))]
     (if (:decode-models *api-context*)
        (st/decode search-result-spec res st/string-transformer)
        res))))


(defn-spec stream5-with-http-info any?
  "Download literature citation entries retrieved by a search query.
  The stream endpoint uses a request query to return all entries associated with the search term in a single download. Specify <tt>fields</tt> to return only data for specific sections of that entry that are of interest to you"
  ([query string?, ] (stream5-with-http-info query nil))
  ([query string?, {:keys [sort fields download]} (s/map-of keyword? any?)]
   (check-required-params query)
   (call-api "/citations/stream" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"query" query "sort" sort "fields" fields "download" download }
              :form-params   {}
              :content-types []
              :accepts       ["application/json" "text/plain;format=tsv" "text/plain;format=list" "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" "application/rdf+xml"]
              :auth-names    []})))

(defn-spec stream5 stream-result-spec
  "Download literature citation entries retrieved by a search query.
  The stream endpoint uses a request query to return all entries associated with the search term in a single download. Specify <tt>fields</tt> to return only data for specific sections of that entry that are of interest to you"
  ([query string?, ] (stream5 query nil))
  ([query string?, optional-params any?]
   (let [res (:data (stream5-with-http-info query optional-params))]
     (if (:decode-models *api-context*)
        (st/decode stream-result-spec res st/string-transformer)
        res))))



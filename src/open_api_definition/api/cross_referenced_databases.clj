(ns open-api-definition.api.cross-referenced-databases
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


(defn-spec find-by-accession-with-http-info any?
  "Get cross-reference database entry by a single accession.
  Search cross-reference database entry by id to return all data associated with that entry. Specify <tt>fields</tt> to return only data for specific sections of that entry that are of interest to you"
  ([id string?, ] (find-by-accession-with-http-info id nil))
  ([id string?, {:keys [fields]} (s/map-of keyword? any?)]
   (check-required-params id)
   (call-api "/database/{id}" :get
             {:path-params   {"id" id }
              :header-params {}
              :query-params  {"fields" fields }
              :form-params   {}
              :content-types []
              :accepts       ["application/json" "application/rdf+xml"]
              :auth-names    []})))

(defn-spec find-by-accession cross-ref-entry-spec
  "Get cross-reference database entry by a single accession.
  Search cross-reference database entry by id to return all data associated with that entry. Specify <tt>fields</tt> to return only data for specific sections of that entry that are of interest to you"
  ([id string?, ] (find-by-accession id nil))
  ([id string?, optional-params any?]
   (let [res (:data (find-by-accession-with-http-info id optional-params))]
     (if (:decode-models *api-context*)
        (st/decode cross-ref-entry-spec res st/string-transformer)
        res))))


(defn-spec search3-with-http-info any?
  "Retrieve cross-reference database entries by a search query.
  The search endpoint uses a request query to return all entries associated with the search term in a paginated list of entries. Use ‘size’ to specify the number of entries per page of results. Specify <tt>fields</tt> to return only data for specific sections of that entry that are of interest to you"
  ([query string?, ] (search3-with-http-info query nil))
  ([query string?, {:keys [sort fields size]} (s/map-of keyword? any?)]
   (check-required-params query)
   (call-api "/database/search" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"query" query "sort" sort "fields" fields "size" size }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn-spec search3 search-result-spec
  "Retrieve cross-reference database entries by a search query.
  The search endpoint uses a request query to return all entries associated with the search term in a paginated list of entries. Use ‘size’ to specify the number of entries per page of results. Specify <tt>fields</tt> to return only data for specific sections of that entry that are of interest to you"
  ([query string?, ] (search3 query nil))
  ([query string?, optional-params any?]
   (let [res (:data (search3-with-http-info query optional-params))]
     (if (:decode-models *api-context*)
        (st/decode search-result-spec res st/string-transformer)
        res))))


(defn-spec stream4-with-http-info any?
  "Download cross-reference database entries retrieved by a search query.
  The stream endpoint uses a request query to return all entries associated with the search term in a single download. Specify <tt>fields</tt> to return only data for specific sections of that entry that are of interest to you"
  ([query string?, ] (stream4-with-http-info query nil))
  ([query string?, {:keys [sort fields download]} (s/map-of keyword? any?)]
   (check-required-params query)
   (call-api "/database/stream" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"query" query "sort" sort "fields" fields "download" download }
              :form-params   {}
              :content-types []
              :accepts       ["application/json" "application/rdf+xml"]
              :auth-names    []})))

(defn-spec stream4 stream-result-spec
  "Download cross-reference database entries retrieved by a search query.
  The stream endpoint uses a request query to return all entries associated with the search term in a single download. Specify <tt>fields</tt> to return only data for specific sections of that entry that are of interest to you"
  ([query string?, ] (stream4 query nil))
  ([query string?, optional-params any?]
   (let [res (:data (stream4-with-http-info query optional-params))]
     (if (:decode-models *api-context*)
        (st/decode stream-result-spec res st/string-transformer)
        res))))



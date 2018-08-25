(ns froscon-18.hangman.backend.wordaxis.http
  "Fetch html from wordaxis.com"
  (:require
   [clojure.string :as str]
   [froscon-18.contrib.hangman.backend.wordaxis.http :as contrib]
   [cemerick.url :as url]))


;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Private

(defn- pattern->url
  "Turn a pattern into a url.
  Hint: You may wanna use `url/url-encode` and `url/url`."
  [pattern]
  "TODO Please implement")


;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Public

(defn fetch!
  "Given a `pattern` return the corresponding html from wordaxis.com.
   The pattern string consists of alphabetic characters and question-marks.
   Hint: Use `contrib/fetch!` to do a blocking HTTP GET request."
  [pattern]
  "TODO Please implement")

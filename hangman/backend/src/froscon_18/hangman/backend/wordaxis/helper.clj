(ns froscon-18.hangman.backend.wordaxis.helper
  "Helper for fetching data"
  (:require
   [clojure.string :as str]))


;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Public

(defn compute
  "Try to compute results without the need to actually fetch data.
   Hint:
     - Return `[pattern]` if `pattern` is a literal (ie doesnt include any wildcards)
     - Return `[]` if `pattern` is either blank or consists of nothing but wildcards
     - Return `nil` otherwise"
  [pattern]
  ["TODO Please implement"])

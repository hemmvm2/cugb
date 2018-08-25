(ns froscon-18.hangman.backend.wordaxis.parser
  "Parse html from wordaxis.com"
  (:require
   [froscon-18.contrib.hangman.backend.wordaxis.parser :as contrib]))


;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Public

(defn parse
  "Extract word results from wordaxis html.
   Hint: Use `(contrib/element-by-id \"result\")`"
  [html]
  ["TODO" "Please" "implement"])

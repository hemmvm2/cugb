(ns froscon-18.hangman.backend.components.app.handler.api
  (:require
   [compojure.core :refer [ANY] :as cp]

   [froscon-18.hangman.backend.components.app.handler.util.transit :as transit]
   [froscon-18.hangman.backend.wordaxis :as wordaxis]
   [froscon-18.hangman.backend.wordaxis.mock :as wordaxis-mock]))


(defn new-routes
  []
  (cp/routes
    (ANY "/words" {:keys [params]}
      (let [{:keys [pattern mock?]}
            params

            data
            (if mock?
              (wordaxis-mock/query! pattern)
              (wordaxis/query! pattern))]

        (transit/response {:data data})))))

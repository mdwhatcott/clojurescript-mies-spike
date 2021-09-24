(ns spike-mies-2.core
  (:require
    [goog.dom :as gdom]
    [goog.events :as gevents]))

(defn values-same? [field-1 field-2]
  (= (aget field-1 "value")
     (aget field-2 "value")))

(defn handle-change [password confirmation status]
  (gdom/setTextContent
    status
    (if (values-same? password confirmation)
      "Matches"
      "Do not match")))

(let [password (gdom/createElement "input")
      confirm  (gdom/createElement "input")
      status   (gdom/createElement "p")
      app      (gdom/getElement "app")]

  (gdom/setProperties password #js {"type" "password"})
  (gdom/setProperties confirm #js {"type" "password"})

  (gevents/listen password "keyup" #(handle-change password confirm status))
  (gevents/listen confirm "keyup" #(handle-change password confirm status))

  (gdom/setTextContent app "")
  (gdom/appendChild app password)
  (gdom/appendChild app confirm)
  (gdom/appendChild app status))



;(ns spike-mies-2.core
;  (:require [clojure.browser.repl :as repl]))
;
;;; (defonce conn
;;;   (repl/connect "http://localhost:9000/repl"))
;
;(enable-console-print!)
;
;(println "Hello world!")

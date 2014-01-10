(ns fioritto.sketch
  (:require (hiccup [page :refer [html5 include-css include-js]]
                    [element :refer [link-to]]
                    [core :refer [html]])
            (garden [core :refer [css]]
                    [stylesheet :refer [at-media]]
                    [units :as u :refer [px pt em]]
                    [color :as color :refer [hsl rgb]]
                    [def :refer [defstyles]])))

(declare page-css)

(def palette (let [base-color (hsl 0 100 50)]
               (color/shades base-color)))

(defn page []
  (html5 [:head
          [:title "Demo"]
          [:style {:type "text/css"} (page-css)]]
         [:body 
          [:header.box] 
          [:article.box]
          [:aside.box]
          [:footer.box]
          ]))

(defn page-css []
  (css [:body
        {:display "flex"}
        {:flex-flow "row"}
        {:justify-content "flex-start"}
        {:align-items "baseline"}
        ]
       [:header
        {:background-color (nth palette 0)}
        {:flex "0 0 auto"}]
       [:article         
        {:background-color (nth palette 1)}]
       [:aside 
        {:background-color (nth palette 2)}]
       [:footer 
        {:background-color (nth palette 3)}]
       [:.box 
        {:min-height (px 100)}
        {:width (px 200)}]))


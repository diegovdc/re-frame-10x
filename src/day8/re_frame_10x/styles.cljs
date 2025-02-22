(ns day8.re-frame-10x.styles
  (:require [day8.re-frame-10x.inlined-deps.garden.v1v3v10.garden.core :as garden]
            [day8.re-frame-10x.inlined-deps.garden.v1v3v10.garden.units :as units :refer [em px percent]]
            [day8.re-frame-10x.inlined-deps.garden.v1v3v10.garden.color :as color]
            [day8.re-frame-10x.inlined-deps.garden.v1v3v10.garden.selectors :as s]
            [day8.re-frame-10x.inlined-deps.garden.v1v3v10.garden.stylesheet :refer [at-keyframes]] ;;(at-import at-media at-keyframes)
            [day8.re-frame-10x.inlined-deps.spade.v1v1v0.spade.core :refer [defclass defglobal]]
            [day8.re-frame-10x.common-styles :as common]
            [day8.re-frame-10x.utils.re-com :as rc]
            [day8.re-frame-10x.view.app-db :as app-db]
            [day8.re-frame-10x.view.timing :as timing]
            [day8.re-frame-10x.view.settings :as settings]
            [day8.re-frame-10x.view.event :as event]
            [day8.re-frame-10x.view.fx :as fx]
            [day8.re-frame-10x.view.container :as container]
            [day8.re-frame-10x.view.history :as history])
  (:require-macros
    [day8.re-frame-10x.inlined-deps.garden.v1v3v10.garden.selectors :refer [defpseudoclass
                                                                            defpseudoelement]]))

(def background-gray common/background-gray)
(def background-gray-hint common/background-gray-hint)
(def dark-green common/dark-green)
(def dark-gold common/dark-gold)
(def dark-purple common/dark-purple)
(def dark-blue common/dark-blue)
(def dark-gray common/dark-gray)
(def dark-skyblue common/dark-skyblue)
(def medium-gray common/medium-gray)
(def light-purple common/light-purple)
(def light-blue common/light-blue)
(def light-gray common/light-gray)
(def yellow common/yellow)
(def text-color common/default-text-color)
(def text-color-muted common/text-color-muted)

(defpseudoclass -moz-focusring)
(defpseudoelement -moz-focus-inner)

(defglobal css-reset
  [:#--re-frame-10x--
   {:all "initial"}

   [:h1 :h2 :h3 :h4 :h5 :h6
    :div :p
    :pre :code
    :a :b :i :span
    :li :ol :ul
    :br
    :img
    :table :tbody :td :tfoot :th :thead :tr
    :button :input :option :select
    {:all "unset"}
    [:&:before :&:after
     {:all "unset"}]]

   ;; /*! abridged from normalize.css v8.0.1 | MIT License | github.com/necolas/normalize.css */
   {:line-height              "1.15"
    :-webkit-text-size-adjust "100%"}

   [:h1
    {:font-size (em 2)
     :margin    "0.67em 0"}]

   [:pre
    {:font-family "monospace, monospace"
     :font-size   (em 1)}]

   [:b
    {:font-weight "bolder"}]

   [:code
    {:font-family "monospace, monospace"
     :font-size   (em 1)}]

   [:button
    :input
    :select
    :textarea
    {:font-family common/font-stack
     :font-size   (percent 100)
     :line-height 1.15
     :margin      0}]

   [:button
    :input
    {:overflow "visible"}]

   [:button
    :select
    {:text-transform "none"}]

   [:button
    (s/html (s/attr= "type" "button"))
    (s/attr= "type" "reset")
    (s/attr= "type" "submit")
    {:-webkit-appearance "button"}]

   [((s/button) -moz-focus-inner)
    ((s/attr= "type" "button") -moz-focus-inner)
    ((s/attr= "type" "reset") -moz-focus-inner)
    ((s/attr= "type" "submit") -moz-focus-inner)
    {:border-style "none"
     :padding      "0"}]

   [((s/button) -moz-focusring)
    ((s/attr= "type" "button") -moz-focusring)
    ((s/attr= "type" "reset") -moz-focusring)
    ((s/attr= "type" "submit") -moz-focusring)
    {:outline "1px dotted ButtonText"}]

   [:textarea
    {:overflow "auto"}]

   ;; additional custom CSS resets
   [(s/a) (s/a s/visited) {:color  text-color
                           :cursor "pointer"}
       [:&:hover {:color           "#23527c"
                  :text-decoration "underline"}]]

   [:option {:display "block"}]

   [:input :optgroup :select :textarea
    {:padding     [[(px 3) (px 3) (px 1) (px 3)]]
     :border      [[(px 1) "solid" medium-gray]]}]

   [:select [(s/& s/focus) {:outline [[medium-gray "dotted" (px 1)]]}]]

   [(s/input (s/attr= "type" "checkbox"))
    {:-webkit-appearance "checkbox"
     :box-sizing         "border-box"
     :margin-top         "3px"}]

   [:li {:display "list-item"}]
   [:li
    ^{:prefix true :vendors [:webkit]}
    {:text-align "match-parent"}]

   [:table :thead :tbody :tfoot :tr :th :td
    {:display                           "block"
     :width                             "auto"
     :height                            "auto"
     :margin                            0
     :padding                           0
     :border                            "none"
     :border-collapse                   "collapse"
     :border-spacing                    0
     :border-color                      "inherit"
     :vertical-align                    "inherit"
     :text-align                        "left"
     :font-weight                       "inherit"
     :-webkit-border-horizontal-spacing 0
     :-webkit-border-vertical-spacing   0}]
   [:table {:display "table"}]
   [:th :td {:display "table-cell"
             :padding [[0 (px 5)]]}]
   [:tr {:display "table-row"}]
   [:thead {:display "table-header-group"}]
   [:tbody {:display "table-row-group"}]
   [:th :td {:display "table-cell"}]
   [:tr {:display "table-row"}]

   ;; SVG Reset
   ;; From https://chromium.googlesource.com/chromium/blink/+/master/Source/core/css/svg.css
   ["svg:not(:root), symbol, image, marker, pattern, foreignObject"
    {:overflow "hidden"}]
   ["svg:root"
    {:width  "100%"
     :height "100%"}]
   ["text, foreignObject"
    {:display "block"}]
   ["text"
    {:white-space "nowrap"}]
   ["tspan, textPath"
    {:white-space "inherit"}]
   ;; No :focus rule
   ["*"
    {:transform-origin "0px 0px 0px"}]
   ["html|* > svg"
    {:transform-origin "50% 50%"}]])



(def label-mixin {:color      text-color
                  :background background-gray-hint
                  :border     [[(px 1) "solid" light-gray]]
                  :font-size  (em 0.9)
                  :margin     [[(px 10) (px 5)]]})

(def panel-mixin {:padding-top    (px 20)
                  :margin         "0 10px"
                  :display        "flex"
                  :flex-direction "column"
                  :flex           "1 1 auto"
                  :overflow-x     "auto"
                  :overflow-y     "auto"
                  :z-index        1000})

(def re-frame-trace-styles
  [:#--re-frame-10x--
   {:background-color common/background-gray
    :font-family      common/font-stack
    :color            text-color}

   [:.label label-mixin]

   [s/table {:width     (percent 100)
             :font-size (px 14)}]
   [s/tbody {:color text-color}]
   [s/thead {:font-weight "bold"}]
   [:tr
    [:th :td {:padding (px 6)}]
    [(s/th s/first-child) {:text-align "right"}]
    [(s/& ".trace--trace") {}]

    [(s/& ":nth-child(even)") {:background background-gray-hint}]

    [(s/& ".trace--sub-create")
     [".trace--op" {:color dark-green}]]
    [(s/& ".trace--sub-run")
     [".trace--op" {:color dark-purple}]]
    [(s/& ".trace--event")
     {:border-top [["2px" common/border-line-color "solid"]]}
     [".trace--op" {:color common/event-color}]]
    [(s/& ".trace--render")
     [".trace--op" {:color dark-skyblue}]]
    [(s/& ".trace--fsm-trigger")
     [".trace--op" {:color dark-blue}]]



    [(s/& ".trace--details")
     {:color text-color-muted}
     [(s/& ":hover")
      (s/& ":focus") {:color (color/darken text-color-muted 0.2)} ;; TODO: darken(color, 20);
      [".trace--details-icon:before" {:color   text-color
                                      :cursor  "pointer"
                                      :content "\"🖶\""}]]

     ["&:focus"
      [".trace--details-tags-text"
       {:border-left  [["1px" "dotted" medium-gray]]
        :padding-left (px 7)}]]]

    [:td
     ["&.trace--toggle"
      {:color      background-gray
       :padding    0
       :text-align "right"}
      ["button:focus"
       {:color   text-color
        :outline "none"}]]
     ["&.trace--op"
      {:color        text-color-muted
       :padding-left 0
       :white-space  "nowrap"}]
     ["&.trace--op-string"
      {:word-break "break-all"}]
     ["&.trace--details-tags"
      {:padding 0
       :cursor  "pointer"}
      [".trace--details-tags-text"
       {:padding       "8px 5px 8px 8px"
        :margin-bottom "5px"}]]
     ["&.trace--meta"
      {:color       text-color-muted
       :white-space "nowrap"
       :text-align  "right"}]
     [".op-string"
      {:cursor  "pointer"
       :padding "1px"}
      ["&:hover"
       {:border-bottom  [[(px 1) "dotted" light-purple]]
        :padding-bottom 0}]]]

    ["&:hover.trace--toggle"
      {:color text-color}]
    ["th" "td"
     ["&:first-child" {:padding-left "7px"}]
     ["&:last-child" {:padding-right "7px"}]]]

   [:.rft-tag
    {:background-color common/white-background-color
     :color            common/default-text-color
     :width            common/gs-50s
     :height           common/gs-19s
     :font-size        "10px"
     :font-weight      "bold"
     :border-radius    "3px"}]

   [".rft-tag__subscription_created"
    {:background-color common/sub-create-color
     :color            "white"}]
   [".rft-tag__subscription_re_run"
    {:background-color common/sub-re-run-color
     :color            "white"}]
   [".rft-tag__subscription_destroyed"
    {:background-color common/sub-destroy-color
     :color            "white"}]
   [".rft-tag__subscription_not_run"
    {:background-color common/sub-not-run-color
     :color            "white"}]
   [".rft-tag__short"
    {:width common/gs-19}]

   [:.button {:padding       "5px 5px 3px"
              :margin        "5px"
              :border-radius "2px"
              #_#_:cursor "pointer"}]
   [:.text-button {:border-bottom "1px dotted #888"
                   :font-weight   "normal"}]

   [:.icon-button {:font-size "10px"}]
   [:button.tab {:font-weight 300}]
   [:.nav-icon
    {:width   "30px"
     :height  "30px"
     :cursor  "pointer"
     :padding "0 5px"
     :margin  "0 5px"}
    ["&.inactive"
     {:cursor "initial"}]]
   [:.tab
    {:background     "transparent"
     :border-radius  0
     :margin         "10px 0 0 0"
     :font-family    common/font-stack
     :padding-bottom "4px"
     :vertical-align "bottom"
     :cursor         "pointer"}]

   [:.tab.active
    {:background     "transparent"
     :color          common/blue-modern-color
     :border-bottom  [[(px 3) "solid" common/blue-modern-color]]
     :border-radius  0
     :padding-bottom (px 1)}]

   [:ul.filter-items :.subtrees
    {:list-style-type "none"
     :margin          "0 5px"}
    [:.subtree-button :.filter-item
     (merge {:display "inline-block"}
            label-mixin)
     [:.filter-item-string {:color      text-color
                            :background yellow}]
     [:.subtree-button-string {:color text-color}]]
    [:.subtree
     [:img {:opacity "0"}]
     [:&:hover
      [:img {"opacity" 1}]]]]

   [:.icon {:display      "inline-block"
            :width        (em 1)
            :height       (em 1)
            :stroke-width 0
            :stroke       "currentColor"
            :fill         "currentColor"}]
   [:.icon-remove {:margin-left (px 10)}]
   [:.filter {:box-shadow "-7px 15px 6px -15px rgba(0, 0, 0, 0.3)"
              :z-index    1001}
    [:.filter-control
     [:select {:border             "none"
               :border-bottom      [[(px 1) "solid" text-color-muted]]
               :background         "white"
               :display            "inline-block"
               :font-family        common/font-stack
               :font-size          (em 1)
               :padding            "2px 0 0 0"
               :-moz-appearance    "menulist"
               :-webkit-appearance "menulist"
               :appearance         "menulist"}]
     [:.filter-control-input {:border-bottom [[(px 1) "solid" text-color-muted]]

                              :display       "inline-block"}

      [(s/& ":before") {:display   "inline-block"
                        :color     text-color-muted
                        :content   "\"⚲\""
                        :transform "rotate(-45deg)"}]
      [:input {:border "none"}
       ["&::placeholder"
        {:color      common/medium-gray
         :font-style "italic"}]]]]]
   [:.filter-control-input
    {:display "flex"
     :flex    "0 0 auto"}]
   [:.nav {:background common/sidebar-background-color
           :height     (px 81)
           :color      "white"}
    [:span.arrow {:color            common/blue-modern-color ;; Should this be a button instead of a span?
                  :background-color common/standard-background-color
                  :padding          (px 4)
                  :width            (px 24)
                  :height           (px 24)
                  :cursor           "pointer"
                  :user-select      "none"}]
    [:span.arrow__disabled {:color  "#cfd8de"
                            :cursor "auto"}]
    [:span.arrow.epoch-aux-nav {:padding (px 4)
                                :width   (px 24)
                                :height  (px 24)}]
    [:span.event-header {:color            common/default-text-color
                         :background-color common/standard-background-color
                         :padding          (px 5)
                         :font-weight      "600"
                         ;; TODO: figure out how to hide long events
                         :text-overflow    "ellipsis"}]]

   [(s/& :.external-window) {:display "flex"
                             :height  (percent 100)
                             :flex    "1 1 auto"}]
   [:.panel-content-top {}
    [:.bm-title-text {:color common/navbar-text-color}]
    [:button {:width       "81px"
              :height      "31px"
              :font-weight 700
              :font-size   "14px"
              :cursor      "pointer"
              :text-align  "center"
              :padding     "0 5px"
              :margin      "0 5px"}]]
   [:.panel-content-tabs {:background-color common/white-background-color :padding-left common/gs-19}]
   [:.panel-content-scrollable panel-mixin]
   [:.epoch-panel panel-mixin]
   [:.tab-contents {:display        "flex"
                    :flex           "1 1 auto"
                    :flex-direction "column"}]
   [:.filter-control {:margin "10px 0 0 10px"}]
   [:.filter-items-count
    {:cursor "auto"}
    [(s/& ".active") {:background yellow}]]
   [:.filter-fields {:margin-top "10px"}]
   [:.filter-category {:display    "inline-block"
                       :background "#efeef1"
                       :cursor     "pointer"
                       :padding    "5px"
                       :margin     "5px"
                       :opacity    "0.3"}]
   [:.active {:opacity 1}]

   [:.re-frame-10x--object
    [:.toggle {:color       text-color-muted
               :cursor      "pointer"
               :line-height 1}]
    ["> span" {:vertical-align "text-top"}]
    [:li {:margin 0}]]
   [:.host-closed {:font-size        (em 4)
                   :margin-left      common/gs-19
                   :margin-right     common/gs-19
                   :background-color (color/rgba 255 255 0 0.8)}]
   [:.errors {:font-size        (em 2)
              :margin-left      common/gs-19
              :margin-right     common/gs-19
              :background-color (color/rgba 255 255 0 0.8)}]
   [:.expansion-button {:font-family    "sans-serif"
                        :width          (px 16)
                        :padding        [[0 common/expansion-button-horizontal-padding]]
                        :vertical-align "middle"}]
   [:.bm-muted-button {:font-size "14px"
                       :height    "23px"
                       :padding   "0px 7px"}]
   [:.noselect {:-webkit-touch-callout "none"
                :-webkit-user-select   "none"
                :-khtml-user-select    "none"
                :-moz-user-select      "none"
                :-ms-user-select       "none"
                :user-select           "none"}]

   ;; https://css-tricks.com/snippets/css/prevent-long-urls-from-breaking-out-of-container/
   [:.dont-break-out
    {
     "overflow-wrap"   "break-word"
     "word-wrap"       "break-word"

     "-ms-word-break"  "break-all"
     ; This is the dangerous one in WebKit, as it breaks things wherever
     "word-break"      "break-all"
     ; /* Instead use this non-standard one: */
     :word-break       "break-word"

     ; /* Adds a hyphen where the word breaks, if supported (No Blink) */
     "-ms-hyphens"     "auto"
     "-moz-hyphens"    "auto"
     "-webkit-hyphens" "auto"
     "hyphens"          "auto"}]])

(def highlight-js-solarized
  ;; From https://github.com/isagalaev/highlight.js/blob/master/src/styles/solarized-light.css
  [[:.hljs {"display" "block"
            "padding" "0.5em"
            "color"   "#657b83"}]
   [:.hljs-comment :.hljs-quote
    {"color" "#93a1a1"}]
   [:.hljs-keyword :.hljs-selector-tag :.hljs-addition
    {"color" "#859900"}]
   ;; Solarized Cyan
   [".hljs-number",
    ".hljs-string",
    ".hljs-meta .hljs-meta-string",
    ".hljs-literal",
    ".hljs-doctag",
    ".hljs-regexp"
    {"color" "#2aa198"}]
   ;; Solarized Blue
   [".hljs-title" ".hljs-section" ".hljs-name" ".hljs-selector-id" ".hljs-selector-class"
    {"color" "#268bd2"}]
   ;; Solarized Blue
   [".hljs-attribute" ".hljs-attr" ".hljs-variable" ".hljs-template-variable" ".hljs-class .hljs-title" ".hljs-type"
    {"color" "#b58900"}]
   ;;Solarized Orange
   [".hljs-symbol" ".hljs-bullet" ".hljs-subst" ".hljs-meta" ".hljs-meta .hljs-keyword"
    {"color" "#cb4b16"}]
   [".hljs-builtin-name" ".hljs-deletion"
    {"color" "#dc322f"}]
   [".hljs-formula"
    {"background" "#eee8d5"}]
   [".hljs-emphasis"
    {"font-style" "italic"}]
   [".hljs-strong"
    {"font-weight" "bold"}]])



(def at-keyframes-styles
  (let [slide? false]
    [(at-keyframes :pulse-previous-re-frame-10x
                   [:from (merge {:color "white"}
                                 (when slide? :left "-100%"))]
                   [:to (when slide? {:left  "0%"})])
     (at-keyframes :pulse-next-re-frame-10x
                   [:from (merge {:color "white"}
                                 (when slide? {:left "100%"}))]
                   [:to (when slide? {:left "0%"})])
     (at-keyframes :fade-clipboard-msg-re-frame-10x
                   [:0% {:margin-left "100px"}]
                   [:5% {:margin-left "0px"
                         :opacity     "1"}]
                   [:90% {:opacity "1"}])]))


(def panel-styles
  (apply garden/css [[:#--re-frame-10x-- rc/re-com-css]
                     [:#--re-frame-10x-- highlight-js-solarized]
                     common/blue-modern
                     re-frame-trace-styles
                     container/container-styles
                     event/event-styles
                     fx/fx-styles
                     history/history-styles
                     app-db/app-db-styles
                     timing/timing-styles
                     settings/settings-styles]))


(defn inject-inline-style [document id style]
  (let [styles-el     (.getElementById document id)
        new-styles-el (.createElement document "style")]
    (.setAttribute new-styles-el "id" id)
    (.setAttribute new-styles-el "type" "text/css")
    (-> new-styles-el
        (.-innerHTML)
        (set! style))
    (if styles-el
      (-> styles-el
          (.-parentNode)
          (.replaceChild new-styles-el styles-el))
      (let []
        (.appendChild (.-head document) new-styles-el)
        new-styles-el))))

(defn inject-trace-styles [document]
  (inject-inline-style document "--re-frame-10x-key-frames--" (garden/css at-keyframes-styles))
  (inject-inline-style document "--re-frame-10x-styles--" panel-styles))

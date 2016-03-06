(ns clojure-noon.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Little teapot calling kettle ..."))



(defn train [] (println "Choo Choo!"))

(println "Cleanliness is the next to godliness")

;wrapping and slurping in emacs
(+ 1 (* 2) 3 4)

(if true
  "By Zeus's hammer!"
  "By Aquama's trident!")

(if false
  "By Zeus's hammer!"
  "By Aquaman's trident!")

(if false
  "By Odin's Elbow")

(if true
  (do (println "Success!")
      "By Zeus's hammer!")
  (do (println "Failure!")
      "By Aquaman's trident!"))

(when true
  (println "Success!")
  "abra cadabra")

(nil? 1)

(nil? nil)

(if "bears eats beets"
  "bears beets Battlestar Galactica")

(if nil
  "This won't be the result because nil is false"
  "nil is falsey")

(= 1 1)


(= nil nil)

(= 1 2)

(or false nil :large_I_mean_venti :why+cant_I_just_say_large)

(or (= 0 1) (= "yes" "no"))

(or nil)

(and :free_wifi :hot_coffee)

(and :feelin_super_cool nil false)

(def failed-protoganist-names
  ["Larry Potter" "Doreen the Explorer" "The Incredible Bulk"])

failed-protoganist-names ;calling the function defined above

;converting a ruby program into clojure - don't do this

(def severity :mild)
(def error-message "OH GOD! IT'S A DISASTER! WE'RE ")
(if (= severity :mild)
 (def error-message (str error-message "MILDLY INCONVENIENCED!"))
 (def error-message (str error-message "DOOOOOOOOOOOMED!")))

;a more clojure centric way of doing things
(defn error-message
  [severity]
  (str "OH GOD! IT'S A DISASTER! We're "
       (if (= severity :mild)
         "Mildly inconvenienced!"
         "Doooooomed!")))

(error-message :mild)

;oooh data structures in clojure
88 ;numbers
"strings" ;and only double quotes and \ to escape
"\"" ;a single double quote right there

; oh noes - no string interpolation in clojure
(def name "Felix")
(str "\"Meow\"-" name)

;maps
{:first-name "Miso"
 :last-name "Soup"}

{"string-key" +}

{:name {:first "John" :middle "Jacob" :last "Sivakumara"}};nested maps using literals {}

(hash-map :a 1 :b 2) ;maps using hash-map function

(get {:a 0 :b 1} :b) ;look up values in maps with get function

(get {:a 0 :b 1} :c "unicorns?") ;setting default return value if get function can't find the key

(get-in {:a 0 :b {:c "ho hum"}} [:b :c]) ;look up values in nested maps using get-in

({:name "The Human Coffeepot"} :name)

(:a {:a 1 :b 2 :c 3}) ; is equivalent to (get {:a 1 :b 2 :c 3} :a)

(:d {:a 1 :b 2 :c 3} "No key found...boy this message is descriptive and boring")

[3 2 1] ;this is a vector
(get [3 2 1] 0) ;looking up a value in a vector

(get ["a" {:name "Logana"} "c"] 1) ;a vector is like an array and can contained mixed types

(vector "creepy" "half" "moon") ;an alternative way of creating a vector []

(conj [1 2 3] 4) ;adding to the end of a vector

'(1 2 3 4) ;creating a list

(nth '(:a :b :c) 0) ;getting a value in a list using nth

(nth '(:a :b :c) 2)

(list 1 "two" {3 4}) ;create a list with ' or list

(conj '(1 2 3) 4) ;conj adds items to the beginning of alist while conj adds to the end of a vector

;; so use a list if you need to add items to the beginning of a sequence or a macro (still don't know what that is)
;; and use a vector everywhere else

;; sets are collections of unique values
# {"jay sivakumaran" 22 :bananas}


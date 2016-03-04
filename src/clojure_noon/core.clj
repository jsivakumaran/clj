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


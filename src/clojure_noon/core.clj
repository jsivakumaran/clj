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
#{"jay sivakumaran" 22 :bananas}

(hash-set 1 1 2 2 ) ;stores #{1 2} only stores each value once

(conj #{:a :b} :b) ;conj in this case doesn't add anything to the hash-set since :b already exists within it

(set [3 3 3 4 4 5]) ; creating a set using the set function and a vector

;; contains? vs keyword vs get
(contains? #{:a :b} :a) ;returns true
(contains? #{:a :b} :3) ;returns false
(contains? #{nil}) nil ;returns true

;using a keyword
(:a #{:a :b}) ; returns :a

;using get
(get #{:a :b} :a) ;returns :a
(get #{:a nil} nil) ;returns nil
(get #{:a :b} "jay sivakumaran") ;returns nil

;contains? is better than get when testing specifically for membership

;basic clojure philosophy - it's better to have 99 functions operate on one data structure than 9 functions on 9 data structures

;now it's time to learn about functions - calling functions - defining functions - anonymous functions - returning functions

;calling functions
(+ 1 2 3 4) ;returns 10
(* 1 2 3 4) ;returns 24
(first [1 2 3 4]) ;returns 1

;all clojure operations have the same structure - opening parenthesis, operator, operands, closing parenthesis
(or + -) ;or returns the first truthy value so it returns plus which is the function of plus
((or + -) 1 2 3) ;returns 6 - because the first expression returns the plus operator which then operates on the other operands (the numbers)
((and (= 1 1) +) 1 2 3) ;returns 6 because and retuns the first falsey value or the last truthy value hence the + is returned

;the following are not valid function calls
(1 2 3 4) ;because numbers aren't functions you\ll get a java exception
("test" 1 2 3) ; because string is not a valid operand

;higher order functions can take functions as an argument or return a function
(inc 1.1) ; returns 2.1
(map inc [0 1 2 3]) ;this is map the function not the data structure

;; function calls - macro calls - special forms (definitions and if expressions)
(if good-mood
  (tweet walking-on-sunshine-lyrics)
  (tweet mopey-country-song-lyrics))

;; clojure can't evaluate both the if clause and the else clause as it normally would with functions because if shoud be one or the other hence why it is a special form - good thing about clojure is that there aren't very many special forms

;;defining  functions - defn + function name + a docstring describing the function (optional) + parameters listed in brackets + function body
(defn too-enthusiastic
  "Return a cheer that might be a bit too enthusiastic"
  [name]
  (str "OH MY. God. " name " YOU are most definitely like the best"))

(too-enthusiastic "Link")

;; functions with multiple arities
(defn no-params
  []
  "I take no parameters!")
(defn one-param
  [x]
  (str "I take one parameter: " x))
(defn two-params
  [x y]
  (str "Two parameters! I will smoosh them " x y)) ;two-arity function

;; functions also support arity overloading - different function body will run depending on the number of parameters passed in
(defn multi-arity
  ;; 3 arity arguments and body
  ([first-arg second-arg third-arg]
   (do-things first-arg second-arg third-arg))
  ;; 2-arity arguments and body
  ([first-arg second-arg]
   (do-things first-arg second-arg))
  ;; 1-arity argument and body
  ([first-arg]
   (do-things first-arg)))

(defn x-chop
  "Describe the kind of chop you're inflicting on someone"
  ([name chop-type]
   (str "I " chop-type " chop " name "! Take That!"))
  ([name]
   (x-chop name "karate")))

(x-chop "myself" "chop")

(x-chop "yourself") ;function supplies a default of karate in case that the function is called with just one argument

(defn senior-comm
  [youngn]
  (str "Get off my lawn, " youngn "!!"))

(defn senior
  [& youngns]
  (map senior-comm youngns))

(senior "Billy" "Joel" "Jay") ; one function calls another

(defn favourite-things
  [name & things]
  (str "Hi, " name ", here are some of my favourite things: "
       (clojure.string/join ", " things)))

(favourite-things "shoes" "learning" "travel" "hackathons")

;;now onto restructuring

(defn my-first 
  [[first-thing]]
  first-thing)

(my-first ["oven" "bike" "war-axe"])

(defn chooser
  [[first-choice second-choice & unimportant-choices]]
  (println (str "Your first choice is " first-choice))
  (println (str "Your second choice is " second-choice))
  (println (str "We're ignore the rest of your choices. "
                "Here they are in case you need to cry over them. "
                (clojure.string/join ", " unimportant-choices))))

(chooser ["pi", "arduino", "beagle-bone", "esp2866"])



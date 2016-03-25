(ns clojurenoob.core
  (:gen-class))

(require '[clojure.string :as str])
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
                (str/join ", " unimportant-choices)))) 

(chooser ["pi", "arduino", "beagle-bone", "esp2866"])


(defn announce-treasure-location
  [{lat :lat lng :lng}]
  (println (str "treasure lat " lat))
  (println (str "treasure lng " lng)))

(announce-treasure-location {:lat 213.123 :lng 722.22}) 

(defn receive-treasure-location
  [{:keys [lat lng]}]
  (println (str "Treasure lat " lat))
  (println (str "Treasure lng " lng)))

;;clojure returns the last form automatically
(defn illustrative-function
  []
  (+ 1 23)
  30
  "jay")

(illustrative-function)

(defn number-comment
  [x]
  (if (> x 7)
    "what a huuuuge number"
    "not so big"))

(number-comment 4)
(number-comment 9)

;;anonymous functions
(fn [param-list]
  function body)

(map (fn [name] (str "hi, " name))
     ["Darth Vader" "Joker"])

((fn [c] (* c 3)) 8)

(def my-special-multiplier (fn [x] (* x 3)))
(my-special-multiplier 12)

#(* % 3)
(#(* % 3) 8)

;;anonymous functions galore #()

(map #(str "Hi, " %)
     ["Darth" "Magoo"])

;;function call
(* 8 3)
;;vs anonymous function
#(* % 3)

;the % symbole represents the argument passed into the function
;;you can take in multiple parameters by using %1 %2 etc.
(#(str %1 " and " %2) "cornbread" "buttered beans")

;;you can also pass in a rest parameter with %&
(#(identity %&) 1 "blarg" :yip)

;;returning functions and dealing with closures
(defn inc-maker
  "Create a custom incrementor"
  [inc-by]
   #(+ % inc-by))

(def inc3 (inc-maker 3))

(inc3 7)

(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "left-eye" :size 1}
                             {:name "left-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "left-shoulder" :size 3}
                             {:name "left-upper-arm" :size 3}
                             {:name "chest" :size 3}
                             {:name "back" :size 10}])

(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})

(defn symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (loop [remaining-asym-parts asym-body-parts
         final-body-parts []]
    (if (empty? remaining-asym-parts)
      final-body-parts
      (let [[part & remaining] remaining-asym-parts]
        (recur remaining
               (into final-body-parts
                     (set [part (matching-part part)])))))))

(symmetrize-body-parts asym-hobbit-body-parts)

(let [x 3]
  x)

(def dalmation-list
  ["Pongo" "Mongo" "Puppy 1" "Puppy 3"])

(let [dalmations (take 2 dalmation-list)]
  dalmations)

(def x 0)
(let [x 1] x) ;as you can see let creates a new scope and x is 1

(def x 0)
(let [c (inc x)] x); the second x references the global x which is 0

(let [[pongo & dalmations] dalmation-list]
  [pongo dalmations])

(into final-body-parts 
      (set [part (matching-part part)]))

(into [] (set [:a :a]))

;let is a handy way to introduce local names for values which simpliefies the code

(loop [iteration 0]
  (println (str "Iteration " iteration))
  (if (> iteration 3)
    (println "Goodbye!")
    (recur (inc iteration))))

;the loop above and the function below are equivalent but loop is less verbose
(defn recursive-printer
  ([]
   (recursive-printer 0))
  ([iteration]
   (println iteration)
   (if (> iteration 3)
     (println "Goodbye!")
     (recursive-printer (inc iteration)))))

(recursive-printer)

#"regular-expression"
(re-find #"^left-" "left-eye")
(re-find #"^left-" "cleft-chin")
(re-find #"^left-" "wongleblart")

;re-find I assume stands for regular-expression find

(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})

(matching-part {:name "left-eye" :size 1})

(matching-part {:name "head" :size 3})

;;better symmetrizer with reduce
(reduce + [1 2 3 4])

;;it is equivalent to this
(+ (+ (+ 1 2) 3) 4)

;reduce can also take an initial value
(reduce + 15 [1 2 3 4]) ;;here the initial value is 15

;;reduce is usually used to consilidate a bunch of values into 1 value like it is done above
;;but reduce can also be used to take a bunch of values and turn them into a larger set of values
;;one way of implementing the reduce function
(defn my-reduce
  ([f initial collection]
   (loop [result initial
          remaining collection]
     (if (empty? remaining)
       result
       (recur (f result (first remaining)) (rest remaining)))))
  ([f [head & tail]]
   (my-reduce f head tail)))

(defn better-symmetrize-body-parts
  "expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (reduce (fn [final-body-parts part]
            (into final-body-parts (set [part (matching-part part)])))
          []
          asym-body-parts))

(defn hit
  [asym-body-parts]
  (let [sym-parts (better-symmetrize-body-parts asym-body-parts)
        body-part-size-sum (reduce + (map :size sym-parts))
        target (rand body-part-size-sum)]
    (loop [[part & remaining] sym-parts
           accumulated-size (:size part)]
      (if (> accumulated-size target)
        part
        (recur remaining (+ accumulated-size (:size (first remaining))))))))
 
(hit asym-hobbit-body-parts)

;;exercises - chapter 3
;1. use the str, vector, list, hash-map and hash-set functions.
(prn-str "hello world")
(str "hello world")
(vector) ;creates an empty vector []
[1 2 3] ;creates a vector with 1 2 3
() ; empty list ()
(1 2 3 4) ;list with 1 2 3 4
(hash-map) ;empty hash-map {}
{:key1 1 :key2 2} ;two keys and two values
(hash-set) ; empty hash-set #{}
#{1 2 3} ;hash-set can only have values 

;;2. write a function that takes a number and adds 100 to it
(defn add-hundred
  [num]
  (+ num 100))
(add-hundred 1)

;;3. Write a function dec-maker, that works exactly like the function inc-maker except with subtraction
(defn dec-maker
  "Create a custom decrementer"
  [dec-by]
  #(- % dec-by))

(def dec3 (dec-maker 3))
(dec3 8)


;;chapter 4
;;programming to abstractions - key concept in clojure

;;a sequence is a collection of elements organized in linear order

(defn titleize
  [topic]
  (str topic "for the Brave and True"))

(map titleize ["Hamsters" "Puppies"]) ;map works with a vector
(map titleize '("Empathy" "Hatred")) ;map works with a list
(map titleize #{"Elbows" "Decorating"}) ;map works with unsorted sets

;;first, rest, and cons is all you need to create the maps

(seq '(1 2 3))
(seq [1 2 3])
(seq #{1 2 3}) ;sequences always return a list
(seq {:name "Bill Compton" :occupation "Dead Mopey Guy"}) ; a sequence of a map consists of two-element key-value vectors

;;into will convert the seq into a map
(into {} (seq {:a 1 :b 2 :c 3}))

;;As long as a data structure implements first, rest, cons - it can use a whole host of functions including
;;reduce filter etc.

;;maps
(map inc [1 2 3]) ; map on a single collection
(map str ["a" "b" "c"] ["A" "B" "C"]) ;returns a list ("aA" "bB" "cC") - this is a map on multiple collections

                                        ;this is the same as above but more verbose
(list (str "a" "A") (str "b" "B") (str "c" "C"))

;;unify-diet-data
(def human-consumption [7.1 2.3 5.5 6.6])
(def critter-consumption [0.1 0.2 0.3 0.4])
(defn unify-diet-data
  [human critter]
  {:human human
   :critter critter})

(map unify-diet-data human-consumption critter-consumption)

;;now onto a little bit of statistics
(def sum #(reduce + %))
(def avg #(/ (sum %) (count %)))
(defn stats
  [numbers]
  (map #(% numbers) [sum count avg])) ;stats function iterates over a vector of functions, applying each function numbers!

(stats [3 4 10])

(stats [80 1 33 5])

(def identities
  [{:alias "Batman" :real "Bruce Wayne"}
   {:alias "Spiderman" :real "Peter Parker"}
   {:alias "Santa" :real "Your Mom"}
   {:alias "Easter Bunny" :real "Your Dad"}])

(map :real identities)
(map :alias identities)

;;reduce
(reduce (fn [new-map [key val]]
          (assoc new-map key (inc val)))
        {}
        {:max 30 :min 10})

                                        reduce can be used to transform a map's values

(reduce (fn [new-map [key val]]
          (if (> val 4)
            (assoc new-map key val)
            new-map))
        {}
        {:human 3.1
         :critter 3.9})

;; take, drop, take-while and drop-while
;;take and drop take two arguments : a number and a sequence
(take 3 [1 2 3 4 5 6 7 8 9 10])
(drop 3 [1 2 3 4 5 6 7 8 9 10])

(def food-journal
  [{:month 1 :day 1 :human 3.4 :critter 2.3}
   {:month 1 :day 2 :human 3.4 :critter 2.3}
   {:month 1 :day 3 :human 3.4 :critter 2.3}
   {:month 1 :day 4 :human 3.4 :critter 2.3}
   {:month 1 :day 7 :human 3.4 :critter 2.3}
   {:month 1 :day 8 :human 3.4 :critter 2.3}
   {:month 1 :day 9 :human 3.4 :critter 2.3}
   {:month 2 :day 2 :human 3.4 :critter 2.3}])

(take-while #(< (:month %) 3) food-journal)
(drop-while #(< (:month %) 4) food-journal)
;;now combine the two
(take-while #(< (:month %) 4)
            (drop-while #(< (:month %) 2) food-journal))

;;filter and some

(filter #(< (:human %) 5) food-journal)

;;and if you were thinking that you could do the same thing as take-while and drop-while with filter - you would be correct
;;except that take-while and drop-while can be more efficient and faster in certain scenarios so they are good to know

(filter #(< (:month %) 3) food-journal)

;;let's get some
(some #(> (:critter %) 5) food-journal) ;nil
(some #(> (:critter %) 2) food-journal) ; true
                                        ;some returns the first truthy value

(some #(and (> (:critter %) 2) %) food-journal) ; returns the first truthy value

                                        ;sort and sort-by
(sort [3 2 1]) ;(1 2 3) - notice that sort returns a list while a vector was passed in

(sort-by count ["aaa" "c" "bb"]) ; ("c" "bb" "aaa")
(concat [1 2] [3 4]) ; (1 2 3 4) - just appends them together into a list

;;lazy seqs
(def vampire-database
  {0 {:makes-bloody-puns? false, :has-pulse? true :name "McStein"}
   1 {:makes-bloody-puns? false, :has-pulse? true :name "Neamonate"}
   2 {:makes-bloody-puns? false, :has-pulse? true :name "Randomator"}
   3 {:makes-bloody-puns? true, :has-pulse? true :name "Damon Salvatore"}
   4 {:makes-bloody-puns? true, :has-pulse? true :name "Berry"}
   })

(defn vampire-related-details
  [social-security-number]
  (Thread/sleep 1000)
  (get vampire-database social-security-number))

(defn vampire?
  [record]
  (and (:makes-bloody-puns? record)
       (not (:has-pulse? record))
       record))

(defn identify-vampire
  [social-security-numbers]
  (first (filter vampire?
                 (map vampire-related-details social-security-numbers))))

(time (vampire-related-details 0))

(time (def mapped-details (map vampire-related-details (range 0 1000000))))

(time (first mapped-details))

(time (identify-vampire (range 0 1000000)))

;;Infinite sequences
(concat (take 8 (repeat "na")) ["Batman!"]) ;; that repeat "na" is an infinite series of "na"s
(take 3 (repeatedly (fn [] (rand-int 10)))) ;; repeatedly call a function that returns a random integer from 0 10 and then take 3 of those numbers

(defn even-numbers
  ([] (even-numbers 0))
  ([n] (cons n (lazy-seq (even-numbers (+ n 2))))))

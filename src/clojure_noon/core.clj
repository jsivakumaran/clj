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

(take 10 (even-numbers))  ;;mind-bending due to the recursion

;;remember what cons does
(cons 0 '(2 4 6)) ; (0 2 4 6) cons appends a value to a list and returns a list

;;The Collection Abstraction
;; as opposed to the sequence abstraction - which was covered earlier in the chapter
;; all of clojure's core data structures (vectors, maps, lists and sets) take part in both collection and sequence abstraction
;;collection abstraction is about the data structure as a whole (i.e. count, empty?, every?) apply to the whole collection
;; and not to an individual element like they would in the sequence abstraction

(empty? []) ;;true
(empty? ["no!"]) ;;false

;;into and conj - very similar

(map identity {:sunlight-reaction "Glitter!"}) ;returns a vector ([:sunlight-reaction "Glitter!"])
;;if you want it to return a map then use into to convert it back into a map like below
(into {} (map identity {:sunlight-reaction "Glitter!"})) ; returns a map {:sunlight-reaction "Glitter!"}

;;into will work with other data structures as well
(map identity [:garlic :sesame-oil :fried-eggs]) ;(:garlic :sesame-oil :fried-eggs)
;; to get back a vector like the vector you sent in do the following
(into [] (map identity [:garlic :sesame-oil :fried-eggs])) ; [:garlic :sesame-oil :fried-eggs]

;;now map converts vector with identical entries into a list and we use into to stick values into a set
(map identity [:garlic-clove :garlic-clove]) ; (:garlic-clove :garlic-clove)
(into #{} (map identity [:garlic-clove :garlic-clove])) ; #{:garlic-clove} only one :garlic-clove since it is a set - into #{}

;;all the above examples have been with the first value as empty into into but it doesn't have to be
(into {:favorite-emotion "gloomy"} [[:sunlight-reaction "Glitter!"]]) ; {:favorite-emotion "gloomy" :sunlight-reaction "Glitter!"}
(into ["cherry"] '("pine" "spruce")) ;["cherry" "pine" "spruce"]

;;and while the above shows two different empty-types converting into the first data-type, they can be both the same data-type
(into {:favorite-animal "kitty"} {:least-favorite-smell "dog" :relationship-with-teenager "creepy"}) ;both arguments passed in are maps

;;takes two collections and adding all the elements from the second into the first

;;conj
;;conj also adds elements to a collection but does it in a slightly different way
(conj [0] [1]); [0 [1]]  -not what you expected huh?
(into [0] [1]); [0 1] - compare into with conj to better elucidate the differences

;;if you wanted the same behavior of into but using conj as above then
(conj [0] 1) ;; [0 1]  ;;with into both arguments must be collections whereas with conj only the first argument must behavior

(conj [0] 1 2 3 4) ;;[0 1 2 3 4] can accept a tonne of arguments

;;conj and into are so similar that you can even define conj in terms of into
(defn my-conj
  [target & additions]
  (into target additions))

(my-conj [0] 1 2 3) ; [0 1 2 3] behaves just like conj but created using into

;;Function Functions
;; learning to accept functions as arguments and return functions as values takes some getting used tonne
;; two such functions are apply and partial

;;apply explodes a seqable data structure so it can be passed to a function that expects a rest parameter
(max 0 2 4 5 3) ; 5 - takes a number of arguments and returns the greatest of all arguments
(max [0 1 2]) ; [0 1 2] - here you are passing in a single argument of a vector, you want to pass in the contents of the vector as arguments

;;apply is perfect for this usage
(apply max [0 1 2]) ; returns 2

;; apply is often used like this, exploding the elements of a collection so that they get passed to a function as separate arguments
;; you can define into in terms of conj by using apply
(defn my-into
  [target additions]
  (apply conj target additions)) ;;apply explodes whatever is passed into additions so they are passed in as exploded arguments

(my-into [0] [1 2 3])  ;; equivalent of calling (conj [0] 1 2 3)

;;partial
;;partial takes a function and a number of arguments - then returns a new function - when you call the returned function, it calls the original function with the original arguments you supplied along with the new arguments

(def add10 (partial + 10))
(add10 3) ; 13 - when you call add10 it calls the original function and arguments +10 and tacks on whatever arguments you call add10 with such as 3 in this case and 5 in the case below
(add10 5) ; 15

(def add-missing-elements
  (partial conj ["water" "earth" "air"]))

(add-missing-elements "unobtanium" "adamantium") ;["water" "earth" "air" "unobtanium" "adamantium"]

;;writing your own partial
(defn my-partial
  [partialized-fn & args]
  (fn [& more-args]
    (apply partialized-fn (into args more-args))))

(def add20 (my-partial + 20))
(add20 3) ;23

;;the anonymous function returned by add20 is defined as below
(fn [& more-args]
  (apply + (into [20] more-args)))

;;here's a toy example of how you could use partial to specialize a logger creating a warn function
(defn lousy-logger
  [log-level message]
  (condp = log-level
    :warn (clojure.string/lower-case message)
    :emergency (clojure.string/upper-case message)))

(def warn (partial lousy-logger :warn))

(warn "Red light ahead") ; "red light ahead" ;;calling (warn "Red light ahead") is identical to calling (lousy-logger :warn "Red light ahead")

;;complement
(defn identify-humans
  [social-security-numbers]
  (filter #(not (vampire? %))
          (map vampire-related-details social-security-numbers))) ;; #(not (vampire? %)) is so common that there's a function for it called complement

(defn not-vampire? (complement vampire?))
(defn identify-humans
  [social-security-numbers]
  (filter not-vampire?
          (map vampire-related-details social-security-numbers)))

;;your own complement
(defn my-complement
  [fun]
  (fn [& args]
    (not (apply fun args))))

(def my-pos (complement neg?))
(my-pos 1) ;;true
(my-pos -1) ;;false

;;complement does one little thing well.

;; Chapter 5 - Pure Functions - what and why
;;all the functions used up till now have been pure except for println and rand

;;it is a pure function if 1. it always returns the same result if given the same arguments 2. It can't cause side effects.

;;pure functions are referentially transparent i.e. same arguments returns the same result
(+ 1 2) ;+ always returns 3 if inputs are 1 and 2
(defn wisdom
  [words]
  (str words ", Daniel-san")) ;; also referentially transparent

(wisdom "Always bathe on Fridays") 

(defn year-end-evaluation
  []
  (if (> (rand) 0.5)
    "You get a raise!"
    "Better luck next year!")) ;;not referentially transparent - because of the random value injected into the functions

(defn analyze-file
  [filename]
  (analysis (slurp filename))) ;;not referentially transparent because the file contents can change even if the filename doesn't

(defn analysis
  [text]
  (str "Character count: " (count text))) ; referentially transparent


;;Immutable Data Structures
;;immutable data structures ensure that your code won't have side effects

;;recursion instead of for/while

(defn sum ;; two-arity function
  ([vals] (sum vals 0)) ;; provide default value of 0 - first arity is just [vals]
  ([vals accumulating-total] ;; second varity is [vals accumulating-total] - so this function can handle one input or two inputs
   (if (empty? vals) ;; if vals is empty all the numbers have been processed so return accumulating-total
     accumulating-total ;;return accumulating-total
     (sum (rest vals) (+ (first vals) accumulating-total))))) ;; (rest vals) so send the rest of the values to sum and add the first of vals to the accumulating-total (+ (first vals) accumulating-total) - + add here is only taking in two values 

(sum [28 38 29]) ; single-arity body calls two-arity body
(sum [28 38 29] 0)
(sum [38 29] 28)
(sum [29] 66)
(sum [] 95); base case is reached - i.e. vals is empty and so returns 95

;;each recursive call to sum creates a new scope where vals and accumulating-total are bound to different values, all without needing to alter the values originally passed to the function or perform any internal mutation

;;generally use recur when doing recursion for performance reasons
;;here's how you would do sum with recur
(defn sum
  ([vals]
   (sum vals 0))
  ([vals accumulating-total]
   (if (empty? vals)
   accumulating-total
   (recur (rest vals) (+ (first vals) accumulating-total)))))

(sum [19 10])

;;Function Composition Instead of Attribute Mutation
(require '[clojure.string :as s]) ;;this require allows us to access the string function library
(defn clean
  [text]
  (s/replace (s/trim text) #"lol" "LOL"))

(clean "My constrictor is so sassy lol!    ") ; "My constrictor is so sassy LOL!"

;; the above does not require any mutation - the clean function passes an immutable value text to a pure function s/trim, which returns an immutable value with the spaces of the string being trimmed and then the value is then passed to the pure function s/replace which returns another immutable value.

;;combining values like this is called function composition
;;recursion uses function composition - instead of passing it to a different function as above, it passes it to itself


;;Pure Functions
;; You have already seen one function partial that creates new functions
;; comp and memoize also creates new functions which rely on referential transparency, immutability or both

;;comp - for creating a new function from the composition of any number of functions - because composing functions is so common in clojure that it has it's own function - comp

((comp inc *) 2 3) ; 7 => 2*3 + 1

;;another example of using comp
(def character
  {:name "Smooches McCutes"
   :attributes {:intelligence 10
                :strength 4
                :dexterity 5}})

(def c-int (comp :intelligence :attributes))
(def c-str (comp :strength :attributes))
(def c-dex (comp :dexterity :attributes))

(c-int character) ; 10
(c-str character) ; 4
(c-dex character) ; 5

;; equivalent of using comp above
(defn c-str-without-comp [c] (:strength (:attributes c)))
(c-str-without-comp character) ;4
;;but as you can tell it's a little longer and less readable

;;when you see comp you immediately know the resulting function's purpose is to combine existing functions in a well-known way
;;what if one of the functions you want to compose needs to take more than one argument?
;;A: wrap it in an anonymous function

(defn spell-slots
  [char]
  (int (inc (/ (c-int char) 2))))

;;now using comp
(def spell-slots-comp (comp int inc #(/ % 2) c-int)) ;; to divide by two all you need to do was wrap the division in an anonymous functions
;;#(/ % 2) - anonymous function that divides an input by 2

(defn two-comp
  [f g]
  (fn [& args]
    (f (apply g args))))

;;memoize - kind of like cacheing to get better performance out of calls to referentially transparent functions like the one below
(defn sleepy-identity
  "Returns the given value after 1 second"
  [x]
  (Thread/sleep 1000)
  x)

(sleepy-identity "Mr. Fantastic") ;returns Mr.Fantastic after one second - first call
(sleepy-identity "Mr. Fantastic") ;returns Mr.Fantastic after one second - second call - even though its the same input and same output

(def memo-sleepy-identity (memoize sleepy-identity))
(memo-sleepy-identity "Mr. Fantastic") ;returns Mr. Fantastic after one second - first call
(memo-sleepy-identity "Mr. Fantastic") ; returns Mr. Fantastic immediately - second call

;;memoize is useful for functions that are computationally intensive or that make network requests - any subsequent calls will not bear the cost

;;Peg Thing
(ns pegthing.core
  (require [clojure.set :as set])
  (:gen-class))

(declare succesfull-move prompt-move game-over query-rows)  ;;this allows you to use refer to these functions before they're defined

{1 {:pegged true, :connections {6 3, 4 2}},
 2 {:pegged true, :connections {9 5, 7 4}},
 3 {:pegged true, :connections {10 6, 8 4}},
 4 {:pegged true, :connections {13 8, 11 7, 6 5, 1 2}},
 5 {:pegged true, :connections {14 9, 12 8}},
 6 {:pegged true, :connections {15 10, 13 9, 4 5, 1 3}},
 7 {:pegged true, :connections {9 8, 2 4}},
 8 {:pegged true, :connections {10 9, 3 5}},
 9 {:pegged true, :connections {7 8, 2 5}},
 10 {:pegged true, :connections {8 9, 3 6}},
 11 {:pegged true, :connections { 13 12, 4 7}},
 12 {:pegged true, :connections {14 13, 5 8}},
 13 {:pegged true, :connections {15 14, 11 12, 6 9, 4 8}},
 14 {:pegged true, :connections {12 13, 5 9}},
 15 {:pegged true, :connections {13 14, 6 10}},
 :rows 5}





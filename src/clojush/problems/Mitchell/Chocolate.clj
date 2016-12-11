(ns clojush.problems.Mitchell.Chocolate
  (:use [clojush.pushgp.pushgp]
        [clojush.random]
        [clojush pushstate interpreter]
        clojush.instructions.common))

;; We want make a package of goal kilos of chocolate. We have small bars (1 kilo each) and big bars (5 kilos each).
;; Return the number of small bars to use, assuming we always use big bars before small bars. Return -1 if it can't be done.
;; Problem is from http://codingbat.com/prob/p191363

(def input-set
  [[4, 1, 9]
   [4, 1, 10]
   [4, 1, 7]
   [6, 2, 7]
   [4, 1, 5]
   [4, 1, 4]
   [5, 4, 9]
   [9, 3, 18]
   [3, 1, 9]
   [1, 2, 7]
   [1, 2, 6]
   [1, 2, 5]
   [6, 1, 10]
   [6, 1, 11]
   [6, 1, 12]
   [6, 1, 13]
   [6, 2, 10]
   [6, 2, 11]
   [6, 2, 12]
   [60, 100, 550]
   [1000, 1000000, 5000006]
   [7, 1, 12]
   [7, 2, 13]])




(defn expected-output
  [inputs]
  (let [[small big goalX] inputs]
    (if (>= (+ (* big 5) small) goalX)
      (loop [i small p big goal goalX]
        (when true
          (cond
            (= goal 0) (- small i)
            (and (<= 5 goal)(> p 0)) (recur i (dec p) (- goal 5))
            (> i 0) (recur (dec i) p (- goal 1))
              :else -1
          )
    ))
      -1)))

(expected-output [4, 1, 10])
(expected-output [1000, 1000000, 5000006])

;; From example code.
(defn make-start-state
  [inputs]
  (reduce (fn [state input]
            (push-item input :input state))
          (make-push-state)
          inputs))


; The only part of this you'd need to change is
; which stack(s) the return value(s) come from.
(defn actual-output
  [program inputs]
  (let [start-state (make-start-state inputs)
        end-state (run-push program start-state)
        top-int (top-item :integer end-state)]
    top-int))



(loop [i 7 p 5 goal 13]
  (println "goal" goal)
  (println "p" p)
  (println "i" i)
  (when true
    (cond
      (= goal 0) 1
      (and (<= 5 goal)(> p 0)) (recur i (dec p) (- goal 5))
      (> i 0) (recur (dec i) p (- goal 1))
      :else -1
    )
  ))
(loop [i 7 p 5 goal 13]
  (println "goal" goal)
  (println "p" p)
  (println "i" i)
  (when (< 0 goal)
    (cond
      (and (<= 5 goal)(> p 0)) (recur i (dec p) (- goal 5))
      (> i 0) (recur (dec i) p (- goal 1))
      :else -1
    )
  ))
(defn all-errors
  [program]
  (doall
    (for [inputs input-set]
      (let [expected (expected-output inputs)
            actual (actual-output program inputs)]
        (if (= expected actual)
          0
          1)))))

(def atom-generators
  (concat
    ; Include all the instructions that act on integers and booleans
    ; Could have :exec here, but I just am limiting things to exec-if
    (registered-for-stacks [:integer :integer :integer])
;;     (list 'exec_if)
     ; The three inputs
    (list 'in1 'in2 'in3)))

(def argmap
  {:error-function all-errors
   :atom-generators atom-generators
   :population-size 500
   })

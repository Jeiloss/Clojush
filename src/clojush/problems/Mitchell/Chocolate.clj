(ns clojush.problems.ec-ai-demos.cube-surface
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
   [4, 1, 7]])

;; takes an input list, and create an list of expected-output
(defn expected-output
  [inputs]
  (let [[small big goal] inputs]
    (if (>= (+ (* big 5) small) goal) true -1)))

(expected-output [4, 1, 10])


;; From example code.
(defn make-start-state
  [inputs]
  (reduce (fn [state input]
            (push-item input :input state))
          (make-push-state)
          inputs))





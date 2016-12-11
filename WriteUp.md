The problem we had Clojush try to solve came from "www.codingbat.com/prob/p191363":
Given a certain number of 5kg and 1kg chocolate bars, return the minimum amount of 1kg bars needed to fill an order of chocolate. If there are not enough bars to reach the correct weight, then return -1.

The problem was setup to receive a 3-integer array:
    [1kg bars , 5kg bars , target kg's]
and return the amount of 1kg bars that are needed, or a -1 if the target weight cannot be reached.

We liked how deceptively easy the problem appears. There were a few local optima that formed a rugged fitness landscape. From time-to-time, the code got sucked in by the deception, and never escaped.

The program did end up reaching a solution.

Before -and after- the goal was reached, there was quite a few failed attempts.
  One of the attempts involved deleting the atom-generators function.
    This resulted in the generations floundering about, not getting more than one correct answer through 5000 generations.
  Small poulation sizes(0- 180) are almost guaranteed to fail up to the 3000 generations tested.
  The number and type of inputs was important for how many generations it took to solve.
    The original input-set had 23 tests with most of their solutions leading towards a local optima, and took thousands of generations, if ever, to reach a correct conclusion.
    When the inputs were stripped down to the six test cases that would test all outcomes, then there the solution was usually reached in under 50 generations.

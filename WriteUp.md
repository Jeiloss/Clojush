The problem we had Clojush try to solve came from "www.codingbat.com/prob/p191363":
Given a certain number of 5kg and 1kg chocolate bars, return the minimum amount of 1kg bars needed to fill an order of chocolate. If there are not enough bars to reach the correct weight, then return -1.

The problem was setup to receive a 3-integer array:
    [1kg bars , 5kg bars , target kg's]
and return the amount of 1kg bars that are needed, or a -1 if the target weight cannot be reached.

We liked how deceptively easy the problem appears. There were a few local optima that formed a rugged fitness landscape. From time-to-time, the code got sucked in by the deception, and never escaped.

The program did end up reaching a solution.

After the code was wirtten as a group effort after we both went our own ways in testing the code, changing the paramaters either in testcases, how many generations, or population side.

Before -and after- the goal was reached, there was quite a few failed attempts.
------

* One of the attempts involved deleting the atom-generators function.
  * This resulted in a population of 650 to flounder about, not getting more than one correct answer through 5000 generations.
* Small population sizes(0- 180) are almost guaranteed to fail up on the test cases.
* The number and type of inputs was important for how many generations it took to solve.
  * The original input-set had 23 tests with most of their solutions leading towards a local optima, and took thousands of generations, if ever, to reach a correct conclusion.
  * When the inputs were stripped down to six test cases -one for each possible outcome, then there the solution was usually reached in under 50 generations.
  
------
*Aternating population size and generation size.
------

To get the code to first run we used -1 and 1, to represent if its a pass or fail. Then after that code was working the code was futher developed to include if the target could be ment or not. Then it would calculate how many 1kg bars were needed and report that number of bars that was needed.

In the 1 and -1 test case it was interstering because it passed pretty quickly at generation 217, then got simplifyed to down the a size of 31. The only parmater that was input other then the defults is the population-size of 500. Given that this is a simple -1 and 1 it sloved pretty quickly in compairson to the others.
The rest of the test cases were one that returned the number of bars if the goal stat could be ment. Testing with 1500 pop and 5001 gen came up with a failure. In the last generation the number of Errors was 1, suggesting that if either a bigger population or more generations would suggest that the problem was close to sloving.
After increasing the population to 2500, and the generation was kept at 5000. Insterting enought with the number of population incressed it was sloved at generation 904, then after auto-simplifying the size was down to 46.
So this number was insterting since it sloved in so few generations compiared to a population size of 1500. Incressing the populatio to 3500 and keeping the amount of generations the same across the board. This one sloved at generation 2454 with the successful program at a size of 51

------

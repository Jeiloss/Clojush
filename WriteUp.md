The problem we had Clojush try to solve came from "www.codingbat.com/prob/p191363":
Given a certain number of 5kg and 1kg chocolate bars, return the minimum amount of 1kg bars needed to fill an order of chocolate. If there are not enough bars to reach the correct weight, then return -1.

The problem was setup to receive a 3-integer array:  
    [1kg bars , 5kg bars , target kg's]  
and return the amount of 1kg bars that are needed, or a -1 if the target weight cannot be reached.

We liked how deceptively easy the problem appears. There were a few local optima that formed a rugged fitness landscape. From time-to-time, the code got sucked in by the deception, and never escaped.

The program did end up reaching a solution.

The code was written as a group effort, afterwards we both went our own ways in testing the code, changing the parameters either in testcases, number of generations, or population size.

  
------
Alternating population size and generation size.
------

To get the code to first run we used -1 and 1, to represent if it's a pass or fail. Then after that code was working, the code was futher developed to include if the target could be met or not. Then it would calculate how many 1kg bars were needed and report the number of bars that was needed.

In the 1 and -1 test case it was interesting because it passed pretty quickly at generation 217, then got simplified down to a size of 31. The only parmater that was input other then the defults is the population-size of 500. Given that this is a simple -1 and 1 it sloved pretty quickly in comparison to the others.
The rest of the test cases were ones that returned the number of 1kg bars if the goal state could be met. Testing with 1500 population-size and 5000 generations came up with a failure. In the last generation the number of errors was 1, suggesting that either a bigger population or more generations is needed and that the problem was close to solving.
After increasing the population to 2500, and keeping the generations at 5000. Interestingly enough, with the number of population increased it was sloved at generation 904, then after auto-simplifying the size was down to 46.
So this number was interesting since it solved in so few generations compared to a population size of 1500. Increasing the population to 3500 and keeping the amount of generations the same across the board. This one soloved at generation 2454 with the successful program at a size of 51

------
Some more things that were tried:
------
The (atom-generators ...) was deleted. The code stil initiated, but it never answered more than one test case at a time, even with a population-size of 650 and 5,000 generations. So, that was added back on and deemed important. Inside of the atom-generators, we started off by only allowing it to use {:integer 'ln1 'ln2 'ln3}. This would eventually solve, but it was a skeptical answer. So it was changed to use {:integer :boolean :exec 5 'ln1 'ln2 'ln3}. This would still solve, and more resembled what our own solution looked like.

Another change was to the test-cases. We originally started with the 23 test-caes that codingbat.com used. These were refined down to six cases, two that would fail and four that would pass. These cases tried to portray examples of each outcome. With only six test-cases and a population of 200, the answer would be reached about 60% of the time and usually before the fiftieth generation; the other 40%, 5000 generations would pass and then a failure would be reported.

The tournament selection was dabbled with, however it would *always* be a victim of deception. Tournament selection never satisfied all the test cases.

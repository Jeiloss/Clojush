The problem we had Clojush try to solve came from "www.codingbat.com/prob/p191363":
Given a certain number of 5kg and 1kg chocolate bars, return the minimum amount of 1kg bars needed to fill an order of chocolate. If there are not enough bars to reach the correct weight, then return -1.

The problem was setup to receive a 3-integer array:  
    [1kg bars , 5kg bars , target kg's]  
and return the amount of 1kg bars that are needed, or a -1 if the target weight cannot be reached.

We liked how deceptively easy the problem appears. There were a few local optima that formed a rugged fitness landscape. From time-to-time, the code got sucked in by the deception, and never escaped. However the program did end up reaching a solution.

The code was written as a group effort, afterwards we both went our own ways in testing the code, changing the parameters either in test cases, number of generations, or population size.

  
------
Alternating population size and generation size.
------

To get the code to first run we used -1 and 1, to represent if it's a pass or fail. Then after that code was working, the code was further developed to include if the target could be met or not. Then it would calculate how many 1kg bars were needed and report the number of bars that was needed.

In the 1 and -1 test case it was interesting because it passed pretty quickly at generation 217, then got simplified down to a size of 31. The only parameter that was input other then the defaults is the population-size of 500. Given that this is a simple -1 and 1 it solved pretty quickly in comparison to the others.

The rest of the test cases were ones that returned the number of 1kg bars if the goal state could be met. Testing with 1500 population-size and 5000 generations came up with a failure. In the last generation, the number of errors was 1, suggesting that either a bigger population or more generations is needed and that the problem was close to solving.

After increasing the population to 2500, and keeping the generations at 5000. With the number of population increased it was solved at generation 904, then after auto-simplifying the size was down to 46.
So this number was interesting since it solved in so few generations compared to a population size of 1500. Increasing the population to 3500 and keeping the amount of generations the same across the board. This one solved at generation 2454 with the successful program at a size of 51. After increasing the number of generations the from 2500 to 3500 did not solve the test cases.

------
Some more things that were tried:
------
The (atom-generators ...) was deleted. The code still initiated, but it never answered more than one test case at a time, even with a population-size of 650 and 5,000 generations. So, that was added back on and deemed important. Inside of the atom-generators, we started off by only allowing it to use {:integer 'ln1 'ln2 'ln3}. This would eventually solve, but it was a skeptical answer. So it was changed to use {:integer :boolean :exec 5 'ln1 'ln2 'ln3}. This would still solve, and more resembled what our own solution looked like.

Another change was to the test-cases. We originally started with the 23 test-cases that codingbat.com used. These were refined down to six cases, two that would fail and four that would pass. These cases tried to portray examples of each outcome. With only six test-cases and a population of 200, the answer would be reached about 60% of the time and usually before the fiftieth generation; the other 40%, 5000 generations would pass and then a failure would be reported.

The tournament selection was dabbled with, however it would *always* be a victim of deception. Tournament selection never satisfied all the test cases.

------
In both cases it seems that increasing either the population or generation would have a positive effect on the chances of solving the program. In the first run of results, the original 23 test-cases were taken from codingbat, but there seemed to be a local optimum on the test cases. Since -1 is returned if the problem is unsolvable. Then there are multiple test cases in the given example in codingbat that return just 1. Since in the first example it solved very quick in terms of generations at 217. The rest, when solving the problem and returning the number of 1kg bars that were needed, took a long time for the program to solve. Since this returned the number -1 when not working, and if it was solvable then it returned a number. In this case it took the program much longer to solve, or in the case of playing within the atom-generators and some custom test-cases it came up with a solution pretty quickly or never passed.

Further testing and changing the test-cases so they represent a more broad range of numbers instead of just returning more fails. In the case of it passing more then 1 bar in multiple problems. If the test cases represented a broad range of numbers, and if -1 is not returned as much then the program could pass more quickly. Instead of taking a lot of generations and computation time. It would be ideal to change the test cases in a way that there would not be a local optimum in just a few of the problems causing the program to essentially hill climb over these answers.

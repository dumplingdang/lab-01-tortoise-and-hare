# lab-01-tortoise-and-hare
## Create a Hare class:
- A Hare has a position represented as an integer. Position can be negative.
- A newly created Hare begins at position 0.
- The Hare has a public move( ) method which accepts no parameters and returns the Hare’s position after itmoves. Themove method will use a randomnumber to determine what happens
when the Hare is prompted to move:
  - 20% of the time the Hare sleeps and doesn’t move.
  - 30% of the time the Hare take a big hop and moves forward 9 units.
  - 10% of the time the Hare suffers a big slip and moves backward 12 units.
  - 30% of the time the Hare takes a small hop and moves forward 1 unit.
  - the rest of the time, the Hare suffers a small slip and moves backward 2 units.
- The Hare needs an accessor and a mutator for its position

## Create a Tortoise class:
- A Tortoise has a position represented as an integer.
- A newly created Tortoise begins at position 0.
- The Tortoise has a public move( ) method which accepts no parameters and returns the Tortoise’s position after it moves. The move method will use a random number to determine what
happens when the Tortoise is prompted to move:
  - 90% of the time the Tortoise moves forward 4 units with a fast plod.
  - the rest of the time, the Tortoise slows down to eat some grass (for energy, like) and moves forward only 1 unit with a slow plod.
- The Tortoise needs an accessor and a mutator for its position.

## Create a Race class:
- A Race manages one Tortoise and one Hare (think unidirectional association). A Race also has a distance, stored as an int. You may need some additional instance variables and some
may need accessors. Minimize the moving parts, though!
- The Race constructor must accept an integer that represents the length of the Race. It must also create a new Tortoise and a new Hare and assign the new objects to the instance variables.
- Race requires a public method called reset which accepts no parameter and uses the Tortoise and Hare position mutators to set its Tortoise and Hare instance variables’ positions to 0.
- Race requires a public simulateRace method. This method accepts no parameters and returns a String representation of the winner’s type ("Tortoise" or "Hare"). It must start by invoking
reset, to ensure the racers are at the starting line. And then it should invoke a private helper method called race(). It must use the results of race( ) to determine who won.
- The private race method accepts no parameters. It must use a loop. We will pretend that each iteration of the loop is one time unit in the race. Perhaps each iteration is a tick of the clock,
for example. With each tick of the clock, the method should invoke the move method for each animal. In order to be fair, randomly choose who moves first each time. The loop must end
as soon as the first competitor crosses the finish line, and the method must return a String representation of the winner ("Tortoise" or "Hare").

## Creat a Driver class:
- Race the Tortoise and the Hare a distance of 100 units and report who won. Ensure the output is formatted carefully and tell me their final positions and how many ‘clock ticks’ elapsed.
- Simulate 100 races of length 100. Who won the most? Report the number of wins for each competitor.
- Simulate 100 races of length 1000. Who won the most? Report the number of wins for each competitor.
- Is there any duplicated logic in your Driver class? Probably. You may wish to extract the duplicated
logic and create an additional method inside Driver called simulateRaces that is static (it has to be in order to be accessed from main) and which accepts two parameters, the number
of races and the length of the race. This method should return a formatted string that reports the number of wins for each competitor.
- In the class comment for Driver, please answer the question: who wins the most?

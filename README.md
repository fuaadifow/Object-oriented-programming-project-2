# Object-oriented-programming-project-2
Complete the abstract superclass named Creature and two subclasses, Goblin
and Basilisk. The parent class has four integer attributes: the position of the
creature which is a point represented by X and Y coordinates, the health level and
the attack power. The Goblin class has one additional attribute, a final constant
representing the distance of attack with value 3. The Creature class includes four
methods:
• The attack() method: a void method that takes in one Creature object parameter and reduces the health level of the attacked creature by the power of the
attacker, only if the target is in the attack range (call to isInRange() method).
• The isInRange() method: this is an abstract method that is implemented
in the child classes Goblin and Basilisk, according to their specific attack
ranges illustrated below. The method returns a boolean representing whether
the target is in the attack range or not.
• The move() method: a void method that takes in two integer parameters, the
amount of points to move by in both X and Y directions. It calculates the new
positions by adding the parameters to the current X and Y positions (i.e if the
position of the creature on the grid is (X, Y) = (2, 4) and the creature is moved
by (3, 2), the final position is (5, 6)).
• The isDefeated() method: it assesses whether a creature is defeated (the
health levels are lower or equal to 0) or not and returns a boolean.
Note that the method isInRange() is abstract, so the Goblin class and the Basilisk
class will have their own implementations. In addition, the child classes have one
constructor each:
1. Both constructors take in two parameters, the X position and the Y position.
1
2. For the Goblin, the max health is set to 80 and the power to 15.
3. For the Basilisk, the max health is set to 200 and the power to 30;
The ranges of attack are illustrated in the figures below. For the Goblin, the range
of attack is a surrounding circle with radius given by a final constant, the distance
of attack, with value 3. For the Basilisk, the range of attack is + 2 in the Y
direction, spread between five cells in the X direction (X-2 : X+2). Implement the
isInRange() method for Goblin and Basilisk according to these rules.
The classes and method signatures are provided in the template files named
Creature.java, Goblin.java and Basilisk.java. The tests for the methods in
each class are found in CreatureTest.java, GoblinTest.java and BasiliskTest.java

CS 407
Final Project
Due Wednesday 12/03/2014

FOR THE FINAL PROJECT WORK IN GROUPS OF 3-4.  IF YOU DO NOT HAVE A GROUP I WILL ASSIGN YOU TO ONE– MAKE SURE ALL OF YOUR NAMES ARE IN ALL CLASS COMMENTS
On every interim assignment, checkpoint, and final project you will have a requirement to indicate the specific contribution of each group member which will weigh into each person’s grade.
Without fail there is always some group that has a member that doesn’t contribute at some point(s).  Make sure you have core functionality taken care of early and if rest of design is modular (as it should be with these patterns) you will be able to demonstrate all work you have done and by reporting all along the way contributions and areas of responsibility I will be able to evaluate the people that did participate (and those that didn’t) accurately.

Please remember creating good documentation for your code is a major part of good software development and is a factor in all work delivered in this class.

For the final project you will be creating a creature simulator/game.  There is a basic structure I want to see for a couple of key things related to using good software development techniques, but I am leaving the details up to you.  
There will be a number of specific implementation assignments throughout the rest of the semester that you can incorporate into your implementation
Also a number of checkpoints to make sure you are on the right track

While there are a few required design patterns be used, other aspects such as good design to support other principles we have talked about like encapsulation will also factor into the grade.  In beginning assignments I will give you specifics of how to include in final project, as semester progresses I will ask you to include a design pattern, but where you include it will be completely up to you and your implementation.  This is not a cookie cutter project in that you are developing to specific application requirements.  Rather you will be developing to specific design pattern requirements allowing/forcing you to be creative in designing a game/simulation feature that makes sense to include that pattern.  I want you to be creative and look for ways to differentiate your simulation from the rest of the class.

The basics of the game/simulation are there is a grid world/board that is populated with creatures that are trying to survive. The user will be able to “design” creatures, run the simulation with various parameters, and see how the resulting species did in terms of survival and evolution and if they created a stable world.

Application interaction:
The program is started with 5 arguments
A directory that holds any number of creature description files
A plant growth rate 
Evolution/Mutation rate
The frequency of output, and 
Board size (assume the board is square so 50 would indicate a 50x50 board)
Number of iterations (-1 means unlimited)

The application would then load the board with the types of creatures specified in the creature description files.  Probably some sort of randomization with some squares populated and others not.  For each cycle, each creature does the same basic operation, taking a turn moving then performing some action and with some probability of cloning or evolving. After the creatures’ moves have been processed, the plant growth should take place following rules of your choosing. This will continue with output of the current count of each type creature every X cycles as specified by the frequency of output argument.

The creatures – there are a couple of basic types of creature behaviors that should be supported and you can add more
Animal type (Meat eater, omnivore, plant eater)
Movement behavior (random, fight (move toward creatures) or flight (move away from creatures)
Movement rate – number of move->actions that should take place for each of the animal’s turns
Can cannibalize
Animal size
Can eat larger animals
The user should be able to specify each of these within the creature file to define a species of creature.  An animal can also evolve which would mean one feature of the animal would change randomly.
For output your program should output a string representation of the traits of the remaining animals sorted by animal type first and then by size.
Ex.	Meat eater, random, 3 moves, size 3,…  - 4 creatures
		Meat eater, fight, 3 moves, size 2,…  - 5 creatures

Key things you must include/create:
Short word document describing the format of your creature file, it is also critical if your application doesn’t completely work you describe which parts do so I can make sure to give you as much credit as possible.  
Sample call to the program, Sample creature files and output from a sample run
Class diagram for your project
JUnit test conditions for all code
Singleton animal creation factory
Use of iterators for going through creatures on the board
Creatures use composition for movement behavior which can be swapped when the creature evolves (you can use it for other behaviors as well of course)
Strategy pattern used for movement behavior
Comparator used for creature sorting
Extra credit
[up to 8pts] Being creative and adding above and beyond additional features to the basic application designed above.  The amount of credit will be dependent on your use of additional design patterns and/or frameworks you introduce specifically related to the extra functionality.  A description of this extra credit including design decisions should be added to your word document
[up to 4pts] Adding a graphic interface to the application

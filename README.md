# trivia-maze

# Trivia Maze
Create a maze that a player must navigate through from entrance to exit.  The maze is composed of rooms.  Each room has 1 or more doors (the design is up to you).  In order for the user to pass through a door, s/he must correctly answer a question.  

The type of questions asked are up to you, but you should have multiple choice, true/false, and short answer (one or two words/ one or two numbers).  The questions (and their corresponding answers) must be stored in a SQLite database.  The format of the database is up to you, but you might want to categorize your questions into the different formats you must display them in.

If a the user is unable to answer a question, that door is then locked permanently.  If the user is unable to make it from the entrance to the exit (due to locked doors), the game is lost.

You may display one room at a time, the entire maze, or the current room and the entire maze.

You are welcome to implement variations on this theme, but run them by your instructor first.  You might place items in the room that can help the user (magic key that gets you through one door, a hint (ala "Who Wants to be a Millionaire") that reduces the multiple choice options or gives you the first letter/digit of an answer that must be typed.

### Other important details

The size of the maze is up to you, but must be at least four by four rooms.  You can randomly place the entrance and exit, or you can fix them at opposite ends.
Provide the means for the user to save the game and of course load a saved game.  Serialization can help greatly with this.
Provide an admin tool that allows for entry of questions and answers into the database.  
Make sure user input is scrubbed as necessary to prevent undesired behavior from the program.  More specifically user input should not crash the program or make it behave unexpectedly.
Include cheats as necessary to allow for easy testing of the program.  Be sure and document those cheats at the top of your source code.
Extra points will be given if you successfully incorporate audio and/or video into the questions.
Tools

You MUST use git to version your project.  You *MUST* also use Pivotal Tracker to plan and manage your project.  You MUST incorporate unit tests into your code base.  On the Java side you can use JUnit, on the C# side there is NUnit and also the unit testing suite provided by Visual Studio.  You are welcome to use Eclipse or IntelliJ for Java projects and Visual Studio or VS Code for C# projects.

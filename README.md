# JavaMinesweeper

This is a project for my \_nology course. The idea is to replicate the original game 'Minesweeper' in Java,
without the use of any online tutorials.

![Minesweeper Gif](./Assets/Minesweper.gif)

# What I learned during this project

This was my first experience with using Java, or any similar language. It'd certainly been a paradigm shift from JavaScript and React. Mostly,
I got a better understanding of how the language works, and how to work within the Eclipse IDE.

# What I struggled with

It was difficult to context switch every day between Java and JavaScript with one language in the morning and one in the afternoon. Instead of just jumping straight from one to the next, I may benefit from a short break in between.

I'm still a ways off with the Java syntax as well, though this project helped greatly. I'm sure I could have utilized streams and maybe interfaces in
this project, but I needed to make it work by the due date, so this will be the focus of a refactoring exercise.

The logic for discovering the surrounding mines to a tile and the cascading functionality seems very bloated, but I'm not yet sure how else to approach it.

# What still needs to be done?

There's still a lot of code that needs to be moved around, particularly out of the App file. This should really just be calling the game to begin,.

There's a remaining bug with one input being repeated which needs to be addressed before anything else.

The ability to 'flag' a square so that you can't accidentaly trigger it shouldn't be too difficult to implement, and each tile object already has
a boolean assigned for this purpose.

There's a way to add colour to both characters and backgrounds in Java, which could make the program more visually distinct

Testing could be implemented.

# What would I do differently on a rebuild?

This was a difficult project in that I've never done anything like it before, in a language that I'm new to. I would make sure to separate
the logic out from the start, so that there's much less work to do in the refactor stage, but once this has been passed in I'm going to go check a few
online tutorials to see other implementations.

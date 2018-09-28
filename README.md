# Poneymon

Work done for a school subject at University Claude Bernard Lyon 1 (M1if01).

Poneymon is game where 5 poneys race. To win, they must complete 5 laps.

The first two poneys are controlled by humans. The last three are controlled by a basic artificial intelligence.

The programm follows the MVC pattern, and the build is managed by Maven.

## Getting Started

In the terminal, go the folder you want to download the project.
First, clone the git project.

```
git clone https://forge.univ-lyon1.fr/p1103680/m1if01.git
```

Then, run the command
```
mvn install
```

If "BUILD SUCCESS" is displayed, you can run the following command to execute the application

```
mvn exec:java
```

If not, we messed up.

## Game Command 

#Buttons
You can pause and restart the game. The restart button keeps the poneys' number of victories.
You can activate the first two poneys nian mode with the buttons related to their color.

There also is a window where poneys' information is displayed, plus another window where the rank of each poney is displayed.


## Running the tests

When installing the project, tests are automatically run. But you can also manually launch them with the command
```
mvn test
```


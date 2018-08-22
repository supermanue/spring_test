# SPRING TEST

this is a program to learn the basics of Spring dependency injection.

It simulates a paper-rock-scissors game.


## Submission
Please find my submission for the problem. It has been implemented with the following languages and libraries:

- Language: Java 1.8
- Build tool: Graddle
- External libraries:
  - Spring: application framework. Used mainly for dependency injection
  - Junit: testing library
  - Mockito: mocking library, also for testing


## CODE ORGANIZATION

I have organized the code in the following modules:

- src: source files

  - model: contains the data models.

  - controller: tools to control the execution: control input/output, implement the gaming logic and orchestrate the execution.

  - configuration: configuration files. Currently there is only one, the Spring configuration file that initialises all the controllers.

  - artificialIntelligence: implements the computer player. There is a single entry point (AI) that support different strategies. I have implemented two basic ones, one based in purely random numbers and other that takes into consideration the last user inputs.  

- test: test files

  - unit: unit testing for each command and controller, making sure that they work as expected under different conditions (happy path and a wide set of errors)

  - integration: integration tests, checking that the system is capable of playing a game.

## CODE DESCRIPTION

I have tried to make the application quite self-explanatory, so here I'll be just briefly describe the architecture and some particular decisions.

As can be seen, the application is organized around different modules taking care of the different responsibilities: input, output, game logic and a general orchestrator. Note that I have not implemented an interface for each one to simplify the readability and design. I have however done that in the case of "Strategy" to exemplify the design pattern (basic OOP).

Spring is used for dependency injection. The idea behind that is that we only want one of each controller. In AppConfig file, all of them are initialized. In the case of "Strategy", the desired implementation of the interface is chosen here, so a different one could be employed all around the code by just modifying it here.

Testing is organized in two modules, unit and integration test. I have included unit tests for every class covering most of the code, although in some cases it is pretty simple. An exception here is "App", as it basically acts as an orchestrator so the unit tests do not completely cover its functionality. Integration test shows how more than one module work together. In particular, a whole game is performed, demonstrating that the modules are correctly integrated.

In order to perform both unit and integration tests I have used JUnit and Mockito libraries. Mocks are widely employed to fake user input and to isolate the software unit being tested from the other ones.

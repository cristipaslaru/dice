# dice
Dice application is a spring boot application that manage the rolling dices. 
we can configure how many dice to roll, how many slides to have and how many rolls.
the information returned:
  1. how many times each total has been rolled.
  2. simulation details, how many rolls, how many simulations for each group of dice-slide
  3. relative distribution, the percentage of each sum compared with total number of rolls.
  

Application url: http://localhost:8080/swagger-ui-dice.html

Running dice app:
  1. git clone
  2. run jar file. 
  or
  1. git clone
  2. import to intelij.
  3. run DiceApplication class
  
 Architecture:
  1. basic sprint boot application
  2. structured in layers: controller - service - repository
  3. in memory database. 
  4. hibernate for database mapping and table creation.
  5. jUnit for test unit.

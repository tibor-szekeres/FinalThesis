## UPDATED - 2021.11.28

## The test's coverage in the application: 
* Log in,
* Change day to Monday, 
* Start a Workout,
* Finish that workout (validate by text if it is actually finished)
* Change finished workout after:
* Searching in search bar for: back
* Choose a workout that has 'back' in it (validate by text if swapped workout equals with expected workout)
* Select a meal, add to shopping cart
* Delete shopping cart
* Add snacks to shopping cart and delete them
* Search for a meditation article
* Search for a program
* Sign out
    
## TODO before running AT:
* install allure
* mvn clean test - allure serve to cmd line - reports are opened in browser
* check chromedriver.exe version, depending on chrome's version
   
## Notes:
* Since the project was built and optimized on my computer i've given wait times compared to my internet and hardware specifics -> it may run differently (fail) on other computers
   
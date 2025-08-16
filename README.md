## A sample implementation demonstrating Hexagonal Architecture and modular design, featuring testing with BDD and TDD approaches.

The repository presents an implementation of Hexagonal Architecture combined with modularization. This approach ensures high cohesion and low coupling.
Such a design supports Behavior Driven Development (BDD), which in turn enables:

- ✅ Unit tests executed in milliseconds
- ✅ Creating tests focused solely on the behavior of each module (Refactoring does not require changes to the tests)
- ✅ Testing only the module's entry point: the facade (No unnecessary testing of internal module structure—no need to test each class individually)
- ✅ Defining tests that describe requirements (Living documentation)
- ✅ Having a sufficient number of integration/acceptance tests with an emphasis on performance (Minimal waiting time for test completion)
- ✅ Defining modules with high cohesion (Everything hidden except for API interfaces) and low coupling (Modules connected via APIs)
  This architecture is easy to understand, maintain, and explain.

# The problem

Each project starts with a problem, from which we get a set of requirements.

## Car Rental Management System

The Car Rental Management System is a software solution designed to streamline the operations of a car rental business.
This system manages the core business processes including car inventory management, rental pricing calculations, and customer loyalty programs through a bonus points system.

## Functional Requirements
* Car Inventory Management
* Rental Price Calculation
* Customer Bonus Points Management

## Car Inventory Management
   Maintain a comprehensive database of available cars including car details (make, model, year, category), track real-time availability status, and manage car condition and maintenance records.

## Rental Price Calculation
   Price
   The price of rentals is based on type of car rented and how many days the car is rented for. The customers specify rental duration when booking and pay up front. If the car is returned late, then rent for the extra days is charged when returning.

   Car types
   The rental company has three types of cars:

- ✅ Premium cars – Price is 300 EURO times number of days rented.
- ✅ Standard cars – Price is 300 EURO for the first 5 days and then 100 EURO times the number of days over 3.
- ✅ Economy cars - Price is 150 EURO for the first 5 days and then 60 EURO times the number of days over 5.

The program should expose a REST-ish HTTP API. The API should (at least) expose operations for:

Renting one or several cars and calculating the price.
Returning cars and calculating possible surcharges.

**Examples of price calculations:**
- ✅ Tesla Model S (Premium car) 1 day: 300 EURO
- ✅ BMW 3 Series (Standard rental) 5 days: 300 EURO
- ✅ Toyota Corolla (Standard rental) 2 days: 120 EURO
- ✅ Volkswagen Polo (Economy car) 7 days: 210 EURO

**Total price: 920 EURO**

**When returning cars late:**
- ✅ Tesla Model S (Premium car) 2 extra days: 600 EURO
- ✅ BMW 3 Series (Standard rental) 1 extra day: 100 EURO

**Total late charge: 700 EURO**

## Customer Bonus Points Management
   Customers get bonus points when renting cars. A premium car rental gives 2 points and other car types give one point per rental (regardless of the time rented).
   
# Acceptance specifications

After gathering a problem description in natural language, the next step is to create specifications for our project.
That is, to split our requirements into a set of scenarios that describe the behavior (user stories) of a system.
At this point, we follow the best practices of BDD (Behavior-Driven Development).
For this car rental project, we can create one main happy path specification.
If this specification is implemented, our project brings money.

## Positive car rental scenario

    As a customer of a car rental service I want to:
        given: 'inventory has an economy car "Toyota Corolla" and a premium car "BMW X5"'

        when: 'I go to /cars'
        then: 'I see both cars available'

        when: 'I go to /loyalty-points'
        then: 'I see I have no loyalty points'

        when: 'I post to /calculate with both cars for 3 days'
        then: 'I can see it will cost me 1200 EURO for BMW X5 and 500 EURO for Toyota Corolla'

        when: 'I post to /rent with both cars for 3 days'
        then: 'I have rented both cars'

        when: 'I go to /rentals'
        then: 'I see both cars are currently rented'

        when: 'I go to /loyalty-points'
        then: 'I see I have 3 loyalty points'

        when: 'I post to /return with BMW X5'
        then: 'BMW X5 is returned successfully'

        when: 'I go to /rentals'
        then: 'I see only Toyota Corolla is still rented'

# Modules

High level design of modules:

Cars
* providing a list of available cars
* adding a new car
* removing a car

Loyalty Points
* providing a list of loyalty points
* adding a new loyalty point

Rentals
* providing a list of rentals
* adding a new rental
* removing a rental
* calculating the price of a rental

Returns
* returning a car

Users
* providing a list of users
* adding a new user

After defining the modules, we can verify module design and connectivity. The main goal is to ensure high cohesion and low coupling.
(Modules don't talk frequently to each other, the communication is via APIs.)

# Start implementation

At this point, we can start to implement first modules using BDD approach. 
Firstly, we introduce acceptance specification that is represented in the form of a integration test.

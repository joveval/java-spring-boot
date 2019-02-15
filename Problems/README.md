# @Controller and @RestController

## 1. Create a web service following the next definition:

*	Path: localhost:8081/api/numbers/generateRandomInteger
*	Method: GET
*	Response: JSON
```
{
	randomNumber: 10,
	generationDate: 01-01-2019
}
```
	
## 2. Create a web service to calculate lower integer in a list:

*	Path: localhost:8081/api/numbers/getLower
*	Method: POST
*	Request Body:
```
[ 100,22,-1,-50,2000,30 ]
```


*	Response: JSON
```
{ minVal: -50 }
```

## 3. Create a web page.
Create a web page that prints hello world {name}. Where name is a parameter passed as a path variable. Example: localhost:8080/hello/José -> prints hello world José.

# @Service, @Component, and JUnit

## 1. Create a service to build a random tree.
Given two parameters: `w` and `d`. You must create a tree of random numbers (from 0 to 1) that has a maximum of `w` children per node (width) and `d`nodes from root to any leaf (depth).
*	Input: `w = 2, d = 2`
*	Output: JSON
```
{
	nodeValue: 0.5,
	children: [
		{
			nodeValue: 0,
			children: []
		},
		{	
			nodeValue: 1,
			children: []
		}
	]
}
```  



## 2. Create a @Component and @Service to upper case a string.
Create a @Component class and define inside a function to upper case each letter of a String variable passed as input parameter. Then create a @Service class that calls this external function and finally return the result as a ResponseEntity.
Given a String parameter: `original`. You must return another String with all characters upper-cased.
*	Input: `original = 'hoLa mundo 2019'`
*	Output: JSON
```
{
	original: 'hoLa mundo 2019',
	upperCased: 'HOLA MUNDO 2019'
}
```  
After accomplishing this, create a JUnit test to validate this the above example.

# @Repository

## 1. Create a @Repository to save, update, delete, and search an @Entity
Create a repository to persist, update, delete and make request (with filters) to a database (mysql) table called Transaction.
Transaction must have the following attributes: 
```
id (int,autoincrement)
trans_name (varchar(100))
trans_date (date)
amount (double)
```
## 2. Publish as web service (without using data rest)
Publish save, update, delete, and findAll (paged) as web service (hint: create a @RestController and use @PostMapping,@PutMapping,@DeleteMapping and @GetMapping respectively)

## 3. Create a JUnit unit test
Create a JUnit test to consume those web services and validate correct response of each one.
	

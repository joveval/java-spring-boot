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

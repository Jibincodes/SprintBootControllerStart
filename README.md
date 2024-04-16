# Exercise Instructions

## Pre-requisites
- Import this repository into your own GitHub workspace
- Open the project in Codespaces, this will take a few minutes
- Once opened, go to Java Projects and Import Projects

# Exercise 1

### Understand Controllers and Endpoints
- Refer to WelcomeController.java and the GET mapping in this class. Note the class level annotation @RestController.
- Run the application and access the endpoint on the browser by appending /welcome to the URL. The welcome message should appear.
- Change the endpoint such that the welcome string is displayed as soon as the application starts, i.e., without appending /welcome.
- Same functionality can be achieved by changing the startup class (PizzaApplication) into a Controller class:
    - Add the annotation @RestController at the class level
    - Add a GET mapping to display a welcome message as follows:
    ```Java
            @GetMapping(value="/")
        	public String getWelcomeString() {
            return "Pizza Takeaway Service, welcome!";
        	}
    ```

### Create new Controller and Endpoints
Let's add the endpoints for CRUD operations on the Pizza entity. Please refer to the exercise on defining API endpoints for a pizzeria.

- Refer to PizzaController.java
- Add an appropriate annotation to make it a Controller class
- Add a unique path "menu" to access all requests to the PizzaController
```Java
    @RequestMapping(path="/menu")
```
- Add the following endpoint to the PizzaController:
    - GET /pizzas
    - Write a method to create a list of pizzas
    - Use the given Pizza data object to access dummy data through the Controller
    - Add GetMapping to the method – define path “/pizzas” and the data format “application/json”
    - Use the ResponseEntity object to return successful and error response
    ```Java
        //get list of pizzas
        @GetMapping(path="/pizzas", produces = "application/json")
        public ResponseEntity getPizzaList() {
            List<Pizza> pizzaList = new ArrayList();

            Pizza pizza1 = new Pizza();
            pizza1.setId(1);
            pizza1.setPizzaName("Margherita");
            pizza1.setPizzaToppings("Mozzarella, Tomato Sauce, Basil");

            Pizza pizza2 = new Pizza();
            pizza2.setId(2);
            pizza2.setPizzaName("Quattro Stagioni");
            pizza2.setPizzaToppings("Mozzarella, Tomato Sauce, Ham, Mushrooms, Artichokes, Olives");

            pizzaList.add(pizza1);
            pizzaList.add(pizza2);

            if(pizzaList.isEmpty())
                return ResponseEntity.notFound().build();
            return ResponseEntity.ok(pizzaList);
        }
    ```
    - Start the application and test the endpoint by appending /pizzas to the URL. Test directly in the browser or using Postman.

- Similar to the above approach, create the following endpoints:
1. GET /pizzas/{id}
    - Write a new method with input as id of the pizza, annotate it using @PathVariable.
    - Add the annotation @GetMapping to the method.– Define path “/pizzas/{id}” and the data format “application/json”.
    - Use the ResponseEntity object to return successful and error response.
    - Test using the browser or Postman.
    ```Java
    @GetMapping(path="/pizzas/{id}", produces = "application/json")
    public ResponseEntity getPizza(@PathVariable Long id) {
        Pizza pizza1 = new Pizza();
        pizza1.setId(1);
        pizza1.setPizzaName("Margherita");
        pizza1.setPizzaToppings("Mozzarella, Tomato Sauce, Basil");

        if (id == 1) {
            return ResponseEntity.ok(pizza1);
        }
        return ResponseEntity.notFound().build();
    }
    ```

2. POST /pizzas
    - Write a new method that has Pizza object as an input, annotate it using @RequestBody.
    - Add the annotation @PostMapping to the method – define path “/pizzas”, data format that is consumed and the data format that is produced.
    - Use the ResponseEntity object to return successful response.
    - Test using Postman.
    ```Java
    @PostMapping(path="/pizzas", consumes="application/json", produces = "application/json")
    public ResponseEntity addPizza(@RequestBody Pizza pizza) {
        //TODO: process POST request

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    ```

3. PUT /pizzas/{id}
    - Write a new method that has the pizza id and the Pizza object as inputs, annotate using @PathVariable and @RequestBody respectively.
    - Add the annotation @PutMapping to the method - define path "/pizzas/{id}", data format that is consumed and the data format that is produced.
    - Use the ResponseEntity object to return successful response
    - Test using Postman.
    ```Java
    @PutMapping(path="/pizzas/{id}", consumes="application/json", produces = "application/json")
    public ResponseEntity updatePizza(@PathVariable Long id, @RequestBody Pizza pizza) {
        //TODO: process PUT request
        
        return ResponseEntity.ok(pizza);
    }
    ```

4. DELETE /pizzas/{id}
    - Write a new method that has the pizza id as an input, annotate it using @PathVariable.
    - Add the annotation @DeleteMapping to the method - define path "/pizzas/{id}".
    - Use the ResponseEntity object to return successful response.
    - Test using Postman.
    ```Java
    @DeleteMapping(path="/pizzas/{id}")
    public ResponseEntity deletePizza(@PathVariable Long id) {
        //TODO: process DELETE request
        
        return ResponseEntity.noContent().build();
    }
    ```

# Exercise 2
Follow similar steps to create end points for (pizza) orders.


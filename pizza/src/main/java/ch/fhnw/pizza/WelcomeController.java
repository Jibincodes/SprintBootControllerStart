package ch.fhnw.pizza;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping(value="welcome") // this is mapped to http://localhost:8080/welcome 
    // so remember to start the application and change url to welcome
    // if you want it in the base url, you can change it to @GetMapping(value="/")
    public String getWelcomeString() {
        
        return "Hello, welcome to our Pizzeria!";
    }


}

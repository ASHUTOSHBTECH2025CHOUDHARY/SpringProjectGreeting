package com.Greeting.Greetings.controller;

import com.Greeting.Greetings.model.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private List<Greeting> greetings = new ArrayList<>();

    public GreetingController() {
        // Initialize with sample data
        greetings.add(new Greeting(1, "Hello"));
        greetings.add(new Greeting(2, "Welcome"));
        greetings.add(new Greeting(3, "Good Morning"));
    }
    //UC1 get
    @GetMapping
    public List<Greeting> getAllGreetings() {
        return greetings;
    }
    @GetMapping("/{greetId}")
    public Greeting getGreetingById(@PathVariable int greetId) {
        return greetings.stream()
                .filter(g -> g.getGreetId() == greetId)
                .findFirst()
                .orElse(new Greeting(0, "Greeting Not Found"));
    }
    //UC1 POST
    @PostMapping("/add")
    public String createGreeting(@RequestBody Greeting newGreeting) {
        greetings.add(newGreeting);
        return "Greeting Added Successfully!";
    }

    //UC1 PUT
    @PutMapping("/{greetId}")
    public String updateGreeting(@PathVariable int greetId, @RequestBody Greeting updatedGreeting) {
        for (Greeting g : greetings) {
            if (g.getGreetId() == greetId) {
                g.setMessage(updatedGreeting.getMessage());
                return "Greeting Updated Successfully!";
            }
        }
        return "Greeting Not Found!";
    }

  //UC1 Delete
    @DeleteMapping("/{greetId}")
    public String deleteGreeting(@PathVariable int greetId) {
        if (greetings.removeIf(g -> g.getGreetId() == greetId)) {
            return "Greeting Deleted Successfully!";
        }
        return "Greeting Not Found!";
    }
}

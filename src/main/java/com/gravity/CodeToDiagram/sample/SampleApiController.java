//just to give an hardcoded input for demo purpose
//Sample API 1 -
/*
package com.gravity.CodeParser.sample;
import org.springframework.web.bind.annotation.*;

@RestController
public class SampleApiController {

    @GetMapping("/api/test1/{name}")
    public String test1(@PathVariable String name) {
        return "First, " + name;
    }

    @GetMapping("/api/test2/{name}")
    public String test2(@PathVariable String name) {
        return "Second, " + name;
    }

    //can add more HTTP methods
}
*/

/* Sample API 2*/

package com.gravity.CodeToDiagram.sample;
//package com.gravity.CodeParser.api;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/sample")
public class SampleApiController {

    // GET method
    @GetMapping("/users")
    public List<String> getUsers() {
        return List.of("Alice", "Bob", "Charlie");
    }

    // POST method
    @PostMapping("/users")
    public String createUser(@RequestBody String user) {
        return "User " + user + " created!";
    }

    // PUT method
    @PutMapping("/users/{id}")
    public String updateUser(@PathVariable("id") String userId, @RequestBody String user) {
        return "User " + userId + " updated with name " + user;
    }

    // DELETE method
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") String userId) {
        return "User " + userId + " deleted!";
    }

    // External API call (dummy method)
    @GetMapping("/external")
    public String callExternalApi() {
        // Simulate calling an external API
        return "Called external API";
    }
}

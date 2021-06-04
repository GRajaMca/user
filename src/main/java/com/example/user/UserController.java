package com.example.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${customer.url}")
    private String url;

    @GetMapping(value = "/user")
    public User getUserInfo() {
        return User.builder().id(1L).name("Raja").build();
    }


    @GetMapping(value = "/user/{userId}")
    public User getUser(@PathVariable("userId") Long userId) {
        log.info("Requested userId : {}", userId);
        return User.builder().id(1L).name("Raja").build();
    }

    @GetMapping(value = "/user/customer")
    public Customer getUserCustomer() {
        return this.restTemplate.getForObject(this.url, Customer.class);
    }

}

@Data
@Builder
class User {
    private String name;
    private Long id;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class Customer {
    private String name;
    private Long id;
}

package com.example.springbootcrud;

import com.example.springbootcrud.model.Employee;
import com.example.springbootcrud.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@SpringBootApplication
public class SpringbootcrudApplication {
    private static final Logger log = LoggerFactory.getLogger(SpringbootcrudApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(SpringbootcrudApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(EmployeeRepository repository) {
        return (args) -> {
            // save a few customers
            repository.save(new Employee("Jack", "Bauer"));
            repository.save(new Employee("Chloe", "O'Brian"));
            repository.save(new Employee("Kim", "Bauer"));


            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Employee e : repository.findAll()) {
                log.info(e.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            Employee e = repository.findById(1L);
            log.info("Customer found with findById(1L):");
            log.info("--------------------------------");
            log.info(e.toString());
            log.info("");

            // fetch customers by last name
            log.info("Customer found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            repository.findByLastName("Bauer").forEach(bauer -> {
                log.info(bauer.toString());
            });
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            //  log.info(bauer.toString());
            // }
            log.info("");
        };
    }

}

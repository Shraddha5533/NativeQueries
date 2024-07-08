package com.nativequeries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nativequeries.entity.User;
import com.nativequeries.entity.Address;
import com.nativequeries.repository.AddressRepository;
import com.nativequeries.repository.UserRepository;

import java.util.List;

@SpringBootApplication
public class NativeQueries1Application implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private AddressRepository addressRepository;

    public static void main(String[] args) {
        SpringApplication.run(NativeQueries1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Create User objects
        User user = new User(1, "John Doe", "New York");
        User user1 = new User(2, "Shraddha", "Sangli");

        // Create Address objects
        Address address1 = new Address(1, "123 Main St", "New York", "NY", user);
        Address address2 = new Address(2, "456 Maple Ave", "Sangli", "MH", user1);

        // Save the User objects
        userRepository.save(user);
        userRepository.save(user1);

        // Save the Address objects
        addressRepository.save(address1);
        addressRepository.save(address2);

        // Retrieve and print all users
        List<User> allUser = userRepository.getAllUser();
        allUser.forEach(e -> {
            System.out.println(e);
        });

        System.out.println("______________________");

        // Retrieve and print users by name and city
        List<User> userByName = userRepository.getUserByName("Shraddha", "Sangli");
        userByName.forEach(e -> {
            System.out.println(e);
        });

        System.out.println("_________________");

        // Retrieve and print users using native query
        userRepository.getUsers().forEach(e -> System.out.println(e));

        System.out.println("_________________");

        // Retrieve and print users by city
        userRepository.getUsersByCity("New York").forEach(e -> System.out.println(e));

        System.out.println("_________________");

        // Retrieve and print users by name pattern
        userRepository.getUsersByNamePattern("John").forEach(e -> System.out.println(e));

        System.out.println("_________________");

          // Retrieve and print users with address in a specific city
         List<Object[]> usersWithAddress = userRepository.getUsersWithAddressInCity("Sangli");
         usersWithAddress.forEach(e -> {
            System.out.println("User: " + e[0] + ", Street: " + e[1] + ", Address City: " + e[2] + ", State: " + e[3]);
        });
    }
}

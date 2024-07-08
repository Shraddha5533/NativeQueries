package com.nativequeries.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nativequeries.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    public List<User> findByName(String name);

    public List<User> findByNameAndCity(String name, String city);

    @Query("select u from User u")
    public List<User> getAllUser();

    @Query("select u from User u where u.name= :n and u.city=:c")
    public List<User> getUserByName(@Param("n") String name, @Param("c") String city);

    @Query(value = "select * from user", nativeQuery = true)
    public List<User> getUsers();
    
 // Native query to get user by city
    @Query(value=" Select * from user where city=:city",nativeQuery=true)
    public List<User> getUsersByCity(@Param("city") String city);
    
 // Native query to get users with a specific name pattern
    @Query(value="select * from user where name like %:pattern%",nativeQuery=true)
    public List<User> getUsersByNamePattern(@Param ("pattern")String pattern);
    
    
 // Join query between User and Address
    @Query(value = "select u.*, a.street, a.city as address_city, a.state from user u join address a on u.id = a.user_id where a.city = :city", nativeQuery = true)
    public List<Object[]> getUsersWithAddressInCity(@Param("city") String city);
}

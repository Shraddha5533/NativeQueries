package com.nativequeries.repository;

import org.springframework.data.repository.CrudRepository;
import com.nativequeries.entity.Address;

public interface AddressRepository extends CrudRepository<Address, Integer> 
{
	
}

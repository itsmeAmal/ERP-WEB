package com.cloudrevel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cloudrevel.base.commonConstants;
import com.cloudrevel.entity.mst.customer;

public interface customerRepository extends JpaRepository<customer, Integer> {
	
	List<customer> findByStatus(Character status);
	
	@Query(value = "SELECT cust FROM customer cust WHERE cust.status='"+ commonConstants.status.STATUS_ACTIVE +"'")
	public List<customer> getAllActiveCustomers();
	
	customer findByIdAndStatus(Integer id, char status);

}

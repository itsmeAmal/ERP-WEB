package com.cloudrevel.service;

import org.springframework.http.ResponseEntity;

import com.cloudrevel.base.CloudRevelException;
import com.cloudrevel.entity.mst.customer;

public interface customerService {
	
	ResponseEntity<Object> createCustomerAcount(customer customer) throws CloudRevelException;
	
	ResponseEntity<Object> updateCustomerAccount(customer customer) throws CloudRevelException;
	
	ResponseEntity<Object> getAllStatusActiveCustomers() throws CloudRevelException;
	
	ResponseEntity<Object> customerMasrkAsDelete(Integer customerId) throws CloudRevelException;
	
	ResponseEntity<Object> customerMarkAsInactive(Integer customerId)throws CloudRevelException;
	
	ResponseEntity<Object> customerMarkAsActive(Integer customerId)throws CloudRevelException;

}

package com.cloudrevel.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.cloudrevel.base.CloudRevelException;
import com.cloudrevel.base.abstractController;
import com.cloudrevel.entity.mst.customer;
import com.cloudrevel.service.customerService;

/**
 * @author Amal
 *
 */

@RequestScope
@RestController
public class customerController extends abstractController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private customerService custService;
	
	@PostMapping(CUSTOMER_CREATE_CUSTOMER_ACCOUNT)
	public ResponseEntity<Object> createCustomerAccount(@RequestBody customer customer) throws CloudRevelException{
		return custService.createCustomerAcount(customer);
	}
	
	@PostMapping(CUSTOMER_UPDATE_CUSTOMER_ACCOUNT) 
	public ResponseEntity<Object> updateCustomerAccount(@RequestBody customer cust)throws CloudRevelException{
		return custService.updateCustomerAccount(cust);
	}
	
	@PutMapping(CUSTOMER_DELETE_CUSTOMER_ACCOUNT)
	public ResponseEntity<Object> deleteCustomerAccount(@RequestParam Integer id)throws CloudRevelException{
		return custService.customerMasrkAsDelete(id);
	}
	
	@GetMapping(CUSTOMER_GET_ALL_CUSTOMER_ACCOUNTS)
	public ResponseEntity<Object> getAllActiveCustomers()throws CloudRevelException{
		return custService.getAllStatusActiveCustomers();	
	}
	
	@PutMapping(CUSTOMER_MARK_AS_INACTIVE_CUSTOMER_ACCOUNT)
	public ResponseEntity<Object> customerMarkAsInactive(@RequestParam Integer id)throws CloudRevelException{
		return custService.customerMarkAsInactive(id);
	}
	
	@PutMapping(CUSTOMER_MARK_AS_ACTIVE_CUSTOMER_ACCOUNT)
	public ResponseEntity<Object> customerMarkAsActive(@RequestParam Integer id)throws CloudRevelException{
		return custService.customerMarkAsActive(id);
	}

}

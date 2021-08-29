package com.cloudrevel.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
	public ResponseEntity<Object> createCustomerAccount(customer customer) throws CloudRevelException{
		return custService.createCustomerAcount(customer);
	}
	
	@PostMapping(CUSTOMER_UPDATE_CUSTOMER_ACCOUNT) 
	public ResponseEntity<Object> updateCustomerAccount(customer cust)throws CloudRevelException{
		return custService.updateCustomerAccount(cust);
	}

}

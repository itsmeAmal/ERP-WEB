package com.cloudrevel.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cloudrevel.base.CloudRevelException;
import com.cloudrevel.base.commonConstants.exceptionMsg;
import com.cloudrevel.base.commonConstants.status;
import com.cloudrevel.entity.mst.customer;
import com.cloudrevel.repository.customerRepository;
import com.cloudrevel.service.customerService;

@Service
public class customerServiceImpl implements customerService{
	
	@Autowired
	protected customerRepository customerRepo;

	@Override
	public ResponseEntity<Object> createCustomerAcount(customer cust) throws CloudRevelException {
		if(null == cust.getCustomerName() || cust.getCustomerName().isEmpty()) {
			throw new CloudRevelException(exceptionMsg.ERROR_CUSTOMER_NAME_REQUIRED);			
		}
		cust.setStatus(status.STATUS_ACTIVE);
		cust.setCreatedBy(null);
		cust.setCreatedOn(new Date()); 
		customerRepo.save(cust);
		return new ResponseEntity<>(HttpStatus.CREATED); 
	}

	@Override
	public ResponseEntity<Object> updateCustomerAccount(customer cust) throws CloudRevelException {
		if(null == cust.getCustomerName() || cust.getCustomerName().isEmpty()) {
			throw new CloudRevelException(exceptionMsg.ERROR_CUSTOMER_NAME_REQUIRED);			
		}
		cust.setStatus(status.STATUS_ACTIVE);
		cust.setUpdateBy(null);
		cust.setUpdateOn(new Date()); 
		customerRepo.save(cust);
		return new ResponseEntity<>(HttpStatus.OK); 
	}

	@Override
	public ResponseEntity<Object> getAllStatusActiveCustomers() throws CloudRevelException {
		return new ResponseEntity<>(customerRepo.findByStatus(status.STATUS_ACTIVE), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> customerMasrkAsDelete(Integer customerId) throws CloudRevelException {
		customer existingCustomer = customerRepo.findByIdAndStatus(customerId, status.STATUS_ACTIVE);
		if(null==existingCustomer) {
			throw new CloudRevelException(exceptionMsg.ERROR_CUSTOMER_DOES_NOT_EXIST);
		}
		existingCustomer.setUpdateBy(null);
		existingCustomer.setUpdateOn(new Date()); 
		existingCustomer.setStatus(status.STATUS_DELETE);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> customerMarkAsInactive(Integer customerId) throws CloudRevelException {
		customer existingCustomer = customerRepo.findByIdAndStatus(customerId, status.STATUS_ACTIVE);
		if(null==existingCustomer) {
			throw new CloudRevelException(exceptionMsg.ERROR_CUSTOMER_DOES_NOT_EXIST);
		}
		existingCustomer.setUpdateBy(null);
		existingCustomer.setUpdateOn(new Date()); 
		existingCustomer.setStatus(status.STATUS_INACTIVE);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> customerMarkAsActive(Integer customerId) throws CloudRevelException {
		customer existingCustomer = customerRepo.findByIdAndStatus(customerId, status.STATUS_INACTIVE);
		if(null==existingCustomer) {
			throw new CloudRevelException(exceptionMsg.ERROR_CUSTOMER_DOES_NOT_EXIST);
		}
		existingCustomer.setUpdateBy(null);
		existingCustomer.setUpdateOn(new Date()); 
		existingCustomer.setStatus(status.STATUS_ACTIVE);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}

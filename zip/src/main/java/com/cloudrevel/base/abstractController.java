/**
 * 
 */
package com.cloudrevel.base;

import java.io.Serializable;

/**
 * @author Amal
 *
 */
public abstract class abstractController implements Serializable{
	
	private static final long serialVersionUID = 1L;

	//Root URL -----------------------------------------------------

	public static final String CUSTOMER = "/customer_service";
	
	//Customer service URL -----------------------------------------
	
	public static final String CUSTOMER_CREATE_CUSTOMER_ACCOUNT = CUSTOMER + "/create_customer_account";
	public static final String CUSTOMER_UPDATE_CUSTOMER_ACCOUNT = CUSTOMER + "/update_customer_account";
	
	

}

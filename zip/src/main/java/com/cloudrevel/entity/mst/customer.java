package com.cloudrevel.entity.mst;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.cloudrevel.base.baseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 
 */
/**
 * @author Amal
 *
 */
@Table(name = "customer")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
public class customer extends baseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "customer_id")
	private Integer id;
	
	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "customer_contact_1")
	private String contact1;
	
	@Column(name = "customer_contact_2")
	private String contact2;
	
	@Column(name = "customer_address")
	private String address;
	
	@Column(name = "customer_email")
	private String email;
	
	@Column(name = "customer_detail")
	private String otherDetails;
	
	@Column(name = "customer_status")
	private Character status;
	
}

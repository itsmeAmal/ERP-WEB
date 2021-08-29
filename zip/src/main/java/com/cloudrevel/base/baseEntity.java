package com.cloudrevel.base;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class baseEntity {
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "created_on")
	private Date createdOn;
	
	@Column(name = "update_by")
	private String updateBy;
	
	@Column(name = "update_on")
	private Date updateOn;

}

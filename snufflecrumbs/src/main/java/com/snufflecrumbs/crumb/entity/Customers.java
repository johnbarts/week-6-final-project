package com.snufflecrumbs.crumb.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customers {
	private Long customerPK;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
}

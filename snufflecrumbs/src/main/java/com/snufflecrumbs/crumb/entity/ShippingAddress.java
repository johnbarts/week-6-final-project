package com.snufflecrumbs.crumb.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShippingAddress {
	private Customers customer;
	private String address;
	private String city;
	private State state;
	private int zip;

}

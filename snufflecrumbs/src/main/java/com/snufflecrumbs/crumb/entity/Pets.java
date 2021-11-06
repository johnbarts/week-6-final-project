package com.snufflecrumbs.crumb.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Pets {
	private Long petPK;
	private Customers customer;
	private String petName;
	private Pet petType;
	private String breed;
	private int age;

}

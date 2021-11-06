package com.snufflecrumbs.crumb.entity;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Orders {
	private Long orderPK;
	private Customers customer;
	private Pets pet;
	private Treats treat;
	private BigDecimal orderPrice;
	private Order orderStatus;

}

package com.snufflecrumbs.crumb.entity;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Treats {
	private Long treatPK;
	private TreatBrand treatBrand;
	private TreatFlavor treatFlavor;
	private int treatCount;
	private BigDecimal price;

}

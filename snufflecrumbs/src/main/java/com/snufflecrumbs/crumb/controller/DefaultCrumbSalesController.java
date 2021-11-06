package com.snufflecrumbs.crumb.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.snufflecrumbs.crumb.entity.TreatBrand;
import com.snufflecrumbs.crumb.entity.TreatFlavor;
import com.snufflecrumbs.crumb.entity.Treats;
import com.snufflecrumbs.crumb.service.CrumbSalesService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultCrumbSalesController implements CrumbSalesController {
	
	@Autowired
	private CrumbSalesService crumbSalesService;

	@Override
	public List<Treats> fetchTreats(TreatBrand treatBrand, TreatFlavor treatFlavor) {
		log.info("treatBrand={}, treatFlavor={}", treatBrand, treatFlavor);
		 
		return crumbSalesService.fetchTreats(treatBrand, treatFlavor);
	}

	@Override
	public Optional<Treats> createTreats(TreatBrand treatBrand, TreatFlavor treatFlavor, int treatCount, BigDecimal treatPrice) {
		
		return crumbSalesService.createTreats(treatBrand, treatFlavor, treatCount, treatPrice);
	}

	@Override
	public Optional<Treats> updateTreats(Long treatPK, TreatBrand treatBrand, TreatFlavor treatFlavor, int treatCount, BigDecimal treatPrice) {
		
		return crumbSalesService.updateTreats(treatPK, treatBrand, treatFlavor, treatCount, treatPrice);
	}

	@Override
	public Optional<Treats> deleteTreats(Long treatPK) {
		
		return crumbSalesService.deleteTreats(treatPK);
	}

}

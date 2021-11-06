package com.snufflecrumbs.crumb.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snufflecrumbs.crumb.dao.CrumbSalesDao;
import com.snufflecrumbs.crumb.entity.TreatBrand;
import com.snufflecrumbs.crumb.entity.TreatFlavor;
import com.snufflecrumbs.crumb.entity.Treats;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultCrumbSalesService implements CrumbSalesService {
	
	@Autowired
	private CrumbSalesDao crumbSalesDao;

	@Override
	public List<Treats> fetchTreats(TreatBrand treatBrand, TreatFlavor treatFlavor) {
		log.info("The fetchTreats method was called with treatBrand={} and treatFlavor={}", treatBrand, treatFlavor);
		
		return crumbSalesDao.fetchTreats(treatBrand, treatFlavor);
	}

	@Override
	public Optional<Treats> createTreats(TreatBrand treatBrand, TreatFlavor treatFlavor, int treatCount, BigDecimal treatPrice) {
		
		return crumbSalesDao.createTreats(treatBrand, treatFlavor, treatCount, treatPrice);
	}

	@Override
	public Optional<Treats> updateTreats(Long treatPK, TreatBrand treatBrand, TreatFlavor treatFlavor, int treatCount, BigDecimal treatPrice) {
		
		return crumbSalesDao.updateTreats(treatPK, treatBrand, treatFlavor, treatCount, treatPrice);
	}

	@Override
	public Optional<Treats> deleteTreats(Long treatPK) {
		
		return crumbSalesDao.deleteTreats(treatPK);
	}

}

package com.snufflecrumbs.crumb.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.snufflecrumbs.crumb.entity.TreatBrand;
import com.snufflecrumbs.crumb.entity.TreatFlavor;
import com.snufflecrumbs.crumb.entity.Treats;

public interface CrumbSalesDao {
	
	List<Treats> fetchTreats(TreatBrand treatBrand, TreatFlavor treatFlavor);
	
	Optional<Treats> createTreats(TreatBrand treatBrand, TreatFlavor treatFlavor, int treatCount, BigDecimal treatPrice);
	
	Optional<Treats> updateTreats(Long treatPK, TreatBrand treatBrand, TreatFlavor treatFlavor, int treatCount, BigDecimal treatPrice);
	
	Optional<Treats> deleteTreats(Long treatPK);
}

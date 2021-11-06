package com.snufflecrumbs.crumb.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.snufflecrumbs.crumb.entity.TreatBrand;
import com.snufflecrumbs.crumb.entity.TreatFlavor;
import com.snufflecrumbs.crumb.entity.Treats;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultCrumbSalesDao implements CrumbSalesDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Treats> fetchTreats(TreatBrand treatBrand, TreatFlavor treatFlavor) {
		log.info("DAO: treatBrand={}, treatFlavor={}", treatBrand, treatFlavor);
	

					// @formatter:off
					String sql = "" 
						+ "SELECT * "
						+ "FROM treats "
						+ "WHERE treat_brand = :treat_brand AND treat_flavor = :treat_flavor";
					// @formatter:on
					
					Map<String, Object> params = new HashMap<>();
					params.put("treat_brand", treatBrand.toString());
					params.put("treat_flavor", treatFlavor.toString());
					List<Treats> treats = jdbcTemplate.query(sql, params, 
						new RowMapper<Treats>() {
						@Override
						public Treats mapRow(ResultSet rs, int rowNum) throws SQLException {
							// @formatter:off
							return Treats.builder()
									.treatPK(rs.getLong("treat_pk"))
									.treatBrand(TreatBrand.valueOf(rs.getString("treat_brand")))
									.treatFlavor(TreatFlavor.valueOf(rs.getString("treat_flavor")))
									.treatCount(rs.getInt("treat_count"))
									.price(new BigDecimal(rs.getString("price")))
									.build();
							// @formatter:on
							}}); 
					return treats;
	}
	
	@Override
	public Optional<Treats> createTreats(TreatBrand treatBrand, TreatFlavor treatFlavor, int treatCount, BigDecimal treatPrice) {
			
				// @formatter:off
				String sql = ""
					+ "INSERT INTO treats ("
					+ "treat_brand, treat_flavor, treat_count, price"
					+ ") VALUES ("
					+ ":treat_brand, :treat_flavor, :treat_count, :price)";
				// @formatter:on
		
				Map<String, Object> params = new HashMap<>();
				params.put("treat_brand", treatBrand.toString());
				params.put("treat_flavor", treatFlavor.toString());
				params.put("treat_count", treatCount);
				params.put("price", treatPrice);
				
				jdbcTemplate.update(sql, params);
				return Optional.ofNullable(Treats.builder()
						.treatBrand(treatBrand)
						.treatFlavor(treatFlavor)
						.treatCount(treatCount)
						.price(treatPrice)
						.build());
		
	}
	
	@Override
	public Optional<Treats> updateTreats(Long treatPK, TreatBrand treatBrand, TreatFlavor treatFlavor, 
			int treatCount, BigDecimal treatPrice) {
			
				// @formatter:off
				String sql = ""
					+ "UPDATE treats "
					+ "SET treat_brand = :treat_brand, treat_flavor = :treat_flavor, "
					+ "treat_count = :treat_count, price = :price "
					+ "WHERE treat_pk = :treat_pk";
				// @formatter:on
		
				Map<String, Object> params = new HashMap<>();
					params.put("treat_pk", treatPK);
					params.put("treat_brand", treatBrand.toString());
					params.put("treat_flavor", treatFlavor.toString());
					params.put("treat_count", treatCount);
					params.put("price", treatPrice);
		    
					
				jdbcTemplate.update(sql, params);
				return Optional.ofNullable(Treats.builder()
						.treatPK(treatPK)
						.treatBrand(treatBrand)
						.treatFlavor(treatFlavor)
						.treatCount(treatCount)
						.price(treatPrice)
						.build());	
	}
	
	@Override
	public Optional<Treats> deleteTreats(Long treatPK) {
				
				// @formatter:off
				String sql = "" 
			      + "DELETE FROM treats WHERE " 
			      + "treat_pk = :treat_pk"; 
				// @formatter:on
					    
			   Map<String, Object> params = new HashMap<>();
			       params.put("treat_pk", treatPK);
			    
			    jdbcTemplate.update(sql, params);
			    return Optional.ofNullable(Treats.builder()
			    		.treatPK(treatPK)
			    		.build());
		  }
	
	class SqlParams {
		String sql;
		MapSqlParameterSource source = new MapSqlParameterSource();
	}

}


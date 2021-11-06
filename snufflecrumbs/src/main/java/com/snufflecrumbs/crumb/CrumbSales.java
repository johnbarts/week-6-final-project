package com.snufflecrumbs.crumb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.snufflecrumbs.ComponentScanMarker;

@SpringBootApplication(scanBasePackageClasses = { ComponentScanMarker.class })
public class CrumbSales {

	public static void main(String[] args) {
		SpringApplication.run(CrumbSales.class, args);

	}

}

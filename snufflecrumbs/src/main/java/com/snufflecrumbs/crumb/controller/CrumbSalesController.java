package com.snufflecrumbs.crumb.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.snufflecrumbs.crumb.entity.TreatBrand;
import com.snufflecrumbs.crumb.entity.TreatFlavor;
import com.snufflecrumbs.crumb.entity.Treats;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/crumbs")
@OpenAPIDefinition(info = @Info(title = "Snufflecrumbs Service"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server.") })
public interface CrumbSalesController {

	//@formatter:off
	  @Operation(
	      summary = "Returns treat entries.",
	      description = "Returns treat entries by their brand and flavor.",
	      responses = {
	          @ApiResponse(
	              responseCode = "200", 
	              description = "A treat query is returned.", 
	              content = @Content(
	                  mediaType = "application/json", 
	              schema = @Schema(implementation = Treats.class))),
	          @ApiResponse(
	              responseCode = "400", 
	              description = "The request parameters are invalid.", 
	              content = @Content(
	                  mediaType = "application/json")),
	          @ApiResponse(
	              responseCode = "404", 
	              description = "No treats were found with the input criteria.", 
	              content = @Content(
	                  mediaType = "application/json")),
	          @ApiResponse(
	              responseCode = "500", 
	              description = "An unplanned error occurred.", 
	              content = @Content(
	                  mediaType = "application/json"))
	      },
	      parameters = {
	          @Parameter(
	              name = "treatBrand", 
	              allowEmptyValue = false, 
	              required = false, 
	              description = "The treat's brand. (ex.'PURINA')"), 
	          @Parameter(
	              name = "treatFlavor",
	              allowEmptyValue = false,
	              required = false,
	              description = "The treat's flavor. (ex.'BEEF')") 
	      }
	  )
	  
	  @GetMapping
	  @ResponseStatus(code = HttpStatus.OK)
	  List<Treats> fetchTreats(
	      @RequestParam(required = false) 
	      TreatBrand treatBrand,
	      @RequestParam(required = false)
	      TreatFlavor treatFlavor);
	  
	  
	  @Operation(
		      summary = "Creates a new treat entry.",
		      description = "Creates a treat entry by entering a brand, flavor, amount, and price.",
		      responses = {
		          @ApiResponse(
		              responseCode = "201", 
		              description = "A treat entry is created.", 
		              content = @Content(
		                  mediaType = "application/json", 
		              schema = @Schema(implementation = Treats.class))),
		          @ApiResponse(
		              responseCode = "400", 
		              description = "The request parameters are invalid.", 
		              content = @Content(
		                  mediaType = "application/json")),
		          @ApiResponse(
		              responseCode = "404", 
		              description = "No treats could be created with the input criteria.", 
		              content = @Content(
		                  mediaType = "application/json")),
		          @ApiResponse(
		              responseCode = "500", 
		              description = "An unplanned error occurred.", 
		              content = @Content(
		                  mediaType = "application/json"))
		      },
		      parameters = {
		          @Parameter(
		              name = "treatBrand", 
		              allowEmptyValue = false, 
		              required = false, 
		              description = "The treat's brand. (ex.'Blue Buffalo')"), 
		          @Parameter(
		              name = "treatFlavor",
		              allowEmptyValue = false,
		              required = false,
		              description = "The treat's flavor. (ex.'BEEF')"),
		          @Parameter(
		              name = "treatCount", 
		              allowEmptyValue = false, 
		              required = false, 
		              description = "The amount of treats. (ex.'50')"),
		          @Parameter(
		              name = "treatPrice", 
		              allowEmptyValue = false, 
		              required = false, 
		              description = "The price of the treat. (ex.'19.99')")
		      }
		  )
	  
	  @PostMapping
	  @ResponseStatus(code = HttpStatus.CREATED)
	  Optional<Treats> createTreats(
			  @RequestParam(required = false)
			  TreatBrand treatBrand,
			  @RequestParam(required = false)
			  TreatFlavor treatFlavor,
			  @RequestParam(required = false)
			  int treatCount,
			  @RequestParam(required = false)
			  BigDecimal treatPrice);
	  
	  
	  @Operation(
		      summary = "Updates an existing treat entry.",
		      description = "Updates a treat entry given it's primary key.",
		      responses = {
		          @ApiResponse(
		              responseCode = "201", 
		              description = "A treat entry is updated.", 
		              content = @Content(
		                  mediaType = "application/json", 
		              schema = @Schema(implementation = Treats.class))),
		          @ApiResponse(
		              responseCode = "400", 
		              description = "The request parameters are invalid.", 
		              content = @Content(
		                  mediaType = "application/json")),
		          @ApiResponse(
		              responseCode = "404", 
		              description = "No treats were found with the input criteria.", 
		              content = @Content(
		                  mediaType = "application/json")),
		          @ApiResponse(
		              responseCode = "500", 
		              description = "An unplanned error occurred.", 
		              content = @Content(
		                  mediaType = "application/json"))
		      },
		      parameters = {
	    		  @Parameter(
		              name = "treatPK", 
		              allowEmptyValue = false, 
		              required = false, 
		              description = "The primary key of the treat to be updated."),
		          @Parameter(
		              name = "treatBrand", 
		              allowEmptyValue = false, 
		              required = false, 
		              description = "The treat brand (ex.'PURINA')"), 
		          @Parameter(
		              name = "treatFlavor",
		              allowEmptyValue = false,
		              required = false,
		              description = "The treat flavor (ex.'BEEF')"),
		          @Parameter(
		              name = "treatCount", 
		              allowEmptyValue = false, 
		              required = false, 
		              description = "The amount of treats. (ex.'50')"),
		          @Parameter(
		              name = "treatPrice", 
		              allowEmptyValue = false, 
		              required = false, 
		              description = "The price of the treat. (ex.'19.99')")
		      }
		  )
	  
	  @PutMapping
	  @ResponseStatus(code = HttpStatus.CREATED)
	  Optional<Treats> updateTreats(
			  @RequestParam(required = false)
			  Long treatPK,
			  @RequestParam(required = false)
			  TreatBrand treatBrand,
			  @RequestParam(required = false)
			  TreatFlavor treatFlavor,
			  @RequestParam(required = false)
			  int treatCount,
			  @RequestParam(required = false)
			  BigDecimal treatPrice);
	  
	  
	  @Operation(
		      summary = "Deletes a treat entry.",
		      description = "Deletes a treat entry given it's primary key.",
		      responses = {
		          @ApiResponse(
		              responseCode = "202", 
		              description = "A treat entry was deleted.", 
		              content = @Content(
		                  mediaType = "application/json", 
		              schema = @Schema(implementation = Treats.class))),
		          @ApiResponse(
		              responseCode = "400", 
		              description = "The request parameters are invalid.", 
		              content = @Content(
		                  mediaType = "application/json")),
		          @ApiResponse(
		              responseCode = "404", 
		              description = "No treat was found with the input criteria.", 
		              content = @Content(
		                  mediaType = "application/json")),
		          @ApiResponse(
		              responseCode = "500", 
		              description = "An unplanned error occurred.", 
		              content = @Content(
		                  mediaType = "application/json"))
		      },
		      parameters = {
		          @Parameter(
		              name = "treatPK", 
		              allowEmptyValue = false, 
		              required = false, 
		              description = "The primary key of the treat entry to be deleted."), 
		      }
		  )
	  
	  @DeleteMapping
	  @ResponseStatus(code = HttpStatus.ACCEPTED)
	  Optional<Treats> deleteTreats(
			  @RequestParam(required = false)
			  Long treatPK);
	  //@formatter:on
	  
}
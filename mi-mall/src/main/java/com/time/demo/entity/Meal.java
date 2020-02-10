package com.time.demo.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Meal implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "mealid")
	private Integer mealid;
	
	@JsonProperty(value = "productid")
	private Integer productid;
	
	@JsonProperty(value = "meal")
	private String meal;
}

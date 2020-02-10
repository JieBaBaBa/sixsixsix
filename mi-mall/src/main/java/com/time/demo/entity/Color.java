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
public class Color implements Serializable {

	private static final long serialVersionUID = 1L;
 
	@JsonProperty(value = "colorid")
	private Integer colorid;

	@JsonProperty(value = "productid")
	private Integer productid;

	@JsonProperty(value = "color")
	private String color;
}

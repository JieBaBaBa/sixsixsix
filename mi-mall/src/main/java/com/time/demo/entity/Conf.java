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
public class Conf implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "confid")
	private Integer confid;

	@JsonProperty(value = "productid")
	private Integer productid;

	@JsonProperty(value = "conf")
	private String conf;
}

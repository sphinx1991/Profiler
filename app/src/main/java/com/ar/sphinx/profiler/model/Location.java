package com.ar.sphinx.profiler.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by sphinx on 17/06/18.
 */
public class Location implements Serializable {

	@SerializedName("street")
	public String street;

	@SerializedName("city")
	public String city;

	@SerializedName("state")
	public String state;

	@SerializedName("zip")
	public String zip;
}

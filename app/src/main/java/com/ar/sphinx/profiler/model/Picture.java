package com.ar.sphinx.profiler.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by sphinx on 17/06/18.
 */
public class Picture implements Serializable{

	@SerializedName("large") public String large;

	@SerializedName("medium") public String medium;

	@SerializedName("thumbnail") public String thumbnail;
}

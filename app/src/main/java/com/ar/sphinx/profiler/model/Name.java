package com.ar.sphinx.profiler.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by sphinx on 17/06/18.
 */
public class Name implements Serializable {

	@SerializedName("title")
	public String title;

	@SerializedName("first")
	public String first;

	@SerializedName("last")
	public String last;
}

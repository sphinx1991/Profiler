package com.ar.sphinx.profiler.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by sphinx on 16/06/18.
 */
public class People implements Serializable {

	@SerializedName("gender")
	public String gender;

	@SerializedName("name")
	public Name name;

	@SerializedName("location")
	public Location location;

	@SerializedName("email")
	public String email;

	@SerializedName("phone")
	public String phone;

	@SerializedName("cell")
	public String cell;

	@SerializedName("login")
	public Login login;

	@SerializedName("picture")
	public Picture picture;

	public String fullName;

	public boolean hasEmail(){
		return email!=null && !email.isEmpty() ;
	}
}

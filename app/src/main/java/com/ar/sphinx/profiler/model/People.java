package com.ar.sphinx.profiler.model;

/**
 * Created by sphinx on 16/06/18.
 */
public class People {

	public String gender;
	public Name name;
	public Location location;
	public String mail;
	public String phone;
	public String cell;
	public Login login;
	public Picture picture;
	public String fullName;

	public boolean hasEmail(){
		return mail!=null && !mail.isEmpty() ;
	}
}

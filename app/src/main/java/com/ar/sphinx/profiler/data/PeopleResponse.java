package com.ar.sphinx.profiler.data;

import com.ar.sphinx.profiler.model.People;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sphinx on 17/06/18.
 */
public class PeopleResponse {

	@SerializedName("results")
	private List<People> peopleList;

	public List<People> getPeopleList() {
		return peopleList;
	}

	public void setPeopleList(List<People> peopleList) {
		this.peopleList = peopleList;
	}
}

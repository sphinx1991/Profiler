package com.ar.sphinx.profiler.data;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sphinx on 17/06/18.
 */
public class PeopleFactory {


	private final static String BASE_URL = "http://api.randomuser.me/";
	private final static String PROJECT_URL = "http://api.randomuser.me/";
	public final static String RANDOM_USER_URL = "http://api.randomuser.me/?results=10&nat=en";

	public static PeopleService create(){

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(BASE_URL)
				.addConverterFactory(GsonConverterFactory.create())
				.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
				.build();
		return  retrofit.create(PeopleService.class);
	}
}

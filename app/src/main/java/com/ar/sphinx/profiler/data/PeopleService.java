package com.ar.sphinx.profiler.data;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by sphinx on 17/06/18.
 */
public interface PeopleService {

	@GET
	Observable<PeopleResponse> fetchPeople(@Url String url);
}

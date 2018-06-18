package com.ar.sphinx.profiler;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.ar.sphinx.profiler.data.PeopleFactory;
import com.ar.sphinx.profiler.data.PeopleService;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by sphinx on 18/06/18.
 */
public class ProfilerApplication extends Application {

	private PeopleService peopleService;
	private Scheduler scheduler;

	public static ProfilerApplication getApplication(@NonNull Context context){
		return (ProfilerApplication) context.getApplicationContext();
	}

	public PeopleService getPeopleService() {
		if(peopleService == null){
			peopleService = PeopleFactory.create();
		}
		return peopleService;
	}
	public Scheduler subscribeScheduler() {
		if (scheduler == null) {
			scheduler = Schedulers.io();
		}

		return scheduler;
	}

	public void setPeopleService(PeopleService peopleService) {
		this.peopleService = peopleService;
	}

	public void setScheduler(Scheduler scheduler) {
		this.scheduler = scheduler;
	}
}

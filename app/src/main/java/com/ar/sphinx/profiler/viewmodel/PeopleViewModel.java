package com.ar.sphinx.profiler.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.view.View;

import com.ar.sphinx.profiler.ProfilerApplication;
import com.ar.sphinx.profiler.data.PeopleFactory;
import com.ar.sphinx.profiler.data.PeopleResponse;
import com.ar.sphinx.profiler.data.PeopleService;
import com.ar.sphinx.profiler.model.People;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by sphinx on 18/06/18.
 */
public class PeopleViewModel extends java.util.Observable {

	public ObservableInt progressView;
	public ObservableInt statusView;
	public ObservableInt recyclerView;
	public ObservableField<String> messageLabel;

	private List<People> peopleList;
	private Context context;
	private CompositeDisposable compositeDisposable = new CompositeDisposable();

	public PeopleViewModel(Context context){
		this.context = context;
		this.progressView = new ObservableInt(View.GONE);
		this.recyclerView = new ObservableInt(View.GONE);
		this.statusView = new ObservableInt(View.VISIBLE);
		this.messageLabel = new ObservableField<>("Press + to load the list of people.");
		peopleList = new ArrayList<>();
	}

	public void fabLoadClick(){
		initializeViews();
		fetchPeopleList();
	}

	private void fetchPeopleList() {
		ProfilerApplication application = ProfilerApplication.getApplication(context);
		PeopleService peopleService = application.getPeopleService();

		Disposable disposable = peopleService.fetchPeople(PeopleFactory.RANDOM_USER_URL)
				.subscribeOn(application.subscribeScheduler())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new Consumer<PeopleResponse>() {
					@Override public void accept(PeopleResponse peopleResponse) throws Exception {
						peopleList.addAll(peopleResponse.getPeopleList());
						progressView.set(View.GONE);
						statusView.set(View.GONE);
						recyclerView.set(View.VISIBLE);
					}
				}, new Consumer<Throwable>() {
					@Override public void accept(Throwable throwable) throws Exception {
						messageLabel.set("There is an error. Oops!!");
						progressView.set(View.GONE);
						statusView.set(View.VISIBLE);
						recyclerView.set(View.GONE);
					}
				});

		compositeDisposable.add(disposable);
	}

	private void initializeViews() {
		progressView.set(View.GONE);
		recyclerView.set(View.GONE);
		statusView.set(View.VISIBLE);
	}

	public List<People> getPeopleList() {
		return peopleList;
	}

	private void unSubscribeFromObservable() {
		if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
			compositeDisposable.dispose();
		}
	}

	public void reset() {
		unSubscribeFromObservable();
		compositeDisposable = null;
		context = null;
	}

	public void changePeopleListDataSet(List<People> list){
		peopleList.addAll(list);
		setChanged();
		notifyObservers();
	}
}

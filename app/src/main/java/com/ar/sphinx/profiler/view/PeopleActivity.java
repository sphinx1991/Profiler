package com.ar.sphinx.profiler.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.ar.sphinx.profiler.R;
import com.ar.sphinx.profiler.data.PeopleFactory;
import com.ar.sphinx.profiler.databinding.ActivityPeopleBinding;
import com.ar.sphinx.profiler.viewmodel.PeopleViewModel;

import java.util.Observable;
import java.util.Observer;

public class PeopleActivity extends AppCompatActivity implements Observer{

	private ActivityPeopleBinding activityPeopleBinding;
	private PeopleViewModel peopleViewModel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_people);
		initDataBinding();
		setSupportActionBar(activityPeopleBinding.toolbar);
		setupListView(activityPeopleBinding.rView);
		setupObserver(peopleViewModel);
	}

	private void setupListView(RecyclerView rView) {
		PeopleAdapter adapter = new PeopleAdapter();
		rView.setAdapter(adapter);
		rView.setLayoutManager(new LinearLayoutManager(this));
	}

	public void setupObserver(Observable observable) {
		observable.addObserver(this);
	}

	private void initDataBinding() {
		activityPeopleBinding = DataBindingUtil.setContentView(this,R.layout.activity_people);
		peopleViewModel = new PeopleViewModel(this);
		activityPeopleBinding.setPeopleViewModel(peopleViewModel);
	}

	@Override protected void onDestroy() {
		super.onDestroy();
		peopleViewModel.reset();
	}

	@Override public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.menu_github) {
			startActivityActionView();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private void startActivityActionView() {
		startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(PeopleFactory.PROJECT_URL)));
	}

	@Override
	public void update(Observable observable, Object o) {
		if(observable instanceof PeopleViewModel){
			PeopleAdapter adapter = (PeopleAdapter) activityPeopleBinding.rView.getAdapter();
			PeopleViewModel peopleViewModel = (PeopleViewModel) observable;
			adapter.setPeopleList(peopleViewModel.getPeopleList());
		}
	}
}

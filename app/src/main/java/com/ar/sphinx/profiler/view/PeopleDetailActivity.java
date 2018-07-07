package com.ar.sphinx.profiler.view;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.ar.sphinx.profiler.R;
import com.ar.sphinx.profiler.databinding.ActivityDetailBinding;
import com.ar.sphinx.profiler.model.People;
import com.ar.sphinx.profiler.viewmodel.PeopleDetailViewModel;

/**
 * Created by sphinx on 18/06/18.
 */
public class PeopleDetailActivity extends AppCompatActivity {

	private static final String EXTRA_PEOPLE = "EXTRA_PEOPLE";

	private ActivityDetailBinding activityDetailBinding;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		activityDetailBinding = DataBindingUtil.setContentView(this,R.layout.activity_detail);
		setSupportActionBar(activityDetailBinding.toolbar);
		displayHomeAsUpEnabled();
		getExtrasFromIntent();
	}

	public void displayHomeAsUpEnabled(){
		ActionBar actionBar = getSupportActionBar();
		if(actionBar!=null){
			actionBar.setDisplayHomeAsUpEnabled(true);
		}
	}

	public static Intent launchDetail(Context context, People people){
		Intent intent = new Intent(context,PeopleDetailActivity.class);
		intent.putExtra(EXTRA_PEOPLE,people);
		return intent;
	}

	public void getExtrasFromIntent(){
		People people = (People) getIntent().getSerializableExtra(EXTRA_PEOPLE);
		PeopleDetailViewModel peopleDetailViewModel = new PeopleDetailViewModel(people);
		activityDetailBinding.setPeopleDetailViewModel(peopleDetailViewModel);
		setTitle(people.name.title + "." + people.name.first + " " + people.name.last);
	}
}

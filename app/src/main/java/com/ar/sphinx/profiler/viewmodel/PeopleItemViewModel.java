package com.ar.sphinx.profiler.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.ar.sphinx.profiler.model.People;
import com.ar.sphinx.profiler.view.PeopleDetailActivity;
import com.bumptech.glide.Glide;

/**
 * Created by sphinx on 18/06/18.
 */
public class PeopleItemViewModel extends BaseObservable {

	private People people;
	private Context context;

	public PeopleItemViewModel(People people,Context context){
		this.context = context;
		this.people = people;
	}

	public String getFullName(){
		people.fullName = people.name.title + people.name.first + people.name.last;
		return people.fullName;
	}

	public String getCell(){
		return people.cell;
	}

	public String getMail(){
		return people.email;
	}

	public String getPicProfile(){
		return people.picture.medium;
	}

	@BindingAdapter("imageUrl")
	public static void setImage(ImageView view,String url){
		Glide.with(view.getContext()).load(url).into(view);
	}

	public void onItemClick(View view){
		context.startActivity(PeopleDetailActivity.launchDetail(view.getContext(),people));
	}

	public void setPeople(People people){
		this.people = people;
		notifyChange();
	}
}

package com.ar.sphinx.profiler.viewmodel;

import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.ar.sphinx.profiler.model.People;
import com.bumptech.glide.Glide;

/**
 * Created by sphinx on 18/06/18.
 */
public class    PeopleDetailViewModel {
	private People people;

	public PeopleDetailViewModel(People people) {
		this.people = people;
	}

	public String getFullUserName() {
		people.fullName = people.name.title + "." + people.name.first + " " + people.name.last;
		return people.fullName;
	}

	public String getUserName() {
		return people.login.username;
	}

	public String getEmail() {
		return people.email;
	}

	public int getEmailVisibility() {
		return people.hasEmail() ? View.VISIBLE : View.GONE;
	}

	public String getCell() {
		return people.cell;
	}

	public String getPictureProfile() {
		return people.picture.large;
	}

	public String getAddress() {
		return people.location.street
				+ " "
				+ people.location.city
				+ " "
				+ people.location.state;
	}

	public String getGender() {
		return people.gender;
	}

	@BindingAdapter({"imageUrl"})
	public static void loadImage(ImageView view, String imageUrl) {
		Glide.with(view.getContext()).load(imageUrl).into(view);
	}
}

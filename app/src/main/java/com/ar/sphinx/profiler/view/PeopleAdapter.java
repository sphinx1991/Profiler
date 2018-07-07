package com.ar.sphinx.profiler.view;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.ar.sphinx.profiler.R;
import com.ar.sphinx.profiler.databinding.LayoutPeopleItemBinding;
import com.ar.sphinx.profiler.model.People;
import com.ar.sphinx.profiler.viewmodel.PeopleItemViewModel;

import java.util.Collections;
import java.util.List;

/**
 * Created by sphinx on 18/06/18.
 */
public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.PeopleAdapterViewHolder>{

	private List<People> peopleList;

	public PeopleAdapter(){
		this.peopleList = Collections.emptyList();
	}

	@NonNull
	@Override
	public PeopleAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		LayoutPeopleItemBinding layoutPeopleItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
				R.layout.layout_people_item, parent,false);
		return new PeopleAdapterViewHolder(layoutPeopleItemBinding);
	}

	@Override
	public void onBindViewHolder(@NonNull PeopleAdapterViewHolder holder, int position) {
		holder.bindPeople(peopleList.get(position));
	}

	@Override
	public int getItemCount() {
		return peopleList.size();
	}

	public void setPeopleList(List<People> peopleList){
		this.peopleList = peopleList;
		notifyDataSetChanged();
	}

	public class PeopleAdapterViewHolder extends RecyclerView.ViewHolder {

		LayoutPeopleItemBinding layoutPeopleItemBinding;

		public PeopleAdapterViewHolder(LayoutPeopleItemBinding layoutPeopleItemBinding) {
			super(layoutPeopleItemBinding.getRoot());
			this.layoutPeopleItemBinding = layoutPeopleItemBinding;
		}

		public void bindPeople(People people){
			if(layoutPeopleItemBinding.getPeopleItemViewModel() == null){
				layoutPeopleItemBinding.setPeopleItemViewModel(new PeopleItemViewModel(people,itemView.getContext()));
			}else {
				layoutPeopleItemBinding.getPeopleItemViewModel().setPeople(people);
			}
		}
	}


}

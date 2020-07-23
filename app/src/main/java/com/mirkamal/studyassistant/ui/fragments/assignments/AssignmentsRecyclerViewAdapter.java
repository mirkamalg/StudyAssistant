package com.mirkamal.studyassistant.ui.fragments.assignments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mirkamal.studyassistant.R;
import com.mirkamal.studyassistant.database.Assignment;

import java.util.List;

public class AssignmentsRecyclerViewAdapter extends RecyclerView.Adapter<ItemAssignmentsViewHolder> {

    private List<Assignment> assignments;

    @NonNull
    @Override
    public ItemAssignmentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_assignments, parent, false);

        return new ItemAssignmentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAssignmentsViewHolder holder, int position) {
        holder.bindItem(assignments.get(position));
    }

    @Override
    public int getItemCount() {
        return assignments.size();
    }

    public void submitList(List<Assignment> assignments) {
        this.assignments = assignments;
        notifyDataSetChanged();
    }
}

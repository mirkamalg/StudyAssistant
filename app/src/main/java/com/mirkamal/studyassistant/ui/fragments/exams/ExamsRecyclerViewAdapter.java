package com.mirkamal.studyassistant.ui.fragments.exams;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mirkamal.studyassistant.R;
import com.mirkamal.studyassistant.database.Exam;

import java.util.List;

public class ExamsRecyclerViewAdapter extends RecyclerView.Adapter<ItemExamsViewHolder> {

    private List<Exam> exams;

    @NonNull
    @Override
    public ItemExamsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_exams, parent, false);

        return new ItemExamsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemExamsViewHolder holder, int position) {
        holder.bindItem(exams.get(position));
    }

    @Override
    public int getItemCount() {
        return exams.size();
    }

    public void submitList(List<Exam> exams) {
        this.exams = exams;
        notifyDataSetChanged();
    }
}

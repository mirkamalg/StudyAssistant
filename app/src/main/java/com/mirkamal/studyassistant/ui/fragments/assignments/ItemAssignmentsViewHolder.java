package com.mirkamal.studyassistant.ui.fragments.assignments;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mirkamal.studyassistant.R;
import com.mirkamal.studyassistant.database.Assignment;

import java.time.format.DateTimeFormatter;

public class ItemAssignmentsViewHolder extends RecyclerView.ViewHolder {

    private TextView subject, topic, deadline;

    public ItemAssignmentsViewHolder(@NonNull View itemView) {
        super(itemView);

        subject = itemView.findViewById(R.id.text_view_subject);
        topic = itemView.findViewById(R.id.text_view_topic);
        deadline = itemView.findViewById(R.id.text_view_deadline);
    }

    public void bindItem(Assignment assignment) {
        subject.setText(assignment.getSubject());
        topic.setText(assignment.getSubject());
        deadline.setText(assignment.getDeadline().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
    }


}

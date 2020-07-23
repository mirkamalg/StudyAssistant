package com.mirkamal.studyassistant.ui.fragments.exams;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mirkamal.studyassistant.R;
import com.mirkamal.studyassistant.database.Exam;

import java.time.format.DateTimeFormatter;
import java.util.Random;

public class ItemExamsViewHolder extends RecyclerView.ViewHolder {

    private TextView subject, date, daysLeft;

    public ItemExamsViewHolder(@NonNull View itemView) {
        super(itemView);

        subject = itemView.findViewById(R.id.text_view_subject);
        date = itemView.findViewById(R.id.text_view_topic);
        daysLeft = itemView.findViewById(R.id.text_view_deadline);
    }

    public void bindItem(Exam exam) {
        subject.setText(exam.getSubject());
        date.setText(exam.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
        daysLeft.setText(String.valueOf(new Random().nextInt(25)) + " day(s) left");
    }

}

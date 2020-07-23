package com.mirkamal.studyassistant.ui.fragments.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mirkamal.studyassistant.R;
import com.mirkamal.studyassistant.database.FakeDataBase;

public class HomeFragment extends Fragment {

    private TextView remainingExams, remainingAssignments, daysToExam, timeStudiedToday;
    private FakeDataBase dataBase;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        remainingExams = view.findViewById(R.id.text_view_remaining_exams);
        remainingAssignments = view.findViewById(R.id.text_view_remaining_assignments);
        daysToExam = view.findViewById(R.id.text_view_days_to_exam);
        timeStudiedToday = view.findViewById(R.id.time_studied_today);

        dataBase = FakeDataBase.getInstance();
        setData();
    }

    private void setData() {
        remainingExams.setText(String.valueOf(dataBase.getExams().size()));
        remainingAssignments.setText(String.valueOf(dataBase.getAssignments().size()));

//        List<Exam> exams = new ArrayList<>();
//        dataBase.getExams().forEach((key, value) -> {
//            exams.add(value);
//        });
//        exams.sort((exam, t1) -> exam.getDate().compareTo((ChronoLocalDateTime<?>) t1));

        daysToExam.setText("3 days");

        timeStudiedToday.setText(dataBase.getStudiedTime());
    }
}

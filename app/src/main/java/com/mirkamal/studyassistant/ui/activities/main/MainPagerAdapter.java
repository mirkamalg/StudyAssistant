package com.mirkamal.studyassistant.ui.activities.main;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.mirkamal.studyassistant.ui.fragments.assignments.AssignmentsFragment;
import com.mirkamal.studyassistant.ui.fragments.exams.ExamsFragment;
import com.mirkamal.studyassistant.ui.fragments.home.HomeFragment;
import com.mirkamal.studyassistant.ui.fragments.timer.TimerFragment;

import java.util.ArrayList;
import java.util.List;

public class MainPagerAdapter extends FragmentStateAdapter {

    private List<Fragment> fragments;

    public MainPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);

        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new ExamsFragment());
        fragments.add(new AssignmentsFragment());
        fragments.add(new TimerFragment());
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }


    @Override
    public int getItemCount() {
        return fragments.size();
    }
}

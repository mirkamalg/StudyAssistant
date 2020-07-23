package com.mirkamal.studyassistant.ui.fragments.timer;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.jem.rubberpicker.RubberSeekBar;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;
import com.mirkamal.studyassistant.R;

import org.jetbrains.annotations.NotNull;

public class TimerFragment extends Fragment {

    private CircularProgressBar circularProgressBar;
    private RubberSeekBar seekBar;
    private TextView goal;
    private MaterialButton buttonStart, buttonPause, buttonStop;
    private int goalStudyTimeMinutes;
    private CountDownTimer timer;
    private boolean isTimerRunning = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_timer, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        circularProgressBar = view.findViewById(R.id.timer_progress_bar);
        seekBar = view.findViewById(R.id.seek_bar_goal_time);
        goal = view.findViewById(R.id.text_view_goal_time);
        buttonStart = view.findViewById(R.id.button_start);
        buttonPause = view.findViewById(R.id.button_pause);
        buttonStop = view.findViewById(R.id.button_stop);

        configureLogic();
    }

    private void configureLogic() {
        seekBar.setOnRubberSeekBarChangeListener(new RubberSeekBar.OnRubberSeekBarChangeListener() {
            @Override
            public void onProgressChanged(@NotNull RubberSeekBar rubberSeekBar, int i, boolean b) {
                goalStudyTimeMinutes = i;
                setGoalText();
            }

            @Override
            public void onStartTrackingTouch(@NotNull RubberSeekBar rubberSeekBar) {

            }

            @Override
            public void onStopTrackingTouch(@NotNull RubberSeekBar rubberSeekBar) {

            }
        });

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.Q)
            @Override
            public void onClick(View view) {
                if (!isTimerRunning) {

                    circularProgressBar.setProgressMax(goalStudyTimeMinutes * 60);
                    buttonStart.setEnabled(false);
                    buttonPause.setEnabled(true);
                    buttonStop.setEnabled(true);
                    seekBar.setVisibility(View.INVISIBLE);

                    timer = new CountDownTimer(goalStudyTimeMinutes * 60000, 1000) {
                        @Override
                        public void onTick(long l) {
                            circularProgressBar.setProgress(circularProgressBar.getProgress() - 1);
                            goal.setText((l / 60000 + 1) + " minutes left");
                            goalStudyTimeMinutes = (int) (l / 60000) + 1;
                        }

                        @Override
                        public void onFinish() {
                            goalStudyTimeMinutes = seekBar.getCurrentValue();
                            seekBar.setCurrentValue(0);
                            isTimerRunning = false;

                            Vibrator vibrator = (Vibrator) requireActivity().getSystemService(Context.VIBRATOR_SERVICE);
                            vibrator.vibrate(1000);
                        }
                    }.start();

                    isTimerRunning = true;

                    Toast.makeText(getContext(), "Timer started", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isTimerRunning) {
                    timer.cancel();

                    isTimerRunning = false;

                    buttonStart.setEnabled(true);

                    Toast.makeText(getContext(), "Timer paused", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seekBar.setEnabled(true);
                circularProgressBar.setProgress(0);
                goalStudyTimeMinutes = seekBar.getCurrentValue();
                isTimerRunning = false;

                timer.cancel();

                buttonStart.setEnabled(true);
                buttonPause.setEnabled(false);
                buttonStop.setEnabled(false);
                seekBar.setVisibility(View.VISIBLE);

                setGoalText();

                Toast.makeText(getContext(), "Timer stopped", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setGoalText() {
        if (goalStudyTimeMinutes >= 60) {
            if (goalStudyTimeMinutes % 60 != 0) {
                goal.setText(goalStudyTimeMinutes / 60 + " Hour(s) " + goalStudyTimeMinutes % 60 + " Minute(s)");
            } else {
                goal.setText(goalStudyTimeMinutes / 60 + " Hour(s)");
            }
        } else {
            goal.setText(goalStudyTimeMinutes + " Minutes");
        }
    }
}

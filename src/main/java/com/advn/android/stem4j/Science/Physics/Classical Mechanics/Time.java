package com.advn.android.stem4j;

import java.util.Timer;
import java.util.TimerTask;

public class Time {
    private long startTime;
    private long pauseTime;
    private long elapsedTime;
    private boolean isRunning;
    private boolean isPaused;
    private Timer timer;
    private TimerTask task;
    private long interval; // Interval in milliseconds

    // Constructor to initialize the timer
    public Time() {
        this.elapsedTime = 0;
        this.isRunning = false;
        this.isPaused = false;
        this.timer = new Timer();
    }

    // Start or resume the timer
    public void start() {
        if (!isRunning) {
            startTime = System.currentTimeMillis();
            isRunning = true;
            isPaused = false;
        } else if (isPaused) {
            startTime += (System.currentTimeMillis() - pauseTime);
            isPaused = false;
        }
        startTimerTask(); // Start the task scheduler if interval is set
    }

    // Pause the timer
    public void pause() {
        if (isRunning && !isPaused) {
            pauseTime = System.currentTimeMillis();
            isPaused = true;
        }
    }

    // Stop the timer and get elapsed time
    public void stop() {
        if (isRunning) {
            if (isPaused) {
                elapsedTime += (pauseTime - startTime);
            } else {
                elapsedTime += (System.currentTimeMillis() - startTime);
            }
            isRunning = false;
            isPaused = false;
            stopTimerTask(); // Stop the task scheduler
        }
    }

    // Get the elapsed time in milliseconds
    public long getElapsedTime() {
        if (isRunning) {
            if (isPaused) {
                return elapsedTime + (pauseTime - startTime);
            } else {
                return elapsedTime + (System.currentTimeMillis() - startTime);
            }
        } else {
            return elapsedTime;
        }
    }

    // Schedule a task to run repeatedly at specified intervals
    public void scheduleAtFixedRate(long intervalMillis, Runnable task) {
        this.interval = intervalMillis;
        this.task = new TimerTask() {
            @Override
            public void run() {
                task.run();
            }
        };
        startTimerTask();
    }

    private void startTimerTask() {
        if (interval > 0 && task != null) {
            timer.scheduleAtFixedRate(task, interval, interval);
        }
    }

    private void stopTimerTask() {
        if (task != null) {
            task.cancel();
        }
        timer.purge(); // Clean up canceled tasks
    }

    public void sleep(double duration) {
        try {
            Thread.sleep((long) (duration * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

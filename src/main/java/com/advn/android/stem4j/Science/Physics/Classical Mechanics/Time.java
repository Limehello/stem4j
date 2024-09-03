package com.advn.android.stem4j;

public class Time {
    private long startTime;
    private long pauseTime;
    private long elapsedTime;
    private boolean isRunning;
    private boolean isPaused;

    // Constructor to initialize the timer
    public Time() {
        this.elapsedTime = 0;
        this.isRunning = false;
        this.isPaused = false;
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

    public void sleep(double duration) {
        try {
            Thread.sleep((long) (duration * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

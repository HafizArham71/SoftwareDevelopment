package com.example._9_aigamecode.Game;

import java.util.Random;

public class ScreenShake {

    private double intensity = 0;
    private double duration  = 0;
    private double elapsed   = 0;
    private double offsetX   = 0;
    private double offsetY   = 0;
    private final Random random = new Random();

    public void trigger(double intensity, double duration) {
        this.intensity = intensity;
        this.duration  = duration;
        this.elapsed   = 0;
    }

    public void update(double deltaTime) {
        if (elapsed < duration) {
            elapsed += deltaTime;
            double progress = elapsed / duration;
            double currentIntensity = intensity * (1 - progress);
            offsetX = (random.nextDouble() - 0.5) * 2 * currentIntensity;
            offsetY = (random.nextDouble() - 0.5) * 2 * currentIntensity;
        } else {
            offsetX = 0;
            offsetY = 0;
        }
    }

    public double getOffsetX() { return offsetX; }
    public double getOffsetY() { return offsetY; }
    public boolean isShaking() { return elapsed < duration; }
}
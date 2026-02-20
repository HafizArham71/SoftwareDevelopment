package com.example._9_aigamecode.Game;

public class Paddle {

    public static final double WIDTH  = GameConfig.PADDLE_WIDTH;
    public static final double HEIGHT = GameConfig.PADDLE_HEIGHT;

    private double x, y;
    private double velY = 0;
    private int score = 0;
    private final boolean isLeft;

    // Visual state
    private double glowIntensity = 0;
    private boolean justScored = false;

    public Paddle(boolean isLeft) {
        this.isLeft = isLeft;
        if (isLeft) {
            x = GameConfig.PADDLE_MARGIN;
        } else {
            x = GameConfig.FIELD_WIDTH - GameConfig.PADDLE_MARGIN - WIDTH;
        }
        y = (GameConfig.FIELD_HEIGHT - HEIGHT) / 2.0;
    }

    public void switchDirection(int dir) {
        velY = dir * GameConfig.PADDLE_SPEED;
    }

    public void stop() {
        velY = 0;
    }

    public void update(Ball ball) {
        y += velY;

        // Clamp within field
        if (y < 0) y = 0;
        if (y + HEIGHT > GameConfig.FIELD_HEIGHT) y = GameConfig.FIELD_HEIGHT - HEIGHT;

        // Glow decay
        glowIntensity = Math.max(0, glowIntensity - 0.03);
        justScored = false;
    }

    public void incrementScore() {
        score++;
        glowIntensity = 1.0;
        justScored = true;
    }

    public void resetScore() {
        score = 0;
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public int getScore() { return score; }
    public boolean isLeft() { return isLeft; }
    public double getGlowIntensity() { return glowIntensity; }
    public boolean isJustScored() { return justScored; }
    public double getVelY() { return velY; }

    public double getCenterY() { return y + HEIGHT / 2.0; }
}
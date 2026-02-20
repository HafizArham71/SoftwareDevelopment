package com.example._9_aigamecode.Game;

import java.util.Random;

public class Ball {

    public static final int SIZE = GameConfig.BALL_SIZE;

    private double x, y;
    private double velX, velY;
    private double speed;
    private final Random random = new Random();

    // Trail data
    private final double[] trailX = new double[GameConfig.TRAIL_LENGTH];
    private final double[] trailY = new double[GameConfig.TRAIL_LENGTH];
    private int trailIndex = 0;

    // Collision flag for effects
    private boolean justHitPaddle = false;
    private boolean justScored   = false;
    private int     scoreSide    = 0; // 1 = left scored, 2 = right scored

    public Ball() {
        reset();
    }

    public void reset() {
        x = GameConfig.FIELD_WIDTH / 2.0 - SIZE / 2.0;
        y = GameConfig.FIELD_HEIGHT / 2.0 - SIZE / 2.0;
        speed = GameConfig.BALL_BASE_SPEED;

        double angle = (random.nextDouble() * 60 - 30);
        double rad   = Math.toRadians(angle);
        int dir = random.nextBoolean() ? 1 : -1;
        velX = dir * speed * Math.cos(rad);
        velY = speed * Math.sin(rad);

        justHitPaddle = false;
        justScored    = false;
        scoreSide     = 0;

        // Clear trail
        for (int i = 0; i < trailX.length; i++) {
            trailX[i] = x + SIZE / 2.0;
            trailY[i] = y + SIZE / 2.0;
        }
    }

    public void update(Paddle left, Paddle right) {
        justHitPaddle = false;
        justScored    = false;

        // Store trail
        trailX[trailIndex] = x + SIZE / 2.0;
        trailY[trailIndex] = y + SIZE / 2.0;
        trailIndex = (trailIndex + 1) % trailX.length;

        x += velX;
        y += velY;

        // Top / Bottom wall bounce
        if (y <= 0) {
            y = 0;
            velY = Math.abs(velY);
        } else if (y + SIZE >= GameConfig.FIELD_HEIGHT) {
            y = GameConfig.FIELD_HEIGHT - SIZE;
            velY = -Math.abs(velY);
        }

        // Left paddle collision
        if (velX < 0 && collidesWithPaddle(left)) {
            handlePaddleHit(left, 1);
        }

        // Right paddle collision
        if (velX > 0 && collidesWithPaddle(right)) {
            handlePaddleHit(right, -1);
        }

        // Scoring
        if (x + SIZE < 0) {
            right.incrementScore();
            justScored = true;
            scoreSide  = 2;
            SoundManager.play("/sound/Score.wav");
            reset();
        } else if (x > GameConfig.FIELD_WIDTH) {
            left.incrementScore();
            justScored = true;
            scoreSide  = 1;
            SoundManager.play("/sound/Score.wav");
            reset();
        }
    }

    private boolean collidesWithPaddle(Paddle p) {
        double bCX = x + SIZE / 2.0;
        double bCY = y + SIZE / 2.0;
        double pRight  = p.getX() + GameConfig.PADDLE_WIDTH;
        double pBottom = p.getY() + GameConfig.PADDLE_HEIGHT;

        return bCX - SIZE / 2.0 < pRight &&
                bCX + SIZE / 2.0 > p.getX() &&
                bCY - SIZE / 2.0 < pBottom &&
                bCY + SIZE / 2.0 > p.getY();
    }

    private void handlePaddleHit(Paddle p, int directionMultiplier) {
        justHitPaddle = true;

        // Calculate hit position relative to paddle center (-1 to 1)
        double paddleCenterY = p.getY() + GameConfig.PADDLE_HEIGHT / 2.0;
        double ballCenterY   = y + SIZE / 2.0;
        double relativeHit   = (ballCenterY - paddleCenterY) / (GameConfig.PADDLE_HEIGHT / 2.0);
        relativeHit = Math.max(-1, Math.min(1, relativeHit));

        // Increase speed
        speed = Math.min(speed + GameConfig.BALL_ACCELERATION, GameConfig.BALL_MAX_SPEED);

        // Calculate new angle based on hit position (max ±60 degrees)
        double maxAngle = 60;
        double angle = relativeHit * maxAngle;
        double rad = Math.toRadians(angle);

        velX = directionMultiplier * speed * Math.cos(rad);
        velY = speed * Math.sin(rad);

        // Push ball outside paddle to prevent sticking
        if (directionMultiplier > 0) {
            x = p.getX() + GameConfig.PADDLE_WIDTH + 1;
        } else {
            x = p.getX() - SIZE - 1;
        }

        SoundManager.play("/sound/Hit.wav");
    }

    // ======================== GETTERS ========================
    public double getX() { return x; }
    public double getY() { return y; }
    public double getVelX() { return velX; }
    public double getVelY() { return velY; }
    public double getSpeed() { return speed; }
    public boolean isJustHitPaddle() { return justHitPaddle; }
    public boolean isJustScored() { return justScored; }
    public int getScoreSide() { return scoreSide; }

    public double[] getTrailX() { return trailX; }
    public double[] getTrailY() { return trailY; }
    public int getTrailIndex() { return trailIndex; }
    public int getTrailLength() { return trailX.length; }

    public double getCenterX() { return x + SIZE / 2.0; }
    public double getCenterY() { return y + SIZE / 2.0; }
}
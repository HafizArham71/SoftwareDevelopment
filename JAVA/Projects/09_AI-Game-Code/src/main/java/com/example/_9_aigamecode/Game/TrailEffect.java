package com.example._9_aigamecode.Game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class TrailEffect {

    public void render(GraphicsContext gc, Ball ball, double offsetX, double offsetY, Color trailColor) {
        double[] tx = ball.getTrailX();
        double[] ty = ball.getTrailY();
        int idx = ball.getTrailIndex();
        int len = ball.getTrailLength();

        for (int i = 0; i < len; i++) {
            int arrIdx = (idx + i) % len;
            double alpha = (double)(i + 1) / len * 0.35;
            double size = Ball.SIZE * ((double)(i + 1) / len) * 0.7;

            gc.setFill(Color.color(
                    trailColor.getRed(),
                    trailColor.getGreen(),
                    trailColor.getBlue(),
                    alpha
            ));

            gc.fillOval(
                    offsetX + tx[arrIdx] - size / 2,
                    offsetY + ty[arrIdx] - size / 2,
                    size, size
            );
        }
    }
}
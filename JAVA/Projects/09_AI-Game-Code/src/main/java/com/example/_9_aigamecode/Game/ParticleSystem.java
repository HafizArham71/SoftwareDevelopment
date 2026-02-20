package com.example._9_aigamecode.Game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class ParticleSystem {

    private final List<Particle> particles = new ArrayList<>();
    private final Random random = new Random();

    public void emit(double x, double y, Color color, int count, double spread) {
        for (int i = 0; i < count; i++) {
            double angle = random.nextDouble() * Math.PI * 2;
            double speed = 1 + random.nextDouble() * spread;
            double vx = Math.cos(angle) * speed;
            double vy = Math.sin(angle) * speed;
            double life = 0.4 + random.nextDouble() * 0.6;
            double size = 2 + random.nextDouble() * 4;
            particles.add(new Particle(x, y, vx, vy, life, size, color));
        }
    }

    public void emitDirectional(double x, double y, Color color, int count, double dirX, double dirY) {
        for (int i = 0; i < count; i++) {
            double spread = 0.8;
            double vx = dirX * (1 + random.nextDouble() * 2) + (random.nextDouble() - 0.5) * spread;
            double vy = dirY * (1 + random.nextDouble() * 2) + (random.nextDouble() - 0.5) * spread * 3;
            double life = 0.3 + random.nextDouble() * 0.5;
            double size = 2 + random.nextDouble() * 5;
            particles.add(new Particle(x, y, vx, vy, life, size, color));
        }
    }

    public void emitScore(double x, double y, Color color) {
        for (int i = 0; i < 30; i++) {
            double angle = random.nextDouble() * Math.PI * 2;
            double speed = 2 + random.nextDouble() * 6;
            double vx = Math.cos(angle) * speed;
            double vy = Math.sin(angle) * speed;
            double life = 0.5 + random.nextDouble() * 1.0;
            double size = 3 + random.nextDouble() * 6;
            particles.add(new Particle(x, y, vx, vy, life, size, color));
        }
    }

    public void update(double deltaTime) {
        Iterator<Particle> it = particles.iterator();
        while (it.hasNext()) {
            Particle p = it.next();
            p.update(deltaTime);
            if (p.isDead()) it.remove();
        }
    }

    public void render(GraphicsContext gc, double offsetX, double offsetY) {
        for (Particle p : particles) {
            double alpha = p.getAlpha();
            Color c = p.color;
            gc.setFill(Color.color(
                    c.getRed(), c.getGreen(), c.getBlue(), alpha
            ));
            double size = p.size * alpha;
            gc.fillOval(
                    offsetX + p.x - size / 2,
                    offsetY + p.y - size / 2,
                    size, size
            );
        }
    }

    public void clear() {
        particles.clear();
    }

    // ======================== INNER CLASS ========================
    private static class Particle {
        double x, y, vx, vy;
        double life, maxLife, size;
        Color color;

        Particle(double x, double y, double vx, double vy, double life, double size, Color color) {
            this.x = x; this.y = y;
            this.vx = vx; this.vy = vy;
            this.life = life; this.maxLife = life;
            this.size = size; this.color = color;
        }

        void update(double dt) {
            x += vx;
            y += vy;
            vx *= 0.96;
            vy *= 0.96;
            life -= dt;
        }

        boolean isDead() { return life <= 0; }

        double getAlpha() {
            return Math.max(0, Math.min(1, life / maxLife));
        }
    }
}
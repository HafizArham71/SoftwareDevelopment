package com.example._9_aigamecode.Game;

import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;

public class GameConfig {

    // ======================== DIMENSIONS ========================
    public static final double FIELD_WIDTH  = 1000;
    public static final double FIELD_HEIGHT = 480;
    public static final double APP_WIDTH    = 1280;
    public static final double APP_HEIGHT   = 800;
    public static final double BOARD_MARGIN = 24;

    // ======================== GAMEPLAY ========================
    public static final int    WIN_SCORE         = 10;
    public static final double BALL_BASE_SPEED   = 10.0;     // from 5.0
    public static final double BALL_MAX_SPEED    = 20.0;    // from 10.0
    public static final double BALL_ACCELERATION = 0.15;    // from 0.15
    public static final double PADDLE_SPEED      = 13;     // from 6.5
    public static final double PADDLE_WIDTH      = 14;
    public static final double PADDLE_HEIGHT     = 100;
    public static final double PADDLE_MARGIN     = 20;
    public static final int    BALL_SIZE         = 16;
    public static final int    COUNTDOWN_SECONDS = 3;

    // ======================== COLORS (60-30-10 Rule) ========================

    // 60% — Background / Dominant
    public static final String BG_DARKEST    = "#020617";   // Slate 950
    public static final String BG_DARK       = "#0F172A";   // Slate 900
    public static final String BG_MEDIUM     = "#1E293B";   // Slate 800

    // 30% — Secondary / Supporting
    public static final String SURFACE       = "#334155";   // Slate 700
    public static final String BORDER        = "#475569";   // Slate 600
    public static final String BORDER_SUBTLE = "#374151";   // Gray 700
    public static final String TEXT_MUTED    = "#94A3B8";   // Slate 400
    public static final String TEXT_DIM      = "#64748B";   // Slate 500

    // 10% — Accent / CTA
    public static final String PLAYER_1_PRIMARY   = "rgba(59, 130, 246, 0.12)";  // Blue 500
    public static final String PLAYER_1_LIGHT     = "#60A5FA";  // Blue 400
    public static final String PLAYER_1_GLOW      = "#2563EB";  // Blue 600
    public static final String PLAYER_1_SUBTLE    = "rgba(59,130,246,0.15)";

    public static final String PLAYER_2_PRIMARY   = "#EC4899";  // Pink 500
    public static final String PLAYER_2_LIGHT     = "#F472B6";  // Pink 400
    public static final String PLAYER_2_GLOW      = "#DB2777";  // Pink 600
    public static final String PLAYER_2_SUBTLE    = "rgba(236,72,153,0.15)";

    public static final String ACCENT_GREEN       = "#10B981";  // Emerald 500
    public static final String ACCENT_YELLOW      = "#F59E0B";  // Amber 500
    public static final String ACCENT_RED         = "#EF4444";  // Red 500

    public static final String TEXT_PRIMARY   = "#F1F5F9";  // Slate 100
    public static final String TEXT_SECONDARY = "#CBD5E1";  // Slate 300
    public static final String TEXT_WHITE     = "#FFFFFF";

    // ======================== FIELD GRADIENT ========================
    public static LinearGradient getFieldGradient() {
        return new LinearGradient(
                0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
                new Stop(0.0, Color.web("#0F172A")),
                new Stop(0.5, Color.web("#0C1425")),
                new Stop(1.0, Color.web("#0F172A"))
        );
    }

    // ======================== FONTS ========================
    public static final String FONT_FAMILY    = "System";
    public static final double FONT_TITLE     = 52;
    public static final double FONT_SUBTITLE  = 15;
    public static final double FONT_SCORE     = 72;
    public static final double FONT_LABEL     = 13;
    public static final double FONT_BUTTON    = 15;
    public static final double FONT_BODY      = 14;
    public static final double FONT_SMALL     = 12;
    public static final double FONT_WINNER    = 56;
    public static final double FONT_COUNTDOWN = 120;

    // ======================== ANIMATION ========================
    public static final double PARTICLE_LIFE   = 0.8;
    public static final int    PARTICLE_COUNT  = 12;
    public static final int    TRAIL_LENGTH    = 8;
    public static final double SHAKE_INTENSITY = 8;
    public static final double SHAKE_DURATION  = 0.25;

    // ======================== UI RADII ========================
    public static final double RADIUS_SM = 6;
    public static final double RADIUS_MD = 12;
    public static final double RADIUS_LG = 20;
    public static final double RADIUS_XL = 28;
    public static final double RADIUS_FIELD = 24;
}
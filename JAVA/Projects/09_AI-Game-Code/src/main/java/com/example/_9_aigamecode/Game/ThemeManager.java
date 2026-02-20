package com.example._9_aigamecode.Game;

import javafx.scene.paint.Color;

public class ThemeManager {

    public enum Theme {
        MIDNIGHT,
        OCEAN,
        NEON,
        FOREST
    }

    private Theme current = Theme.MIDNIGHT;

    public void setTheme(Theme theme) { this.current = theme; }
    public Theme getTheme() { return current; }

    public String getBgDarkest() {
        return switch (current) {
            case OCEAN  -> "#001220";
            case NEON   -> "#0a0010";
            case FOREST -> "#071207";
            default     -> GameConfig.BG_DARKEST;
        };
    }

    public String getBgDark() {
        return switch (current) {
            case OCEAN  -> "#001830";
            case NEON   -> "#120020";
            case FOREST -> "#0d1f0d";
            default     -> GameConfig.BG_DARK;
        };
    }

    public String getFieldBg() {
        return switch (current) {
            case OCEAN  -> "#00253D";
            case NEON   -> "#1a0030";
            case FOREST -> "#142814";
            default     -> GameConfig.BG_DARK;
        };
    }

    public Color getPlayer1Color() {
        return switch (current) {
            case OCEAN  -> Color.web("#06B6D4");
            case NEON   -> Color.web("#A855F7");
            case FOREST -> Color.web("#22C55E");
            default     -> Color.web(GameConfig.PLAYER_1_PRIMARY);
        };
    }

    public Color getPlayer2Color() {
        return switch (current) {
            case OCEAN  -> Color.web("#F97316");
            case NEON   -> Color.web("#F43F5E");
            case FOREST -> Color.web("#EAB308");
            default     -> Color.web(GameConfig.PLAYER_2_PRIMARY);
        };
    }

    public String getPlayer1Hex() {
        return switch (current) {
            case OCEAN  -> "#06B6D4";
            case NEON   -> "#A855F7";
            case FOREST -> "#22C55E";
            default     -> GameConfig.PLAYER_1_PRIMARY;
        };
    }

    public String getPlayer2Hex() {
        return switch (current) {
            case OCEAN  -> "#F97316";
            case NEON   -> "#F43F5E";
            case FOREST -> "#EAB308";
            default     -> GameConfig.PLAYER_2_PRIMARY;
        };
    }

    public Color getBallColor() {
        return switch (current) {
            case NEON   -> Color.web("#FBBF24");
            default     -> Color.web("#F1F5F9");
        };
    }

    public Color getTrailColor() {
        return switch (current) {
            case OCEAN  -> Color.web("#38BDF8");
            case NEON   -> Color.web("#FBBF24");
            case FOREST -> Color.web("#86EFAC");
            default     -> Color.web("#94A3B8");
        };
    }

    public String getMidlineColor() {
        return switch (current) {
            case OCEAN  -> "#0E4D6B";
            case NEON   -> "#3B0764";
            case FOREST -> "#1A3A1A";
            default     -> "#334155";
        };
    }

    public String getBorderColor() {
        return switch (current) {
            case OCEAN  -> "#0C4A6E";
            case NEON   -> "#581C87";
            case FOREST -> "#166534";
            default     -> GameConfig.BORDER;
        };
    }
}
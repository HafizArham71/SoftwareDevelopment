package com.example._9_aigamecode.Game;

import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Window extends Application {

    // ======================== GAME OBJECTS ========================
    private Ball ball;
    private Paddle paddle1;
    private Paddle paddle2;
    private ParticleSystem particles;
    private ScreenShake screenShake;
    private TrailEffect trailEffect;
    private ThemeManager themeManager;

    // ======================== UI NODES ========================
    private Canvas gameCanvas;
    private Label scoreALabel, scoreBLabel;
    private Label playerANameLabel, playerBNameLabel;
    private Label winnerLabel, winnerSubLabel;
    private VBox winnerOverlay;
    private Label countdownLabel;
    private StackPane countdownOverlay;
    private Label speedLabel;
    private Rectangle progressFillA, progressFillB;

    // ======================== STATE ========================
    private boolean wPressed, sPressed, upPressed, downPressed;
    private AnimationTimer gameLoop;
    private boolean gameOver   = false;
    private boolean gamePaused = false;
    private boolean gameStarted = false;

    private Stage primaryStage;
    private String player1Name = "PLAYER A";
    private String player2Name = "PLAYER B";

    // Delta time tracking
    private long lastFrameTime = 0;

    // ======================== SETTINGS ========================
    private int winScore = GameConfig.WIN_SCORE;
    private boolean soundEnabled = true;
    private boolean particlesEnabled = true;
    private boolean trailEnabled = true;
    private boolean shakeEnabled = true;

    @Override
    public void start(Stage stage) {
        this.primaryStage = stage;
        themeManager = new ThemeManager();

        try {
            Image icon = new Image("Icon.png");
            stage.getIcons().add(icon);
        } catch (Exception ignored) { }

        stage.setTitle("Ping Pong — by TaskFlow");
        stage.setMinWidth(900);
        stage.setMinHeight(650);

        Scene startScene = createStartScene();
        stage.setScene(startScene);
        stage.show();
    }

    // ================================================================
    //                       START SCREEN
    // ================================================================

    private Scene createStartScene() {
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: " + GameConfig.BG_DARKEST + ";");

        // Background ambient particles (decorative circles)
        Pane bgDecorations = createBgDecorations();

        // Main card
        BorderPane card = new BorderPane();
        card.setMaxWidth(880);
        card.setMaxHeight(620);
        card.setStyle(
                "-fx-background-color: " + GameConfig.BG_DARK + ";" +
                        "-fx-background-radius: " + GameConfig.RADIUS_XL + ";" +
                        "-fx-border-color: " + GameConfig.BORDER_SUBTLE + ";" +
                        "-fx-border-radius: " + GameConfig.RADIUS_XL + ";" +
                        "-fx-border-width: 1;"
        );

        DropShadow cardShadow = new DropShadow();
        cardShadow.setRadius(60);
        cardShadow.setOffsetY(15);
        cardShadow.setColor(Color.color(0, 0, 0, 0.6));
        card.setEffect(cardShadow);

        // ============== HEADER ==============
        VBox header = new VBox(6);
        header.setAlignment(Pos.CENTER);
        header.setPadding(new Insets(48, 0, 16, 0));

        // Logo icon
        StackPane logoIcon = new StackPane();
        Circle logoBg = new Circle(28);
        logoBg.setFill(Color.web(GameConfig.PLAYER_1_PRIMARY, 0.15));
        logoBg.setStroke(Color.web(GameConfig.PLAYER_1_PRIMARY, 0.3));
        logoBg.setStrokeWidth(1.5);
        Label logoEmoji = new Label("🏓");
        logoEmoji.setFont(Font.font(26));
        logoIcon.getChildren().addAll(logoBg, logoEmoji);

        Label title = new Label("PING PONG");
        title.setFont(Font.font(GameConfig.FONT_FAMILY, FontWeight.BLACK, GameConfig.FONT_TITLE));
        title.setTextFill(Color.web(GameConfig.TEXT_PRIMARY));

        // Gradient underline
        Rectangle underline = new Rectangle(120, 3);
        underline.setFill(new LinearGradient(
                0, 0, 1, 0, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.web(GameConfig.PLAYER_1_PRIMARY)),
                new Stop(1, Color.web(GameConfig.PLAYER_2_PRIMARY))
        ));
        underline.setArcWidth(4); underline.setArcHeight(4);

        Label subtitle = new Label("PLAYER SETUP");
        subtitle.setFont(Font.font(GameConfig.FONT_FAMILY, FontWeight.BOLD, GameConfig.FONT_SUBTITLE));
        subtitle.setTextFill(Color.web(GameConfig.TEXT_DIM));
        subtitle.setPadding(new Insets(10, 0, 0, 0));

        header.getChildren().addAll(logoIcon, title, underline, subtitle);
        card.setTop(header);

        // ============== CENTER ==============
        VBox center = new VBox(28);
        center.setAlignment(Pos.CENTER);
        center.setPadding(new Insets(24, 72, 24, 72));

        // Player inputs
        HBox namesRow = new HBox(24);
        namesRow.setAlignment(Pos.CENTER);

        VBox leftInput = createPlayerInputGroup("PLAYER 1", GameConfig.PLAYER_1_PRIMARY, "PLAYER A", "W / S");
        VBox rightInput = createPlayerInputGroup("PLAYER 2", GameConfig.PLAYER_2_PRIMARY, "PLAYER B", "↑ / ↓");

        // VS divider
        VBox vsDivider = new VBox();
        vsDivider.setAlignment(Pos.CENTER);
        vsDivider.setPadding(new Insets(20, 16, 0, 16));
        Label vsLabel = new Label("VS");
        vsLabel.setFont(Font.font(GameConfig.FONT_FAMILY, FontWeight.BLACK, 22));
        vsLabel.setTextFill(Color.web(GameConfig.TEXT_DIM));
        vsDivider.getChildren().add(vsLabel);

        namesRow.getChildren().addAll(leftInput, vsDivider, rightInput);

        // Divider line
        Line divider = new Line(0, 0, 500, 0);
        divider.setStroke(Color.web(GameConfig.BORDER_SUBTLE));
        divider.setStrokeWidth(1);

        // Settings row
        HBox settingsRow = createStartSettings();

        // Theme selector
        HBox themeRow = createThemeSelector();

        // Start button area
        VBox startArea = new VBox(10);
        startArea.setAlignment(Pos.CENTER);

        // Start button
        StackPane startBtn = createStartButton();

        Label hintLabel = new Label("or press ENTER");
        hintLabel.setFont(Font.font(GameConfig.FONT_FAMILY, FontWeight.MEDIUM, GameConfig.FONT_SMALL));
        hintLabel.setTextFill(Color.web(GameConfig.TEXT_DIM));

        startArea.getChildren().addAll(startBtn, hintLabel);

        // Controls info
        HBox controlsInfo = new HBox(48);
        controlsInfo.setAlignment(Pos.CENTER);
        controlsInfo.setPadding(new Insets(8, 0, 0, 0));

        Label escLabel = new Label("ESC to pause");
        escLabel.setFont(Font.font(GameConfig.FONT_FAMILY, FontWeight.MEDIUM, GameConfig.FONT_SMALL));
        escLabel.setTextFill(Color.web(GameConfig.TEXT_DIM));

        Label rLabel = new Label("R to restart");
        rLabel.setFont(Font.font(GameConfig.FONT_FAMILY, FontWeight.MEDIUM, GameConfig.FONT_SMALL));
        rLabel.setTextFill(Color.web(GameConfig.TEXT_DIM));

        controlsInfo.getChildren().addAll(escLabel, rLabel);

        center.getChildren().addAll(namesRow, divider, settingsRow, themeRow, startArea, controlsInfo);
        card.setCenter(center);

        root.getChildren().addAll(bgDecorations, card);

        Scene scene = new Scene(root, GameConfig.APP_WIDTH, GameConfig.APP_HEIGHT);

        // Input handling
        TextField leftField = (TextField) leftInput.lookup(".text-field");
        TextField rightField = (TextField) rightInput.lookup(".text-field");

        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                collectNamesAndStart(leftField, rightField);
            }
        });

        startBtn.setOnMouseClicked(e -> collectNamesAndStart(leftField, rightField));

        return scene;
    }

    private void collectNamesAndStart(TextField left, TextField right) {
        player1Name = left.getText().trim().isEmpty() ? "PLAYER A" : left.getText().trim().toUpperCase();
        player2Name = right.getText().trim().isEmpty() ? "PLAYER B" : right.getText().trim().toUpperCase();
        if (player1Name.length() > 12) player1Name = player1Name.substring(0, 12);
        if (player2Name.length() > 12) player2Name = player2Name.substring(0, 12);
        showGameScene();
    }

    private VBox createPlayerInputGroup(String label, String color, String placeholder, String controls) {
        VBox group = new VBox(8);
        group.setAlignment(Pos.CENTER);
        group.setPrefWidth(280);

        // Color dot + label
        HBox labelRow = new HBox(8);
        labelRow.setAlignment(Pos.CENTER);

        Circle dot = new Circle(5);
        dot.setFill(Color.web(color));

        Label playerLabel = new Label(label);
        playerLabel.setFont(Font.font(GameConfig.FONT_FAMILY, FontWeight.BOLD, GameConfig.FONT_LABEL));
        playerLabel.setTextFill(Color.web(GameConfig.TEXT_MUTED));

        labelRow.getChildren().addAll(dot, playerLabel);

        // Input field
        TextField field = new TextField();
        field.setPromptText(placeholder);
        field.setMaxWidth(260);
        field.setFont(Font.font(GameConfig.FONT_FAMILY, FontWeight.MEDIUM, GameConfig.FONT_BODY));
        field.setStyle(
                "-fx-background-color: " + GameConfig.BG_DARKEST + ";" +
                        "-fx-border-color: " + GameConfig.BORDER_SUBTLE + ";" +
                        "-fx-border-radius: " + GameConfig.RADIUS_SM + ";" +
                        "-fx-background-radius: " + GameConfig.RADIUS_SM + ";" +
                        "-fx-text-fill: " + GameConfig.TEXT_PRIMARY + ";" +
                        "-fx-prompt-text-fill: " + GameConfig.TEXT_DIM + ";" +
                        "-fx-padding: 12 16;" +
                        "-fx-focus-color: " + color + ";" +
                        "-fx-faint-focus-color: transparent;"
        );

        field.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal) {
                field.setStyle(field.getStyle().replace(
                        "-fx-border-color: " + GameConfig.BORDER_SUBTLE,
                        "-fx-border-color: " + color
                ));
            } else {
                field.setStyle(field.getStyle().replace(
                        "-fx-border-color: " + color,
                        "-fx-border-color: " + GameConfig.BORDER_SUBTLE
                ));
            }
        });

        // Controls badge
        Label controlsLabel = new Label(controls);
        controlsLabel.setFont(Font.font(GameConfig.FONT_FAMILY, FontWeight.BOLD, GameConfig.FONT_SMALL));
        controlsLabel.setTextFill(Color.web(color));
        controlsLabel.setStyle(
                "-fx-background-color: " + color.replace("#", "rgba(") + ",0.12);" +
                        "-fx-background-radius: 4;" +
                        "-fx-padding: 4 10;"
        );

        group.getChildren().addAll(labelRow, field, controlsLabel);
        return group;
    }

    private HBox createStartSettings() {
        HBox row = new HBox(24);
        row.setAlignment(Pos.CENTER);

        // Win score selector
        VBox scoreGroup = new VBox(4);
        scoreGroup.setAlignment(Pos.CENTER);
        Label scoreLabel = new Label("WIN SCORE");
        scoreLabel.setFont(Font.font(GameConfig.FONT_FAMILY, FontWeight.BOLD, 11));
        scoreLabel.setTextFill(Color.web(GameConfig.TEXT_DIM));

        HBox scoreSelector = new HBox(0);
        scoreSelector.setAlignment(Pos.CENTER);
        scoreSelector.setStyle(
                "-fx-background-color: " + GameConfig.BG_DARKEST + ";" +
                        "-fx-background-radius: " + GameConfig.RADIUS_SM + ";" +
                        "-fx-border-color: " + GameConfig.BORDER_SUBTLE + ";" +
                        "-fx-border-radius: " + GameConfig.RADIUS_SM + ";"
        );

        int[] scores = {5, 7, 10, 15, 20};
        Label[] scoreBtns = new Label[scores.length];
        for (int i = 0; i < scores.length; i++) {
            final int sc = scores[i];
            Label btn = new Label(String.valueOf(sc));
            btn.setFont(Font.font(GameConfig.FONT_FAMILY, FontWeight.BOLD, 13));
            btn.setPadding(new Insets(6, 14, 6, 14));
            btn.setCursor(javafx.scene.Cursor.HAND);

            if (sc == winScore) {
                btn.setTextFill(Color.web(GameConfig.TEXT_WHITE));
                btn.setStyle("-fx-background-color: " + GameConfig.PLAYER_1_PRIMARY + "; -fx-background-radius: 4;");
            } else {
                btn.setTextFill(Color.web(GameConfig.TEXT_DIM));
                btn.setStyle("-fx-background-color: transparent;");
            }

            scoreBtns[i] = btn;

            btn.setOnMouseClicked(e -> {
                winScore = sc;
                for (Label b : scoreBtns) {
                    b.setTextFill(Color.web(GameConfig.TEXT_DIM));
                    b.setStyle("-fx-background-color: transparent;");
                }
                btn.setTextFill(Color.web(GameConfig.TEXT_WHITE));
                btn.setStyle("-fx-background-color: " + GameConfig.PLAYER_1_PRIMARY + "; -fx-background-radius: 4;");
            });

            scoreSelector.getChildren().add(btn);
        }

        scoreGroup.getChildren().addAll(scoreLabel, scoreSelector);

        // Sound toggle
        VBox soundGroup = createToggleSetting("SOUND", soundEnabled, (val) -> {
            soundEnabled = val;
            SoundManager.setEnabled(val);
        });

        // Particles toggle
        VBox particleGroup = createToggleSetting("EFFECTS", particlesEnabled, (val) -> {
            particlesEnabled = val;
            trailEnabled = val;
            shakeEnabled = val;
        });

        row.getChildren().addAll(scoreGroup, soundGroup, particleGroup);
        return row;
    }

    private VBox createToggleSetting(String labelText, boolean initialVal, java.util.function.Consumer<Boolean> onChange) {
        VBox group = new VBox(4);
        group.setAlignment(Pos.CENTER);

        Label label = new Label(labelText);
        label.setFont(Font.font(GameConfig.FONT_FAMILY, FontWeight.BOLD, 11));
        label.setTextFill(Color.web(GameConfig.TEXT_DIM));

        Label toggleBtn = new Label(initialVal ? "ON" : "OFF");
        toggleBtn.setFont(Font.font(GameConfig.FONT_FAMILY, FontWeight.BOLD, 13));
        toggleBtn.setPadding(new Insets(6, 20, 6, 20));
        toggleBtn.setCursor(javafx.scene.Cursor.HAND);

        updateToggleStyle(toggleBtn, initialVal);

        final boolean[] state = {initialVal};
        toggleBtn.setOnMouseClicked(e -> {
            state[0] = !state[0];
            toggleBtn.setText(state[0] ? "ON" : "OFF");
            updateToggleStyle(toggleBtn, state[0]);
            onChange.accept(state[0]);
        });

        group.getChildren().addAll(label, toggleBtn);
        return group;
    }

    private void updateToggleStyle(Label btn, boolean on) {
        if (on) {
            btn.setTextFill(Color.web(GameConfig.ACCENT_GREEN));
            btn.setStyle(
                    "-fx-background-color: rgba(16,185,129,0.12);" +
                            "-fx-background-radius: " + GameConfig.RADIUS_SM + ";" +
                            "-fx-border-color: rgba(16,185,129,0.3);" +
                            "-fx-border-radius: " + GameConfig.RADIUS_SM + ";"
            );
        } else {
            btn.setTextFill(Color.web(GameConfig.TEXT_DIM));
            btn.setStyle(
                    "-fx-background-color: " + GameConfig.BG_DARKEST + ";" +
                            "-fx-background-radius: " + GameConfig.RADIUS_SM + ";" +
                            "-fx-border-color: " + GameConfig.BORDER_SUBTLE + ";" +
                            "-fx-border-radius: " + GameConfig.RADIUS_SM + ";"
            );
        }
    }

    private HBox createThemeSelector() {
        HBox row = new HBox(12);
        row.setAlignment(Pos.CENTER);

        Label label = new Label("THEME");
        label.setFont(Font.font(GameConfig.FONT_FAMILY, FontWeight.BOLD, 11));
        label.setTextFill(Color.web(GameConfig.TEXT_DIM));
        label.setPadding(new Insets(0, 8, 0, 0));

        String[][] themes = {
                {"MIDNIGHT", "#3B82F6", "#EC4899"},
                {"OCEAN",    "#06B6D4", "#F97316"},
                {"NEON",     "#A855F7", "#F43F5E"},
                {"FOREST",   "#22C55E", "#EAB308"}
        };

        HBox themeBtns = new HBox(6);
        themeBtns.setAlignment(Pos.CENTER);

        Label[] buttons = new Label[themes.length];
        for (int i = 0; i < themes.length; i++) {
            final int idx = i;
            Label btn = new Label(themes[i][0]);
            btn.setFont(Font.font(GameConfig.FONT_FAMILY, FontWeight.BOLD, 11));
            btn.setPadding(new Insets(5, 12, 5, 12));
            btn.setCursor(javafx.scene.Cursor.HAND);
            buttons[i] = btn;

            if (i == 0) {
                btn.setTextFill(Color.web(GameConfig.TEXT_WHITE));
                btn.setStyle("-fx-background-color: " + GameConfig.SURFACE + "; -fx-background-radius: 4;");
            } else {
                btn.setTextFill(Color.web(GameConfig.TEXT_DIM));
                btn.setStyle("-fx-background-color: transparent; -fx-background-radius: 4;");
            }

            btn.setOnMouseClicked(e -> {
                ThemeManager.Theme t = ThemeManager.Theme.values()[idx];
                themeManager.setTheme(t);
                for (Label b : buttons) {
                    b.setTextFill(Color.web(GameConfig.TEXT_DIM));
                    b.setStyle("-fx-background-color: transparent; -fx-background-radius: 4;");
                }
                btn.setTextFill(Color.web(GameConfig.TEXT_WHITE));
                btn.setStyle("-fx-background-color: " + GameConfig.SURFACE + "; -fx-background-radius: 4;");
            });

            themeBtns.getChildren().add(btn);
        }

        row.getChildren().addAll(label, themeBtns);
        return row;
    }

    private StackPane createStartButton() {
        StackPane btn = new StackPane();
        btn.setCursor(javafx.scene.Cursor.HAND);
        btn.setMaxWidth(260);
        btn.setPadding(new Insets(14, 48, 14, 48));

        Rectangle bg = new Rectangle(260, 48);
        bg.setArcWidth(GameConfig.RADIUS_MD * 2);
        bg.setArcHeight(GameConfig.RADIUS_MD * 2);
        bg.setFill(new LinearGradient(
                0, 0, 1, 0, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.web(GameConfig.PLAYER_1_PRIMARY)),
                new Stop(1, Color.web(GameConfig.PLAYER_2_PRIMARY))
        ));

        DropShadow btnShadow = new DropShadow();
        btnShadow.setColor(Color.web(GameConfig.PLAYER_1_PRIMARY, 0.4));
        btnShadow.setRadius(20);
        btnShadow.setOffsetY(6);
        bg.setEffect(btnShadow);

        Label btnText = new Label("START GAME");
        btnText.setFont(Font.font(GameConfig.FONT_FAMILY, FontWeight.EXTRA_BOLD, GameConfig.FONT_BUTTON));
        btnText.setTextFill(Color.web(GameConfig.TEXT_WHITE));

        btn.getChildren().addAll(bg, btnText);

        btn.setOnMouseEntered(e -> {
            ScaleTransition st = new ScaleTransition(Duration.millis(150), btn);
            st.setToX(1.04); st.setToY(1.04); st.play();
        });
        btn.setOnMouseExited(e -> {
            ScaleTransition st = new ScaleTransition(Duration.millis(150), btn);
            st.setToX(1.0); st.setToY(1.0); st.play();
        });

        return btn;
    }

    private Pane createBgDecorations() {
        Pane pane = new Pane();
        pane.setMouseTransparent(true);

        double[][] circles = {
                {100, 100, 200, 0.03}, {900, 600, 300, 0.04},
                {600, 100, 150, 0.03}, {200, 500, 180, 0.02}
        };

        for (double[] c : circles) {
            Circle circle = new Circle(c[2]);
            circle.setFill(Color.web(GameConfig.PLAYER_1_PRIMARY, c[3]));
            circle.setCenterX(c[0]);
            circle.setCenterY(c[1]);
            pane.getChildren().add(circle);
        }

        return pane;
    }

    // ================================================================
    //                       GAME SCREEN
    // ================================================================

    private void showGameScene() {
        particles   = new ParticleSystem();
        screenShake = new ScreenShake();
        trailEffect = new TrailEffect();

        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: " + themeManager.getBgDarkest() + ";");

        // Main layout
        VBox mainLayout = new VBox(0);
        mainLayout.setAlignment(Pos.TOP_CENTER);
        mainLayout.setStyle("-fx-background-color: transparent;");

        // Header bar
        HBox headerBar = buildHeaderBar();

        // Score section
        HBox scoreSection = buildScoreSection();

        // Game field
        StackPane fieldWrapper = buildGameField();

        // Bottom info bar
        HBox bottomBar = buildBottomBar();

        mainLayout.getChildren().addAll(headerBar, scoreSection, fieldWrapper, bottomBar);
        VBox.setVgrow(fieldWrapper, Priority.ALWAYS);

        // Overlays
        winnerOverlay = buildWinnerOverlay();
        countdownOverlay = buildCountdownOverlay();

        // Pause overlay
        VBox pauseOverlay = buildPauseOverlay();

        root.getChildren().addAll(mainLayout, pauseOverlay, countdownOverlay, winnerOverlay);

        Scene scene = new Scene(root, GameConfig.APP_WIDTH, GameConfig.APP_HEIGHT);
        setupGame(scene, pauseOverlay);

        primaryStage.setScene(scene);

        // Start countdown
        startCountdown(() -> {
            gameStarted = true;
            gameLoop.start();
        });
    }

    // ======================== HEADER BAR ========================
    private HBox buildHeaderBar() {
        HBox bar = new HBox();
        bar.setAlignment(Pos.CENTER_LEFT);
        bar.setPadding(new Insets(16, 28, 12, 28));
        bar.setStyle("-fx-background-color: " + themeManager.getBgDark() + ";" +
                "-fx-border-color: " + themeManager.getBorderColor() + ";" +
                "-fx-border-width: 0 0 1 0;");

        // Left: Game title
        HBox leftSection = new HBox(10);
        leftSection.setAlignment(Pos.CENTER_LEFT);

        Label logoEmoji = new Label("🏓");
        logoEmoji.setFont(Font.font(18));

        Label gameTitle = new Label("PING PONG");
        gameTitle.setFont(Font.font(GameConfig.FONT_FAMILY, FontWeight.EXTRA_BOLD, 16));
        gameTitle.setTextFill(Color.web(GameConfig.TEXT_PRIMARY));

        // Win score badge
        Label winBadge = new Label("First to " + winScore);
        winBadge.setFont(Font.font(GameConfig.FONT_FAMILY, FontWeight.BOLD, 11));
        winBadge.setTextFill(Color.web(GameConfig.TEXT_DIM));
        winBadge.setStyle(
                "-fx-background-color: " + themeManager.getBgDarkest() + ";" +
                        "-fx-background-radius: 4;" +
                        "-fx-padding: 3 10;" +
                        "-fx-border-color: " + themeManager.getBorderColor() + ";" +
                        "-fx-border-radius: 4;"
        );

        leftSection.getChildren().addAll(logoEmoji, gameTitle, winBadge);

        // Right: Speed + controls
        HBox rightSection = new HBox(16);
        rightSection.setAlignment(Pos.CENTER_RIGHT);
        HBox.setHgrow(rightSection, Priority.ALWAYS);

        speedLabel = new Label("SPEED: 1.0x");
        speedLabel.setFont(Font.font(GameConfig.FONT_FAMILY, FontWeight.BOLD, 11));
        speedLabel.setTextFill(Color.web(GameConfig.ACCENT_YELLOW));
        speedLabel.setStyle(
                "-fx-background-color: rgba(245,158,11,0.1);" +
                        "-fx-background-radius: 4;" +
                        "-fx-padding: 3 10;"
        );

        Label pauseHint = new Label("ESC Pause");
        pauseHint.setFont(Font.font(GameConfig.FONT_FAMILY, FontWeight.MEDIUM, 11));
        pauseHint.setTextFill(Color.web(GameConfig.TEXT_DIM));

        Label restartHint = new Label("R Restart");
        restartHint.setFont(Font.font(GameConfig.FONT_FAMILY, FontWeight.MEDIUM, 11));
        restartHint.setTextFill(Color.web(GameConfig.TEXT_DIM));

        rightSection.getChildren().addAll(speedLabel, pauseHint, restartHint);

        bar.getChildren().addAll(leftSection, rightSection);
        return bar;
    }

    // ======================== SCORE SECTION ========================
    private HBox buildScoreSection() {
        HBox section = new HBox(0);
        section.setAlignment(Pos.CENTER);
        section.setPadding(new Insets(20, 40, 16, 40));
        section.setStyle("-fx-background-color: transparent;");

        // Player A
        HBox playerA = new HBox(16);
        playerA.setAlignment(Pos.CENTER_RIGHT);
        HBox.setHgrow(playerA, Priority.ALWAYS);

        VBox playerAInfo = new VBox(2);
        playerAInfo.setAlignment(Pos.CENTER_RIGHT);
        playerANameLabel = new Label(player1Name);
        playerANameLabel.setFont(Font.font(GameConfig.FONT_FAMILY, FontWeight.BOLD, GameConfig.FONT_LABEL));
        playerANameLabel.setTextFill(Color.web(GameConfig.TEXT_MUTED));

        // Progress bar A
        StackPane progressA = createProgressBar(true);

        playerAInfo.getChildren().addAll(playerANameLabel, progressA);

        scoreALabel = new Label("00");
        scoreALabel.setFont(Font.font(GameConfig.FONT_FAMILY, FontWeight.BLACK, GameConfig.FONT_SCORE));
        scoreALabel.setTextFill(themeManager.getPlayer1Color());

        DropShadow scoreGlowA = new DropShadow();
        scoreGlowA.setColor(Color.web(themeManager.getPlayer1Hex(), 0.3));
        scoreGlowA.setRadius(20);
        scoreALabel.setEffect(scoreGlowA);

        playerA.getChildren().addAll(playerAInfo, scoreALabel);

        // Center divider
        VBox centerDiv = new VBox(4);
        centerDiv.setAlignment(Pos.CENTER);
        centerDiv.setPadding(new Insets(0, 32, 0, 32));

        Line vLine = new Line(0, 0, 0, 60);
        vLine.setStroke(Color.web(GameConfig.BORDER_SUBTLE));
        vLine.setStrokeWidth(1);

        Label vsLabel = new Label("VS");
        vsLabel.setFont(Font.font(GameConfig.FONT_FAMILY, FontWeight.BLACK, 12));
        vsLabel.setTextFill(Color.web(GameConfig.TEXT_DIM));

        centerDiv.getChildren().addAll(vLine, vsLabel);

        // Player B
        HBox playerB = new HBox(16);
        playerB.setAlignment(Pos.CENTER_LEFT);
        HBox.setHgrow(playerB, Priority.ALWAYS);

        scoreBLabel = new Label("00");
        scoreBLabel.setFont(Font.font(GameConfig.FONT_FAMILY, FontWeight.BLACK, GameConfig.FONT_SCORE));
        scoreBLabel.setTextFill(themeManager.getPlayer2Color());

        DropShadow scoreGlowB = new DropShadow();
        scoreGlowB.setColor(Color.web(themeManager.getPlayer2Hex(), 0.3));
        scoreGlowB.setRadius(20);
        scoreBLabel.setEffect(scoreGlowB);

        VBox playerBInfo = new VBox(2);
        playerBInfo.setAlignment(Pos.CENTER_LEFT);
        playerBNameLabel = new Label(player2Name);
        playerBNameLabel.setFont(Font.font(GameConfig.FONT_FAMILY, FontWeight.BOLD, GameConfig.FONT_LABEL));
        playerBNameLabel.setTextFill(Color.web(GameConfig.TEXT_MUTED));

        StackPane progressB = createProgressBar(false);

        playerBInfo.getChildren().addAll(playerBNameLabel, progressB);

        playerB.getChildren().addAll(scoreBLabel, playerBInfo);

        section.getChildren().addAll(playerA, centerDiv, playerB);
        return section;
    }

    private StackPane createProgressBar(boolean isLeft) {
        StackPane wrapper = new StackPane();
        wrapper.setAlignment(isLeft ? Pos.CENTER_RIGHT : Pos.CENTER_LEFT);
        wrapper.setPrefWidth(160);
        wrapper.setMaxHeight(4);

        Rectangle track = new Rectangle(160, 4);
        track.setFill(Color.web(GameConfig.BG_MEDIUM));
        track.setArcWidth(4); track.setArcHeight(4);

        Rectangle fill = new Rectangle(0, 4);  // Ensure this is a Rectangle
        fill.setArcWidth(4); fill.setArcHeight(4);
        fill.setFill(isLeft ? themeManager.getPlayer1Color() : themeManager.getPlayer2Color());

        if (isLeft) {
            progressFillA = fill;  // Assign the Rectangle to progressFillA
        } else {
            progressFillB = fill;  // Assign the Rectangle to progressFillB
        }

        wrapper.getChildren().addAll(track, fill);
        StackPane.setAlignment(fill, isLeft ? Pos.CENTER_RIGHT : Pos.CENTER_LEFT);

        return wrapper;
    }


    // ======================== GAME FIELD ========================
    private StackPane buildGameField() {
        StackPane wrapper = new StackPane();
        wrapper.setAlignment(Pos.CENTER);
        wrapper.setPadding(new Insets(8, 28, 16, 28));

        double totalW = GameConfig.FIELD_WIDTH + 2 * GameConfig.BOARD_MARGIN;
        double totalH = GameConfig.FIELD_HEIGHT + 2 * GameConfig.BOARD_MARGIN;

        // Field background
        Rectangle fieldBg = new Rectangle(totalW, totalH);
        fieldBg.setArcWidth(GameConfig.RADIUS_FIELD * 2);
        fieldBg.setArcHeight(GameConfig.RADIUS_FIELD * 2);
        fieldBg.setFill(Color.web(themeManager.getFieldBg()));
        fieldBg.setStroke(Color.web(themeManager.getBorderColor()));
        fieldBg.setStrokeWidth(1.5);

        DropShadow fieldShadow = new DropShadow();
        fieldShadow.setColor(Color.color(0, 0, 0, 0.5));
        fieldShadow.setRadius(40);
        fieldShadow.setOffsetY(12);
        fieldBg.setEffect(fieldShadow);

        // Canvas for all game rendering
        gameCanvas = new Canvas(totalW, totalH);
        gameCanvas.setClip(createRoundedClip(totalW, totalH, GameConfig.RADIUS_FIELD));

        wrapper.getChildren().addAll(fieldBg, gameCanvas);
        return wrapper;
    }

    private Rectangle createRoundedClip(double w, double h, double radius) {
        Rectangle clip = new Rectangle(w, h);
        clip.setArcWidth(radius * 2);
        clip.setArcHeight(radius * 2);
        return clip;
    }

    // ======================== BOTTOM BAR ========================
    private HBox buildBottomBar() {
        HBox bar = new HBox();
        bar.setAlignment(Pos.CENTER);
        bar.setPadding(new Insets(10, 28, 14, 28));

        HBox leftInfo = new HBox(24);
        leftInfo.setAlignment(Pos.CENTER_LEFT);
        HBox.setHgrow(leftInfo, Priority.ALWAYS);

        Label p1Controls = new Label("W/S — " + player1Name);
        p1Controls.setFont(Font.font(GameConfig.FONT_FAMILY, FontWeight.MEDIUM, 11));
        p1Controls.setTextFill(Color.web(GameConfig.TEXT_DIM));

        Label p2Controls = new Label("↑/↓ — " + player2Name);
        p2Controls.setFont(Font.font(GameConfig.FONT_FAMILY, FontWeight.MEDIUM, 11));
        p2Controls.setTextFill(Color.web(GameConfig.TEXT_DIM));

        leftInfo.getChildren().addAll(p1Controls, p2Controls);

        HBox rightInfo = new HBox(8);
        rightInfo.setAlignment(Pos.CENTER_RIGHT);

        Circle statusDot = new Circle(3);
        statusDot.setFill(Color.web(GameConfig.ACCENT_GREEN));

        Timeline dotBlink = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(statusDot.opacityProperty(), 1)),
                new KeyFrame(Duration.millis(1000), new KeyValue(statusDot.opacityProperty(), 0.3)),
                new KeyFrame(Duration.millis(2000), new KeyValue(statusDot.opacityProperty(), 1))
        );
        dotBlink.setCycleCount(Animation.INDEFINITE);
        dotBlink.play();

        Label liveLabel = new Label("LIVE");
        liveLabel.setFont(Font.font(GameConfig.FONT_FAMILY, FontWeight.BOLD, 11));
        liveLabel.setTextFill(Color.web(GameConfig.ACCENT_GREEN));

        rightInfo.getChildren().addAll(statusDot, liveLabel);

        bar.getChildren().addAll(leftInfo, rightInfo);
        return bar;
    }

    // ======================== OVERLAYS ========================
    private VBox buildWinnerOverlay() {
        VBox overlay = new VBox(16);
        overlay.setAlignment(Pos.CENTER);
        overlay.setVisible(false);
        overlay.setStyle("-fx-background-color: rgba(2,6,23,0.88);");

        winnerLabel = new Label();
        winnerLabel.setFont(Font.font(GameConfig.FONT_FAMILY, FontWeight.BLACK, GameConfig.FONT_WINNER));

        winnerSubLabel = new Label("WINS THE MATCH!");
        winnerSubLabel.setFont(Font.font(GameConfig.FONT_FAMILY, FontWeight.BOLD, 18));
        winnerSubLabel.setTextFill(Color.web(GameConfig.TEXT_MUTED));

        // Buttons
        HBox buttonRow = new HBox(16);
        buttonRow.setAlignment(Pos.CENTER);
        buttonRow.setPadding(new Insets(16, 0, 0, 0));

        StackPane playAgainBtn = createOverlayButton("PLAY AGAIN", GameConfig.PLAYER_1_PRIMARY, true);
        StackPane menuBtn = createOverlayButton("MAIN MENU", GameConfig.SURFACE, false);

        playAgainBtn.setOnMouseClicked(e -> restartGame());
        menuBtn.setOnMouseClicked(e -> {
            if (gameLoop != null) gameLoop.stop();
            primaryStage.setScene(createStartScene());
        });

        buttonRow.getChildren().addAll(playAgainBtn, menuBtn);

        Label scoreInfo = new Label();
        scoreInfo.setFont(Font.font(GameConfig.FONT_FAMILY, FontWeight.BOLD, 14));
        scoreInfo.setTextFill(Color.web(GameConfig.TEXT_DIM));
        scoreInfo.setId("winScoreInfo");

        overlay.getChildren().addAll(winnerLabel, winnerSubLabel, scoreInfo, buttonRow);
        return overlay;
    }

    private StackPane createOverlayButton(String text, String bgColor, boolean isPrimary) {
        StackPane btn = new StackPane();
        btn.setCursor(javafx.scene.Cursor.HAND);
        btn.setPadding(new Insets(12, 32, 12, 32));

        Label label = new Label(text);
        label.setFont(Font.font(GameConfig.FONT_FAMILY, FontWeight.BOLD, 14));
        label.setTextFill(Color.web(GameConfig.TEXT_WHITE));

        btn.setStyle(
                "-fx-background-color: " + bgColor + ";" +
                        "-fx-background-radius: " + GameConfig.RADIUS_SM + ";"
        );

        if (isPrimary) {
            DropShadow shadow = new DropShadow();
            shadow.setColor(Color.web(bgColor, 0.4));
            shadow.setRadius(16);
            shadow.setOffsetY(4);
            btn.setEffect(shadow);
        }

        btn.setOnMouseEntered(e -> btn.setOpacity(0.85));
        btn.setOnMouseExited(e -> btn.setOpacity(1));

        btn.getChildren().add(label);
        return btn;
    }

    private StackPane buildCountdownOverlay() {
        StackPane overlay = new StackPane();
        overlay.setAlignment(Pos.CENTER);
        overlay.setStyle("-fx-background-color: rgba(2,6,23,0.75);");

        countdownLabel = new Label("3");
        countdownLabel.setFont(Font.font(GameConfig.FONT_FAMILY, FontWeight.BLACK, GameConfig.FONT_COUNTDOWN));
        countdownLabel.setTextFill(Color.web(GameConfig.TEXT_PRIMARY));

        DropShadow glow = new DropShadow();
        glow.setColor(Color.web(GameConfig.PLAYER_1_PRIMARY, 0.5));
        glow.setRadius(40);
        countdownLabel.setEffect(glow);

        overlay.getChildren().add(countdownLabel);
        return overlay;
    }

    private VBox buildPauseOverlay() {
        VBox overlay = new VBox(12);
        overlay.setAlignment(Pos.CENTER);
        overlay.setVisible(false);
        overlay.setStyle("-fx-background-color: rgba(2,6,23,0.85);");

        Label pauseIcon = new Label("⏸");
        pauseIcon.setFont(Font.font(40));

        Label pauseLabel = new Label("PAUSED");
        pauseLabel.setFont(Font.font(GameConfig.FONT_FAMILY, FontWeight.BLACK, 36));
        pauseLabel.setTextFill(Color.web(GameConfig.TEXT_PRIMARY));

        Label resumeHint = new Label("Press ESC to resume");
        resumeHint.setFont(Font.font(GameConfig.FONT_FAMILY, FontWeight.MEDIUM, 14));
        resumeHint.setTextFill(Color.web(GameConfig.TEXT_DIM));

        overlay.getChildren().addAll(pauseIcon, pauseLabel, resumeHint);
        return overlay;
    }

    // ======================== COUNTDOWN ========================
    private void startCountdown(Runnable onComplete) {
        countdownOverlay.setVisible(true);

        Timeline countdown = new Timeline();
        for (int i = GameConfig.COUNTDOWN_SECONDS; i >= 1; i--) {
            final int num = i;
            countdown.getKeyFrames().add(new KeyFrame(
                    Duration.seconds(GameConfig.COUNTDOWN_SECONDS - i),
                    e -> {
                        countdownLabel.setText(String.valueOf(num));
                        // Pulse animation
                        ScaleTransition st = new ScaleTransition(Duration.millis(300), countdownLabel);
                        st.setFromX(1.3); st.setFromY(1.3);
                        st.setToX(1.0); st.setToY(1.0);
                        st.play();
                    }
            ));
        }

        // "GO!" frame
        countdown.getKeyFrames().add(new KeyFrame(
                Duration.seconds(GameConfig.COUNTDOWN_SECONDS),
                e -> {
                    countdownLabel.setText("GO!");
                    countdownLabel.setTextFill(Color.web(GameConfig.ACCENT_GREEN));
                    ScaleTransition st = new ScaleTransition(Duration.millis(200), countdownLabel);
                    st.setFromX(1.5); st.setFromY(1.5);
                    st.setToX(1.0); st.setToY(1.0);
                    st.play();
                }
        ));

        // Hide overlay
        countdown.getKeyFrames().add(new KeyFrame(
                Duration.seconds(GameConfig.COUNTDOWN_SECONDS + 0.6),
                e -> {
                    countdownOverlay.setVisible(false);
                    countdownLabel.setTextFill(Color.web(GameConfig.TEXT_PRIMARY));
                    onComplete.run();
                }
        ));

        countdown.play();
    }

    // ======================== GAME SETUP ========================
    private void setupGame(Scene scene, VBox pauseOverlay) {
        ball = new Ball();
        paddle1 = new Paddle(true);
        paddle2 = new Paddle(false);
        gameOver = false;
        gamePaused = false;
        gameStarted = false;
        lastFrameTime = 0;

        if (gameLoop != null) gameLoop.stop();

        scene.setOnKeyPressed(e -> {
            KeyCode code = e.getCode();

            // Paddle controls
            if (code == KeyCode.W)    { wPressed = true; paddle1.switchDirection(-1); }
            if (code == KeyCode.S)    { sPressed = true; paddle1.switchDirection(1); }
            if (code == KeyCode.UP)   { upPressed = true; paddle2.switchDirection(-1); }
            if (code == KeyCode.DOWN) { downPressed = true; paddle2.switchDirection(1); }

            // Pause
            if (code == KeyCode.ESCAPE && gameStarted && !gameOver) {
                gamePaused = !gamePaused;
                pauseOverlay.setVisible(gamePaused);
            }

            // Restart
            if (code == KeyCode.R && (gameOver || gameStarted)) {
                restartGame();
            }

            // Back to menu
            if (code == KeyCode.M && gameOver) {
                if (gameLoop != null) gameLoop.stop();
                primaryStage.setScene(createStartScene());
            }
        });

        scene.setOnKeyReleased(e -> {
            KeyCode code = e.getCode();
            if (code == KeyCode.W)    wPressed = false;
            if (code == KeyCode.S)    sPressed = false;
            if (code == KeyCode.UP)   upPressed = false;
            if (code == KeyCode.DOWN) downPressed = false;

            if (!wPressed && !sPressed)     paddle1.stop();
            if (!upPressed && !downPressed) paddle2.stop();
        });

        gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (lastFrameTime == 0) { lastFrameTime = now; return; }
                double deltaTime = (now - lastFrameTime) / 1_000_000_000.0;
                deltaTime = Math.min(deltaTime, 0.05); // Cap delta
                lastFrameTime = now;

                if (!gamePaused && !gameOver) {
                    updateGame(deltaTime);
                }
                renderGame();
            }
        };
    }

    // ======================== GAME LOOP ========================
    private void updateGame(double dt) {
        ball.update(paddle1, paddle2);
        paddle1.update(ball);
        paddle2.update(ball);

        // Particles
        if (particlesEnabled) {
            particles.update(dt);

            // Paddle hit particles
            if (ball.isJustHitPaddle()) {
                Color hitColor = ball.getVelX() > 0 ? themeManager.getPlayer1Color() : themeManager.getPlayer2Color();
                double dirX = ball.getVelX() > 0 ? 1 : -1;
                particles.emitDirectional(
                        ball.getCenterX(), ball.getCenterY(),
                        hitColor, GameConfig.PARTICLE_COUNT, dirX, 0
                );
            }

            // Score particles
            if (ball.isJustScored()) {
                Color scoreColor = ball.getScoreSide() == 1 ? themeManager.getPlayer1Color() : themeManager.getPlayer2Color();
                particles.emitScore(
                        GameConfig.FIELD_WIDTH / 2.0,
                        GameConfig.FIELD_HEIGHT / 2.0,
                        scoreColor
                );
            }
        }

        // Screen shake
        if (shakeEnabled) {
            screenShake.update(dt);

            if (ball.isJustHitPaddle()) {
                screenShake.trigger(GameConfig.SHAKE_INTENSITY * 0.5, GameConfig.SHAKE_DURATION * 0.5);
            }
            if (ball.isJustScored()) {
                screenShake.trigger(GameConfig.SHAKE_INTENSITY, GameConfig.SHAKE_DURATION);
            }
        }

        // Win check
        if (paddle1.getScore() >= winScore) {
            showWinner(player1Name, themeManager.getPlayer1Color(), themeManager.getPlayer1Hex());
        } else if (paddle2.getScore() >= winScore) {
            showWinner(player2Name, themeManager.getPlayer2Color(), themeManager.getPlayer2Hex());
        }
    }

    private void renderGame() {
        GraphicsContext gc = gameCanvas.getGraphicsContext2D();
        double w = gameCanvas.getWidth();
        double h = gameCanvas.getHeight();
        double m = GameConfig.BOARD_MARGIN;

        // Clear
        gc.clearRect(0, 0, w, h);

        // Field background
        gc.setFill(Color.web(themeManager.getFieldBg()));
        gc.fillRect(0, 0, w, h);

        // Apply screen shake offset
        double shakeX = shakeEnabled ? screenShake.getOffsetX() : 0;
        double shakeY = shakeEnabled ? screenShake.getOffsetY() : 0;
        gc.save();
        gc.translate(shakeX, shakeY);

        // Center line (dashed)
        gc.setStroke(Color.web(themeManager.getMidlineColor()));
        gc.setLineWidth(2);
        gc.setLineDashes(8, 14);
        double midX = m + GameConfig.FIELD_WIDTH / 2.0;
        gc.strokeLine(midX, m, midX, m + GameConfig.FIELD_HEIGHT);
        gc.setLineDashes(null);

        // Center circle
        gc.setStroke(Color.web(themeManager.getMidlineColor()));
        gc.setLineWidth(1.5);
        gc.strokeOval(midX - 50, m + GameConfig.FIELD_HEIGHT / 2.0 - 50, 100, 100);

        // Goal lines (subtle)
        gc.setStroke(Color.web(themeManager.getPlayer1Hex(), 0.15));
        gc.setLineWidth(3);
        gc.strokeLine(m, m, m, m + GameConfig.FIELD_HEIGHT);

        gc.setStroke(Color.web(themeManager.getPlayer2Hex(), 0.15));
        gc.strokeLine(m + GameConfig.FIELD_WIDTH, m, m + GameConfig.FIELD_WIDTH, m + GameConfig.FIELD_HEIGHT);

        // Ball trail
        if (trailEnabled) {
            trailEffect.render(gc, ball, m, m, themeManager.getTrailColor());
        }

        // Particles
        if (particlesEnabled) {
            particles.render(gc, m, m);
        }

        // Ball
        double ballScreenX = m + ball.getX();
        double ballScreenY = m + ball.getY();

        // Ball glow
        gc.setFill(Color.web(GameConfig.TEXT_PRIMARY, 0.1));
        double glowSize = Ball.SIZE * 2.5;
        gc.fillOval(
                ballScreenX + Ball.SIZE / 2.0 - glowSize / 2.0,
                ballScreenY + Ball.SIZE / 2.0 - glowSize / 2.0,
                glowSize, glowSize
        );

        // Ball body
        gc.setFill(themeManager.getBallColor());
        gc.fillOval(ballScreenX, ballScreenY, Ball.SIZE, Ball.SIZE);

        // Ball highlight (top-left)
        gc.setFill(Color.web(GameConfig.TEXT_WHITE, 0.4));
        gc.fillOval(ballScreenX + 3, ballScreenY + 3, Ball.SIZE * 0.35, Ball.SIZE * 0.35);

        // Paddles
        renderPaddle(gc, paddle1, m, themeManager.getPlayer1Color(), themeManager.getPlayer1Hex());
        renderPaddle(gc, paddle2, m, themeManager.getPlayer2Color(), themeManager.getPlayer2Hex());

        gc.restore();

        // ============== UPDATE UI LABELS ==============
        scoreALabel.setText(String.format("%02d", paddle1.getScore()));
        scoreBLabel.setText(String.format("%02d", paddle2.getScore()));

        // Speed label
        double speedMultiplier = ball.getSpeed() / GameConfig.BALL_BASE_SPEED;
        speedLabel.setText(String.format("SPEED: %.1fx", speedMultiplier));

        // Progress bars
        double pctA = (double) paddle1.getScore() / winScore;
        double pctB = (double) paddle2.getScore() / winScore;
        ((Rectangle) progressFillA).setWidth(160 * Math.min(1, pctA));
        ((Rectangle) progressFillB).setWidth(160 * Math.min(1, pctB));
    }

    private void renderPaddle(GraphicsContext gc, Paddle p, double margin, Color color, String hex) {
        double px = margin + p.getX();
        double py = margin + p.getY();
        double pw = Paddle.WIDTH;
        double ph = Paddle.HEIGHT;

        // Paddle glow
        double glowIntensity = p.getGlowIntensity();
        if (glowIntensity > 0) {
            gc.setFill(Color.color(color.getRed(), color.getGreen(), color.getBlue(), glowIntensity * 0.3));
            gc.fillRoundRect(px - 8, py - 8, pw + 16, ph + 16, 20, 20);
        }

        // Ambient glow (always subtle)
        gc.setFill(Color.color(color.getRed(), color.getGreen(), color.getBlue(), 0.08));
        gc.fillRoundRect(px - 4, py - 4, pw + 8, ph + 8, 14, 14);

        // Paddle body
        gc.setFill(color);
        gc.fillRoundRect(px, py, pw, ph, 10, 10);

        // Paddle inner highlight
        gc.setFill(Color.color(1, 1, 1, 0.15));
        gc.fillRoundRect(px + 2, py + 2, pw - 4, ph * 0.3, 8, 8);
    }

    // ======================== WINNER ========================
    private void showWinner(String player, Color color, String hex) {
        gameOver = true;
        gameLoop.stop();

        SoundManager.play("/sound/Win.wav");

        // Massive particle burst
        if (particlesEnabled) {
            for (int i = 0; i < 5; i++) {
                particles.emitScore(
                        GameConfig.FIELD_WIDTH / 2.0 + (Math.random() - 0.5) * 400,
                        GameConfig.FIELD_HEIGHT / 2.0 + (Math.random() - 0.5) * 200,
                        color
                );
            }
        }

        winnerLabel.setText(player);
        winnerLabel.setTextFill(color);

        DropShadow winGlow = new DropShadow();
        winGlow.setColor(Color.color(color.getRed(), color.getGreen(), color.getBlue(), 0.5));
        winGlow.setRadius(30);
        winnerLabel.setEffect(winGlow);

        // Score info
        Label scoreInfo = (Label) winnerOverlay.lookup("#winScoreInfo");
        if (scoreInfo != null) {
            scoreInfo.setText(String.format("%s  %02d — %02d  %s",
                    player1Name, paddle1.getScore(),
                    paddle2.getScore(), player2Name));
        }

        winnerOverlay.setVisible(true);

        // Entry animation
        FadeTransition ft = new FadeTransition(Duration.millis(400), winnerOverlay);
        ft.setFromValue(0); ft.setToValue(1);
        ft.play();

        ScaleTransition st = new ScaleTransition(Duration.millis(500), winnerLabel);
        st.setFromX(0.5); st.setFromY(0.5);
        st.setToX(1); st.setToY(1);
        st.setInterpolator(Interpolator.SPLINE(0.34, 1.56, 0.64, 1));
        st.play();
    }

    // ======================== RESTART ========================
    private void restartGame() {
        if (gameLoop != null) gameLoop.stop();
        particles.clear();
        showGameScene();
    }

    // ======================== MAIN ========================
    public static void main(String[] args) {
        launch(args);
    }
}
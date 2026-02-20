package com.example._9_aigamecode.Game;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.InputStream;

public class SoundManager {

    private static boolean enabled = true;
    private static float volume = 0.7f;

    public static void setEnabled(boolean e) { enabled = e; }
    public static boolean isEnabled() { return enabled; }
    public static void setVolume(float v) { volume = Math.max(0, Math.min(1, v)); }
    public static float getVolume() { return volume; }

    public static void play(String resourcePath) {
        if (!enabled) return;

        new Thread(() -> {
            try {
                InputStream is = SoundManager.class.getResourceAsStream(resourcePath);
                if (is == null) return;

                BufferedInputStream bis = new BufferedInputStream(is);
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(bis);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);

                // Volume
                if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
                    FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                    float dB = (float) (Math.log10(volume) * 20);
                    gainControl.setValue(Math.max(dB, gainControl.getMinimum()));
                }

                clip.start();
                clip.addLineListener(event -> {
                    if (event.getType() == LineEvent.Type.STOP) {
                        clip.close();
                    }
                });
            } catch (Exception ignored) { }
        }).start();
    }
}
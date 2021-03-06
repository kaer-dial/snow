package snow.player.util;

import android.media.audiofx.BassBoost;
import android.media.audiofx.Equalizer;
import android.media.audiofx.PresetReverb;
import android.media.audiofx.Virtualizer;
import android.os.Bundle;

import androidx.annotation.NonNull;

/**
 * 用于获取和修改 Android 音频特效的配置信息。
 */
public final class AndroidAudioEffectConfigUtil {
    public static final String KEY_SETTING_EQUALIZER = "setting_equalizer";
    public static final String KEY_SETTING_BASS_BOOST = "setting_bass_boost";
    public static final String KEY_SETTING_VIRTUALIZER = "setting_virtualizer";
    public static final String KEY_SETTING_PRESET_REVERB = "setting_preset_reverb";

    private AndroidAudioEffectConfigUtil() {
        throw new AssertionError();
    }

    /**
     * 从 config 中应用 Equalizer 的配置。
     *
     * @param config    Bundle 对象，包含音频特效的配置信息，不能为 null
     * @param equalizer 要恢复配置的 Equalizer 对象，不能为 null
     */
    public static void applySettings(@NonNull Bundle config, @NonNull Equalizer equalizer) {
        String settings = config.getString(KEY_SETTING_EQUALIZER);
        if (settings == null || settings.isEmpty()) {
            return;
        }

        try {
            equalizer.setProperties(new Equalizer.Settings(settings));
        } catch (IllegalArgumentException | IllegalStateException | UnsupportedOperationException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从 config 中应用 BassBoost 的配置。
     *
     * @param config    Bundle 对象，包含音频特效的配置信息，不能为 null
     * @param bassBoost 要恢复配置的 BassBoost 对象，不能为 null
     */
    public static void applySettings(@NonNull Bundle config, @NonNull BassBoost bassBoost) {
        String settings = config.getString(KEY_SETTING_BASS_BOOST);
        if (settings == null || settings.isEmpty()) {
            return;
        }

        try {
            bassBoost.setProperties(new BassBoost.Settings(settings));
        } catch (IllegalArgumentException | IllegalStateException | UnsupportedOperationException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从 config 中应用 Virtualizer 的配置。
     *
     * @param config      Bundle 对象，包含音频特效的配置信息，不能为 null
     * @param virtualizer 要恢复配置的 Virtualizer 对象，不能为 null
     */
    public static void applySettings(@NonNull Bundle config, @NonNull Virtualizer virtualizer) {
        String settings = config.getString(KEY_SETTING_VIRTUALIZER);
        if (settings == null || settings.isEmpty()) {
            return;
        }

        try {
            virtualizer.setProperties(new Virtualizer.Settings(settings));
        } catch (IllegalArgumentException | IllegalStateException | UnsupportedOperationException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从 config 中应用 PresetReverb 的配置。
     *
     * @param config       Bundle 对象，包含音频特效的配置信息，不能为 null
     * @param presetReverb 要恢复配置的 PresetReverb 对象，不能为 null
     */
    public static void applySettings(@NonNull Bundle config, @NonNull PresetReverb presetReverb) {
        String settings = config.getString(KEY_SETTING_PRESET_REVERB);
        if (settings == null || settings.isEmpty()) {
            return;
        }

        try {
            presetReverb.setProperties(new PresetReverb.Settings(settings));
        } catch (IllegalArgumentException | IllegalStateException | UnsupportedOperationException e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新音频特效的 Equalizer 配置。
     *
     * @param config   Bundle 对象，包含音频特效的配置信息，不能为 null
     * @param settings 最新的 Equalizer 配置，不能为 null
     */
    public static void updateSettings(@NonNull Bundle config, @NonNull Equalizer.Settings settings) {
        config.putString(KEY_SETTING_EQUALIZER, settings.toString());
    }

    /**
     * 更新音频特效的 BassBoost 配置。
     *
     * @param config   Bundle 对象，包含音频特效的配置信息，不能为 null
     * @param settings 最新的 BassBoost 配置，不能为 null
     */
    public static void updateSettings(@NonNull Bundle config, @NonNull BassBoost.Settings settings) {
        config.putString(KEY_SETTING_BASS_BOOST, settings.toString());
    }

    /**
     * 更新音频特效的 Virtualizer 配置。
     *
     * @param config   Bundle 对象，包含音频特效的配置信息，不能为 null
     * @param settings 最新的 Virtualizer 配置，不能为 null
     */
    public static void updateSettings(@NonNull Bundle config, @NonNull Virtualizer.Settings settings) {
        config.putString(KEY_SETTING_VIRTUALIZER, settings.toString());
    }

    /**
     * 更新音频特效的 PresetReverb 配置。
     *
     * @param config   Bundle 对象，包含音频特效的配置信息，不能为 null
     * @param settings 最新的 PresetReverb 配置，不能为 null
     */
    public static void updateSettings(@NonNull Bundle config, @NonNull PresetReverb.Settings settings) {
        config.putString(KEY_SETTING_PRESET_REVERB, settings.toString());
    }
}

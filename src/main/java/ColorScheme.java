package main.java;

import java.awt.Color;
import java.util.HashMap;

/**
 * Class ColorScheme that handles the colors of the game
 */
public class ColorScheme {

    // Colores para el modo claro
    public static final Color WINBG = new Color(0XFAF8EF);
    public static final Color GRIDBG = new Color(0XBBADA0);
    public static final Color BRIGHT = new Color(0X776E65);
    public static final Color LIGHT = new Color(0XF9F6F2);

    // Colores para el modo oscuro
    public static final Color DARK_WINBG = new Color(0x3B3939);
    public static final Color DARK_GRIDBG = new Color(0x595353);
    public static final Color DARK_BRIGHT = new Color(0x526679);
    public static final Color DARK_LIGHT = new Color(0x706F6F);

    private HashMap<Integer, Color> background = new HashMap<>();

    /**
     * Set the colors of the game
     */
    public ColorScheme() {
        if (Game.isDarkMode) {
            initDarkBackgrounds();
        } else {
            initLightBackgrounds();
        }
    }

    /**
     * Initialize the light colors of the game
     */
    private void initLightBackgrounds() {
        background.put(0, new Color(238, 228, 218, 90));
        background.put(2, new Color(0XEEE4DA));
        background.put(4, new Color(0XEDE0C8));
        background.put(8, new Color(0XF2B179));
        background.put(16, new Color(0XF59563));
        background.put(32, new Color(0XF67C5F));
        background.put(64, new Color(0XF65E3B));
        background.put(128, new Color(0XEDCF72));
        background.put(256, new Color(0XEDCC61));
        background.put(512, new Color(0XEDC850));
        background.put(1024, new Color(0XEDC53F));
        background.put(2048, new Color(0XEDC22E));
        background.put(4096, 	new Color (0XEEE4DA));
		background.put(8192, 	new Color (0XEDE0C8));
		background.put(16384, 	new Color (0XF2B179));
		background.put(32768, 	new Color (0XF59563));
		background.put(65536, 	new Color (0XF67C5F));
		background.put(131072, 	new Color (0XF65E3B));

    }

    /**
     * Initialize the dark colors of the game
     */
    private void initDarkBackgrounds() {
        background.put(0, new Color(30, 30, 30, 90));
        background.put(2, new Color(0xC9EEFD)); // Light Sky Blue
        background.put(4, new Color(0x99F1F1)); // Light Blue
        background.put(8, new Color(0x96F3F3)); // Powder Blue
        background.put(16, new Color(0xA3BCEC)); // Alice Blue
        background.put(32, new Color(0x9CC2EE)); // Light Blue
        background.put(64, new Color(0x99C4EE)); // Light Steel Blue
        background.put(128, new Color(0x82C6DC)); // Azure
        background.put(256, new Color(0x88B4D9)); // Alice Blue
        background.put(512, new Color(0x7DD8E3)); // Light Cyan
        background.put(1024, new Color(0x65B9DE)); // Light Cyan
        background.put(2048, new Color(0x4DB3F3)); // Alice Blue
        background.put(4096, new Color (0xC9EEFD));
        background.put(8192, new Color (0x99F1F1));
        background.put(16384, new Color (0x96F3F3));
        background.put(32768, new Color (0xA3BCEC));
        background.put(65536, new Color (0x9CC2EE));
        background.put(131072, new Color (0x7DD8E3));
    }

    /**
     * Returns the background color of the tile
     * @param value value of the tile
     * @return background color of the tile
     */
    public Color getTileBackground(int value) {
        updateColors();
        return background.get(value);
    }

    /**
     * Returns the color of the tile
     * @param value value of the tile
     * @return color of the tile
     */
    public Color getTileColor(int value) {
        if (Game.isDarkMode) {
            return (value <= 8) ? DARK_BRIGHT : DARK_LIGHT;
        } else {
            return (value <= 8) ? BRIGHT : LIGHT;
        }
    }

    /**
     * Returns the color of the text
     * @param value value of the tile
     * @return color of the text
     */
    public void updateColors() {
        if (Game.isDarkMode) {
            initDarkBackgrounds();
        } else {
            initLightBackgrounds();
        }
    }


}

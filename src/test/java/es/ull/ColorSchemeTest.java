package es.ull;

import org.junit.jupiter.api.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColorSchemeTest {

    @Test
    void testGetTileBackgroundLightMode() {
        // Configurar el modo claro
        ColorScheme colorScheme = new ColorScheme();
        Game.isDarkMode = false;

        // Probar el método getTileBackground para un valor específico
        Color backgroundColor = colorScheme.getTileBackground(2);

        // Verificar que el color devuelto sea el esperado para el modo claro
        assertEquals(new Color(0XEEE4DA), backgroundColor);
    }

    @Test
    void testGetTileBackgroundDarkMode() {
        ColorScheme colorScheme = new ColorScheme();

        // Configurar el modo oscuro
        Game.isDarkMode = true;

        // Probar el método getTileBackground para un valor específico
        Color backgroundColor = colorScheme.getTileBackground(2);

        // Verificar que el color devuelto sea el esperado para el modo oscuro
        assertEquals(new Color(0xC9EEFD), backgroundColor);
    }

    // Puedes agregar más pruebas para otros métodos y casos según sea necesario
}

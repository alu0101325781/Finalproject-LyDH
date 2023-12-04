package es.ull;

import org.junit.jupiter.api.Test;
import java.awt.Color;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.awt.GraphicsEnvironment;

public class ColorSchemeTest {

    @Test
    void testGetTileBackgroundLightMode() {
        // Configurar el modo claro
        ColorScheme colorScheme = new ColorScheme();
        Game.isDarkMode = false;

        // Verificar si el entorno es sin cabeza antes de realizar operaciones de AWT
        if (!GraphicsEnvironment.isHeadless()) {
            // Probar el método getTileBackground para un valor específico
            Color backgroundColor = colorScheme.getTileBackground(2);

            // Verificar que el color devuelto sea el esperado para el modo claro
            assertEquals(new Color(0XEEE4DA), backgroundColor);
        } else {
            System.out.println("Skipping AWT-related test in headless environment.");
        }
    }

    @Test
    void testGetTileBackgroundDarkMode() {
        // Configurar el modo oscuro
        ColorScheme colorScheme = new ColorScheme();
        Game.isDarkMode = true;

        // Verificar si el entorno es sin cabeza antes de realizar operaciones de AWT
        if (!GraphicsEnvironment.isHeadless()) {
            // Probar el método getTileBackground para un valor específico
            Color backgroundColor = colorScheme.getTileBackground(2);

            // Verificar que el color devuelto sea el esperado para el modo oscuro
            assertEquals(new Color(0xC9EEFD), backgroundColor);
        } else {
            System.out.println("Skipping AWT-related test in headless environment.");
        }
    }

    // Puedes agregar más pruebas para otros métodos y casos según sea necesario
}

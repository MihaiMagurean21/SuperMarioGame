import java.awt.Image;
import java.io.InputStream;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public final class ResourceLoader {
    public static ImageIcon load(String path) {
        try {
            InputStream input = ResourceLoader.class.getResourceAsStream(path);
            if (input == null) {
                input = ResourceLoader.class.getResourceAsStream("/" + path);
            }
            if (input != null) {
            	Image image = Toolkit.getDefaultToolkit().createImage(org.apache.commons.io.IOUtils.toByteArray(input));                return new ImageIcon(image);
            } else {
                System.err.println("Image not found: " + path);
                return null;
            }
        } catch (Exception e) {
            System.err.println("Error loading image: " + path);
            e.printStackTrace();
            return null;
        }
    }
}
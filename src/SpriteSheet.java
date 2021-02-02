import java.awt.image.BufferedImage;

public class SpriteSheet {
    private final BufferedImage image;

    public SpriteSheet(BufferedImage image) {
        this.image = image;
    }

    public BufferedImage grabImage(int col, int row, int width, int height) {
        return image.getSubimage(
                (col * Constants.SPRITE_SHEET_SIZE) - Constants.SPRITE_SHEET_SIZE,
                (row * Constants.SPRITE_SHEET_SIZE) - Constants.SPRITE_SHEET_SIZE,
                width,
                height
        );
    }
}

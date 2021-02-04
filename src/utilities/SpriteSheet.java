package utilities;

import framework.Constants;

import java.awt.image.BufferedImage;

public class SpriteSheet {
    private final BufferedImage image;

    public SpriteSheet(BufferedImage image) {
        this.image = image;
    }

    public BufferedImage grabImage(int col, int row, int width, int height) {
        return image.getSubimage(
                (col * Constants.BLOCK_SIZE) - Constants.BLOCK_SIZE,
                (row * Constants.BLOCK_SIZE) - Constants.BLOCK_SIZE,
                width,
                height
        );
    }
}

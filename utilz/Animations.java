package utilz;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Animations {
    private BufferedImage[][] animation;

    public Animations(){

    }

    public void importImg() {
        InputStream is = getClass().getResourceAsStream("/player/Colour1/Outline/120x80_PNGSheets/_Attack.png");
        try {
            animation[0][0] = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        is = getClass().getResourceAsStream("/player/Colour1/Outline/120x80_PNGSheets/_Death.png");
        try {
            animation[0][1] = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        is = getClass().getResourceAsStream("/player/Colour1/Outline/120x80_PNGSheets/_Hit.png");
        try {
            animation[0][2] = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        is = getClass().getResourceAsStream("/player/Colour1/Outline/120x80_PNGSheets/_Idle.png");
        try {
            animation[0][3] = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        is = getClass().getResourceAsStream("/player/Colour1/Outline/120x80_PNGSheets/_Jump.png");
        try {
            animation[0][4] = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        is = getClass().getResourceAsStream("/player/Colour1/Outline/120x80_PNGSheets/_Roll.png");
        try {
            animation[0][5] = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        is = getClass().getResourceAsStream("/player/Colour1/Outline/120x80_PNGSheets/_RunLeft.png");
        try {
            animation[0][6] = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        is = getClass().getResourceAsStream("/player/Colour1/Outline/120x80_PNGSheets/_RunRight.png");
        try {
            animation[0][7] = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package utilz;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class AnimazioniPlayer {


    public BufferedImage[] attackSpirte;
    public BufferedImage[] runRightSpirte;
    public BufferedImage[] runLeftSpirte;
    public BufferedImage[] rollSpirte;
    public BufferedImage[] idleSpirte;
    public BufferedImage[] hitSpirte;
    public BufferedImage[] deathSpirte;
    public BufferedImage[] fallSpirte;
    public BufferedImage[] attackLeftSpirte;

    private BufferedImage frame;
    private int aniTick;
    private int aniSpeed = 10;
    private int aniIndex;

    public int getAniTick() {
        return aniTick;
    }

    public int getAniSpeed() {
        return aniSpeed;
    }

    public int getAniIndex() {
        return aniIndex;
    }

    public void caricaAnimazioni() {
        idleSpirte = estraiSprite("/player/_Idle.png", 10);
        fallSpirte = estraiSprite("/player/_Fall.png", 3);
        runRightSpirte = estraiSprite("/player/_RunRight.png", 10);
        runLeftSpirte = estraiSprite("/player/_RunLeft.png", 10);
        attackSpirte = estraiSprite("/player/_Attack.png", 4);
        attackLeftSpirte = estraiSprite("/player/_AttackLeft.png", 4);
        hitSpirte = estraiSprite("/player/_Hit.png", 1);
        rollSpirte = estraiSprite("/player/_Roll.png", 12);
        deathSpirte = estraiSprite("/player/_Death.png", 10);
    }

    private BufferedImage[] estraiSprite(String path, int count) {
        BufferedImage[] frames = new BufferedImage[count];
        try (InputStream is = getClass().getResourceAsStream(path)) {
            BufferedImage sheet = ImageIO.read(is);
            int frameWidth = sheet.getWidth() / count;
            int frameHeight = sheet.getHeight();

            for (int i = 0; i < count; i++) {
                frames[i] = sheet.getSubimage(i * frameWidth, 0, frameWidth, frameHeight);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return frames;
    }

    public int updateAnimazione(int playerStatus) {
        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= getFrameCount(playerStatus)) {
                aniIndex = 0;
            }
        }
        return aniIndex;
    }

    public boolean isAnimationCompleted(int status) {
        int frameCount = getFrameCount(status);
        return aniIndex >= frameCount - 1; // -1 perché partiamo da 0
    }

    public void resetAniIndex() {
        aniIndex = 0;
        aniTick = 0;
    }

    private int getFrameCount(int status) {
        switch (status) {
            case 0: return idleSpirte.length;
            case 1: return fallSpirte.length;
            case 2: return runRightSpirte.length;
            case 3: return runLeftSpirte.length;
            case 4: return attackSpirte.length;
            case 5: return attackLeftSpirte.length;
            case 6: return hitSpirte.length;
            case 7: return rollSpirte.length;
            case 8: return deathSpirte.length;
            default: return 1;
        }
    }

    public void debugAnimation(int status) {
        System.out.println("Animazione: " + status
                + " | Frame: " + aniIndex
                + " | Totale frame: " + getFrameCount(status));
    }
}

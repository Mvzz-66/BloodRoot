package utilz;

import entity.Skeleton;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class AnimazioniSkeletri {


    public BufferedImage[] attackSpirte;
    public BufferedImage[] walkRightSpirte;
    public BufferedImage[] walkLeftSpirte;
    public BufferedImage[] idleSpirte;
    public BufferedImage[] hitSpirte;
    public BufferedImage[] deathSpirte;

    private BufferedImage frame;
    private int aniTick;
    private int aniSpeed = 10;
    private int aniIndex;

    public void caricaAnimazioni() {
        idleSpirte = estraiSprite("/player/Skeleton Idle.png", 12);
        walkRightSpirte = estraiSprite("/player/Skeleton WalkRight.png", 13);
        walkLeftSpirte = estraiSprite("/player/Skeleton WalkLeft.png", 13);
        attackSpirte = estraiSprite("/player/Skeleton Attack.png", 20);
        hitSpirte = estraiSprite("/player/Skeleton Hit.png", 8);
        deathSpirte = estraiSprite("/player/Skeleton Dead.png", 15);
    }

    private BufferedImage[] estraiSprite(String path, int count) {
        BufferedImage[] frames = new BufferedImage[count];
        try (InputStream is = getClass().getResourceAsStream(path)) {
            BufferedImage sheet = ImageIO.read(is);
            for (int i = 0; i < count; i++) {
                frames[i] = sheet.getSubimage(i * 120, 0, 120, 80);
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

    private int getFrameCount(int status) {
        switch (status) {
            case 0: return idleSpirte.length;
            case 1: return walkRightSpirte.length;
            case 2: return walkLeftSpirte.length;
            case 3: return attackSpirte.length;
            case 4: return hitSpirte.length;
            case 5: return deathSpirte.length;
            default: return 1;
        }
    }
}


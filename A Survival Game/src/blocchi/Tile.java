package blocchi;

import java.awt.image.BufferedImage;

/**
 *
 * @author Denis
 */
public class Tile {
    private BufferedImage sprite;
    private int id, tiletype;
    

    public Tile(BufferedImage sprite, int id, int tiletype) {
        this.sprite = sprite;
        this.id = id;
        this.tiletype=tiletype;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public int getId() {
        return id;
    }
    public int getTileType(){
        return tiletype;
    }

}

/**
 * @author Pugliano Denis, Occhiato Andrea
 * @version 1.0
 * @file Tile.java
 * @brief Classe per gestire dati della mappa
 */

package blocchi;

import java.awt.image.BufferedImage;

/**
 * @class Tile
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

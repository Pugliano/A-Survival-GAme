package blocchi;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Denis
 */
public class TileManager {
    public Tile ERBA, ACQUA; //erba=0 , acqua=1,
    public BufferedImage atlas;
    public ArrayList<Tile> tiles = new ArrayList<>();

    public TileManager() {
        loadAtlas();
        createTiles();
    }

    private void createTiles() {
        int id = 0;
        for (int i = 0; i < 45; i++) {
            for (int j = 0; j < 19; j++) {
                if(i==1 && j==13)
                    tiles.add(ERBA = new Tile(getSprite(j, i), id++, 1));
                else
                    tiles.add(ERBA = new Tile(getSprite(j, i), id++, 0));
            }
        }
    }

    private void loadAtlas() {
        try {
            atlas = ImageIO.read(getClass().getResourceAsStream("/immagini/blocchi/atlas.png"));
        } catch (IOException ex) {
            Logger.getLogger(TileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Tile getTile(int id) {
        return tiles.get(id);
    }

    public BufferedImage getSprite(int id) {
        return tiles.get(id).getSprite();
    }

    private BufferedImage getSprite(int x, int y) {
        return atlas.getSubimage(x*16, y*16, 16, 16);
    }
}

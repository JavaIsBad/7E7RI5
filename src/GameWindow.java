import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;

public class GameWindow extends JPanel {

    final int taillex=240, tailley=480;
    final int taillecarrex=taillex/10, taillecarrey=tailley/20;

    private Matrice matrice;
    private BufferedImage img;

    public void paint(Graphics g)
    { int x,y;
        int posx=0, posy=0;
        super.paint(g);
        g.drawImage(img,0,0,taillex,tailley,0,0,311,625,Color.black,null);
        for (y=0;y<20;y++) {
            posx=0;
            for (x=0;x<10;x++) {
                if (matrice.isSomething(x,y)) {
                    g.setColor(CouleurTetris.getCouleur(matrice.get(x,y)));
                g.fillRect(posx, posy, taillecarrex, taillecarrey);
                }
                posx+=taillecarrex;
            }
            posy+=taillecarrey;
        }
    }

    public void refresh()
    {
        matrice.refresh();
        repaint(getVisibleRect());
    }

    public GameWindow(Matrice m)
    {
        super();
        setPreferredSize(new Dimension(taillex, tailley));
        matrice = m;
        try{
            img = ImageIO.read(new File("../photo.jpg"));
        }catch (IOException ex){
        }
    }

}

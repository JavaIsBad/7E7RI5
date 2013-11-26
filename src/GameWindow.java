import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GameWindow extends JPanel {

    final int taillex=320, tailley=640;
    final int taillecarrex=taillex/10, taillecarrey=tailley/20;
    final int bords=taillecarrex;
    BufferedImage background=null, piece=null;
    private Matrice matrice;
    private BufferedImage img;

    public void paint(Graphics g)
    { int x,y;
        int posx, posy=bords;
        g.drawImage(background, bords, bords, bords+taillex, bords+tailley, 0, 0, background.getWidth(), background.getHeight(), null);
        g.setColor(Color.WHITE);
        for(int i=bords+taillecarrex; i<bords+taillex; i+=taillecarrex)
            g.drawLine(i, bords, i, bords+tailley);
        g.setColor(Color.BLACK);
        g.drawLine(bords-1, bords-1, bords+taillex+1, bords-1);
        g.drawLine(bords-1, bords-1, bords-1, bords+tailley+1);
        g.drawLine(bords+taillex, bords-1, bords+taillex, bords+tailley);
        g.drawLine(bords-1, bords+tailley, bords+taillex, bords+tailley);
        for (y=0;y<matrice.sizeY;y++) {
            posx=bords;
            for (x=0;x<matrice.sizeX;x++) {
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
        setPreferredSize(new Dimension(taillex+2*bords, tailley+2*bords));
        setBackground(Color.WHITE);
        matrice = m;
        try{
        background=ImageIO.read(new File("../pictures/background.jpg"));
        }
        catch (IOException e){
            System.out.println("Woulé l'image n'existe pas");
            System.exit(4012);
        }
    }

}

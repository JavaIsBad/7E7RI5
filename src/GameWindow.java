import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Dimension;

public class GameWindow extends JPanel {

final int taillex=320, tailley=640;
final int taillecarrex=taillex/10, taillecarrey=tailley/20;

    private Matrice matrice;

    public void paint(Graphics g)
    { int x,y;
	int posx=0, posy=0;
        super.paint(g);
        for (y=0;y<20;y++) {
		posx=0;
            for (x=0;x<10;x++) {
                if (matrice.isSomething(x,y)) {
                    g.setColor(CouleurTetris.getCouleur(matrice.get(x,y)));
                } else {
                    g.setColor(Color.black);
                }
                g.fillRect(posx, posy, taillecarrex, taillecarrey);
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
    }
}

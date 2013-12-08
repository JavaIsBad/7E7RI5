import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * La fenêtre de jeu
 * @author Maxime Schmitt et son fidèle assistant Raphaël Schimchowitsch
 */

public class GameWindow extends JPanel {
	/// Vrai si gameover
	private boolean gameover=false;
	/// Le score à afficher
	private int score=0;
	/// La taille du texte
	final int textArea=160;
	/// La taille de la fenetre de jeu en x et y
    final int taillex=320, tailley=500;
    /// La position du texte en y
    final int textYpos=tailley/2;
    /// La taille des cubes de tetris
    final int taillecarrex=taillex/10, taillecarrey=tailley/20;
    /// Les bords pour faire cool
    final int bords=taillecarrex;
    /// Une image de fond pour faire beau
    BufferedImage background=null, piece=null;
    /// Une matrice à afficher
    private Matrice matrice;
    /// Une image qui ne sert à rien
    private BufferedImage img;

	/**
	 * Peind la fenêtre de jeu
	 */
    public void paint(Graphics g)
    { int x,y;
        int posx, posy=bords;
        g.drawImage(background, bords, bords, bords+taillex, bords+tailley, 0, 0, background.getWidth(), background.getHeight(), null);
        g.setColor(Color.BLACK);
        g.fillRect(bords+taillex+textArea/3-10, textYpos-15, textArea, 25);
        g.setColor(Color.WHITE);
        g.drawString("Score : "+score, bords+taillex+textArea/3, textYpos);
        for(int i=bords+taillecarrex; i<bords+taillex; i+=taillecarrex)
            g.drawLine(i, bords, i, bords+tailley);
        g.setColor(Color.BLACK);
        g.drawLine(bords-1, bords-1, bords+taillex+1, bords-1);
        g.drawLine(bords-1, bords-1, bords-1, bords+tailley+1);
        g.drawLine(bords+taillex, bords-1, bords+taillex, bords+tailley);
        g.drawLine(bords-1, bords+tailley, bords+taillex, bords+tailley);
        for (y=0;y<matrice.sizeY;y++){
            posx=bords;
            for (x=0;x<matrice.sizeX;x++){
                if (matrice.isSomething(x,y)) {
                    g.setColor(CouleurTetris.getCouleur(matrice.get(x,y)));
                    g.fillRect(posx, posy, taillecarrex, taillecarrey);
                }
                posx+=taillecarrex;
            }
            posy+=taillecarrey;
        }
        if(gameover){
			  g.setColor(Color.BLACK);
			  g.fillRect(taillex/2+bords-30, tailley/2-30+bords, 160, 80);
			  g.setColor(Color.RED);
			  g.drawString("GAME OVER", taillex/2+bords+15, tailley/2+bords+15);
		}
    }

	/**
	 * Demande de rafraichire la fenêtre de jeu
	 * @param score Le score qu'on veut afficher
	 */
	
    public void refresh(int score)
    {
		this.score=score;
        repaint(getVisibleRect());
    }
    
    /**
     * Quand gameOver
     */

	public void gameOver(){
		gameover=true;
		repaint(getVisibleRect());
	}
	
	/**
	 * Constructeur de Gamewindow
	 * @param m La matrice qu'on veut afficher
	 */
	
    public GameWindow(Matrice m)
    {
        super();
        setPreferredSize(new Dimension(taillex+2*bords+textArea, tailley+2*bords));
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

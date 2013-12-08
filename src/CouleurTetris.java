import java.awt.Color;

public class CouleurTetris {
	/// Les couleurs utilisées dans le tetris
	private static Color tabcolor[]={
	new Color(255,255,255),
	new Color(255,255,0),
	new Color(255,0,255),
	new Color(255,0,0),
	new Color(0,255,255),
	new Color(0,255,0),
	new Color(0,0,255)
};
	/**
	 * Retourne la couleur associée à l'entier
	 * @param couleur La couleur représenté par un entier
	 * @return La couleur Color associé
	 */
	public static Color getCouleur(int couleur){
		Color coul=null;
		if(couleur>0 && couleur<8)
			coul=tabcolor[couleur-1];
		return coul;
	}
}

import java.awt.Color;

public class CouleurTetris {
	private static Color tabcolor[]={
	new Color(255,166,0),
	new Color(255,0,47),
	new Color(255,0,219),
	new Color(0,91,25),
	new Color(0,255,169),
	new Color(75,255,0),
	new Color(237,255,0)
};

	public static Color getCouleur(int couleur){
		Color coul=null;
		if(couleur>0 && couleur<8)
			coul=tabcolor[couleur-1];
		return coul;
	}
}

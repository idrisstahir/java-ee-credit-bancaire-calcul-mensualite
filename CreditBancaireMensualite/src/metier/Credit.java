package metier;

public class Credit {

	public double calculMensualite(double m, int d, double t) {
		double mensualite = 0;
		mensualite = (m * t/(12*100)) / (1 - Math.pow((1 + t/(12*100)), d*-1));
		return mensualite;
	}
	
}

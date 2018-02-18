package metier;

public class TestCredit {

	public static void main(String[] args) {
		
		Credit c = new Credit();
		System.out.println(c.calculMensualite(200_000, 240, 4.5));

	}

}

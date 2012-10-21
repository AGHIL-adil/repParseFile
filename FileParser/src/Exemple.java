import java.io.File;


public class Exemple {
	public static void main(String args[])
	{
		CountHandler ct = new CountHandler();
		File fl = new File("monFichierTest.txt");
		FileParser fp = new FileParser();
		fp.parse(fl,ct);
		System.out.print("le fichier contient " + ct.getCompL()+" lignes");
		System.out.print(" dont " + ct.getCmpC() + " sont des commentaires");
	}
}

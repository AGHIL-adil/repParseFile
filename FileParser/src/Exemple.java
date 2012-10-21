import java.io.File;


public class Exemple {
	public static void main(String args[])
	{
		CountHandler ct1 = new CountHandler();
		CountHandler ct2 = new CountHandler();
		File fl = new File("monFichierTest.txt");
		File f2 = new File("fichier.xml");
		FileParser fp = new FileParser();
		fp.parse(fl,ct1);
		fp.parse(f2,ct2);
		System.out.print("le fichier contient " + ct1.getCompL()+" lignes");
		System.out.print(" dont " + ct1.getCmpC() + " sont des commentaires");
		System.out.print("le fichier contient " + ct2.getCompL()+" lignes");
		System.out.print(" dont " + ct2.getCmpC() + " sont des commentaires");
	}
}

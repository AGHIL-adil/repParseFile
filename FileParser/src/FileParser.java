import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;


public class FileParser{
	public void parse(File file, ContentHandler handler)
	{
		boolean trouve_xml = false;
		try{
			InputStream ips=new FileInputStream(file); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			if ((ligne=br.readLine())!=null){
				if(ligne.startsWith("<?xml"))
				{
					while ((ligne=br.readLine())!=null)
					{
						if(ligne.endsWith("-->"))
							trouve_xml = false;
						if(ligne.startsWith("<!--"))
							trouve_xml =true;
						if(trouve_xml==false)
						{
							handler.defaultLine(ligne);
						}
						else
						{
							handler.defaultLine(ligne);
							handler.commentLine(ligne);
						}
					}
					br.close(); 
				}
			}
		}
		catch (Exception e){
			System.out.println(e.toString());
		}

	}
}

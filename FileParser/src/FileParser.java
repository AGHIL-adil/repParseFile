import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;


public class FileParser{
	public void parse(File file, ContentHandler handler)
	{
		boolean trouve_java = false;
		try{
			InputStream ips=new FileInputStream(file); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			System.out.println("debcom : "+ getComments("config.yaml", "debCom"));
			System.out.println("fincom : "+ getComments("config.yaml", "finCom"));
			System.out.println("com : "+ getComments("config.yaml", "com"));
			while ((ligne=br.readLine())!=null){
					if(ligne.endsWith(getComments("config.yaml", "finCom")))
						trouve_java = false;
					if(ligne.startsWith(getComments("config.yaml", "debCom")))
						trouve_java =true;
					if(trouve_java==false)
					{
						if(ligne.startsWith(getComments("config.yaml", "com")))
						{
							handler.commentLine(ligne);
							handler.defaultLine(ligne);
						}
						else
							handler.defaultLine(ligne);
					}
					else
					{	
						handler.commentLine(ligne);
					}
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
		

	}
	public String getComments(String configFile,String com) {
		DataInputStream config;
		Map map = null;

		try {
			config = new DataInputStream(new FileInputStream(configFile));
			Yaml yaml = new Yaml();
			map = (Map) yaml.load(config);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return (String) map.get(com);

	}
}

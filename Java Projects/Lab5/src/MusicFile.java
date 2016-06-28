import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.net.URL;
public class MusicFile implements MusicFileInterface
{
	private Scanner musicFile;
	private String[] fields;
	private ArrayList<String> currentLine;
	
	public void open(String indexFileName) throws IOException{
		try
	    {
			if(indexFileName.contains("http")){
				musicFile = new Scanner(new URL(indexFileName).openStream());
			}
			else{
				musicFile = new Scanner(new File(indexFileName));
			}
			musicFile.useDelimiter("\r\n");
	    }
	    catch(IOException e)
	    {
	      System.out.println(indexFileName +" not found. Program will now end.");
	      System.exit(0);
	    }
	}
	
	public boolean hasMoreItems(){
		return musicFile.hasNext();
	}
	public ArrayList<String> readItem(){
		fields = musicFile.next().split("; ");
	    currentLine = new ArrayList<String>();
	    for(int i = 0; i<fields.length; i++){
	      currentLine.add(fields[i]);
	    }
	    return currentLine;
	}
	public void close(){
		musicFile.close();
	}
}

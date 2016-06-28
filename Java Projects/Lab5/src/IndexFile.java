import java.io.IOException;
import java.io.PrintWriter;
public class IndexFile implements IndexFileInterface
{
	private PrintWriter indexFile;
	
	public void open(String indexFileName) throws IOException{
		try
	    {
	      indexFile = new PrintWriter(indexFileName);
	      indexFile.printf("%-13s%-50s%-6s%-42s", "Accession#", "Title", "Type", "Additional Information");
	      indexFile.println("\n");
	      indexFile.println("\n");
	    }
	    catch(IOException e)
	    {
	      System.out.println(indexFileName + "cannot be written to. Program will now end.");
	      System.exit(0);
	    }
	}
	public void writeItem(MusicItem itemToWrite){
		indexFile.format("%-13s%-50s%-6s%-42s", itemToWrite.getAccessionNumber(), itemToWrite.getTitle(), itemToWrite.getMedia(), itemToWrite.displaySupplementalInfo());
		indexFile.println("\n");
	}
	public void close(){
		indexFile.close();
	}
	
}

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class MusicManager implements MusicManagerInterface
{
	private MusicFile musicFile;
	private IndexFile indexFile;
	private MusicList musicList;
	private String location;
	private ArrayList<String> itemList;
	private Scanner prompt = new Scanner(System.in);
	
	public MusicManager(){
		musicFile = new MusicFile();
		musicList = new MusicList();
		System.out.print("Is the music archive on the 'disk' or 'web'?: ");
		//expects either "disk" or "web". Assuming one of those two will be chosen.
		location = prompt.next().toString();
		prompt.close();
		try
		{
			if(location.equals("web")){
				musicFile.open("http://www.ics.uci.edu/~rkwang/Fall_2014_ICS45J/LabManual/Lab5/music.txt");
			}
			else if(location.equals("disk")){
				musicFile.open("music.txt");
			}
		}
		catch (IOException e)
		{
			System.out.println("File could not be read. Program will now end.");
			System.exit(0);
		}
		
		while(musicFile.hasMoreItems())
		{
			itemList = musicFile.readItem(); 
			switch(itemList.get(MusicItem.MEDIA_CODE_POSITION))
			{
				case MusicItem.COMPACT: 								
					musicList.addItem(new CompactMedia(itemList));
					break;
				case MusicItem.PAPER: 								
					musicList.addItem(new Paper(itemList));
					break;
				case MusicItem.VINYL: 								
					musicList.addItem(new Vinyl(itemList));
					break;
				case MusicItem.WAX_CYLINDER: 		
					musicList.addItem(new WaxCylinder(itemList));
					break;
			}
		}
		musicFile.close();
	}
	public void makeIndexAndDisplayCounts(){
		indexFile = new IndexFile();
		try
		{
		
			indexFile.open("index.txt");
		}
		catch(IOException e)
		{
			System.out.println("Could not write file at desired location. Program will now end.");
			System.exit(0);
		}
		
		for(int i = 0; i<musicList.getBuckets().size(); i++)
		{
			for(int j = 0; j<musicList.getBuckets().get(i).getItems().size(); j++)
			{
				indexFile.writeItem(musicList.getBuckets().get(i).getItems().get(j));
			}
		}
		indexFile.close();
		System.out.println("'index.txt'");
		System.out.println("Total Items: " + musicList.getTotalItemCount());
		System.out.println("Compact Media: " + musicList.getCompactMediaItemCount());
		System.out.println("Paper: " + musicList.getPaperItemCount());
		System.out.println("Vinyl: " + musicList.getVinylItemCount());
		System.out.println("Wax Cylinder: " +musicList.getWaxCylinderItemCount());
	}
}

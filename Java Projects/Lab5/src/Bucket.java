import java.util.LinkedList;

public class Bucket implements BucketInterface
{
	private LinkedList<MusicItem> musicList;
	
	public Bucket(){
		musicList = new LinkedList<MusicItem>();
	}
	
	public void addItem(MusicItem itemToAdd){
		for(int i = 0; i<musicList.size(); i++){
		      if (((MusicItem)musicList.get(i)).getTitle().compareTo(itemToAdd.getTitle()) > 0)
		      {
		        musicList.add(i, itemToAdd);
		        return;
		      }
		 }
		 musicList.add(itemToAdd);
	}
	
	public LinkedList<MusicItem> getItems(){
		return musicList;
	}
}

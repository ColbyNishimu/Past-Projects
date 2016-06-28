import java.util.ArrayList;


public class MusicList implements MusicListInterface
{
	private int totalCount;
	private int paperCount;
	private int compactMediaCount;
	private int vinylCount;
	private int waxCylinderCount;
	private int bucketNum;
	private ArrayList<Bucket> buckets;
	
	public MusicList(){
		buckets = new ArrayList<Bucket>();
	    for(int i = 0; i < 26; i++){
	      buckets.add(new Bucket());
	    }
	    totalCount = 0;
	    paperCount = 0;
	    compactMediaCount = 0;
	    vinylCount = 0;
	    waxCylinderCount = 0;
	}
	
	public void addItem(MusicItem item){
		bucketNum = item.getTitle().charAt(0) - 'A';
	    buckets.get(bucketNum).addItem(item);
	    if (item.getMedia().equals("P")){
	        paperCount++;
	      } 
	    else if (item.getMedia().equals("C")){
	        compactMediaCount++;
	      } 
	    else if (item.getMedia().equals("V")){
	        vinylCount++;
	      } 
	    else if (item.getMedia().equals("W")){
	        waxCylinderCount++;
	      }
	    totalCount++;
	}
	public ArrayList<Bucket> getBuckets(){
		return buckets;
	}
	
	public int getTotalItemCount(){
		return totalCount;
	}
	
	public int getPaperItemCount(){
		return paperCount;
	}
	
	public int getCompactMediaItemCount(){
		return compactMediaCount;
	}
	
	public int getVinylItemCount(){
		return vinylCount;
	}
	
	public int getWaxCylinderItemCount(){
		return waxCylinderCount;
	}
}

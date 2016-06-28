import java.util.*;
abstract class MusicItem implements MusicItemInterface
{
	public static final String PAPER = "P";
	public static final String COMPACT = "C";
	public static final String VINYL = "V";
	public static final String WAX_CYLINDER = "W";
	public static final int ACCESSION_NUMBER_POSITION = 0;
	public static final int TITLE_POSITION = 1;
	public static final int MEDIA_CODE_POSITION = 2;
	private String accessionNumber;
	private String title;
	private String type;
	
	public MusicItem(ArrayList<String> item){
		accessionNumber = item.get(ACCESSION_NUMBER_POSITION);
		title = item.get(TITLE_POSITION);
		type = item.get(MEDIA_CODE_POSITION);
	}
	
	public abstract String displaySupplementalInfo();
	
	public String getAccessionNumber(){
		return accessionNumber;
	}
	public String getTitle(){
		return title;
	}
	public String getMedia(){
		return type;
	}	
}

class CompactMedia extends MusicItem{
	private int tracksNumber;
	private String year;

	public CompactMedia(ArrayList<String> item){
		super(item);
		tracksNumber = Integer.parseInt(item.get(3));
		year = item.get(4);
	}
	
	public String displaySupplementalInfo(){
		return "Number of Tracks: " +tracksNumber+", Year Released: "+year;
	}
}

class Vinyl extends MusicItem
{
	private String record;
	private int rpm;

	public Vinyl(ArrayList<String> item)
	{
		super(item);
		record = item.get(3);
		rpm = Integer.parseInt(item.get(4));
	}

	public String displaySupplementalInfo()
	{
		return "Record Label: "+record+", RPM: "+rpm;
	}

}

class WaxCylinder extends MusicItem
{
	private String maker;

	public WaxCylinder(ArrayList<String> item)
	{
		super(item);
		maker = item.get(3);
	}

	public String displaySupplementalInfo()
	{
		return "Maker: "+maker;
	}

}

class Paper extends MusicItem
{
	private int numberOfPages;

	public Paper(ArrayList<String> item)
	{
		super(item);
		numberOfPages = Integer.parseInt(item.get(3));
	}

	public String displaySupplementalInfo()
	{
		return "Pages: "+numberOfPages;
	}
}


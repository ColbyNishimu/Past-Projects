
public class ColbyNishimura
{
	//Variables
	String fullName = "Colby Nishimura";
	String firstName = "Colby";
	String lastName = "Nishimura";
	String UCInetID = "cnishimu";
	int studentNumber = 81272756;
	
	//Methods
	public String getFullName(){
		return fullName;
	}
	public String getFirstName(){
		return firstName;
	}
	public String getLastName(){
		return lastName;
	}
	public String getUCInetId(){
		return UCInetID;
	}
	public int getStudentNumber(){
		return studentNumber;
	}
	public String getRotatedFullName(int shift){
		if(shift > 0){
			return fullName.substring(shift)+fullName.substring(0, shift);
		}
		else if(shift < 0){
			int pos = shift*-1;
			//First, I make the number positive to make it easier for me to work with
			return fullName.substring(fullName.length()-pos)+fullName.substring(0, fullName.length()-pos);
		}
		else{
			//I return an unaltered name for 0
			return fullName;
		}
	}
	//End Class ColbyNishimura
}

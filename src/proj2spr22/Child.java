package proj2spr22;
/**
 * <p>Title: Child class
 * <p>Description: contains the info for each child entered
 * into the roller hockey league.
 * 
 * @author Gaetano Re
 *
 */
public class Child {
	private String name;
	private String dob;
	private String dateRecieved;
	
	public Child(String n, String dB, String dR) {
		name = n;
		dob = dB;
		dateRecieved = dR;
	}
	
	public int getAge() {
		int age = 0;
		String [] splitDateOB = dob.split("-");
		String [] splitDateRec = dateRecieved.split("-");
		int birthMonth = Integer.parseInt(splitDateOB[1]);
		int birthDay = Integer.parseInt(splitDateOB[2]);
		int birthYear = Integer.parseInt(splitDateOB[0]);
		int appMonth = Integer.parseInt(splitDateRec[1]);
		int appDay = Integer.parseInt(splitDateRec[2]);
		int appYear = Integer.parseInt(splitDateRec[0]);
		age = appYear - birthYear;
		if(birthMonth < appMonth) {
			--age;
		}
		else if(birthDay < appDay && birthMonth == appMonth) {
			--age;
		}
		return age;
		
		
		
	}
}

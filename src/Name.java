
public class Name {
	private String year;
	private String gender;
	private String ethnicity;
	private String first;
	private int count;
	// add constructors and auxiliary methods
	public Name(){
	}
	public Name(String year, String gender, String ethnicity, String first, int count){
		this.year = year;
		this.gender = gender;
		this.ethnicity = ethnicity;
		this.first = first;
		this.count = count;
		
	}

	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEthnicity() {
		return ethnicity;
	}
	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String toString() {
		return year + " " + gender + " " + ethnicity + " " + first + " " + count;
	}

}

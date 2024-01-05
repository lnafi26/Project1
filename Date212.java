public class Date212{
	private int year;
    private int month;
    private int day;

	public Date212(String dateString){
        year = Integer.parseInt(dateString.substring(0, 4));
        month = Integer.parseInt(dateString.substring(4, 6));
        day = Integer.parseInt(dateString.substring(6, 8));
		//parses input string and initializes year, month, and day
    } //constructor

    private boolean isValidDate(){
        if (this.month == 2){
            int tempFebDay = 28;
            if (Year.isLeap(this.year)) tempFebDay = 29;
            if (this.day < 1 || this.day > tempFebDay) return false;
        } //checks for leap years, and depending on results alters February's range of days

        if (this.month < 1 || this.month > 12) return false; //checks if the month is valid

        int tempDay = 30;
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) tempDay = 31;
        if (this.day < 1 || this.day > tempDay) return false;
        //checks if the day is valid

        else return true;
    } //private method that checks if month and day are valid

	public boolean isValid(){
		return (this.isValidDate());
	} //public-facing method that calls isValidDate()

	public int compareTo(Date212 other){
		if (this.year > other.year) return 1;
		else if (this.year < other.year) return -1;
		//checks whether the "other" date's year or the year of the date calling this method is larger; if "other" is larger, returns -1 / if calling date is larger, returns 1 / else, enter The Nested If Statements (Hell)
		else{
			if (this.month > other.month) return 1;
			else if (this.month < other.month) return -1;
			//same as above except compares the month, if neither works then jump down to the Third Circle
			else{
				if (this.day > other.day) return 1;
				else if (this.day < other.day) return -1;
				//same as above except it compares the day, if neither works then ascend back to the surface
			}
		}
		return 0;
    } //method that implements compareTo method for sorting

	public String toString(){
        return (month + "/" + day + "/" + year);
    } //method that returns the date in the form mm/dd/yyyy

	public String toRaw(){
		return (year + "" + month + "" + day);
	} //method that returns the date in the form yyyymmdd
} //class Date212
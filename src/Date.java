
public class Date {
	int currentDate = 1;
	StringBuilder sb;
	
	public void dayChange(){
		this.currentDate = this.currentDate + 1;
	}
	
	public String toString(){
		sb = new StringBuilder(String.format("January %d, 2015", this.currentDate));
		return sb.toString();
	}
	
}

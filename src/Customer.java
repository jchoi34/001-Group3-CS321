
public class Customer {
	int id;
	String name, address, ccType, ccNumber, ccExpiration;
	
	public void setCustomer(int id){
		this.id = id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	public void setCCType(String ccType){
		this.ccType = ccType;
	}
	
	public void setCCNumber(String ccNumber){
		this.ccNumber = ccNumber;
	}
	
	public void setCCExpiration(String ccExpiration){
		this.ccExpiration = ccExpiration;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getAddress(){
		return this.address;
	}
	
	public String getCCType(){
		return this.ccType;
	}
	
	public String getCCNumber(){
		return this.ccNumber;
	}
	
	public String getCCExpiration(){
		return this.ccExpiration;
	}
}

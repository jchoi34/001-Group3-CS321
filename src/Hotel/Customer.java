package Hotel;


public class Customer {
	public int customerID;
	String name, address, ccType, ccNumber, ccExpiration;
	
	public void setCustomerID(int id){
		this.customerID = id;
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
	
	public int getCustomerID(){
		return this.customerID;
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

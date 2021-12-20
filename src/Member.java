
public class Member {

	private int id;
	private String name;
	private String surname;
	private String address;
	private String password;
	private int invetoryNo;
	
	
	public Member() {
		this.id = -1;
		this.name = "";
		this.surname ="";
		this.address="";
		this.password="";
		this.invetoryNo=-1;
	}
	
	public Member(int id , String name ,String surname , String address , String password , int inventoryNo) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.password = password ;
		this.invetoryNo = inventoryNo;
		
	}
	
	public int getId() {
		return id;
	}
	
	public String getAddress() {
		return address;
	}
	public String get_Name() {
		return name;
	}
	
	public String get_Surname() {
		return surname;
	}
	
	public String get_FullName() {
		return name + " " + surname;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setSurname(String surname) {
		this.surname=surname;
	}
	
	public void setAddress(String address) {
		this.address=address;
	}
	
	public void setPassword(String password) {
		this.password=password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String toString() {
		
		return "Member";
	}
	
}

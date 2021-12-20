import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Connection;



public class Main {

	
	public void intro() {
		System.out.println("          XXXXX Spor okuluna ho�geldiniz   ");
		System.out.println("                    �ye giri�i  ");
		
	}
	
	
	public ArrayList<String> getAuthInfo(){
		
		Scanner scan = new Scanner(System.in);
		ArrayList<String> authentication = new ArrayList();
		System.out.println(" �ye no :");
		authentication.add(scan.nextLine());
		System.out.println(" �ifre  :");
		authentication.add(scan.nextLine());
		return authentication;
		
		
	}
	
	
	public void personMenu(Member m) {
		System.out.println("      ho�geldiniz say�n : " + m.get_FullName());
		System.out.println( " �sim : "+m.get_Name());
		System.out.println( " Soyisim : "+m.get_Surname() );
		System.out.println( " Adres : "+m.getAddress() );
		
		
	}
	
	public void adminMenu(Connection c) {
		Scanner scan = new Scanner(System.in);
		String get=null;
		System.out.println("      ho�geldiniz say�n : admin");
		int flag = 0;
		//Statement stmt = c.createStatement();
		//PreparedStatement = c.prepareStatement();
		
		try {
			while(true) {
				System.out.println(" 1) Sporcu arama ");
				System.out.println(" 2) Sporcu ekleme ");
				System.out.println(" 3) Sporcu Bilgi g�ncelleme ");
				System.out.println(" 4) Sporcu Silme ");
				System.out.println(" 5) ��k��");
				
				System.out.println("Se�im yapmak istedi�iniz de�eri girin :");
				get = scan.nextLine();
			
				
				
				if(flag == 1) {
					break;
				}
				
				if( get.equals("1") ) {
					
					while(true) {
						System.out.println(" 1) Sporcu no ile arama ");
						System.out.println(" 2) isim ile arama ");
						System.out.println(" 3) soyisim ile arama ");
						System.out.println(" 4) �nceki men� ");
						System.out.println(" 5) ��k�� ");
						System.out.println("Se�im yapmak istedi�iniz de�eri girin !");
						get = scan.nextLine();
						if( get.equals("1") ) {
							System.out.println(" Sporcu no giriniz :	 ");
							get = scan.nextLine();
							String query = "SELECT * FROM MEMBERS WHERE id = ?";
							
							PreparedStatement stmt = c.prepareStatement(query);
							stmt.setInt(1, Integer.parseInt(get) );
							ResultSet set = stmt.executeQuery();
							if(set.isBeforeFirst() == false) {
								System.out.println(" kay�t bulunamad� !!");
								
							}else {
								System.out.println(" Sporcu No : " + set.getInt("id"));
								System.out.println(" �sim : " + set.getString("name") );
								System.out.println(" Soyisim : " + set.getString("surname") );
								System.out.println(" Adres : " + set.getString("address") );
							}
							
						}
						else if( get.equals("2") ) {
							System.out.println(" �sim giriniz :	 ");
							get = scan.nextLine();
							String query = "SELECT * FROM MEMBERS WHERE name = ?";
							PreparedStatement stmt = c.prepareStatement(query);
							stmt.setString(1, get);
							ResultSet set = stmt.executeQuery();
							if(set.isBeforeFirst() == false) {
								System.out.println(" kay�t bulunamad� !!");
								
							}else {
								
								while( set.next() ) {
									System.out.println("---------------------");
									System.out.println(" Sporcu No : " + set.getInt("id"));
									System.out.println(" �sim : " + set.getString("name") );
									System.out.println(" Soyisim : " + set.getString("surname") );
									System.out.println(" Adres : " + set.getString("address") );
								}
									
							}
						}
						else if( get.equals("3") ) {
							System.out.println(" Soyisim  giriniz :	 ");
							get = scan.nextLine();
							String query = "SELECT * FROM MEMBERS WHERE surname = ?";
							PreparedStatement stmt = c.prepareStatement(query);
							stmt.setString(1, get);
							ResultSet set = stmt.executeQuery();
							if(set.isBeforeFirst() == false) {
								System.out.println(" kay�t bulunamad� !!");
								
							}else {
								
								while( set.next() ) {
									System.out.println("---------------------");
									System.out.println(" Sporcu No : " + set.getInt("id"));
									System.out.println(" �sim : " + set.getString("name") );
									System.out.println(" Soyisim : " + set.getString("surname") );
									System.out.println(" Adres : " + set.getString("address") );
								}
							}
						}
						else if( get.equals("4") ) {
							break;
						}
						else if( get.equals("5") ) {
							flag = 1;
							break;
						}
						else {
							System.out.println("yanl�� se�im tekrar dene");
						}
					}
				}
				else if( get.equals("2") ) {
					Member m = new Member();
					System.out.println( " �sim Giriniz: " );
					get = scan.nextLine();
					m.setName(get);
					System.out.println( " Soyisim Giriniz: " );
					get = scan.nextLine();
					m.setSurname(get);
					System.out.println( " Adres Giriniz: " );
					get = scan.nextLine();
					m.setAddress(get);
					System.out.println( " �ifre Giriniz: " );
					get = scan.nextLine();
					m.setPassword(get);
					String query = "INSERT INTO MEMBERS (name,surname , address , password) VALUES (? , ? , ? , ?)";
					PreparedStatement stmt = c.prepareStatement(query);
					stmt.setString(1, m.get_Name());
					stmt.setString(2, m.get_Surname());
					stmt.setString(3, m.getAddress() );
					stmt.setString(4, m.getPassword() );
					stmt.execute();
					System.out.println("yeni sporcu eklendi");
				}
				else if( get.equals("3") ) {
					System.out.println(" Sporcu no giriniz :	 ");
					get = scan.nextLine();
					String query = "SELECT * FROM MEMBERS WHERE id = ?";
					PreparedStatement stmt = c.prepareStatement(query);
					stmt.setInt(1, Integer.parseInt(get) );
					ResultSet set = stmt.executeQuery();
					if(set.isBeforeFirst() == false) {
						System.out.println(" kay�t bulunamad� !!");
						
					}
					else {
						System.out.println(" kay�t bulundu!!");
						System.out.println( " 1)isim g�ncelleme " );
						System.out.println( " 2)Soyisim g�ncelleme: " );
						System.out.println( " 3)Adres g�ncelleme: " );
						System.out.println( " 4)�ifre g�ncelleme: " );
						get = scan.nextLine();
						
					}
					
				}
				else if( get.equals("4") ) {
					System.out.println(" Sporcu no giriniz :	 ");
					get = scan.nextLine();
					if( Integer.parseInt(get) == 1) {
						System.out.println("Admin kullan�c� silinemez !!");
						continue;
					}
					String query = "DELETE FROM MEMBERS WHERE id = ?";
					PreparedStatement stmt = c.prepareStatement(query);
					stmt.setInt(1, Integer.parseInt(get) );
					if ( stmt.execute()) {
						System.out.println("Sporcu ba�ar� ile silindi");
					}
					else {
						System.out.println("Sporcu ba�ar� ile silindi");
					}
					
				}
				else if( get.equals("5") ) {
					break;
				}
				else {
					System.out.println("yanl�� se�im tekrar dene");
				}
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
			
	}
	
	
	
	public static void main(String args[]) {
	
		
		Main driver = new Main();
		
		String jdbcUrl = "jdbc:postgresql://localhost:5432/SportSchool";
		String userName = "postgres";
		String userPassword = "636373";
		
		Connection connect = null;
		
		try{
			connect = DriverManager.getConnection(jdbcUrl, userName, userPassword);
			System.out.println("ba�landi");
			Statement statement = connect.createStatement();
			
			
			ArrayList<String> create_query = new ArrayList();
			ArrayList<String> table_names = new ArrayList();
			create_query.add("CREATE TABLE MEMBERS (id SERIAL PRIMARY KEY , name VARCHAR(200) , surname VARCHAR(200) , address VARCHAR(200) , password varchar(10), inventory_no int  ) ");
			table_names.add("members");
			
			/*
			for(String x:table_names) {
				statement.execute(create_query.get(table_names.indexOf(x)) );
				
			}*/
			
			
			driver.intro();
			ArrayList<String> authentication = driver.getAuthInfo();
			
			String pQuery = "SELECT * FROM MEMBERS WHERE ID = ? AND PASSWORD = ? ";
			PreparedStatement pStatement = connect.prepareStatement(pQuery);

			pStatement.setInt(1,Integer.parseInt( authentication.get(0) ) );
			pStatement.setString(2,authentication.get(1));
			ResultSet set = null;
			Member user = null;
			while(true) {
				set = pStatement.executeQuery();
				if ( set.next() == false ) {
					System.out.println("L�tfen bilgilerinizi kontrol edin l�tfen tekrar deneyiniz!!!\n");
					authentication = driver.getAuthInfo();
				}
				else {
					
					user = new Member(set.getInt("id") , set.getString("name") , set.getString("surname") , set.getString("address") , set.getString("password") , set.getInt("inventory_no") );
					
					break;
				}
			}
			if( user.getId() == 1) {
				driver.adminMenu(connect);
			}
			else {
				driver.personMenu(user);
			}
			
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		  
		
		
		
		
	}
	
	
}

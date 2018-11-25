/*import java.sql.*;
public class Connectivity {
	static Connection con;
	static PrepareStatement stmt;
	public  static Statement connectiondb() {
		try {
			Class.forName("java.sql.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			 stmt=con.prepareStatement(null);
			 return stmt;
		
		}catch(Exception e) {
			return null;
		}
	}
		public static void cclose() {
			try{
				con.close();
				stmt.close();
				}
			catch(Exception e)
			{
				
			}
			}
			
		}

	
*/

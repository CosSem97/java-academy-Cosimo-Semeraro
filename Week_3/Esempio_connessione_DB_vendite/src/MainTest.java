import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class MainTest {

	
	
	public static void main(String[] args) throws SQLException {
		
		// creo una connessione al DB di nome vendite in cui l'utente a collegarsi è javauser e la cui password è password
		Connection conn = eseguiConnessioneAlDB("vendite", "javauser", "password");
		
		if(conn == null){
			System.out.println("Errore nella connessione al DB!");
			System.exit(-1);
		}
			
		
		// --- eseguo una query ---
		String query = "SELECT product_name, SUM(quantity) AS totQtySold"
					 + " FROM products P, sales S"
					 + " WHERE P.id = S.product_id"
					 + " GROUP BY product_name"
					 + " HAVING totQtySold > 30"
					 + " ORDER BY product_name;";
		
		if(eseguiQuery(conn, query) == 0) {
			System.out.println("Query eseguita con successo!");
		}
		else {
			System.out.println("Query non eseguita con successo!");
		}
		
		System.out.println("\n---- Query con cursore ResultSet che si muove al contrario ---");
		eseguiQueryReversePrint(conn, query);
		
		System.out.println("\n---- Query con cursore ResultSet che salta le righe ---");
		eseguiQueryJumpPrint(conn, query);
		
		
		
		
		// --- eseguo un'update ---
		String update = "UPDATE products SET product_name = 'Apple Watch 5' WHERE product_name = 'Apple Watch';";
		
		if(eseguiUpdate(conn, update) > 0) {
			System.out.println("\nUpdate eseguito con successo! Sono state modificate ");
		}
		else {
			System.out.println("\nUpdate non eseguito con successo!");
		}
		
		
		
		// chiudo la connessione
		conn.close();
		
	}
	
	
	
	// restituisce 0 se la query viene eseguita correttamente sul DB, -1 altrimenti
	public static int eseguiQuery(Connection conn, String query) {
		
		try {
			
			Statement st = conn.createStatement();
			
			ResultSet resTable = st.executeQuery(query);
			
			System.out.println("NomeProdotto   |   " + "quantitàTotaleVenduta");
			System.out.println("------------   |   " + "---------------------");
			
			while(resTable.next()) {
				
				System.out.print(resTable.getString(1) + " 			");
				System.out.println(resTable.getInt(2));
			}
			
			
		}
		catch(SQLException e) {
			System.out.println("Error message: " + e.getMessage());
			System.out.println("Errore: " + e.getErrorCode());
		}
		
		return 0;
	}
	
	
	
	// restituisce 0 se la query viene eseguita correttamente sul DB, -1 altrimenti
	public static int eseguiQueryReversePrint(Connection conn, String query) {
		
		try {
			
			// Statement st = conn.createStatement();
			Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			ResultSet resTable = st.executeQuery(query);
			
			System.out.println("NomeProdotto   |   " + "quantitàTotaleVenduta");
			System.out.println("------------   |   " + "---------------------");
			
			resTable.last();
			System.out.print(resTable.getString(1) + " 			");
			System.out.println(resTable.getInt(2));
			
			while(resTable.previous()) {
				
				System.out.print(resTable.getString(1) + " 			");
				System.out.println(resTable.getInt(2));
			}
			
			
		}
		catch(SQLException e) {
			System.out.println("Error message: " + e.getMessage());
			System.out.println("Errore: " + e.getErrorCode());
		}
		
		return 0;
	}
		
		
		
		
	// restituisce 0 se la query viene eseguita correttamente sul DB, -1 altrimenti
		public static int eseguiQueryJumpPrint(Connection conn, String query) {
			
			try {
						
				// Statement st = conn.createStatement();
				Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				
				ResultSet resTable = st.executeQuery(query);
				
				System.out.println("NomeProdotto   |   " + "quantitàTotaleVenduta");
				System.out.println("------------   |   " + "---------------------");
				
				resTable.first();
				System.out.print(resTable.getString(1) + " 			");
				System.out.println(resTable.getInt(2));
				
				while(resTable.relative(2)) {
					
					System.out.print(resTable.getString(1) + " 			");
					System.out.println(resTable.getInt(2));
				}
				
				
			}
			catch(SQLException e) {
				System.out.println("Error message: " + e.getMessage());
				System.out.println("Errore: " + e.getErrorCode());
			}
			
			return 0;
		}
	
	
	
	
	// restituisce il numero di righe aggiornate nel DB
	public static int eseguiUpdate(Connection conn, String update) {
		
		try {
			
			Statement st = conn.createStatement();
			
			int numRows = st.executeUpdate(update);
			
			return numRows;
			
		}
		catch(SQLException e) {
			System.out.println("Errore: " + e.getErrorCode());
			return 0;
		}
		
		
	}
	
	
	
	
	// esegue la connessione al DB e restituisce un oggetto Connection
	public static Connection eseguiConnessioneAlDB(String dbName, String user, String password) {
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, user, password);
		}
		catch(SQLException e) {
			System.out.println("Eccezione SQL: " + e.getMessage());
			System.out.println("Stato: " + e.getSQLState());
			System.out.println("Errore: " + e.getErrorCode());
		}
		
		return conn;
	}

}

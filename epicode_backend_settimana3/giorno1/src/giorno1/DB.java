package giorno1;



import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DB {
	
	private final String url = "jdbc:postgresql://localhost:5432/postgres?useSSL=false";
	private final String username = "postgres";
	private final String password = "postgres";
	private Connection conn = null;

	public void connect() {
		try {
		  System.out.println("Connecting to database " + url);
		  conn = DriverManager.getConnection(url, username, password);
		  System.out.println("Connection is successful!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void disconnect() {
		if( conn != null ) {    	  
		    try {
				  conn.close();
				  System.out.println("Disonnection is successful!");
			} catch (SQLException e) {
				  e.printStackTrace();
			}
		}
	}
	
	
	public void insertStudent(Student s) {
		
		try {
			String sql = "INSERT INTO school_students (name, lastname, birthdate, gender, avg, min_vote, max_vote) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, s.getName());
			stmt.setString(2, s.getLastname());
			stmt.setDate(3, Date.valueOf(s.getBirthdate()));
			stmt.setString(4, s.getGender());
			stmt.setDouble(5, s.getAvg());
			stmt.setInt(6, s.getMin_vote());
			stmt.setInt(7, s.getMax_vote());
			stmt.executeUpdate();
			
			System.out.println("Insert is successful!");
		}
		catch(SQLException e) {
			System.out.println("There was an error during inserting data");
			e.printStackTrace();
		}
		
	}
	
	public void updateStudent(String fullname, int id) {
		
		try {
			String sql = "UPDATE students SET fullname = ? WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, fullname);
			stmt.setInt(2, id);
			stmt.execute();
			
			System.out.println("Update is successful!");
		}
		catch(SQLException e) {
			System.out.println("There was an error during updating data");
			e.printStackTrace();
		}
		
	}
	
	public void selectAllStudents() {
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = 
			 stmt.executeQuery("SELECT students.id as sid, fullname, addresses.address FROM students JOIN addresses ON students.address_id = addresses.id ORDER BY sid ASC");
			
			System.out.println( "Students list:" );
			while( rs.next() ) {
				System.out.printf(
					"ID: %d Fullname: %s Address: %s%n", 
					rs.getInt("sid"), 
					rs.getString("fullname"),
					rs.getString("address")
				);
				System.out.println("-----------------------------------------------");
			}
			
		} catch (SQLException e) {
			System.out.println("There was an error during selecting data");
			e.printStackTrace();
		}
		
	}
	public void updateStudent(int id, HashMap<String, Object> s) {
		String sql = "UPDATE school_students SET ";
	    ArrayList<Object> values = new ArrayList<>();
	    int i = 1;
	    for (Map.Entry<String, Object> entry : s.entrySet()) {
	        sql += entry.getKey() + " = ?";
	        if (i < s.size()) {
	            sql += ", ";
	        }
	        values.add(entry.getValue());
	        i++;
	    }
	    sql += " WHERE id = ?";
	    values.add(id);
	       try {
	    	   PreparedStatement pstmt = conn.prepareStatement(sql);
	              for (int j = 0; j < values.size(); j++) {
	                  pstmt.setObject(j + 1, values.get(j));
	              }
	              pstmt.executeUpdate();
	          } catch (SQLException e) {
	              System.out.println("Errore, utente non modificato");
	          }
	          System.out.println("Utente modificato con successo!!!");
	      }
	
public void deleteStudent(int id) {
        
        try {
        	String sql = "DELETE FROM school_students WHERE id = ?";
        	PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            int deletedRows = pstmt.executeUpdate();
            if (deletedRows > 0) {
                System.out.println("Lo studente con id " + id + " è stato eliminato.");
            } else {
                System.out.println("Lo studente con id " + id + "  non esiste.");
            }
        } catch (SQLException e) {
            System.out.println("Errore, studente non eliminato");;
        }
    }
public void getBest() {
    
    try {
    	String sql = "SELECT id, name, lastname, avg FROM school_students GROUP BY id ORDER BY avg DESC LIMIT 1";
    	PreparedStatement pstmt = conn.prepareStatement(sql);
    	ResultSet resultSet = pstmt.executeQuery();
        if (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String lastname = resultSet.getString("lastname");
            double avg = resultSet.getDouble("avg");
            System.out.println("Lo Studente con la media più alta è: ");
            System.out.println("Id: " + id);
            System.out.println("Name: " + name);
            System.out.println("Lastname: " + lastname);
            System.out.println("Average grade: " + avg);
        } else {
            System.out.println("Studente non trovato!");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public void getVoteRange(int min, int max) {
	
	try {
		String sql = "SELECT * FROM school_students WHERE min_vote >= ? AND max_vote <= ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, min);
		pstmt.setInt(2, max);
		ResultSet rs = pstmt.executeQuery();
		System.out.println("Nome\tCognome\tSesso\tData di nascita\tMedia voto\tVoto minimo\tVoto massimo");
		while (rs.next()) {
			System.out.println(rs.getString("name") + "\t" + rs.getString("lastname") + "\t" + rs.getString("gender") + "\t" + rs.getString("birthdate") + "\t" + rs.getDouble("avg") + "\t" + rs.getInt("min_vote") + "\t" + rs.getInt("max_vote"));
		}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}

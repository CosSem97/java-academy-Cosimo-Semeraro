package com.academy.cic;

import com.academy.cic.entity.*;
import com.academy.cic.util.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Dao {
	
	// inserisce nel DB un nuovo studente
	public void insertStudent(Student student) throws SQLException {
		String query = "INSERT INTO student (id, first_name, last_name, age) VALUES  (?, ?, ?, ?)";

    	Connection conn = null;
    	PreparedStatement pstmt = null;

        try {
            conn = JdbcUtil.getConnection();

            pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, student.getId());
            pstmt.setString(2, student.getFirst_name());
            pstmt.setString(3, student.getLast_name());
            pstmt.setInt(4, student.getAge());
            
            pstmt.executeUpdate();

        }
        catch (SQLException e) {
            System.out.println("Errore nell'inserimento dello studente nel DB!");
            System.out.println(e.getMessage());
            
        } 
        finally {
        	JdbcUtil.closePreparedStatement(pstmt);
        	JdbcUtil.closeConnection(conn);
        }
    }
	
	
	// inserisce nel DB un nuovo corso
	public void insertCourse(Course course) throws SQLException {
		String query = "INSERT INTO course (id, name) VALUES  (?, ?)";

    	Connection conn = null;
    	PreparedStatement pstmt = null;

        try {
            conn = JdbcUtil.getConnection();

            pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, course.getId());
            pstmt.setString(2, course.getName());
            
            pstmt.executeUpdate();

        }
        catch (SQLException e) {
            System.out.println("Errore nell'inserimento del corso nel DB!");
            System.out.println(e.getMessage());
            
        } 
        finally {
        	JdbcUtil.closePreparedStatement(pstmt);
        	JdbcUtil.closeConnection(conn);
        }
    }
	
	
	// inserisce nel DB una nuova registrazione
	public void registryStudentCourse(Registration reg) throws SQLException {
    	String query = "INSERT INTO registration (id, student_id, course_id, grade) VALUES (?,?,?,?)";

    	Connection conn = null;
    	PreparedStatement pstmt = null;

        try {
            conn = JdbcUtil.getConnection();
            
            pstmt = conn.prepareStatement(query);
            
            pstmt.setInt(1, reg.getId());
            pstmt.setInt(2, reg.getStudent().getId());
            pstmt.setInt(3, reg.getCourse().getId());
            pstmt.setInt(4, reg.getGrade());
            
            pstmt.executeUpdate();

        }
        catch (SQLException e) {
        	System.out.println("Errore nell'inserimento della registrazione nel DB!");
            System.out.println(e.getMessage());
        }
        finally {
        	JdbcUtil.closePreparedStatement(pstmt);
        	JdbcUtil.closeConnection(conn);
        }
    }
	
	
	// Restituisce lo studente che nel DB ha quel nome e cognome
	public Student selectByNameSurname(String name, String surname) throws SQLException {
    	String query = "SELECT * "
    			+ "FROM student "
    			+ "WHERE first_name = ? AND last_name = ?";

    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	Student stud = null;

        try {
        	conn = JdbcUtil.getConnection();

        	pstmt = conn.prepareStatement(query);
        	pstmt.setString(1, name);
        	pstmt.setString(2, surname);

            rs = pstmt.executeQuery();

            if (rs.next()) {
            	// se esiste nel DB uno studente con quel nome e cognome
            	
            	stud = new Student();
            	
                stud.setId(rs.getInt("id"));
                stud.setFirst_name(rs.getString("first_name"));
                stud.setLast_name(rs.getString("last_name"));
                stud.setAge(rs.getInt("age"));
            }

        }
        catch (SQLException e) {
        	System.out.println("Errore nel retrieve dello studente dal DB!");
            System.out.println(e.getMessage());
        }
        finally {
        	JdbcUtil.closeResultSet(rs);
        	JdbcUtil.closePreparedStatement(pstmt);
        	JdbcUtil.closeConnection(conn);
        }
        return stud;
    }
	
	
	
	public void updateCourseGradeById(int regId, int grade) throws SQLException {
    	String query = "UPDATE registration SET grade = ? WHERE id = ?";

    	Connection conn = null;
    	PreparedStatement pstmt = null;

        try {
            conn = JdbcUtil.getConnection();

            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, grade);
            pstmt.setInt(2, regId);
            
            pstmt.executeUpdate();

        }
        catch (SQLException e) {
        	System.out.println("Errore nell'aggiornamento del grade nel DB!");
            System.out.println(e.getMessage());
        }
        finally {
        	JdbcUtil.closePreparedStatement(pstmt);
        	JdbcUtil.closeConnection(conn);
        }
    }
	
	
	
	// restituisce la lista dei corsi di uno studente
	public List<Course> findStudentCourses(int studentId) throws SQLException {
    	String query = "SELECT R.course_id, C.name "
    			+ "FROM registration R, course C "
    			+ "WHERE R.course_id = C.id AND student_id = ?";

    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	List<Course> corsi = new ArrayList<Course>();

        try {
        	conn = JdbcUtil.getConnection();

        	pstmt = conn.prepareStatement(query);
        	pstmt.setInt(1, studentId);

            rs = pstmt.executeQuery();

            
            while (rs.next()) {
            	// per ogni corso a cui quello studente è registrato
            	
            	// aggiungo il corso alla lista
            	corsi.add(new Course(rs.getInt("course_id"), rs.getString("name")));
            }

        }
        catch (SQLException e) {
        	System.out.println("Errore nel retrieve dei corsi dello studente dal DB!");
            System.out.println(e.getMessage());
        }
        finally {
        	JdbcUtil.closeResultSet(rs);
        	JdbcUtil.closePreparedStatement(pstmt);
        	JdbcUtil.closeConnection(conn);
        }
        
        return corsi;
    }
	
	
	
	// restituisce una lista di oggetti della classe StudentNumCourses
	// Per ogni studente ho il numero di corsi a cui è registrato
	public List<StudentNumCourses> findStudentIdNumcourses() throws SQLException {
	    String query = "SELECT R.student_id, COUNT(*) AS numCorsi "
	    		+ "FROM registration R "
	    		+ "GROUP BY R.student_id";
	    
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    List<StudentNumCourses> studentsNumCorsi = new ArrayList<StudentNumCourses>();
	    
	    try {
	       	conn = JdbcUtil.getConnection();

	        pstmt = conn.prepareStatement(query);

	        rs = pstmt.executeQuery();
	           
	            
	        while (rs.next()) {
	        	// per ogni studente
	        	
	        	studentsNumCorsi.add(new StudentNumCourses(rs.getInt("student_id"), rs.getInt("numCorsi")));
	        }

	    }
	    catch (SQLException e) {
	    	   System.out.println("Errore nel retrieve degli studenti dal DB!");
	           System.out.println(e.getMessage());
	    }
	    finally {
	    	   JdbcUtil.closeResultSet(rs);
	    	   JdbcUtil.closePreparedStatement(pstmt);
	    	   JdbcUtil.closeConnection(conn);
	    }
	       
	    return studentsNumCorsi;
	 }
	
	
	
	// restituisce una lista di oggetti della classe StudentNumCourses
	// Per ogni studente ho i dati dello studente e il numero di corsi a cui è registrato
	public List<StudentNumCourses> findStudentDataNumcourses() throws SQLException {
		   String query = "SELECT S.*, COUNT(*) AS numCorsi "
		   		+ "FROM registration R, student S "
		   		+ "WHERE R.student_id = S.id "
		    	+ "GROUP BY R.student_id";
		    
		    Connection conn = null;
		    PreparedStatement pstmt = null;
		    ResultSet rs = null;
		    List<StudentNumCourses> studentsNumCorsi = new ArrayList<StudentNumCourses>();
		    
		    try {
		       	conn = JdbcUtil.getConnection();

		        pstmt = conn.prepareStatement(query);

		        rs = pstmt.executeQuery();
		           
		            
		        while (rs.next()) {
		         // per ogni studente
		            
		         studentsNumCorsi.add(new StudentNumCourses(new Student(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getInt("age")), rs.getInt("numCorsi")));
		        }

		    }
		    catch (SQLException e) {
		    	   System.out.println("Errore nel retrieve degli studenti dal DB!");
		           System.out.println(e.getMessage());
		    }
		    finally {
		    	   JdbcUtil.closeResultSet(rs);
		    	   JdbcUtil.closePreparedStatement(pstmt);
		    	   JdbcUtil.closeConnection(conn);
		    }
		       
		    return studentsNumCorsi;
		 }
}

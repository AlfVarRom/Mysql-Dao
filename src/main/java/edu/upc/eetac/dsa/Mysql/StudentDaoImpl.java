package edu.upc.eetac.dsa.Mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class StudentDaoImpl implements StudentDao {

	
	// Variable para ejecutar querys
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection connect;

	// Querys
	private String SQL_DELETE = "DELETE FROM student WHERE name = ?";
	private String SQL_GET = "SELECT NAME FROM student,RelacionStudentClass,Class where name = relname and numclass=renumclass and prof = ?";

	//Constructor donde se recupera la conexiÃ³n a BBDD
	public StudentDaoImpl() {
		connect = AccessMySQLDao.getConnect();
	}

	//FunciÃ³n de borrado de usuario
	public boolean deleteStudent(Student key) {

		try {
			connect = AccessMySQLDao.getConnect();

			ps = connect.prepareStatement(SQL_DELETE);
			ps.setString(1, key.getName());

			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return false;
	}

	//FunciÃ³n de obtenciÃ³n de usuario
	public Student getStudent(String key) {
		Student a = null;
		try {
			connect = AccessMySQLDao.getConnect();

			ps = connect.prepareStatement(SQL_GET);
			ps.setString(1, key);
			rs = ps.executeQuery();
			while (rs.next()) {
				a = new Student(rs.getString(1));
			}
			return a;

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return a;

	}
}

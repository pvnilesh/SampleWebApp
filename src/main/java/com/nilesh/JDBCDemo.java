import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class JDBCDemo {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		// Class.forName("com.mysql.cj.jdbc.Driver");
		
		StudentDAO dao = new StudentDAO();
		dao.setupConnection();
		
		//Student s = dao.getStudent(14);
		//System.out.println(s);
		
		//Student s1 = new Student(14, "Archana");
		//dao.addStudent(s1);
		
		List<Student> studs = dao.getAllStudents();
		for(Student s: studs) {
			System.out.println(s);
		}
		
		dao.clearConnection();
	}

}

class Student {
	int rollno;
	String sname;
	
	public Student(int rollno, String sname) {
		this.rollno = rollno;
		this.sname = sname;
	}

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", sname=" + sname + "]";
	}
	
}

class StudentDAO {
	Connection con = null;
	
	public Student getStudent(int rollno) throws Exception{
		String query = "select sname from student where rollno=" + rollno;
		
		//System.out.println("connected");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		rs.next();
		String sname = rs.getString(1);
		//System.out.println(sname);
		
		st.close();
		
		return new Student(rollno, sname);
	}
	
	
	public void addStudent(Student s) throws Exception{
		String query = "insert into student values (?,?)";
		
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, s.rollno);
		pst.setString(2, s.sname);
		
		int count = pst.executeUpdate();
		System.out.println(count + " rows affected");
	}
	
	public List<Student> getAllStudents() throws Exception{
		List<Student> studs = new ArrayList<>();
		String query = "select * from student";
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()) {
			int rollno = rs.getInt(1);
			String sname = rs.getString(2);
			
			studs.add(new Student(rollno, sname));
		}
		
		return studs;
	}
	
	public void setupConnection() throws Exception{
		String url = "jdbc:mysql://localhost:3306/nilesh";
		String user = "root";
		String pass = "mysql123";
		con =  DriverManager.getConnection(url, user, pass);
		
	}
	
	public void clearConnection() throws Exception{
		con.close();
	}
}

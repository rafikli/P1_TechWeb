package mvc.model;

import java.sql.*;
import java.util.*;

public class DAO {
	
	Connection connection = null;
	
	String url = System.getenv("mysql_url");
	String user = System.getenv("mysql_user");
	String password = System.getenv("mysql_password");
	public DAO() throws ClassNotFoundException, SQLException {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);

		
		
		}

	public List<Alunos> getLista() {
		
		List<Alunos> alunos = new ArrayList<Alunos>();
		
		PreparedStatement stmt;
		try {
			stmt = connection.
				prepareStatement("SELECT * FROM Alunos");
		
		ResultSet rs = stmt.executeQuery();
	
		while (rs.next()) {
			
			Alunos aluno = new Alunos();
			
			aluno.setId(rs.getInt("id"));
			
			aluno.setNome(rs.getString("nome"));
			
			//aluno.setTime(rs.getTimestamp("time"));
			
			aluno.setDuvida(rs.getString("duvida"));
			
			alunos.add(aluno);
		}		
			rs.close();
			stmt.close();
		
		} 
		catch (SQLException | NullPointerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return alunos;
    }

	public void close() {
		// TODO Auto-generated method stub
		try {
			connection.close();
		} catch (SQLException | NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void adiciona(Alunos aluno) {
		String sql = "INSERT INTO Alunos" +
		"(nome,duvida) values(?,?)";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
		
		stmt.setString(1,aluno.getNome());
		
		//stmt.setTimestamp(2,  current);
		
		stmt.setString(2,aluno.getDuvida());
		
		stmt.execute();
		stmt.close();
		} catch (SQLException | NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void altera(Alunos aluno) {
		String sql = "UPDATE Alunos SET " +
		 "nome=?, duvida=? WHERE id=?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, aluno.getNome());
			//stmt.setDate(2, new java.sql.Date(aluno.getNascimento().getTimeInMillis()));
			stmt.setString(2, aluno.getDuvida());
			stmt.setInt(3, aluno.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException | NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void remove(Integer id) {
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("DELETE FROM Alunos WHERE id=?");
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException | NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}




package mvc.model;

import java.sql.Timestamp;

public class Alunos {

	private Integer id;
	private String nome;
	private Timestamp time;
	private String duvida;
	
	public Integer getId() {return this.id;}
	public void setId(Integer id) {this.id = id;}
	
	public String getNome() {return this.nome;}
	public void setNome(String nome) {this.nome = nome;}
	
	public Timestamp getTime() {return this.time;}
	public void setTime(Timestamp time) {this.time = time;}
	
	public String getDuvida() {return this.duvida;}
	public void setDuvida(String duvida) {this.duvida = duvida;}
}
//import java.sql.Timestamp;
//Timestamp ts = new Timestamp(date.getTime(););
//
//stmt.setTime(2, ts);
//aluno.setTime()

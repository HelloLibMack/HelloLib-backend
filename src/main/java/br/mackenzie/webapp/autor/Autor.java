package br.mackenzie.webapp.autor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import br.mackenzie.webapp.livro.Livro;

@Entity
@Table(name="autor")
public class Autor {

  @Id @GeneratedValue
  private long id;
  private String nome;
  private String dtNascimento;
  private String nacionalidade;
  private String sexo;



  public Autor() {
    super();
  }


  public long getId() {
  	return id;
  }
  
  
  public void setId(long id) {
  	this.id = id;
  }
  
  
  public String getNome() {
  	return nome;
  }
  
  
  public void setNome(String nome) {
  	this.nome = nome;
  }
  
  
  public String getDtNascimento() {
  	return dtNascimento;
  }
  
  
  public void setDtNascimento(String dtNascimento) {
  	this.dtNascimento = dtNascimento;
  }
  
  
  public String getNacionalidade() {
  	return nacionalidade;
  }
  
  
  public void setNacionalidade(String nacionalidade) {
  	this.nacionalidade = nacionalidade;
  }
  
  
  public String getSexo() {
  	return sexo;
  }
  
  
  public void setSexo(String sexo) {
  	this.sexo = sexo;
  }
  
  

}
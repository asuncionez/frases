package com.ipn.mx.modelo.entidades;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
@Entity
@Table (name = "Frase")
public class Frase implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFrase;
	
	@NotBlank(message = "El texto de la frase es obligatorio")
	@Size(min = 10, max = 200, message = "El tamaño tiene que estar entre 10 y 200")
	@Column(name = "texto", length = 200, nullable = false)
	private String texto;
	
	@NotBlank(message = "El autor de la frase es obligatorio")
	@Size(min = 10, max = 100, message = "El tamaño tiene que estar entre 10 y 100")
	@Column(name = "autor", length = 100, nullable = false)
	private String autor;
	
	public Frase() {
		super();
	}
	public Long getIdFrase() {
		return idFrase;
	}
	public void setIdFrase(Long idFrase) {
		this.idFrase = idFrase;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Frase [idFrase=");
		builder.append(idFrase);
		builder.append(", texto=");
		builder.append(texto);
		builder.append(", autor=");
		builder.append(autor);
		builder.append("]");
		return builder.toString();
	}
	
	

}

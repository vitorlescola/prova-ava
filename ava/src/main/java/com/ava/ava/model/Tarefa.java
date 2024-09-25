package com.ava.ava.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tarefa {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false)
	private String titulo;
	@Column(nullable=false)
	private String descriçao;
	private Date dataCriaçao;
	private Date prazo;
	@Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusTarefa status;
	public enum StatusTarefa {
	    PENDENTE,
	    CONCLUIDA
	}
	
	
	
	public void criarTarefa() {
		
	}
	
	public void excluirTarefa() {
		
	}
	
	public void atualizaeTarefa() {
		
	}

	public Tarefa() {
	}

	public Tarefa(String titulo, String descriçao, Date dataCriaçao, Date prazo, StatusTarefa status) {
		this.titulo = titulo;
		this.descriçao = descriçao;
		this.dataCriaçao = dataCriaçao;
		this.prazo = prazo;
		this.status=status;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescriçao() {
		return descriçao;
	}

	public void setDescriçao(String descriçao) {
		this.descriçao = descriçao;
	}

	public Date getDataCriaçao() {
		return dataCriaçao;
	}

	public void setDataCriaçao(Date dataCriaçao) {
		this.dataCriaçao = dataCriaçao;
	}

	public Date getPrazo() {
		return prazo;
	}

	public void setPrazo(Date prazo) {
		this.prazo = prazo;
	}

	public StatusTarefa getStatus() {
		return status;
	}

	public void setStatus(StatusTarefa status) {
		this.status = status;
	}
}
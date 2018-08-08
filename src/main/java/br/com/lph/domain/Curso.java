package br.com.lph.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "cursos",
       indexes = { @Index(
               columnList = "titulo, data_inicio",
               unique = true,
               name = "unique_titulo_dataInicio")
       }
)

public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  
    @Column(nullable = false)
    private String titulo;
  
    @Column(name = "carga_horaria", nullable = false)
    @Enumerated(EnumType.STRING) // obrigatório por ser um campo enum
    private CargaHoraria cargaHoraria;
  
    @Column(name = "data_inicio")
    private Date dataInicio;

	public Curso() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public CargaHoraria getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(CargaHoraria cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", titulo=" + titulo + ", cargaHoraria=" + cargaHoraria + ", dataInicio="
				+ dataInicio + "]";
	}
}

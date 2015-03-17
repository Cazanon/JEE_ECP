package persistence.models.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import persistence.models.utils.NivelEstudios;

@Entity
public class Voto {
	
	@Id
	private Integer id;
	
	private String valoracion;
	
	private NivelEstudios nivelEstudios;
	
	private String ipUsuario;
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn
	private Tema tema;
	
	public Voto(){
		super();
	}
	
	public Voto(String valoracion, NivelEstudios nivelEstudios, String ipUsuario, Tema tema){
		super();
		this.valoracion = valoracion;
		this.nivelEstudios = nivelEstudios;
		this.ipUsuario = ipUsuario;
		this.tema = tema;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getValoracion() {
		return valoracion;
	}

	public void setValoracion(String valoracion) {
		this.valoracion = valoracion;
	}

	public NivelEstudios getNivelEstudios() {
		return nivelEstudios;
	}

	public void setNivelEstudios(NivelEstudios nivelEstudios) {
		this.nivelEstudios = nivelEstudios;
	}

	public String getIpUsuario() {
		return ipUsuario;
	}

	public void setIpUsuario(String ipUsuario) {
		this.ipUsuario = ipUsuario;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
	@Override
    public boolean equals(Object obj) {
        assert obj != null;
        Voto other = (Voto) obj;
        return id.equals(other.id) && valoracion.equals(other.valoracion)
                && nivelEstudios.equals(other.nivelEstudios) && ipUsuario.equals(other.ipUsuario)
                && tema.equals(other.tema);
    }
	
    @Override
    public String toString() {
        return "User[id=" + id + ", valoracion=" + valoracion + "]";
    }
	
}

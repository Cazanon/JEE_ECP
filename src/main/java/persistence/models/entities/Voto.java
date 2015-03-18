package persistence.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import persistence.models.utils.NivelEstudios;

@Entity
@Table(name = Voto.TABLE)
public class Voto {
    public static final String TABLE = "VOTO";

    public static final String ID = "ID";	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = ID)
	private Integer id;
	
	public static final String VALORACION = "VALORACION";	
    @Column(name = VALORACION)
	private String valoracion;
	
	public static final String NIVEL_ESTUDIOS = "NIVEL_ESTUDIOS";	
    @Column(name = NIVEL_ESTUDIOS)
	@Enumerated(EnumType.STRING)
	private NivelEstudios nivelEstudios;
	
	public static final String IP_USUARIO = "IP_USUARIO";	
    @Column(name = IP_USUARIO)
	private String ipUsuario;
	
    public static final String ID_TEMA = "ID_TEMA";
	@ManyToOne    
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
    	return "\nVoto->IP Usuario: "+ ipUsuario +",\tTema: "+ tema +",\tValoracion: "
    			+ valoracion +",\tNivel de Estudios: "+ nivelEstudios +"\n";
    }
	
}

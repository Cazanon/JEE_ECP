package persistence.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = Tema.TABLE)
public class Tema {
    public static final String TABLE = "TEMA";

    public static final String ID = "ID";
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = ID)
	private Integer id;
	
    public static final String NOMBRE = "NOMBRE";    
    @Column(name = NOMBRE)
	private String nombre;
    
    public static final String PREGUNTA = "PREGUNTA";    
    @Column(name = PREGUNTA)
	private String pregunta;
	
	public Tema(){
		super();
	}
	
	public Tema(String nombre, String pregunta){
		super();
		this.nombre = nombre;
		this.pregunta = pregunta;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	
	@Override
    public boolean equals(Object obj) {
        assert obj != null;
        Tema other = (Tema) obj;
        return id.equals(other.id) && nombre.equals(other.nombre)
                && pregunta.equals(other.pregunta);
    }
	
    @Override
    public String toString() {
    	return "\nTema->Nombre: "+ nombre +",\tPregunta: "+ pregunta +"\n";
    }
	
}

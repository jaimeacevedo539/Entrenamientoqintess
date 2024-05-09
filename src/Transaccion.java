import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.io.Serializable;
import java.util.Map;

@XmlRootElement
@XmlSeeAlso({Transaccion.class,Tag59.class,Tag53A.class,Tag50k.class,Tag32a.class})
public class Transaccion implements Serializable {
    private static final long serialVersionUID =1L;
    private DatosOrigen datosOrigen;
    private DatosDestino datosDestino;
    private Map<String, String> mapa;
    private Map<String, Object> businessData;


    public Transaccion() {
    }

    public Transaccion(DatosOrigen datosOrigen, DatosDestino datosDestino, Map<String, String> mapa, Map<String, Object> businessData) {
        this.datosOrigen = datosOrigen;
        this.datosDestino = datosDestino;
        this.mapa = mapa;
        this.businessData = businessData;
    }

    @XmlElement
    public DatosOrigen getDatosOrigen() {
        return datosOrigen;
    }

    public void setDatosOrigen(DatosOrigen datosOrigen) {
        this.datosOrigen = datosOrigen;
    }

    @XmlElement
    public DatosDestino getDatosDestino() {
        return datosDestino;
    }

    public void setDatosDestino(DatosDestino datosDestino) {
        this.datosDestino = datosDestino;
    }

    @XmlElement
    public Map<String, String> getMapa() {
        return mapa;
    }

    public void setMapa(Map<String, String> mapa) {
        this.mapa = mapa;
    }

    @XmlElement
    public Map<String, Object> getBusinessData() {
        return businessData;
    }

    public void setBusinessData(Map<String, Object> businessData) {
        this.businessData = businessData;
    }
}
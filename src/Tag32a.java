import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.io.Serializable;

@XmlRootElement
@XmlSeeAlso({Tag32a.class})
public class Tag32a implements Serializable {
    private static final long serialVersionUID =1L;
    private String numeroImportante;

    public Tag32a() {
    }

    public Tag32a(String numeroImportante) {
        this.numeroImportante = numeroImportante;
    }

    @XmlElement
    public String getNumeroImportante() {
        return numeroImportante;
    }

    public void setNumeroImportante(String numeroImportante) {
        this.numeroImportante = numeroImportante;
    }
}

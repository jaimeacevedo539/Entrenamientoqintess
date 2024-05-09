import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.io.Serializable;


@XmlRootElement
@XmlSeeAlso({Tag59.class})
public class Tag59 implements Serializable {
    private static final long serialVersionUID =1L;
    private String nCuenta;
    private String refPago;
    private String ciudad;
    private String pais;

    public Tag59() {
    }

    public Tag59(String nCuenta, String refPago, String ciudad, String pais) {
        this.nCuenta = nCuenta;
        this.refPago = refPago;
        this.ciudad = ciudad;
        this.pais = pais;
    }

    @XmlElement
    public String getnCuenta() {
        return nCuenta;
    }

    public void setnCuenta(String nCuenta) {
        this.nCuenta = nCuenta;
    }

    @XmlElement
    public String getRefPago() {
        return refPago;
    }

    public void setRefPago(String refPago) {
        this.refPago = refPago;
    }

    @XmlElement
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @XmlElement
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}

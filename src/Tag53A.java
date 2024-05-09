import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.io.Serializable;

@XmlRootElement
@XmlSeeAlso({Tag53A.class})
public class Tag53A implements Serializable {
    private static final long serialVersionUID =1L;
    private String nCuenta;
    private String bic;

    public Tag53A() {
    }

    public Tag53A(String nCuenta, String bic) {
        this.nCuenta = nCuenta;
        this.bic = bic;
    }

    @XmlElement
    public String getnCuenta() {
        return nCuenta;
    }

    public void setnCuenta(String nCuenta) {
        this.nCuenta = nCuenta;
    }

    @XmlElement
    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }
}

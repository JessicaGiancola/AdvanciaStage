
package soapservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import model.Dough;


/**
 * <p>Classe Java per anonymous complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="d" type="{http://model}Dough"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "d"
})
@XmlRootElement(name = "addDough")
public class AddDough {

    @XmlElement(required = true)
    protected Dough d;

    /**
     * Recupera il valore della proprietà d.
     * 
     * @return
     *     possible object is
     *     {@link Dough }
     *     
     */
    public Dough getD() {
        return d;
    }

    /**
     * Imposta il valore della proprietà d.
     * 
     * @param value
     *     allowed object is
     *     {@link Dough }
     *     
     */
    public void setD(Dough value) {
        this.d = value;
    }

}

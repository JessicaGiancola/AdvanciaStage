
package soapservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="addDoughReturn" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
    "addDoughReturn"
})
@XmlRootElement(name = "addDoughResponse")
public class AddDoughResponse {

    protected boolean addDoughReturn;

    /**
     * Recupera il valore della proprietÓ addDoughReturn.
     * 
     */
    public boolean isAddDoughReturn() {
        return addDoughReturn;
    }

    /**
     * Imposta il valore della proprietÓ addDoughReturn.
     * 
     */
    public void setAddDoughReturn(boolean value) {
        this.addDoughReturn = value;
    }

}

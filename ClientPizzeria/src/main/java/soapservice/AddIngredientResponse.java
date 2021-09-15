
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
 *         &lt;element name="addIngredientReturn" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
    "addIngredientReturn"
})
@XmlRootElement(name = "addIngredientResponse")
public class AddIngredientResponse {

    protected boolean addIngredientReturn;

    /**
     * Recupera il valore della proprietà addIngredientReturn.
     * 
     */
    public boolean isAddIngredientReturn() {
        return addIngredientReturn;
    }

    /**
     * Imposta il valore della proprietà addIngredientReturn.
     * 
     */
    public void setAddIngredientReturn(boolean value) {
        this.addIngredientReturn = value;
    }

}

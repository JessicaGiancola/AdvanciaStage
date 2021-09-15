
package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per Ingredient complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="Ingredient"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ingID" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="ingName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ingredient", propOrder = {
    "ingID",
    "ingName"
})
public class Ingredient {

    protected int ingID;
    @XmlElement(required = true, nillable = true)
    protected String ingName;

    /**
     * Recupera il valore della proprietà ingID.
     * 
     */
    public int getIngID() {
        return ingID;
    }

    /**
     * Imposta il valore della proprietà ingID.
     * 
     */
    public void setIngID(int value) {
        this.ingID = value;
    }

    /**
     * Recupera il valore della proprietà ingName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIngName() {
        return ingName;
    }

    /**
     * Imposta il valore della proprietà ingName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIngName(String value) {
        this.ingName = value;
    }

}

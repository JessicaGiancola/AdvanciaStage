
package soapservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import model.Dough;
import model.Ingredient;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.0-SNAPSHOT
 * Generated source version: 2.2
 * 
 */
@WebService(name = "PizzeriaSoapServiceImpl", targetNamespace = "http://soapservice")
@XmlSeeAlso({
    model.ObjectFactory.class,
    soapservice.ObjectFactory.class
})
public interface PizzeriaSoapServiceImpl {


    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "getAllReturn", targetNamespace = "http://soapservice")
    @RequestWrapper(localName = "getAll", targetNamespace = "http://soapservice", className = "soapservice.GetAll")
    @ResponseWrapper(localName = "getAllResponse", targetNamespace = "http://soapservice", className = "soapservice.GetAllResponse")
    public String getAll();

    /**
     * 
     * @param d
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(name = "addDoughReturn", targetNamespace = "http://soapservice")
    @RequestWrapper(localName = "addDough", targetNamespace = "http://soapservice", className = "soapservice.AddDough")
    @ResponseWrapper(localName = "addDoughResponse", targetNamespace = "http://soapservice", className = "soapservice.AddDoughResponse")
    public boolean addDough(
        @WebParam(name = "d", targetNamespace = "http://soapservice")
        Dough d);

    /**
     * 
     * @param i
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(name = "addIngredientReturn", targetNamespace = "http://soapservice")
    @RequestWrapper(localName = "addIngredient", targetNamespace = "http://soapservice", className = "soapservice.AddIngredient")
    @ResponseWrapper(localName = "addIngredientResponse", targetNamespace = "http://soapservice", className = "soapservice.AddIngredientResponse")
    public boolean addIngredient(
        @WebParam(name = "i", targetNamespace = "http://soapservice")
        Ingredient i);

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "getAllDoughReturn", targetNamespace = "http://soapservice")
    @RequestWrapper(localName = "getAllDough", targetNamespace = "http://soapservice", className = "soapservice.GetAllDough")
    @ResponseWrapper(localName = "getAllDoughResponse", targetNamespace = "http://soapservice", className = "soapservice.GetAllDoughResponse")
    public String getAllDough();

}

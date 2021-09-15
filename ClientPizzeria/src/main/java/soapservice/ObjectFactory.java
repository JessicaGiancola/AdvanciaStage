
package soapservice;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the soapservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: soapservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAll }
     * 
     */
    public GetAll createGetAll() {
        return new GetAll();
    }

    /**
     * Create an instance of {@link GetAllResponse }
     * 
     */
    public GetAllResponse createGetAllResponse() {
        return new GetAllResponse();
    }

    /**
     * Create an instance of {@link AddDough }
     * 
     */
    public AddDough createAddDough() {
        return new AddDough();
    }

    /**
     * Create an instance of {@link AddDoughResponse }
     * 
     */
    public AddDoughResponse createAddDoughResponse() {
        return new AddDoughResponse();
    }

    /**
     * Create an instance of {@link AddIngredient }
     * 
     */
    public AddIngredient createAddIngredient() {
        return new AddIngredient();
    }

    /**
     * Create an instance of {@link AddIngredientResponse }
     * 
     */
    public AddIngredientResponse createAddIngredientResponse() {
        return new AddIngredientResponse();
    }

    /**
     * Create an instance of {@link GetAllDough }
     * 
     */
    public GetAllDough createGetAllDough() {
        return new GetAllDough();
    }

    /**
     * Create an instance of {@link GetAllDoughResponse }
     * 
     */
    public GetAllDoughResponse createGetAllDoughResponse() {
        return new GetAllDoughResponse();
    }

}

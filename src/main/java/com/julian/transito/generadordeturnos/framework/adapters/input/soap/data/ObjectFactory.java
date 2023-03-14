
package com.julian.transito.generadordeturnos.framework.adapters.input.soap.data;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the data package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: data
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindTurnRequest }
     * 
     */
    public FindTurnRequest createFindTurnRequest() {
        return new FindTurnRequest();
    }

    /**
     * Create an instance of {@link ScheduleTurnRequest }
     * 
     */
    public ScheduleTurnRequest createScheduleTurnRequest() {
        return new ScheduleTurnRequest();
    }

    /**
     * Create an instance of {@link GetListAvailableTurnsRequest }
     * 
     */
    public GetListAvailableTurnsRequest createGetListAvailableTurnsRequest() {
        return new GetListAvailableTurnsRequest();
    }

    /**
     * Create an instance of {@link TurnResponse }
     * 
     */
    public TurnResponse createTurnResponse() {
        return new TurnResponse();
    }

    /**
     * Create an instance of {@link TurnData }
     * 
     */
    public TurnData createTurnData() {
        return new TurnData();
    }

}

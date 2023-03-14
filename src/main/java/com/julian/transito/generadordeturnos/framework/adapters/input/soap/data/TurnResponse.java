
package com.julian.transito.generadordeturnos.framework.adapters.input.soap.data;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="turnResponse" type="{http://spring.io/guides/gs-producing-web-service}turnData" maxOccurs="unbounded" minOccurs="0"/&gt;
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
    "turnResponse"
})
@XmlRootElement(name = "TurnResponse", namespace = "http://spring.io/guides/gs-producing-web-service")
public class TurnResponse {

    @XmlElement(namespace = "http://spring.io/guides/gs-producing-web-service")
    protected List<TurnData> turnResponse;

    /**
     * Gets the value of the turnResponse property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the turnResponse property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTurnResponse().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TurnData }
     * 
     * 
     */
    public List<TurnData> getTurnResponse() {
        if (turnResponse == null) {
            turnResponse = new ArrayList<TurnData>();
        }
        return this.turnResponse;
    }

}

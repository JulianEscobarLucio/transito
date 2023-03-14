
package com.julian.transito.generadordeturnos.framework.adapters.input.soap.data;

import jakarta.xml.bind.annotation.*;


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
 *         &lt;element name="documentType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="documentNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="turnId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "documentType",
    "documentNumber",
    "turnId"
})
@XmlRootElement(name = "ScheduleTurnRequest", namespace = "http://spring.io/guides/gs-producing-web-service")
public class ScheduleTurnRequest {

    @XmlElement(namespace = "http://spring.io/guides/gs-producing-web-service", required = true)
    protected String documentType;
    @XmlElement(namespace = "http://spring.io/guides/gs-producing-web-service", required = true)
    protected String documentNumber;
    @XmlElement(namespace = "http://spring.io/guides/gs-producing-web-service", required = true)
    protected String turnId;

    /**
     * Obtiene el valor de la propiedad documentType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentType() {
        return documentType;
    }

    /**
     * Define el valor de la propiedad documentType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentType(String value) {
        this.documentType = value;
    }

    /**
     * Obtiene el valor de la propiedad documentNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentNumber() {
        return documentNumber;
    }

    /**
     * Define el valor de la propiedad documentNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentNumber(String value) {
        this.documentNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad turnId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTurnId() {
        return turnId;
    }

    /**
     * Define el valor de la propiedad turnId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTurnId(String value) {
        this.turnId = value;
    }

}

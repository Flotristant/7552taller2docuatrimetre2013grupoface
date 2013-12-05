
package ar.fiuba.redsocedu.datalayer.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for evento complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="evento">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.datalayer.redsocedu.fiuba.ar/}returnedObject">
 *       &lt;sequence>
 *         &lt;element name="muro" type="{http://ws.datalayer.redsocedu.fiuba.ar/}muro" minOccurs="0"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "evento", propOrder = {
    "muro",
    "nombre"
})
public class Evento
    extends ReturnedObject
{

    protected Muro muro;
    protected String nombre;

    /**
     * Gets the value of the muro property.
     * 
     * @return
     *     possible object is
     *     {@link Muro }
     *     
     */
    public Muro getMuro() {
        return muro;
    }

    /**
     * Sets the value of the muro property.
     * 
     * @param value
     *     allowed object is
     *     {@link Muro }
     *     
     */
    public void setMuro(Muro value) {
        this.muro = value;
    }

    /**
     * Gets the value of the nombre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the value of the nombre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

}

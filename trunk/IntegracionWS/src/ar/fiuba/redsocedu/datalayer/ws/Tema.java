
package ar.fiuba.redsocedu.datalayer.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tema complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tema">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.datalayer.redsocedu.fiuba.ar/}returnedObject">
 *       &lt;sequence>
 *         &lt;element name="mensajes" type="{http://ws.datalayer.redsocedu.fiuba.ar/}mensaje" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subforo" type="{http://ws.datalayer.redsocedu.fiuba.ar/}subforo" minOccurs="0"/>
 *         &lt;element name="subforoId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tema", propOrder = {
    "mensajes",
    "nombre",
    "subforo",
    "subforoId"
})
public class Tema
    extends ReturnedObject
{

    @XmlElement(nillable = true)
    protected List<Mensaje> mensajes;
    protected String nombre;
    protected Subforo subforo;
    protected Long subforoId;

    /**
     * Gets the value of the mensajes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mensajes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMensajes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Mensaje }
     * 
     * 
     */
    public List<Mensaje> getMensajes() {
        if (mensajes == null) {
            mensajes = new ArrayList<Mensaje>();
        }
        return this.mensajes;
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

    /**
     * Gets the value of the subforo property.
     * 
     * @return
     *     possible object is
     *     {@link Subforo }
     *     
     */
    public Subforo getSubforo() {
        return subforo;
    }

    /**
     * Sets the value of the subforo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Subforo }
     *     
     */
    public void setSubforo(Subforo value) {
        this.subforo = value;
    }

    /**
     * Gets the value of the subforoId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSubforoId() {
        return subforoId;
    }

    /**
     * Sets the value of the subforoId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSubforoId(Long value) {
        this.subforoId = value;
    }

}

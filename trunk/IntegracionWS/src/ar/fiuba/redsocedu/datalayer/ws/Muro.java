
package ar.fiuba.redsocedu.datalayer.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for muro complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="muro">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.datalayer.redsocedu.fiuba.ar/}returnedObject">
 *       &lt;sequence>
 *         &lt;element name="muroId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="eventos" type="{http://ws.datalayer.redsocedu.fiuba.ar/}evento" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "muro", propOrder = {
    "muroId",
    "eventos",
    "nombre"
})
public class Muro
    extends ReturnedObject
{

    protected Long muroId;
    @XmlElement(nillable = true)
    protected List<Evento> eventos;
    protected String nombre;

    /**
     * Gets the value of the muroId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMuroId() {
        return muroId;
    }

    /**
     * Sets the value of the muroId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMuroId(Long value) {
        this.muroId = value;
    }

    /**
     * Gets the value of the eventos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the eventos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEventos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Evento }
     * 
     * 
     */
    public List<Evento> getEventos() {
        if (eventos == null) {
            eventos = new ArrayList<Evento>();
        }
        return this.eventos;
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

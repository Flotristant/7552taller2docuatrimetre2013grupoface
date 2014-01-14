
package ar.fiuba.redsocedu.datalayer.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for subforo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="subforo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.datalayer.redsocedu.fiuba.ar/}returnedObject">
 *       &lt;sequence>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="seccionId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="subforoId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="subforopadreId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="subforos" type="{http://ws.datalayer.redsocedu.fiuba.ar/}subforo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="temas" type="{http://ws.datalayer.redsocedu.fiuba.ar/}tema" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "subforo", propOrder = {
    "nombre",
    "seccionId",
    "subforoId",
    "subforopadreId",
    "subforos",
    "temas"
})
public class Subforo
    extends ReturnedObject
{

    protected String nombre;
    protected Long seccionId;
    protected Long subforoId;
    protected Long subforopadreId;
    @XmlElement(nillable = true)
    protected List<Subforo> subforos;
    @XmlElement(nillable = true)
    protected List<Tema> temas;

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
     * Gets the value of the seccionId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSeccionId() {
        return seccionId;
    }

    /**
     * Sets the value of the seccionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSeccionId(Long value) {
        this.seccionId = value;
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

    /**
     * Gets the value of the subforopadreId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSubforopadreId() {
        return subforopadreId;
    }

    /**
     * Sets the value of the subforopadreId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSubforopadreId(Long value) {
        this.subforopadreId = value;
    }

    /**
     * Gets the value of the subforos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subforos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubforos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Subforo }
     * 
     * 
     */
    public List<Subforo> getSubforos() {
        if (subforos == null) {
            subforos = new ArrayList<Subforo>();
        }
        return this.subforos;
    }

    /**
     * Gets the value of the temas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the temas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTemas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Tema }
     * 
     * 
     */
    public List<Tema> getTemas() {
        if (temas == null) {
            temas = new ArrayList<Tema>();
        }
        return this.temas;
    }

}

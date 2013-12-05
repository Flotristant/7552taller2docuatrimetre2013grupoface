
package ar.fiuba.redsocedu.datalayer.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cartelera complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cartelera">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.datalayer.redsocedu.fiuba.ar/}returnedObject">
 *       &lt;sequence>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="noticias" type="{http://ws.datalayer.redsocedu.fiuba.ar/}noticia" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cartelera", propOrder = {
    "nombre",
    "noticias"
})
public class Cartelera
    extends ReturnedObject
{

    protected String nombre;
    @XmlElement(nillable = true)
    protected List<Noticia> noticias;

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
     * Gets the value of the noticias property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the noticias property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNoticias().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Noticia }
     * 
     * 
     */
    public List<Noticia> getNoticias() {
        if (noticias == null) {
            noticias = new ArrayList<Noticia>();
        }
        return this.noticias;
    }

}

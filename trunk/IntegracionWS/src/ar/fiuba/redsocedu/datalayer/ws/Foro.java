
package ar.fiuba.redsocedu.datalayer.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for foro complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="foro">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.datalayer.redsocedu.fiuba.ar/}returnedObject">
 *       &lt;sequence>
 *         &lt;element name="ambitoId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="foroId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="secciones" type="{http://ws.datalayer.redsocedu.fiuba.ar/}seccion" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "foro", propOrder = {
    "ambitoId",
    "foroId",
    "nombre",
    "secciones"
})
public class Foro
    extends ReturnedObject
{

    protected Long ambitoId;
    protected Long foroId;
    protected String nombre;
    @XmlElement(nillable = true)
    protected List<Seccion> secciones;

    /**
     * Gets the value of the ambitoId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAmbitoId() {
        return ambitoId;
    }

    /**
     * Sets the value of the ambitoId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAmbitoId(Long value) {
        this.ambitoId = value;
    }

    /**
     * Gets the value of the foroId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getForoId() {
        return foroId;
    }

    /**
     * Sets the value of the foroId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setForoId(Long value) {
        this.foroId = value;
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
     * Gets the value of the secciones property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the secciones property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSecciones().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Seccion }
     * 
     * 
     */
    public List<Seccion> getSecciones() {
        if (secciones == null) {
            secciones = new ArrayList<Seccion>();
        }
        return this.secciones;
    }

}

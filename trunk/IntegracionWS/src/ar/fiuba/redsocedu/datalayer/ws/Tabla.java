
package ar.fiuba.redsocedu.datalayer.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tabla complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tabla">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.datalayer.redsocedu.fiuba.ar/}returnedObject">
 *       &lt;sequence>
 *         &lt;element name="campos" type="{http://ws.datalayer.redsocedu.fiuba.ar/}campo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="filas" type="{http://ws.datalayer.redsocedu.fiuba.ar/}fila" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="tablaId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tabla", propOrder = {
    "campos",
    "filas",
    "tablaId"
})
public class Tabla
    extends ReturnedObject
{

    @XmlElement(nillable = true)
    protected List<Campo> campos;
    @XmlElement(nillable = true)
    protected List<Fila> filas;
    protected Long tablaId;

    /**
     * Gets the value of the campos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the campos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCampos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Campo }
     * 
     * 
     */
    public List<Campo> getCampos() {
        if (campos == null) {
            campos = new ArrayList<Campo>();
        }
        return this.campos;
    }

    /**
     * Gets the value of the filas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the filas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFilas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Fila }
     * 
     * 
     */
    public List<Fila> getFilas() {
        if (filas == null) {
            filas = new ArrayList<Fila>();
        }
        return this.filas;
    }

    /**
     * Gets the value of the tablaId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTablaId() {
        return tablaId;
    }

    /**
     * Sets the value of the tablaId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTablaId(Long value) {
        this.tablaId = value;
    }

}

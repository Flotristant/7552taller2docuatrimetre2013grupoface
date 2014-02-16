
package ar.fiuba.redsocedu.datalayer.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for fila complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="fila">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.datalayer.redsocedu.fiuba.ar/}returnedObject">
 *       &lt;sequence>
 *         &lt;element name="celdas" type="{http://ws.datalayer.redsocedu.fiuba.ar/}celda" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="filaId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
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
@XmlType(name = "fila", propOrder = {
    "celdas",
    "filaId",
    "tablaId"
})
public class Fila
    extends ReturnedObject
{

    @XmlElement(nillable = true)
    protected List<Celda> celdas;
    protected Long filaId;
    protected Long tablaId;

    /**
     * Gets the value of the celdas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the celdas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCeldas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Celda }
     * 
     * 
     */
    public List<Celda> getCeldas() {
        if (celdas == null) {
            celdas = new ArrayList<Celda>();
        }
        return this.celdas;
    }

    /**
     * Gets the value of the filaId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFilaId() {
        return filaId;
    }

    /**
     * Sets the value of the filaId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFilaId(Long value) {
        this.filaId = value;
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


package ar.fiuba.redsocedu.datalayer.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wiki complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wiki">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.datalayer.redsocedu.fiuba.ar/}returnedObject">
 *       &lt;sequence>
 *         &lt;element name="ambitoId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="articulos" type="{http://ws.datalayer.redsocedu.fiuba.ar/}articulo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="portada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="wikiId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wiki", propOrder = {
    "ambitoId",
    "articulos",
    "portada",
    "wikiId"
})
public class Wiki
    extends ReturnedObject
{

    protected Long ambitoId;
    @XmlElement(nillable = true)
    protected List<Articulo> articulos;
    protected String portada;
    protected Long wikiId;

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
     * Gets the value of the articulos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the articulos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArticulos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Articulo }
     * 
     * 
     */
    public List<Articulo> getArticulos() {
        if (articulos == null) {
            articulos = new ArrayList<Articulo>();
        }
        return this.articulos;
    }

    /**
     * Gets the value of the portada property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPortada() {
        return portada;
    }

    /**
     * Sets the value of the portada property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPortada(String value) {
        this.portada = value;
    }

    /**
     * Gets the value of the wikiId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getWikiId() {
        return wikiId;
    }

    /**
     * Sets the value of the wikiId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setWikiId(Long value) {
        this.wikiId = value;
    }

}

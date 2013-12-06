
package ar.fiuba.redsocedu.datalayer.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for noticia complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="noticia">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.datalayer.redsocedu.fiuba.ar/}returnedObject">
 *       &lt;sequence>
 *         &lt;element name="cartelera" type="{http://ws.datalayer.redsocedu.fiuba.ar/}cartelera" minOccurs="0"/>
 *         &lt;element name="carteleraId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="contenido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="noticiaId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="titulo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "noticia", propOrder = {
    "cartelera",
    "carteleraId",
    "contenido",
    "noticiaId",
    "titulo"
})
public class Noticia
    extends ReturnedObject
{

    protected Cartelera cartelera;
    protected Long carteleraId;
    protected String contenido;
    protected Long noticiaId;
    protected String titulo;

    /**
     * Gets the value of the cartelera property.
     * 
     * @return
     *     possible object is
     *     {@link Cartelera }
     *     
     */
    public Cartelera getCartelera() {
        return cartelera;
    }

    /**
     * Sets the value of the cartelera property.
     * 
     * @param value
     *     allowed object is
     *     {@link Cartelera }
     *     
     */
    public void setCartelera(Cartelera value) {
        this.cartelera = value;
    }

    /**
     * Gets the value of the carteleraId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCarteleraId() {
        return carteleraId;
    }

    /**
     * Sets the value of the carteleraId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCarteleraId(Long value) {
        this.carteleraId = value;
    }

    /**
     * Gets the value of the contenido property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * Sets the value of the contenido property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContenido(String value) {
        this.contenido = value;
    }

    /**
     * Gets the value of the noticiaId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNoticiaId() {
        return noticiaId;
    }

    /**
     * Sets the value of the noticiaId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNoticiaId(Long value) {
        this.noticiaId = value;
    }

    /**
     * Gets the value of the titulo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Sets the value of the titulo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitulo(String value) {
        this.titulo = value;
    }

}

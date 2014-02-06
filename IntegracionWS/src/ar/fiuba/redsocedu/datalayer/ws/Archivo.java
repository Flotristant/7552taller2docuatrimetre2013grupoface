
package ar.fiuba.redsocedu.datalayer.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for archivo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="archivo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.datalayer.redsocedu.fiuba.ar/}returnedObject">
 *       &lt;sequence>
 *         &lt;element name="contenido" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="recurso" type="{http://ws.datalayer.redsocedu.fiuba.ar/}recurso" minOccurs="0"/>
 *         &lt;element name="recursoId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="tamanio" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="tipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "archivo", propOrder = {
    "contenido",
    "nombre",
    "recurso",
    "recursoId",
    "tamanio",
    "tipo"
})
public class Archivo
    extends ReturnedObject
{

    protected byte[] contenido;
    protected String nombre;
    protected Recurso recurso;
    protected Long recursoId;
    protected Long tamanio;
    protected String tipo;

    /**
     * Gets the value of the contenido property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getContenido() {
        return contenido;
    }

    /**
     * Sets the value of the contenido property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setContenido(byte[] value) {
        this.contenido = ((byte[]) value);
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
     * Gets the value of the recurso property.
     * 
     * @return
     *     possible object is
     *     {@link Recurso }
     *     
     */
    public Recurso getRecurso() {
        return recurso;
    }

    /**
     * Sets the value of the recurso property.
     * 
     * @param value
     *     allowed object is
     *     {@link Recurso }
     *     
     */
    public void setRecurso(Recurso value) {
        this.recurso = value;
    }

    /**
     * Gets the value of the recursoId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRecursoId() {
        return recursoId;
    }

    /**
     * Sets the value of the recursoId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRecursoId(Long value) {
        this.recursoId = value;
    }

    /**
     * Gets the value of the tamanio property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTamanio() {
        return tamanio;
    }

    /**
     * Sets the value of the tamanio property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTamanio(Long value) {
        this.tamanio = value;
    }

    /**
     * Gets the value of the tipo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Sets the value of the tipo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipo(String value) {
        this.tipo = value;
    }

}


package ar.fiuba.redsocedu.datalayer.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for encuesta complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="encuesta">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.datalayer.redsocedu.fiuba.ar/}returnedObject">
 *       &lt;sequence>
 *         &lt;element name="evaluada" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="preguntas" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="recurso" type="{http://ws.datalayer.redsocedu.fiuba.ar/}recurso" minOccurs="0"/>
 *         &lt;element name="recursoId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "encuesta", propOrder = {
    "evaluada",
    "preguntas",
    "recurso",
    "recursoId"
})
public class Encuesta
    extends ReturnedObject
{

    protected Boolean evaluada;
    protected String preguntas;
    protected Recurso recurso;
    protected Long recursoId;

    /**
     * Gets the value of the evaluada property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEvaluada() {
        return evaluada;
    }

    /**
     * Sets the value of the evaluada property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEvaluada(Boolean value) {
        this.evaluada = value;
    }

    /**
     * Gets the value of the preguntas property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreguntas() {
        return preguntas;
    }

    /**
     * Sets the value of the preguntas property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreguntas(String value) {
        this.preguntas = value;
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

}

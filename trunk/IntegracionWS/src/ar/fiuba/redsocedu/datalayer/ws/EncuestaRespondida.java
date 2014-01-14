
package ar.fiuba.redsocedu.datalayer.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for encuestaRespondida complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="encuestaRespondida">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.datalayer.redsocedu.fiuba.ar/}returnedObject">
 *       &lt;sequence>
 *         &lt;element name="evaluacion" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="preguntasRespondidas" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="recursoId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="usuarioId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "encuestaRespondida", propOrder = {
    "evaluacion",
    "preguntasRespondidas",
    "recursoId",
    "usuarioId"
})
public class EncuestaRespondida
    extends ReturnedObject
{

    protected Long evaluacion;
    protected String preguntasRespondidas;
    protected Long recursoId;
    protected Long usuarioId;

    /**
     * Gets the value of the evaluacion property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getEvaluacion() {
        return evaluacion;
    }

    /**
     * Sets the value of the evaluacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setEvaluacion(Long value) {
        this.evaluacion = value;
    }

    /**
     * Gets the value of the preguntasRespondidas property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreguntasRespondidas() {
        return preguntasRespondidas;
    }

    /**
     * Sets the value of the preguntasRespondidas property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreguntasRespondidas(String value) {
        this.preguntasRespondidas = value;
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
     * Gets the value of the usuarioId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getUsuarioId() {
        return usuarioId;
    }

    /**
     * Sets the value of the usuarioId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setUsuarioId(Long value) {
        this.usuarioId = value;
    }

}


package ar.fiuba.redsocedu.datalayer.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for actividad complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="actividad">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.datalayer.redsocedu.fiuba.ar/}returnedObject">
 *       &lt;sequence>
 *         &lt;element name="actividadId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="actividadSuperiorId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ambitoSuperiorId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaFin" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="fechaInicio" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="grupos" type="{http://ws.datalayer.redsocedu.fiuba.ar/}grupo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="gruposExclusivo" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="notas" type="{http://ws.datalayer.redsocedu.fiuba.ar/}nota" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="tipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoEscala" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "actividad", propOrder = {
    "actividadId",
    "actividadSuperiorId",
    "ambitoSuperiorId",
    "descripcion",
    "fechaFin",
    "fechaInicio",
    "grupos",
    "gruposExclusivo",
    "nombre",
    "notas",
    "tipo",
    "tipoEscala"
})
public class Actividad
    extends ReturnedObject
{

    protected Long actividadId;
    protected Long actividadSuperiorId;
    protected Long ambitoSuperiorId;
    protected String descripcion;
    protected Long fechaFin;
    protected Long fechaInicio;
    @XmlElement(nillable = true)
    protected List<Grupo> grupos;
    protected Boolean gruposExclusivo;
    protected String nombre;
    @XmlElement(nillable = true)
    protected List<Nota> notas;
    protected String tipo;
    protected String tipoEscala;

    /**
     * Gets the value of the actividadId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getActividadId() {
        return actividadId;
    }

    /**
     * Sets the value of the actividadId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setActividadId(Long value) {
        this.actividadId = value;
    }

    /**
     * Gets the value of the actividadSuperiorId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getActividadSuperiorId() {
        return actividadSuperiorId;
    }

    /**
     * Sets the value of the actividadSuperiorId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setActividadSuperiorId(Long value) {
        this.actividadSuperiorId = value;
    }

    /**
     * Gets the value of the ambitoSuperiorId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAmbitoSuperiorId() {
        return ambitoSuperiorId;
    }

    /**
     * Sets the value of the ambitoSuperiorId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAmbitoSuperiorId(Long value) {
        this.ambitoSuperiorId = value;
    }

    /**
     * Gets the value of the descripcion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets the value of the descripcion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Gets the value of the fechaFin property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFechaFin() {
        return fechaFin;
    }

    /**
     * Sets the value of the fechaFin property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFechaFin(Long value) {
        this.fechaFin = value;
    }

    /**
     * Gets the value of the fechaInicio property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Sets the value of the fechaInicio property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFechaInicio(Long value) {
        this.fechaInicio = value;
    }

    /**
     * Gets the value of the grupos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the grupos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGrupos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Grupo }
     * 
     * 
     */
    public List<Grupo> getGrupos() {
        if (grupos == null) {
            grupos = new ArrayList<Grupo>();
        }
        return this.grupos;
    }

    /**
     * Gets the value of the gruposExclusivo property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isGruposExclusivo() {
        return gruposExclusivo;
    }

    /**
     * Sets the value of the gruposExclusivo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setGruposExclusivo(Boolean value) {
        this.gruposExclusivo = value;
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
     * Gets the value of the notas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the notas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNotas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Nota }
     * 
     * 
     */
    public List<Nota> getNotas() {
        if (notas == null) {
            notas = new ArrayList<Nota>();
        }
        return this.notas;
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

    /**
     * Gets the value of the tipoEscala property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoEscala() {
        return tipoEscala;
    }

    /**
     * Sets the value of the tipoEscala property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoEscala(String value) {
        this.tipoEscala = value;
    }

}

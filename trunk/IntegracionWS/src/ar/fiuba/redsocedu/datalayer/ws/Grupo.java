
package ar.fiuba.redsocedu.datalayer.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for grupo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="grupo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.datalayer.redsocedu.fiuba.ar/}returnedObject">
 *       &lt;sequence>
 *         &lt;element name="actividadId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="grupoId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="notas" type="{http://ws.datalayer.redsocedu.fiuba.ar/}nota" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="usuarios" type="{http://ws.datalayer.redsocedu.fiuba.ar/}usuario" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "grupo", propOrder = {
    "actividadId",
    "grupoId",
    "notas",
    "usuarios"
})
public class Grupo
    extends ReturnedObject
{

    protected Long actividadId;
    protected Long grupoId;
    @XmlElement(nillable = true)
    protected List<Nota> notas;
    @XmlElement(nillable = true)
    protected List<Usuario> usuarios;

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
     * Gets the value of the grupoId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getGrupoId() {
        return grupoId;
    }

    /**
     * Sets the value of the grupoId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setGrupoId(Long value) {
        this.grupoId = value;
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
     * Gets the value of the usuarios property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the usuarios property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsuarios().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Usuario }
     * 
     * 
     */
    public List<Usuario> getUsuarios() {
        if (usuarios == null) {
            usuarios = new ArrayList<Usuario>();
        }
        return this.usuarios;
    }

}

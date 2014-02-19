
package ar.fiuba.redsocedu.datalayer.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ambito complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ambito">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.datalayer.redsocedu.fiuba.ar/}returnedObject">
 *       &lt;sequence>
 *         &lt;element name="actividades" type="{http://ws.datalayer.redsocedu.fiuba.ar/}actividad" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ambitoId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="carteleras" type="{http://ws.datalayer.redsocedu.fiuba.ar/}cartelera" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="chats" type="{http://ws.datalayer.redsocedu.fiuba.ar/}chat" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="foros" type="{http://ws.datalayer.redsocedu.fiuba.ar/}foro" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="muros" type="{http://ws.datalayer.redsocedu.fiuba.ar/}muro" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="recursos" type="{http://ws.datalayer.redsocedu.fiuba.ar/}recurso" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="tablas" type="{http://ws.datalayer.redsocedu.fiuba.ar/}tabla" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="wikis" type="{http://ws.datalayer.redsocedu.fiuba.ar/}wiki" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ambito", propOrder = {
    "actividades",
    "ambitoId",
    "carteleras",
    "chats",
    "foros",
    "muros",
    "recursos",
    "tablas",
    "wikis"
})
public class Ambito
    extends ReturnedObject
{

    @XmlElement(nillable = true)
    protected List<Actividad> actividades;
    protected Long ambitoId;
    @XmlElement(nillable = true)
    protected List<Cartelera> carteleras;
    @XmlElement(nillable = true)
    protected List<Chat> chats;
    @XmlElement(nillable = true)
    protected List<Foro> foros;
    @XmlElement(nillable = true)
    protected List<Muro> muros;
    @XmlElement(nillable = true)
    protected List<Recurso> recursos;
    @XmlElement(nillable = true)
    protected List<Tabla> tablas;
    @XmlElement(nillable = true)
    protected List<Wiki> wikis;

    /**
     * Gets the value of the actividades property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the actividades property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActividades().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Actividad }
     * 
     * 
     */
    public List<Actividad> getActividades() {
        if (actividades == null) {
            actividades = new ArrayList<Actividad>();
        }
        return this.actividades;
    }

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
     * Gets the value of the carteleras property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the carteleras property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCarteleras().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Cartelera }
     * 
     * 
     */
    public List<Cartelera> getCarteleras() {
        if (carteleras == null) {
            carteleras = new ArrayList<Cartelera>();
        }
        return this.carteleras;
    }

    /**
     * Gets the value of the chats property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the chats property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChats().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Chat }
     * 
     * 
     */
    public List<Chat> getChats() {
        if (chats == null) {
            chats = new ArrayList<Chat>();
        }
        return this.chats;
    }

    /**
     * Gets the value of the foros property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the foros property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getForos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Foro }
     * 
     * 
     */
    public List<Foro> getForos() {
        if (foros == null) {
            foros = new ArrayList<Foro>();
        }
        return this.foros;
    }

    /**
     * Gets the value of the muros property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the muros property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMuros().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Muro }
     * 
     * 
     */
    public List<Muro> getMuros() {
        if (muros == null) {
            muros = new ArrayList<Muro>();
        }
        return this.muros;
    }

    /**
     * Gets the value of the recursos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recursos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecursos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Recurso }
     * 
     * 
     */
    public List<Recurso> getRecursos() {
        if (recursos == null) {
            recursos = new ArrayList<Recurso>();
        }
        return this.recursos;
    }

    /**
     * Gets the value of the tablas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tablas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTablas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Tabla }
     * 
     * 
     */
    public List<Tabla> getTablas() {
        if (tablas == null) {
            tablas = new ArrayList<Tabla>();
        }
        return this.tablas;
    }

    /**
     * Gets the value of the wikis property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wikis property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWikis().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Wiki }
     * 
     * 
     */
    public List<Wiki> getWikis() {
        if (wikis == null) {
            wikis = new ArrayList<Wiki>();
        }
        return this.wikis;
    }

}

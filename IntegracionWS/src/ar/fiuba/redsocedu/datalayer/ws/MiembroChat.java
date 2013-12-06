
package ar.fiuba.redsocedu.datalayer.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for miembroChat complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="miembroChat">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.datalayer.redsocedu.fiuba.ar/}returnedObject">
 *       &lt;sequence>
 *         &lt;element name="chats" type="{http://ws.datalayer.redsocedu.fiuba.ar/}chat" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="mensajesChat" type="{http://ws.datalayer.redsocedu.fiuba.ar/}mensajeChat" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "miembroChat", propOrder = {
    "chats",
    "estado",
    "mensajesChat",
    "nombre"
})
public class MiembroChat
    extends ReturnedObject
{

    @XmlElement(nillable = true)
    protected List<Chat> chats;
    protected boolean estado;
    @XmlElement(nillable = true)
    protected List<MensajeChat> mensajesChat;
    protected String nombre;

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
     * Gets the value of the estado property.
     * 
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * Sets the value of the estado property.
     * 
     */
    public void setEstado(boolean value) {
        this.estado = value;
    }

    /**
     * Gets the value of the mensajesChat property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mensajesChat property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMensajesChat().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MensajeChat }
     * 
     * 
     */
    public List<MensajeChat> getMensajesChat() {
        if (mensajesChat == null) {
            mensajesChat = new ArrayList<MensajeChat>();
        }
        return this.mensajesChat;
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

}

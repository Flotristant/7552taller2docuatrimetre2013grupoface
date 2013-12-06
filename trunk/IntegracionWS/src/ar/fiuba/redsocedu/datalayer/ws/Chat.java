
package ar.fiuba.redsocedu.datalayer.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for chat complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="chat">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.datalayer.redsocedu.fiuba.ar/}returnedObject">
 *       &lt;sequence>
 *         &lt;element name="mensajesChat" type="{http://ws.datalayer.redsocedu.fiuba.ar/}mensajeChat" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="miembrosChat" type="{http://ws.datalayer.redsocedu.fiuba.ar/}miembroChat" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "chat", propOrder = {
    "mensajesChat",
    "miembrosChat"
})
public class Chat
    extends ReturnedObject
{

    @XmlElement(nillable = true)
    protected List<MensajeChat> mensajesChat;
    @XmlElement(nillable = true)
    protected List<MiembroChat> miembrosChat;

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
     * Gets the value of the miembrosChat property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the miembrosChat property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMiembrosChat().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MiembroChat }
     * 
     * 
     */
    public List<MiembroChat> getMiembrosChat() {
        if (miembrosChat == null) {
            miembrosChat = new ArrayList<MiembroChat>();
        }
        return this.miembrosChat;
    }

}


package ar.fiuba.redsocedu.datalayer.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for mensajeChat complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="mensajeChat">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.datalayer.redsocedu.fiuba.ar/}returnedObject">
 *       &lt;sequence>
 *         &lt;element name="chat" type="{http://ws.datalayer.redsocedu.fiuba.ar/}chat" minOccurs="0"/>
 *         &lt;element name="chatId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="contenido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mensajeChatId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="miembroChat" type="{http://ws.datalayer.redsocedu.fiuba.ar/}miembroChat" minOccurs="0"/>
 *         &lt;element name="miembroChatId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mensajeChat", propOrder = {
    "chat",
    "chatId",
    "contenido",
    "mensajeChatId",
    "miembroChat",
    "miembroChatId",
    "fecha"
})
public class MensajeChat
    extends ReturnedObject
{

    protected Chat chat;
    protected Long chatId;
    protected String contenido;
    protected Long mensajeChatId;
    protected MiembroChat miembroChat;
    protected Long miembroChatId;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecha;

    /**
     * Gets the value of the chat property.
     * 
     * @return
     *     possible object is
     *     {@link Chat }
     *     
     */
    public Chat getChat() {
        return chat;
    }

    /**
     * Sets the value of the chat property.
     * 
     * @param value
     *     allowed object is
     *     {@link Chat }
     *     
     */
    public void setChat(Chat value) {
        this.chat = value;
    }

    /**
     * Gets the value of the chatId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getChatId() {
        return chatId;
    }

    /**
     * Sets the value of the chatId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setChatId(Long value) {
        this.chatId = value;
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
     * Gets the value of the mensajeChatId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMensajeChatId() {
        return mensajeChatId;
    }

    /**
     * Sets the value of the mensajeChatId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMensajeChatId(Long value) {
        this.mensajeChatId = value;
    }

    /**
     * Gets the value of the miembroChat property.
     * 
     * @return
     *     possible object is
     *     {@link MiembroChat }
     *     
     */
    public MiembroChat getMiembroChat() {
        return miembroChat;
    }

    /**
     * Sets the value of the miembroChat property.
     * 
     * @param value
     *     allowed object is
     *     {@link MiembroChat }
     *     
     */
    public void setMiembroChat(MiembroChat value) {
        this.miembroChat = value;
    }

    /**
     * Gets the value of the miembroChatId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMiembroChatId() {
        return miembroChatId;
    }

    /**
     * Sets the value of the miembroChatId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMiembroChatId(Long value) {
        this.miembroChatId = value;
    }

    /**
     * Gets the value of the fecha property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFecha() {
        return fecha;
    }

    /**
     * Sets the value of the fecha property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecha(XMLGregorianCalendar value) {
        this.fecha = value;
    }

}

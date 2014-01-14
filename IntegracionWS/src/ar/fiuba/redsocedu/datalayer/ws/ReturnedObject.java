
package ar.fiuba.redsocedu.datalayer.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for returnedObject complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="returnedObject">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "returnedObject", propOrder = {
    "id"
})
@XmlSeeAlso({
    SeccionArticulo.class,
    Noticia.class,
    MensajeChat.class,
    Nota.class,
    Celda.class,
    Campo.class,
    Encuesta.class,
    Usuario.class,
    Actividad.class,
    Link.class,
    Evento.class,
    Chat.class,
    Seccion.class,
    Alumno.class,
    Fila.class,
    Muro.class,
    Wiki.class,
    Recurso.class,
    Subforo.class,
    EncuestaRespondida.class,
    Grupo.class,
    Articulo.class,
    Cartelera.class,
    Foro.class,
    Tema.class,
    Mensaje.class,
    MiembroChat.class,
    Ambito.class,
    Tabla.class,
    Curso.class,
    Archivo.class
})
public class ReturnedObject {

    protected Long id;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

}

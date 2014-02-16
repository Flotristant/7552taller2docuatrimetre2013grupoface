
package ar.fiuba.redsocedu.datalayer.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dataErrorCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="dataErrorCode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NO_ERROR"/>
 *     &lt;enumeration value="INPUT_ERROR"/>
 *     &lt;enumeration value="HIBERNATE_ERROR"/>
 *     &lt;enumeration value="INTERNAL_ERROR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "dataErrorCode")
@XmlEnum
public enum DataErrorCode {

    NO_ERROR,
    INPUT_ERROR,
    HIBERNATE_ERROR,
    INTERNAL_ERROR;

    public String value() {
        return name();
    }

    public static DataErrorCode fromValue(String v) {
        return valueOf(v);
    }

}

package com.baymax.baymax.utils.jaxb;

import org.eclipse.persistence.jaxb.JAXBContextProperties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: EricQiu
 * Date: 5/15/15
 * Time: 6:10 PM
 */
public class JaxbMarshaller {
    public static UserJasonObject marshalUser(InputStream input) throws JAXBException {
        Map<String, Object> properties = new HashMap<String, Object>(1);
        properties.put(JAXBContextProperties.MEDIA_TYPE, "application/json");
        JAXBContext jc = JAXBContext.newInstance(UserJasonObject.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        UserJasonObject user = (UserJasonObject) unmarshaller.unmarshal(input);
        return user;
    }
}

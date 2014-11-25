package org.openmrs.module.muzimamedia;

import com.sun.xml.internal.ws.api.PropertySet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by vikas on 20/11/14.
 */
@Component
public class MuzimaMediaConstants {

    public static String PROPERTY_MEDIA_PATH = "muzima_media_path";
    public static String MEDIA_PATH ;

    public MuzimaMediaConstants() throws IOException {
        Properties properties = new Properties();
        properties.load(MuzimaMediaConstants.class.getClassLoader().getResourceAsStream("constants.properties"));
        MuzimaMediaConstants.MEDIA_PATH = properties.getProperty(PROPERTY_MEDIA_PATH);
    }

}

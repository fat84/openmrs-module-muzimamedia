package org.openmrs.module.muzimamedia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * Created by vikas on 20/11/14.
 */
@Component
public class MuzimaMediaConstants {

    //@Value("${muzima_media_path}")
    public static String MEDIA_PATH = "./tomcat/webapps/openmrs-standalone/WEB-INF/view/module/muzimamedia/resources/media/";

}

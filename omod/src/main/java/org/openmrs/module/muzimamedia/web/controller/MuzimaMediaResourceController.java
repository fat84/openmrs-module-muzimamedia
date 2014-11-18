package org.openmrs.module.muzimamedia.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.module.muzimamedia.MuzimaConstants;
import org.openmrs.module.webservices.rest.web.v1_0.controller.MainResourceController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by vikas on 17/11/14.
 */
@Controller
@RequestMapping(MuzimaConstants.BASE_REQUEST_MAPPING)
public class MuzimaMediaResourceController extends MainResourceController {
    private static final Log log = LogFactory.getLog(MuzimaMediaResourceController.class);

    @Override
    public String getNamespace() {
        return MuzimaConstants.MUZIMA_NAMESPACE;
    }
}

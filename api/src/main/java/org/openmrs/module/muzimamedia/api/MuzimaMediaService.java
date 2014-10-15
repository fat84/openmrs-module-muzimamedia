package org.openmrs.module.muzimamedia.api;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.muzimamedia.MuzimaMedia;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vikas on 15/10/14.
 */
public interface MuzimaMediaService extends OpenmrsService {
    @Transactional
    MuzimaMedia save(MuzimaMedia media) throws Exception;
}

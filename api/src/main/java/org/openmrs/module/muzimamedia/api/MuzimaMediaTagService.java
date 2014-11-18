package org.openmrs.module.muzimamedia.api;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.muzimamedia.MuzimaMediaTag;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vikas on 17/11/14.
 */
public interface MuzimaMediaTagService  extends OpenmrsService  {
    @Transactional(readOnly = true)
    public List<MuzimaMediaTag> getAll();

    @Transactional
    public MuzimaMediaTag add(String name);
}

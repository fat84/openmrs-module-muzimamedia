package org.openmrs.module.muzimamedia.api;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.muzimamedia.MuzimaMediaType;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vikas on 19/11/14.
 */
public interface MuzimaMediaTypeService extends OpenmrsService {
    @Transactional(readOnly = true)
    public List<MuzimaMediaType> getAll();

    @Transactional
    public MuzimaMediaType add(String name);
}
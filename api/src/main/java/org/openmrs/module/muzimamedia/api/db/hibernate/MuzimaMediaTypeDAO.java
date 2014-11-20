package org.openmrs.module.muzimamedia.api.db.hibernate;

import org.openmrs.module.muzimamedia.MuzimaMediaType;

import java.util.List;

/**
 * Created by vikas on 19/11/14.
 */
public interface MuzimaMediaTypeDAO {
    List<MuzimaMediaType> getAll();
    public MuzimaMediaType findByName(String name);
}

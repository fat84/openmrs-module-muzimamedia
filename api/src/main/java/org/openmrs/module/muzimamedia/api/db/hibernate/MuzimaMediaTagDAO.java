package org.openmrs.module.muzimamedia.api.db.hibernate;

import org.openmrs.module.muzimamedia.MuzimaMediaTag;

import java.util.List;

/**
 * Created by vikas on 17/11/14.
 */
public interface MuzimaMediaTagDAO {

    List<MuzimaMediaTag> getAll();
    void save(MuzimaMediaTag tag);
}

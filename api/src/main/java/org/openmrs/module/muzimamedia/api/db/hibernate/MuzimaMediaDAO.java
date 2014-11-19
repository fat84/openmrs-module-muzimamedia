package org.openmrs.module.muzimamedia.api.db.hibernate;

import org.openmrs.module.muzimamedia.MuzimaMedia;

import java.util.List;

/**
 * Created by vikas on 15/10/14.
 */
public interface MuzimaMediaDAO {

    public List<MuzimaMedia> getAll();
    public void saveMedia(MuzimaMedia media);
    public MuzimaMedia findById(Integer id);
    public MuzimaMedia findByUuid(String uuid);
    void saveForm(MuzimaMedia form);
}

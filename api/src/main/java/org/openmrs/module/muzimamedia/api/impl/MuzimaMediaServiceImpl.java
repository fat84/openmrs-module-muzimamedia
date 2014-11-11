package org.openmrs.module.muzimamedia.api.impl;

import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.muzimamedia.MuzimaMedia;
import org.openmrs.module.muzimamedia.api.MuzimaMediaService;
import org.openmrs.module.muzimamedia.api.db.hibernate.MuzimaMediaDAO;

/**
 * Created by vikas on 15/10/14.
 */
public class MuzimaMediaServiceImpl extends BaseOpenmrsService implements MuzimaMediaService{

    private MuzimaMediaDAO dao;

    public MuzimaMediaServiceImpl(MuzimaMediaDAO dao){
        this.dao = dao;
    }
    @Override
    public MuzimaMedia save(MuzimaMedia media) throws Exception {
        dao.saveMedia(media);
        return media;
    }
}

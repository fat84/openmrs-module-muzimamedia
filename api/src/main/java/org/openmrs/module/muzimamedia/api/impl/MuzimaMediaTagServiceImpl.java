package org.openmrs.module.muzimamedia.api.impl;

import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.muzimamedia.MuzimaMediaTag;
import org.openmrs.module.muzimamedia.api.MuzimaMediaService;
import org.openmrs.module.muzimamedia.api.MuzimaMediaTagService;
import org.openmrs.module.muzimamedia.api.db.hibernate.MuzimaMediaTagDAO;

import java.util.List;

/**
 * Created by vikas on 17/11/14.
 */
public class MuzimaMediaTagServiceImpl extends BaseOpenmrsService implements MuzimaMediaTagService {
    private MuzimaMediaTagDAO dao;

    public MuzimaMediaTagServiceImpl(MuzimaMediaTagDAO dao) {
        this.dao = dao;
    }

    public List<MuzimaMediaTag> getAll() {
        return dao.getAll();
    }

    public MuzimaMediaTag add(String name) {
        MuzimaMediaTag tag = new MuzimaMediaTag(name);
        dao.save(tag);
        return tag;
    }
}

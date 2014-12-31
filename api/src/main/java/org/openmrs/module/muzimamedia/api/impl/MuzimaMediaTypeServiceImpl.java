package org.openmrs.module.muzimamedia.api.impl;

import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.muzimamedia.MuzimaMediaType;
import org.openmrs.module.muzimamedia.api.MuzimaMediaTypeService;
import org.openmrs.module.muzimamedia.api.db.hibernate.MuzimaMediaTypeDAO;

import java.util.List;

/**
 * Created by vikas on 19/11/14.
 */
public class MuzimaMediaTypeServiceImpl extends BaseOpenmrsService implements MuzimaMediaTypeService {

    private MuzimaMediaTypeDAO muzimaMediaTypeDAO;

    public MuzimaMediaTypeServiceImpl(MuzimaMediaTypeDAO muzimaMediaTypeDAO){
        this.muzimaMediaTypeDAO = muzimaMediaTypeDAO;
    }
    @Override
    public List<MuzimaMediaType> getAll() {
        return null;
    }
    @Override
    public MuzimaMediaType add(String name) {
        return null;
    }

    @Override
    public MuzimaMediaType findById(Integer id) {
        return muzimaMediaTypeDAO.findById(id);
    }
}

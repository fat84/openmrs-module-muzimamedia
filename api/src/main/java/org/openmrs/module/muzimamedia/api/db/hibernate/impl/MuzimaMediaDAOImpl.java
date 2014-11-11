package org.openmrs.module.muzimamedia.api.db.hibernate.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.openmrs.module.muzimamedia.MuzimaMedia;
import org.openmrs.module.muzimamedia.api.db.hibernate.MuzimaMediaDAO;

import java.util.List;

/**
 * Created by vikas on 15/10/14.
 */
public class MuzimaMediaDAOImpl implements MuzimaMediaDAO {

    private SessionFactory factory;

    @Override
    public List<MuzimaMedia> getAll() {
        return null;
    }

    @Override
    public void saveMedia(MuzimaMedia media) {
     session().saveOrUpdate(media);
    }

    private Session session() {
        return factory.getCurrentSession();
    }
}

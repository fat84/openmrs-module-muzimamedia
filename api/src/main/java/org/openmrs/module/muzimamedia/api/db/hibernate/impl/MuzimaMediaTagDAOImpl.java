package org.openmrs.module.muzimamedia.api.db.hibernate.impl;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.openmrs.module.muzimamedia.MuzimaMediaTag;
import org.openmrs.module.muzimamedia.api.db.hibernate.MuzimaMediaTagDAO;

import java.util.List;

/**
 * Created by vikas on 17/11/14.
 */
public class MuzimaMediaTagDAOImpl implements MuzimaMediaTagDAO {

    private SessionFactory factory;

    public MuzimaMediaTagDAOImpl(SessionFactory factory){
        this.factory = factory;
    }
    public List<MuzimaMediaTag> getAll() {
        return (List<MuzimaMediaTag>) session().createCriteria(MuzimaMediaTag.class).list();
    }
    public void save(MuzimaMediaTag tag) {
        session().save(tag);
    }
    private Session session() {
        return factory.getCurrentSession();
    }
}

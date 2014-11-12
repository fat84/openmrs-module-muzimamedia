package org.openmrs.module.muzimamedia.api.db.hibernate.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.openmrs.module.muzimamedia.MuzimaMedia;
import org.openmrs.module.muzimamedia.api.db.hibernate.MuzimaMediaDAO;

import java.util.List;

/**
 * Created by vikas on 15/10/14.
 */
public class MuzimaMediaDAOImpl implements MuzimaMediaDAO {

    private SessionFactory factory;

    public MuzimaMediaDAOImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<MuzimaMedia> getAll() {
        Criteria criteria = session().createCriteria(MuzimaMedia.class);
        //criteria.add(Restrictions.eq("voided", false));
        return criteria.list();
    }

    @Override
    public void saveMedia(MuzimaMedia media) {
     session().saveOrUpdate(media);
    }

    @Override
    public MuzimaMedia findById(Integer id) {
        return (MuzimaMedia) session().get(MuzimaMedia.class, id);
    }

    private Session session() {
        return factory.getCurrentSession();
    }
}

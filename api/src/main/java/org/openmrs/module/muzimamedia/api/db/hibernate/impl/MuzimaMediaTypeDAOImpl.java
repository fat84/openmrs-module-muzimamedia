package org.openmrs.module.muzimamedia.api.db.hibernate.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.openmrs.module.muzimamedia.MuzimaMediaType;
import org.openmrs.module.muzimamedia.api.db.hibernate.MuzimaMediaTypeDAO;

import java.util.List;

/**
 * Created by vikas on 19/11/14.
 */
public class MuzimaMediaTypeDAOImpl implements MuzimaMediaTypeDAO {

    private SessionFactory factory;

    public MuzimaMediaTypeDAOImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<MuzimaMediaType> getAll() {
        Criteria criteria = session().createCriteria(MuzimaMediaType.class);
        //criteria.add(Restrictions.eq("voided", false));
        return criteria.list();
    }

    @Override
    public MuzimaMediaType findByName(String name) {
        return (MuzimaMediaType) session().createQuery("from MuzimaMediaType type where type.name = '" + name + "'").uniqueResult();
    }

    private Session session() {
        return factory.getCurrentSession();
    }
}

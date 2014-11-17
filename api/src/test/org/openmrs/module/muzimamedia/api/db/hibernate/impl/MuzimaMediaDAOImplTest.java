package org.openmrs.module.muzimamedia.api.db.hibernate.impl;

import org.junit.Before;
import org.junit.Test;
import org.openmrs.api.context.Context;
import org.openmrs.module.muzimamedia.MuzimaMedia;
import org.openmrs.module.muzimamedia.api.MuzimaMediaBuilder;
import org.openmrs.module.muzimamedia.api.db.hibernate.MuzimaMediaDAO;
import org.openmrs.test.BaseModuleContextSensitiveTest;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.hasItem;

public class MuzimaMediaDAOImplTest extends BaseModuleContextSensitiveTest {

    private MuzimaMediaDAO dao;

    @Before
    public void setUpDao() throws Exception {
        dao = (MuzimaMediaDAO) applicationContext.getBean("muzimaMediaDAO");
        executeDataSet("mediaTestData.xml");
    }

    @Test
    public void getAllShouldGetAllForms() throws Exception {
        List<MuzimaMedia> list = dao.getAll();
        assertThat(list.size(), is(2));
        assertThat(list, hasItem(MuzimaMediaBuilder.muzimaMedia()
                .withId(1)
                .withTitle("Test Video 1")
                .withVersion("1.0")
                .withDescription("Test Video 1 Description")
                .withURL("")
                .instance()));
        assertThat(list, hasItem(MuzimaMediaBuilder.muzimaMedia()
                .withId(2)
                .withTitle("Test Video 2")
                .withVersion("1.0")
                .withDescription("Test Video 2 Description")
                .withURL("")
                .instance()));
    }

    @Test
    public void findByIdShouldFindById() {
        MuzimaMedia muzimaMedia = dao.findById(1);
        assertThat(muzimaMedia, is(MuzimaMediaBuilder.muzimaMedia()
                .withId(1)
                .instance()));
    }

    @Test
    public void saveMediaShouldSaveMedia() {
        dao.saveMedia(MuzimaMediaBuilder.muzimaMedia()
                .withId(1)
                .withTitle("Muzima media demo 1")
                .withVersion("1.0")
                .withDescription("Muzima media demo 1 description")
                .withURL("/tmp")
                .instance());
        List<MuzimaMedia> list = dao.getAll();
        assertThat(list, hasItem(MuzimaMediaBuilder.muzimaMedia().withId(1).withTitle("Muzima media demo 1")
                .withVersion("1.0")
                .withDescription("Muzima media demo 1 description")
                .withURL("/tmp").instance()));
    }
}
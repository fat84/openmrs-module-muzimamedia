package org.openmrs.module.muzimamedia.api.impl;

import org.junit.Before;
import org.junit.Test;
import org.openmrs.module.muzimamedia.MuzimaMedia;
import org.openmrs.module.muzimamedia.api.MuzimaMediaBuilder;
import org.openmrs.module.muzimamedia.api.MuzimaMediaService;
import org.openmrs.module.muzimamedia.api.db.hibernate.MuzimaMediaDAO;
import org.openmrs.test.BaseModuleContextSensitiveTest;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MuzimaMediaServiceImplTest extends BaseModuleContextSensitiveTest {

    private MuzimaMediaService muzimaMediaService;
    private MuzimaMediaDAO muzimaMediaDAO;

    @Before
    public void setUp() throws Exception {
        muzimaMediaDAO = mock(MuzimaMediaDAO.class);
        muzimaMediaService = new MuzimaMediaServiceImpl(muzimaMediaDAO);
    }

    void setUpDao() {
        List<MuzimaMedia> muzimaForms = new ArrayList<MuzimaMedia>();
        muzimaForms.add(
                MuzimaMediaBuilder.muzimaMedia()
                        .withId(1)
                        .withTitle("Test Video 1")
                        .withVersion("1.0")
                        .withDescription("Test Video 1 Description")
                        .withURL("")
                        .instance());
        muzimaForms.add(MuzimaMediaBuilder.muzimaMedia()
                .withId(2)
                .withTitle("Test Video 2")
                .withVersion("1.0")
                .withDescription("Test Video 2 Description")
                .withURL("")
                .instance());

        when(muzimaMediaDAO.getAll()).thenReturn(muzimaForms);
    }

    @Test
    public void getAllShouldGetAllMedia() throws Exception {
        setUpDao();
        List<MuzimaMedia> list = muzimaMediaService.getAll();
        assertThat(list.size(), is(2));
        verify(muzimaMediaDAO, times(1)).getAll();
    }

    @Test
    public void findByIdShouldFindMediaById() {
        muzimaMediaService.findById(1);
        verify(muzimaMediaDAO, times(1)).findById(1);
    }

    @Test
    public void saveShouldSaveMedia() throws Exception {
        MuzimaMedia muzimaMedia = MuzimaMediaBuilder.muzimaMedia().withId(123).instance();
        muzimaMediaService.saveMedia(muzimaMedia);
        verify(muzimaMediaDAO, times(1)).saveMedia(muzimaMedia);
    }
}
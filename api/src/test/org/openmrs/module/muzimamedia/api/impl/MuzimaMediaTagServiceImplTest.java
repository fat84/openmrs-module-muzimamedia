package org.openmrs.module.muzimamedia.api.impl;

import org.junit.Before;
import org.junit.Test;
import org.openmrs.api.context.Context;
import org.openmrs.module.muzimamedia.MuzimaMediaTag;
import org.openmrs.module.muzimamedia.api.MuzimaMediaTagBuilder;
import org.openmrs.module.muzimamedia.api.MuzimaMediaTagService;
import org.openmrs.test.BaseModuleContextSensitiveTest;

import java.util.Collection;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by vikas on 17/11/14.
 */
public class MuzimaMediaTagServiceImplTest extends BaseModuleContextSensitiveTest {

    private MuzimaMediaTagService service;

    @Before
    public void setUp() throws Exception {
        service = Context.getService(MuzimaMediaTagService.class);
        executeDataSet("TagTestData.xml");
    }

    @Test
    public void getAll_shouldGetAllTags() throws Exception {
        Collection<MuzimaMediaTag> list = service.getAll();
        assertThat(list.contains(MuzimaMediaTagBuilder.tag().withId(1).withName("Video 1").instance()), is(true));
        assertThat(list.contains(MuzimaMediaTagBuilder.tag().withId(2).withName("Video 2").instance()), is(true));
        assertThat(list.contains(MuzimaMediaTagBuilder.tag().withId(3).withName("Video 3").instance()), is(true));
        assertThat(list.contains(MuzimaMediaTagBuilder.tag().withId(4).withName("Video 4").instance()), is(true));
    }

    @Test
    public void add_shouldAddTag() throws Exception {
        MuzimaMediaTag tag = service.add("Video 5");
        assertThat(tag.getId(), notNullValue());
        Collection<MuzimaMediaTag> list = service.getAll();
        assertThat(list.contains(MuzimaMediaTagBuilder.tag().withId(tag.getId()).withName("Video 5").instance()), is(true));
    }


}

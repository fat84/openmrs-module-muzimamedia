package org.openmrs.module.muzimamedia.api;

import org.openmrs.module.muzimamedia.MuzimaMediaTag;

/**
 * Created by vikas on 17/11/14.
 */
public class MuzimaMediaTagBuilder extends Builder<MuzimaMediaTag> {
    private Integer id;
    private String name;

    private MuzimaMediaTagBuilder() {
    }

    @Override
    public MuzimaMediaTag instance() {
        MuzimaMediaTag tag = new MuzimaMediaTag(name);
        tag.setId(id);
        return tag;
    }

    public static MuzimaMediaTagBuilder tag() {
        return new MuzimaMediaTagBuilder();
    }


    public MuzimaMediaTagBuilder withId(Integer id) {
        this.id = id;
        return this;
    }

    public MuzimaMediaTagBuilder withName(String name) {
        this.name = name;
        return this;
    }
}
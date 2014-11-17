package org.openmrs.module.muzimamedia.api;

import org.openmrs.module.muzimamedia.MuzimaMedia;

/**
 * Created by shwethathammaiah on 11/11/14.
 */
public class MuzimaMediaBuilder extends Builder<MuzimaMedia> {

    private Integer id;
    private String title;
    private String description;
    private String version;
    private String url;

    private MuzimaMediaBuilder(){

    }

    @Override
    public MuzimaMedia instance() {
        MuzimaMedia muzimaMedia = new MuzimaMedia();
        muzimaMedia.setId(id);
        muzimaMedia.setTitle(title);
        muzimaMedia.setDescription(description);
        muzimaMedia.setVersion(version);
        muzimaMedia.setUrl(url);
        return muzimaMedia;
    }

    public static MuzimaMediaBuilder muzimaMedia() {
        return new MuzimaMediaBuilder();
    }


    public MuzimaMediaBuilder withId(Integer id) {
        this.id = id;
        return this;
    }


    public MuzimaMediaBuilder withTitle(String title) {
        this.title = title;
        return this;
    }


    public MuzimaMediaBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public MuzimaMediaBuilder withVersion(String version) {
        this.version = version;
        return this;
    }

    public MuzimaMediaBuilder withURL(String url) {
        this.url = url;
        return this;
    }

}

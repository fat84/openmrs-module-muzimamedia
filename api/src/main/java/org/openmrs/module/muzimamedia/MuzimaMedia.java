package org.openmrs.module.muzimamedia;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.openmrs.BaseOpenmrsData;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by vikas on 15/10/14.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class MuzimaMedia extends BaseOpenmrsData{
    private Integer id;
    private String title;
    private String description;
    private String version;
    private String url;
    private Set<MuzimaMediaTag> tags = new HashSet<MuzimaMediaTag>();

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result;
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        return result;
    }


    public MuzimaMedia(){
    }
    public MuzimaMedia(String title, String description, String version, String url){

        if (getUuid()==null) {
            setUuid(UUID.randomUUID().toString());
        }

        this.title = title;
        this.description = description;
        this.version = version;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MuzimaMedia muzimaMedia = (MuzimaMedia) o;
        if (tags != null ? !tags.equals(muzimaMedia.tags) : muzimaMedia.tags != null) return false;
        return this.getId().equals(muzimaMedia.getId());
    }

    @Override
    public String toString() {
        return "MuzimaMedia{" +
                "id=" + id +
                ", uuid=" + getUuid() +
                ", title='" + getTitle() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", version='" + getVersion() + '\'' +
                ", url='" + getUrl() + '\'' +
                ", voided='" + getVoided() + '\'' +
                ", tags=" + tags +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<MuzimaMediaTag> getTags() {
        return tags;
    }

    public void setTags(Set<MuzimaMediaTag> tags) {
        this.tags = tags;
    }
}

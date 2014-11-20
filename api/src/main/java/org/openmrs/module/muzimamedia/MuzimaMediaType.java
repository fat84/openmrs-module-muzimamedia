package org.openmrs.module.muzimamedia;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.openmrs.BaseOpenmrsData;

/**
 * Created by vikas on 19/11/14.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class MuzimaMediaType extends BaseOpenmrsData {

    public enum Type {
        VIDEO, IMAGE, AUDIO
    }
    private Integer id;
    private String name;

    public MuzimaMediaType() {
    } // Used by hibernate

    public MuzimaMediaType(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MuzimaMediaType mediaType = (MuzimaMediaType) o;

        if (id != null ? !id.equals(mediaType.id) : mediaType.id != null) return false;
        if (name != null ? !name.equals(mediaType.name) : mediaType.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MuzimaMediaType{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                '}';
    }
}

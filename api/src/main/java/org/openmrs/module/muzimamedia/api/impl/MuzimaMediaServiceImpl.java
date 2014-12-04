package org.openmrs.module.muzimamedia.api.impl;

import org.dom4j.DocumentException;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.muzimamedia.MuzimaMedia;
import org.openmrs.module.muzimamedia.MuzimaMediaConstants;
import org.openmrs.module.muzimamedia.MuzimaMediaTag;
import org.openmrs.module.muzimamedia.MuzimaMediaType;
import org.openmrs.module.muzimamedia.api.MuzimaMediaService;
import org.openmrs.module.muzimamedia.api.db.hibernate.MuzimaMediaDAO;
import org.openmrs.module.muzimamedia.api.db.hibernate.MuzimaMediaTypeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import javax.lang.model.type.UnknownTypeException;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by vikas on 15/10/14.
 */
public class MuzimaMediaServiceImpl extends BaseOpenmrsService implements MuzimaMediaService{

    private MuzimaMediaDAO dao;
    private MuzimaMediaTypeDAO typeDAO;

    public MuzimaMediaServiceImpl(MuzimaMediaDAO dao, MuzimaMediaTypeDAO typeDAO){

        this.dao = dao;
        this.typeDAO = typeDAO;
    }

    @Override
    public MuzimaMedia saveMedia(MuzimaMedia media) throws Exception {
        dao.saveMedia(media);
        return media;
    }

    @Override
    public List<MuzimaMedia> getAll() {
        return  dao.getAll();
    }

    @Override
    public MuzimaMedia findById(Integer id) {
        return dao.findById(id);
    }

    public MuzimaMedia uploadVideo(MultipartFile videoFile, String title, String description, String version, String tags) throws Exception {
        if(!mediaWithThisVersionAndTitleExists(title,version)) {
            if(videoFile == null)
                throw new DocumentException("Please select Media file");
            String fileName =  getFileName()+ getFileExtension(videoFile);
            String filePath = MuzimaMediaConstants.MEDIA_PATH +fileName;
            int mediaTypeId = getMediaType(videoFile);

            MuzimaMedia muzimaMedia = new MuzimaMedia(title,description,version, fileName, mediaTypeId, getTags(tags));
            videoFile.transferTo(new File(filePath));
            return saveMedia(muzimaMedia);
        }
            throw new DocumentException("Media with this title and version already exists!");
    }
    private Set<MuzimaMediaTag> getTags(String tags){
        Set<MuzimaMediaTag> muzimaMediaTags = new HashSet<MuzimaMediaTag>();
        if(!tags.isEmpty()){
            for (String tag : tags.split(","))
            {
                MuzimaMediaTag muzimaMediaTag = new MuzimaMediaTag();
                muzimaMediaTag.setName(tag);
                muzimaMediaTags.add(muzimaMediaTag);
            }
        }
        return muzimaMediaTags;
    }
    private boolean mediaWithThisVersionAndTitleExists(String title, String version) {
        MuzimaMedia muzimaMedia = dao.findByVersionAndTitle(title, version);
        if (muzimaMedia != null)
            return true;
        else
            return false;
    }

    public String getFileExtension(MultipartFile file){

        return "."+file.getOriginalFilename().split("\\.")[1];
    }
    public String getFileName()
    {
       return  UUID.randomUUID().toString();
    }

    public int getMediaType(MultipartFile file) throws Exception {

        MuzimaMediaType mediaType = new MuzimaMediaType();
        if (file.getContentType().toUpperCase().contains(MuzimaMediaType.Type.VIDEO.toString()))
            mediaType = typeDAO.findByName(MuzimaMediaType.Type.VIDEO.toString().toLowerCase());
        else if (file.getContentType().toUpperCase().contains(MuzimaMediaType.Type.IMAGE.toString()))
            mediaType = typeDAO.findByName(MuzimaMediaType.Type.IMAGE.toString().toLowerCase());
        else if (file.getContentType().toUpperCase().contains(MuzimaMediaType.Type.AUDIO.toString()))
            mediaType = typeDAO.findByName(MuzimaMediaType.Type.AUDIO.toString().toLowerCase());
        else throw new Exception("this media file is not valid");

        return mediaType.getId();
    }

    public MuzimaMedia findByUniqueId(String uuid) {
        return dao.findByUuid(uuid);
    }

    public MuzimaMedia save(MuzimaMedia media) throws Exception {
        dao.saveForm(media);
        return media;
    }

    @Override
    public MuzimaMedia UpdateVideo(MultipartFile videoFile, String uuid) throws Exception {
        MuzimaMedia muzimaMedia = dao.findByUuid(uuid);
        if(videoFile == null)
            throw new DocumentException("Please select Media file");
        String fileName =  getFileName()+ getFileExtension(videoFile);
        String filePath = MuzimaMediaConstants.MEDIA_PATH +fileName;
        videoFile.transferTo(new File(filePath));
        int mediaTypeId = getMediaType(videoFile);

        muzimaMedia.setUrl(fileName);
        muzimaMedia.setMuzimaMediaType(mediaTypeId);

        return saveMedia(muzimaMedia);
    }
}

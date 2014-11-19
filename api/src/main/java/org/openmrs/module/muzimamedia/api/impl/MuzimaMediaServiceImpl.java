package org.openmrs.module.muzimamedia.api.impl;

import org.openmrs.api.context.Context;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.muzimamedia.MuzimaMedia;
import org.openmrs.module.muzimamedia.api.MuzimaMediaService;
import org.openmrs.module.muzimamedia.api.db.hibernate.MuzimaMediaDAO;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import java.util.List;

/**
 * Created by vikas on 15/10/14.
 */
public class MuzimaMediaServiceImpl extends BaseOpenmrsService implements MuzimaMediaService{

    private String mediaPath = "./tomcat/webapps/openmrs-standalone/WEB-INF/view/module/muzimamedia/resources/media/";
    private MuzimaMediaDAO dao;

    public MuzimaMediaServiceImpl(MuzimaMediaDAO dao){
        this.dao = dao;
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

    public MuzimaMedia uploadVideo(MultipartFile videoFile, String title, String description, String version) throws Exception {

        String fileName =  getFileName()+ getFileExtension(videoFile);
        String filePath = this.mediaPath +fileName;
        MuzimaMedia muzimaMedia = new MuzimaMedia(title,description,version, fileName);
        videoFile.transferTo(new File(filePath));
        return saveMedia(muzimaMedia);
    }

    public String getFileExtension(MultipartFile file){

        return "."+file.getOriginalFilename().split("\\.")[1];
    }
    public String getFileName()
    {
       return  UUID.randomUUID().toString();

    }

    public MuzimaMedia findByUniqueId(String uuid) {
        return dao.findByUuid(uuid);
    }

    public MuzimaMedia save(MuzimaMedia media) throws Exception {
        dao.saveForm(media);
        return media;
    }
}

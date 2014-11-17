package org.openmrs.module.muzimamedia.api;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.muzimamedia.MuzimaMedia;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.util.List;

/**
 * Created by vikas on 15/10/14.
 */
public interface MuzimaMediaService extends OpenmrsService {
    @Transactional

    MuzimaMedia saveMedia(MuzimaMedia media) throws Exception;

    @Transactional(readOnly = true)
    List<MuzimaMedia> getAll();

    MuzimaMedia findById(Integer id);

    @Transactional
    MuzimaMedia uploadVideo(MultipartFile videoFile, String title, String Description, String version) throws Exception;

}

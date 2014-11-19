package org.openmrs.module.muzimamedia.web.controller;

import org.openmrs.api.context.Context;
import org.openmrs.module.muzimamedia.MuzimaMedia;
import org.openmrs.module.muzimamedia.api.MuzimaMediaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 * Created by vikas on 03/11/14.
 */
@Controller
@RequestMapping(value = "module/muzimamedia")
public class MuzimaMediaController {

    @ResponseBody
    @RequestMapping(value = "video/upload.form", method = RequestMethod.POST)
    public void uploadMedia(final MultipartHttpServletRequest request,
                               final @RequestParam String title,
                               final @RequestParam String description,
                               final @RequestParam String version) throws Exception {

        MuzimaMediaService muzimaMediaService = Context.getService(MuzimaMediaService.class);
        muzimaMediaService.uploadVideo(request.getFile("file"),title, description,version);
    }

    @ResponseBody
    @RequestMapping(value = "video/tag.form", method = RequestMethod.POST)
    public void saveTag( final @RequestBody MuzimaMedia media ) throws Exception {
        MuzimaMediaService muzimaMediaService = Context.getService(MuzimaMediaService.class);
        muzimaMediaService.saveMedia(media);
    }

    @ResponseBody
    @RequestMapping(value = "video/remove.form", method = RequestMethod.POST)
    public void removeMedia( final @RequestBody MuzimaMedia media ) throws Exception {
        MuzimaMediaService muzimaMediaService = Context.getService(MuzimaMediaService.class);
        muzimaMediaService.saveMedia(media);
    }

}

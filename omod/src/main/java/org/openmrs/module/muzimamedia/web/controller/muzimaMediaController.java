package org.openmrs.module.muzimamedia.web.controller;

import org.openmrs.api.context.Context;
import org.openmrs.module.muzimamedia.MuzimaMedia;
import org.openmrs.module.muzimamedia.api.MuzimaMediaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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

        MultipartFile file = request.getFile("file");


    }

    @ResponseBody
    @RequestMapping(value = "video/media.form", method = RequestMethod.GET)
    public List<MuzimaMedia> getMedia(final MultipartHttpServletRequest request) throws Exception {

        MuzimaMediaService muzimaMediaService = Context.getService(MuzimaMediaService.class);
        return muzimaMediaService.getAll();
    }
}
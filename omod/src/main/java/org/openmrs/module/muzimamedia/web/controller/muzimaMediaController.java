package org.openmrs.module.muzimamedia.web.controller;

import org.openmrs.api.context.Context;
import org.openmrs.module.muzimamedia.MuzimaMedia;
import org.openmrs.module.muzimamedia.api.MuzimaMediaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;

/**
 * Created by vikas on 03/11/14.
 */
@Controller
@RequestMapping(value = "module/muzimamedia")
public class muzimaMediaController {

    @ResponseBody
    @RequestMapping(value = "video/upload.form", method = RequestMethod.POST)
    public void uploadMedia(final MultipartHttpServletRequest request,
                               final @RequestParam String title,
                               final @RequestParam String description,
                               final @RequestParam String version) throws Exception {

        MultipartFile file = request.getFile("file");


    }
}

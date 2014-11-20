package org.openmrs.module.muzimamedia.resources;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.annotation.Handler;
import org.openmrs.api.context.Context;
import org.openmrs.module.muzimamedia.MuzimaConstants;
import org.openmrs.module.muzimamedia.MuzimaMedia;
import org.openmrs.module.muzimamedia.api.MuzimaMediaService;
import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.annotation.Resource;
import org.openmrs.module.webservices.rest.web.representation.CustomRepresentation;
import org.openmrs.module.webservices.rest.web.representation.DefaultRepresentation;
import org.openmrs.module.webservices.rest.web.representation.RefRepresentation;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.resource.impl.DataDelegatingCrudResource;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceDescription;
import org.openmrs.module.webservices.rest.web.resource.impl.NeedsPaging;
import org.openmrs.module.webservices.rest.web.response.ResourceDoesNotSupportOperationException;
import org.openmrs.module.webservices.rest.web.response.ResponseException;

import java.util.List;

/**
 * Created by vikas on 17/11/14.
 */
@Resource(name = RestConstants.VERSION_1 + "/" + MuzimaConstants.MODULE_ID + "/media",
        supportedClass = MuzimaMedia.class, supportedOpenmrsVersions = {"1.8.*", "1.9.*"})
@Handler(supports = MuzimaMedia.class)
public class MuzimaMediaResource extends DataDelegatingCrudResource<MuzimaMedia> {

    private static final Log log = LogFactory.getLog(MuzimaMediaResource.class);

    @Override
    protected NeedsPaging<MuzimaMedia> doGetAll(RequestContext context) throws ResponseException {
        MuzimaMediaService service = Context.getService(MuzimaMediaService.class);
        List<MuzimaMedia> all = service.getAll();
        return new NeedsPaging<MuzimaMedia>(all, context);
    }

    @Override
    public MuzimaMedia getByUniqueId(String uuid) {
        MuzimaMediaService service = Context.getService(MuzimaMediaService.class);
        return service.findByUniqueId(uuid);
    }

    @Override
    public Object retrieve(String uuid, RequestContext context) throws ResponseException {
        MuzimaMediaService service = Context.getService(MuzimaMediaService.class);
        return asRepresentation(service.findByUniqueId(uuid), context.getRepresentation());
    }

    @Override
    protected void delete(MuzimaMedia media, String s, RequestContext requestContext) throws ResponseException {
        throw new ResourceDoesNotSupportOperationException();
    }

    public MuzimaMedia newDelegate() {
        return new MuzimaMedia();
    }


    public MuzimaMedia save(MuzimaMedia media) {
        MuzimaMediaService service = Context.getService(MuzimaMediaService.class);
        try {
            return service.save(media);
        } catch (Exception e) {
            log.error(e);
        }
        return media;

    }

    @Override
    public void purge(MuzimaMedia media, RequestContext requestContext) throws ResponseException {
        throw new ResourceDoesNotSupportOperationException();
    }

    public DelegatingResourceDescription getRepresentationDescription(Representation rep) {
        DelegatingResourceDescription description = null;

        if (rep instanceof DefaultRepresentation || rep instanceof RefRepresentation) {
            description = new DelegatingResourceDescription();
            description.addProperty("uuid");
            description.addProperty("id");
            description.addProperty("title");
            description.addProperty("description");
            description.addProperty("version");
            description.addProperty("url");
            description.addProperty("voided");
            description.addProperty("muzimaMediaType");
            description.addProperty("tags", new CustomRepresentation("(id,uuid,name)"));
            description.addSelfLink();
        }
        return description;
    }
}


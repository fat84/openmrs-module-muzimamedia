package org.openmrs.module.muzimamedia.resources;

import org.openmrs.annotation.Handler;
import org.openmrs.api.context.Context;
import org.openmrs.module.muzimamedia.MuzimaConstants;
import org.openmrs.module.muzimamedia.MuzimaMedia;
import org.openmrs.module.muzimamedia.MuzimaMediaTag;
import org.openmrs.module.muzimamedia.api.MuzimaMediaTagService;
import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.annotation.Resource;
import org.openmrs.module.webservices.rest.web.representation.DefaultRepresentation;
import org.openmrs.module.webservices.rest.web.representation.RefRepresentation;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.resource.impl.DataDelegatingCrudResource;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceDescription;
import org.openmrs.module.webservices.rest.web.resource.impl.NeedsPaging;
import org.openmrs.module.webservices.rest.web.response.ResponseException;

/**
 * Created by vikas on 17/11/14.
 */
@Resource(name = RestConstants.VERSION_1 + "/" + MuzimaConstants.MODULE_ID + "/tag",
        supportedClass = MuzimaMedia.class, supportedOpenmrsVersions = {"1.8.*", "1.9.*"})
@Handler(supports = MuzimaMedia.class)
public class MuzimaMediaTagResource extends DataDelegatingCrudResource<MuzimaMediaTag> {

    @Override
    protected NeedsPaging<MuzimaMediaTag> doGetAll(RequestContext context) throws ResponseException {
        MuzimaMediaTagService service = Context.getService(MuzimaMediaTagService.class);
        return new NeedsPaging<MuzimaMediaTag>(service.getAll(), context);
    }

    @Override
    public MuzimaMediaTag getByUniqueId(String s) {
        return null;
    }

    @Override
    protected void delete(MuzimaMediaTag muzimaMediaTag, String s, RequestContext requestContext) throws ResponseException {

    }

    public MuzimaMediaTag newDelegate() {
        return new MuzimaMediaTag();
    }

    public MuzimaMediaTag save(MuzimaMediaTag muzimaMediaTag) {
        return null;
    }

    @Override
    public void purge(MuzimaMediaTag muzimaMediaTag, RequestContext requestContext) throws ResponseException {

    }

    public DelegatingResourceDescription getRepresentationDescription(Representation rep) {
        DelegatingResourceDescription description = null;
        if (rep instanceof RefRepresentation || rep instanceof DefaultRepresentation) {
            DelegatingResourceDescription description1 = new DelegatingResourceDescription();
            description1.addProperty("uuid");
            description1.addProperty("id");
            description1.addProperty("name");
            description = description1;
        }
        return description;
    }
}

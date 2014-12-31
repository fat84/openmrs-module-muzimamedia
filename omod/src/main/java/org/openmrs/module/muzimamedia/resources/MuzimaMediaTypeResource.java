package org.openmrs.module.muzimamedia.resources;

import org.openmrs.annotation.Handler;
import org.openmrs.api.context.Context;
import org.openmrs.module.muzimamedia.MuzimaConstants;
import org.openmrs.module.muzimamedia.MuzimaMediaTag;
import org.openmrs.module.muzimamedia.MuzimaMediaType;
import org.openmrs.module.muzimamedia.api.MuzimaMediaTagService;
import org.openmrs.module.muzimamedia.api.MuzimaMediaTypeService;
import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.annotation.Resource;
import org.openmrs.module.webservices.rest.web.representation.DefaultRepresentation;
import org.openmrs.module.webservices.rest.web.representation.RefRepresentation;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.resource.impl.DataDelegatingCrudResource;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceDescription;
import org.openmrs.module.webservices.rest.web.resource.impl.NeedsPaging;
import org.openmrs.module.webservices.rest.web.response.ResourceDoesNotSupportOperationException;
import org.openmrs.module.webservices.rest.web.response.ResponseException;

/**
 * Created by vikas on 15/12/14.
 */
@Resource(name = RestConstants.VERSION_1 + "/" + MuzimaConstants.MODULE_ID + "/type",
        supportedClass = MuzimaMediaType.class, supportedOpenmrsVersions = {"1.8.*", "1.9.*"})
@Handler(supports = MuzimaMediaType.class)
public class MuzimaMediaTypeResource extends DataDelegatingCrudResource<MuzimaMediaType> {

    @Override
    public MuzimaMediaType getByUniqueId(String s) {
        MuzimaMediaTypeService service = Context.getService(MuzimaMediaTypeService.class);
        return service.findById(Integer.parseInt(s));
    }

    @Override
    protected void delete(MuzimaMediaType muzimaMediaType, String s, RequestContext requestContext) throws ResponseException {
        throw new ResourceDoesNotSupportOperationException();
    }

    public MuzimaMediaType newDelegate() {
        return new MuzimaMediaType();
    }

    public MuzimaMediaType save(MuzimaMediaType muzimaMediaType) {
        throw new ResourceDoesNotSupportOperationException();
    }

    @Override
    public void purge(MuzimaMediaType muzimaMediaType, RequestContext requestContext) throws ResponseException {
        throw new ResourceDoesNotSupportOperationException();
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

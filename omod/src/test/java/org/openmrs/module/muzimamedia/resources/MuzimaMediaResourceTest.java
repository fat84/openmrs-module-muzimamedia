package org.openmrs.module.muzimamedia.resources;

import junit.framework.TestCase;
import org.dom4j.DocumentException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openmrs.api.context.Context;
import org.openmrs.module.muzimamedia.MuzimaMedia;
import org.openmrs.module.muzimamedia.api.MuzimaMediaService;
import org.openmrs.module.webservices.rest.SimpleObject;
import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.api.RestService;
import org.openmrs.module.webservices.rest.web.representation.CustomRepresentation;
import org.openmrs.module.webservices.rest.web.representation.DefaultRepresentation;
import org.openmrs.module.webservices.rest.web.representation.RefRepresentation;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.response.ResourceDoesNotSupportOperationException;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Context.class)
public class MuzimaMediaResourceTest extends TestCase{
    private MuzimaMediaService service;
    MuzimaMediaResource controller;

    @Before
    public void setUp() throws Exception {

        MuzimaMedia media = getMedia("foo");
        service = mock(MuzimaMediaService.class);
        when(service.findByUniqueId("foo")).thenReturn(media);
        controller = new MuzimaMediaResource();
        mockStatic(Context.class);
        PowerMockito.when(Context.getService(MuzimaMediaService.class)).thenReturn(service);

    }

    private MuzimaMedia getMedia(String uuid) {
        MuzimaMedia muzimamedia = new MuzimaMedia();
        muzimamedia.setId(uuid.hashCode());
        muzimamedia.setUuid(uuid);
        return muzimamedia;
    }

    @Test
    public void retrieve_shouldGetMuzimaMediaByUUID() {
        Representation representation = mock(CustomRepresentation.class);
        when(representation.getRepresentation()).thenReturn("(uuid:uuid,id:id)");
        RequestContext context = mock(RequestContext.class);
        when(context.getRepresentation()).thenReturn(representation);

        Object foo = controller.retrieve("foo", context);
        verify(service, times(1)).findByUniqueId("foo");
    }

    @Test(expected = ResourceDoesNotSupportOperationException.class)
    public void delete_notSupported() {
        controller.delete(getMedia(""), "", null);
    }

    @Test
    public void save_shouldDelegateToService() throws SAXException, DocumentException, TransformerException, IOException, XPathExpressionException, ParserConfigurationException {
        MuzimaMedia media = getMedia("");
        controller.save(media);
        try {
            verify(service, times(1)).save(media);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAll_shouldGetAllMedia() {
        Representation representation = mock(CustomRepresentation.class);
        RequestContext context = mock(RequestContext.class);

        RestService restService = mock(RestService.class);
        when(restService.getResourceBySupportedClass(MuzimaMediaResource.class)).thenReturn(null);
        PowerMockito.when(Context.getService(RestService.class)).thenReturn(restService);


        when(representation.getRepresentation()).thenReturn("(uuid:uuid,id:id)");
        when(context.getRepresentation()).thenReturn(representation);
        when(context.getStartIndex()).thenReturn(0);
        when(context.getLimit()).thenReturn(10);
        when(service.getAll()).thenReturn(getMuzimaMedia());

        SimpleObject response = controller.getAll(context);
        assertThat(response.containsKey("results"), is(true));
        List Media = (List) response.get("results");
        assertThat(Media.size(), is(3));
        verify(service, times(1)).getAll();
    }

    private ArrayList<MuzimaMedia> getMuzimaMedia() {
        ArrayList<MuzimaMedia> muzimaMedias = new ArrayList<MuzimaMedia>();
        muzimaMedias.add(getMedia("foo"));
        muzimaMedias.add(getMedia("bar"));
        muzimaMedias.add(getMedia("baz"));
        return muzimaMedias;
    }

    @Test
    public void getRepresentationDescription_shouldAddDefaultProperties() {
        Representation representation = mock(RefRepresentation.class);
        Set<String> keys = controller.getRepresentationDescription(representation).getProperties().keySet();
        assertThat(keys.contains("id"), is(true));
        assertThat(keys.contains("uuid"), is(true));
        assertThat(keys.contains("title"), is(true));
        assertThat(keys.contains("description"), is(true));
        assertThat(keys.contains("tags"), is(true));

        representation = mock(DefaultRepresentation.class);
        keys = controller.getRepresentationDescription(representation).getProperties().keySet();
        assertThat(keys.contains("id"), is(true));
        assertThat(keys.contains("uuid"), is(true));
        assertThat(keys.contains("title"), is(true));
        assertThat(keys.contains("description"), is(true));
        assertThat(keys.contains("tags"), is(true));
    }

}
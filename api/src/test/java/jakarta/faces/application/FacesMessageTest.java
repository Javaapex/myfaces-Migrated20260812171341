package jakarta.faces.application;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.application.FacesMessage.Severity;
import org.apache.myfaces.core.api.shared.lang.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FacesMessageTest {

    @Mock
    private Application application;

    @InjectMocks
    private FacesMessage facesMessage;

    @BeforeEach
    public void setup() {
        when(application.getMessageBundle()).thenReturn(new HashMap<>());
    }

    @Test
    public void testFacesMessageConstructor_NoArgs() {
        facesMessage = new FacesMessage();
        assertEquals(Severity.INFO, facesMessage.getSeverity());
        assertEquals("", facesMessage.getSummary());
        assertEquals(null, facesMessage.getDetail());
        assertEquals(false, facesMessage.isRendered());
    }

    @Test
    public void testFacesMessageConstructor_Summary() {
        facesMessage = new FacesMessage("Summary");
        assertEquals(Severity.INFO, facesMessage.getSeverity());
        assertEquals("Summary", facesMessage.getSummary());
        assertEquals(null, facesMessage.getDetail());
        assertEquals(false, facesMessage.isRendered());
    }

    @Test
    public void testFacesMessageConstructor_SummaryDetail() {
        facesMessage = new FacesMessage("Summary", "Detail");
        assertEquals(Severity.INFO, facesMessage.getSeverity());
        assertEquals("Summary", facesMessage.getSummary());
        assertEquals("Detail", facesMessage.getDetail());
        assertEquals(false, facesMessage.isRendered());
    }

    @Test
    public void testFacesMessageConstructor_SeveritySummaryDetail() {
        facesMessage = new FacesMessage(Severity.ERROR, "Summary", "Detail");
        assertEquals(Severity.ERROR, facesMessage.getSeverity());
        assertEquals("Summary", facesMessage.getSummary());
        assertEquals("Detail", facesMessage.getDetail());
        assertEquals(false, facesMessage.isRendered());
    }

    @Test
    public void testGetSeverity() {
        facesMessage = new FacesMessage(Severity.ERROR, "Summary", "Detail");
        assertEquals(Severity.ERROR, facesMessage.getSeverity());
    }

    @Test
    public void testSetSeverity() {
        facesMessage = new FacesMessage(Severity.INFO, "Summary", "Detail");
        facesMessage.setSeverity(Severity.ERROR);
        assertEquals(Severity.ERROR, facesMessage.getSeverity());
    }

    @Test
    public void testGetSummary() {
        facesMessage = new FacesMessage(Severity.INFO, "Summary", "Detail");
        assertEquals("Summary", facesMessage.getSummary());
    }

    @Test
    public void testSetSummary() {
        facesMessage = new FacesMessage(Severity.INFO, "Summary", "Detail");
        facesMessage.setSummary("New Summary");
        assertEquals("New Summary", facesMessage.getSummary());
    }

    @Test
    public void testGetDetail() {
        facesMessage = new FacesMessage(Severity.INFO, "Summary", "Detail");
        assertEquals("Detail", facesMessage.getDetail());
    }

    @Test
    public void testSetDetail() {
        facesMessage = new FacesMessage(Severity.INFO, "Summary", "Detail");
        facesMessage.setDetail("New Detail");
        assertEquals("New Detail", facesMessage.getDetail());
    }

    @Test
    public void testIsRendered() {
        facesMessage = new FacesMessage(Severity.INFO, "Summary", "Detail");
        assertEquals(false, facesMessage.isRendered());
    }

    @Test
    public void testSetRendered() {
        facesMessage = new FacesMessage(Severity.INFO, "Summary", "Detail");
        facesMessage.setRendered(true);
        assertEquals(true, facesMessage.isRendered());
    }

    @Test
    public void testNullSeverity() {
        assertThrows(NullPointerException.class, () -> new FacesMessage(null, "Summary", "Detail"));
    }

    @Test
    public void testNullSummary() {
        assertThrows(NullPointerException.class, () -> new FacesMessage(Severity.INFO, null, "Detail"));
    }

    @Test
    public void testNullDetail() {
        assertThrows(NullPointerException.class, () -> new FacesMessage(Severity.INFO, "Summary", null));
    }
}
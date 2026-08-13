package jakarta.faces.application;

import jakarta.faces.FacesException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ViewExpiredExceptionTest {

    @Mock
    private FacesException facesException;

    @InjectMocks
    private ViewExpiredException viewExpiredException;

    @BeforeEach
    public void setup() {
        viewExpiredException = new ViewExpiredException();
    }

    @Test
    public void testNoArgConstructor() {
        viewExpiredException = new ViewExpiredException();
        assertEquals("", viewExpiredException.getViewId());
    }

    @Test
    public void testViewIdConstructor() {
        viewExpiredException = new ViewExpiredException("viewId");
        assertEquals("viewId", viewExpiredException.getViewId());
    }

    @Test
    public void testMessageViewIdConstructor() {
        viewExpiredException = new ViewExpiredException("message", "viewId");
        assertEquals("viewId", viewExpiredException.getViewId());
    }

    @Test
    public void testMessageCauseViewIdConstructor() {
        FacesException cause = new FacesException("cause");
        viewExpiredException = new ViewExpiredException("message", cause, "viewId");
        assertEquals("viewId", viewExpiredException.getViewId());
    }

    @Test
    public void testCauseViewIdConstructor() {
        FacesException cause = new FacesException("cause");
        viewExpiredException = new ViewExpiredException(cause, "viewId");
        assertEquals("viewId", viewExpiredException.getViewId());
    }

    @Test
    public void testGetViewId() {
        viewExpiredException = new ViewExpiredException("viewId");
        assertEquals("viewId", viewExpiredException.getViewId());
    }

    @Test
    public void testGetViewIdNull() {
        viewExpiredException = new ViewExpiredException();
        assertEquals("", viewExpiredException.getViewId());
    }

    @Test
    public void testGetViewIdEmpty() {
        viewExpiredException = new ViewExpiredException("");
        assertEquals("", viewExpiredException.getViewId());
    }
}
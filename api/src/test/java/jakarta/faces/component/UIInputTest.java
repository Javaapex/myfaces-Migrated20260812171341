package jakarta.faces.component;

import jakarta.faces.context.FacesContext;
import jakarta.faces.component.UIInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UIInputTest {

    @Mock
    private FacesContext facesContext;

    @Mock
    private UIInput uiInput;

    @BeforeEach
    public void setup() {
        when(uiInput.getFacesContext()).thenReturn(facesContext);
    }

    @Test
    public void testSetValue() {
        Object value = "testValue";
        uiInput.setValue(value);
        assertEquals(value, uiInput.getLocalValue());
    }

    @Test
    public void testGetValue() {
        Object value = "testValue";
        uiInput.setValue(value);
        assertEquals(value, uiInput.getValue());
    }

    @Test
    public void testGetValue_LocalValueSet() {
        uiInput.setLocalValueSet(true);
        assertEquals(null, uiInput.getValue());
    }

    @Test
    public void testSetValue_LocalValueSet() {
        uiInput.setLocalValueSet(true);
        uiInput.setValue("testValue");
        assertEquals("testValue", uiInput.getLocalValue());
    }

    @Test
    public void testSetValue_NullValue() {
        uiInput.setValue(null);
        assertEquals(null, uiInput.getLocalValue());
    }

    @Test
    public void testGetValue_NullValue() {
        uiInput.setValue(null);
        assertEquals(null, uiInput.getValue());
    }

    @Test
    public void testSetValue_EmptyString() {
        uiInput.setValue("");
        assertEquals("", uiInput.getLocalValue());
    }

    @Test
    public void testGetValue_EmptyString() {
        uiInput.setValue("");
        assertEquals("", uiInput.getValue());
    }

    @Test
    public void testSetValue_DevelopmentMode() {
        when(facesContext.isProjectStage(ProjectStage.Development)).thenReturn(true);
        Object value = "testValue";
        uiInput.setValue(value);
        assertEquals(value, uiInput.getLocalValue());
    }

    @Test
    public void testGetValue_DevelopmentMode() {
        when(facesContext.isProjectStage(ProjectStage.Development)).thenReturn(true);
        Object value = "testValue";
        uiInput.setValue(value);
        assertEquals(value, uiInput.getValue());
    }
}
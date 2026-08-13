package jakarta.faces.component;

import jakarta.faces.context.FacesContext;
import jakarta.faces.component.visit.VisitCallback;
import jakarta.faces.component.visit.VisitContext;
import jakarta.faces.component.visit.VisitResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UIFormTest {

    @Mock
    private FacesContext facesContext;

    @Mock
    private VisitContext visitContext;

    @Mock
    private VisitCallback visitCallback;

    @Mock
    private UIComponentBase uiComponentBase;

    @BeforeEach
    public void setup() {
        when(facesContext.getViewRoot()).thenReturn(null);
        when(uiComponentBase.getFacetCount()).thenReturn(0);
        when(uiComponentBase.getChildCount()).thenReturn(0);
        when(uiComponentBase.getChildren()).thenReturn(java.util.Collections.emptyList());
    }

    @Test
    public void testCreateUniqueId_PrependIdFalse_NoSeed() {
        UIForm uiForm = new UIForm();
        uiForm.setPrependId(false);
        String uniqueId = uiForm.createUniqueId(facesContext, null);
        assertEquals(UIViewRoot.UNIQUE_ID_PREFIX, uniqueId.substring(0, UIViewRoot.UNIQUE_ID_PREFIX.length()));
    }

    @Test
    public void testCreateUniqueId_PrependIdFalse_WithSeed() {
        UIForm uiForm = new UIForm();
        uiForm.setPrependId(false);
        String uniqueId = uiForm.createUniqueId(facesContext, "seed");
        assertEquals(UIViewRoot.UNIQUE_ID_PREFIX + "seed", uniqueId);
    }

    @Test
    public void testCreateUniqueId_PrependIdTrue_NoSeed() {
        UIForm uiForm = new UIForm();
        uiForm.setPrependId(true);
        String uniqueId = uiForm.createUniqueId(facesContext, null);
        assertEquals(UIViewRoot.UNIQUE_ID_PREFIX, uniqueId.substring(0, UIViewRoot.UNIQUE_ID_PREFIX.length()));
    }

    @Test
    public void testCreateUniqueId_PrependIdTrue_WithSeed() {
        UIForm uiForm = new UIForm();
        uiForm.setPrependId(true);
        String uniqueId = uiForm.createUniqueId(facesContext, "seed");
        assertEquals(UIViewRoot.UNIQUE_ID_PREFIX + "seed", uniqueId);
    }

    @Test
    public void testIsSubmitted() {
        UIForm uiForm = new UIForm();
        uiForm.setSubmitted(true);
        assertEquals(true, uiForm.isSubmitted());
    }

    @Test
    public void testIsSubmitted_NotSubmitted() {
        UIForm uiForm = new UIForm();
        uiForm.setSubmitted(false);
        assertEquals(false, uiForm.isSubmitted());
    }

    @Test
    public void testSetSubmitted() {
        UIForm uiForm = new UIForm();
        uiForm.setSubmitted(true);
        assertEquals(true, uiForm.isSubmitted());
    }

    @Test
    public void testProcessDecodes() {
        UIForm uiForm = new UIForm();
        uiForm.processDecodes(facesContext);
    }

    @Test
    public void testProcessDecodes_Submitted() {
        UIForm uiForm = new UIForm();
        uiForm.setSubmitted(true);
        uiForm.processDecodes(facesContext);
    }

    @Test
    public void testProcessValidators() {
        UIForm uiForm = new UIForm();
        uiForm.processValidators(facesContext);
    }

    @Test
    public void testProcessValidators_Submitted() {
        UIForm uiForm = new UIForm();
        uiForm.setSubmitted(true);
        uiForm.processValidators(facesContext);
    }

    @Test
    public void testProcessValidators_PreValidateEvent() {
        UIForm uiForm = new UIForm();
        uiForm.processValidators(facesContext);
    }

    @Test
    public void testProcessValidators_PostValidateEvent() {
        UIForm uiForm = new UIForm();
        uiForm.processValidators(facesContext);
    }
}
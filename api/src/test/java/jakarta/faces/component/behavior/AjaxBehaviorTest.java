package jakarta.faces.component.behavior;

import jakarta.faces.component.behavior.ClientBehaviorBase;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.AjaxBehaviorListener;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AjaxBehaviorTest {

    @Mock
    private FacesContext facesContext;

    @Mock
    private StateHelper stateHelper;

    @Mock
    private AjaxBehaviorListener listener;

    @InjectMocks
    private AjaxBehavior ajaxBehavior;

    @BeforeEach
    public void setup() {
        when(facesContext.getApplication()).thenReturn(null);
        when(facesContext.getPartialViewContext()).thenReturn(null);
        when(stateHelper.get(ATTR_EXECUTE)).thenReturn(null);
        when(stateHelper.get(ATTR_ON_ERROR)).thenReturn(null);
        when(stateHelper.get(ATTR_ON_EVENT)).thenReturn(null);
        when(stateHelper.get(ATTR_RENDER)).thenReturn(null);
        when(stateHelper.get(ATTR_DISABLED)).thenReturn(null);
        when(stateHelper.get(ATTR_IMMEDIATE)).thenReturn(null);
        when(stateHelper.get(ATTR_DELAY)).thenReturn(null);
        when(stateHelper.get(ATTR_CLEAR_MODEL)).thenReturn(null);
        when(stateHelper.get(ATTR_RESET_VALUES)).thenReturn(null);
    }

    @Test
    public void testAddAjaxBehaviorListener() {
        ajaxBehavior.addAjaxBehaviorListener(listener);
        verify(listener, times(1)).addBehaviorListener(any());
    }

    @Test
    public void testRemoveAjaxBehaviorListener() {
        ajaxBehavior.removeAjaxBehaviorListener(listener);
        verify(listener, times(1)).removeBehaviorListener(any());
    }

    @Test
    public void testGetExecute() {
        when(stateHelper.get(ATTR_EXECUTE)).thenReturn(VAL_FORM_LIST);
        assertEquals(VAL_FORM_LIST, ajaxBehavior.getExecute());
    }

    @Test
    public void testSetExecute() {
        ajaxBehavior.setExecute(VAL_FORM_LIST);
        verify(stateHelper, times(1)).put(ATTR_EXECUTE, VAL_FORM_LIST);
    }

    @Test
    public void testGetOnerror() {
        when(stateHelper.get(ATTR_ON_ERROR)).thenReturn("onerror");
        assertEquals("onerror", ajaxBehavior.getOnerror());
    }

    @Test
    public void testSetOnerror() {
        ajaxBehavior.setOnerror("onerror");
        verify(stateHelper, times(1)).put(ATTR_ON_ERROR, "onerror");
    }

    @Test
    public void testGetOnevent() {
        when(stateHelper.get(ATTR_ON_EVENT)).thenReturn("onevent");
        assertEquals("onevent", ajaxBehavior.getOnevent());
    }

    @Test
    public void testSetOnevent() {
        ajaxBehavior.setOnevent("onevent");
        verify(stateHelper, times(1)).put(ATTR_ON_EVENT, "onevent");
    }

    @Test
    public void testGetRender() {
        when(stateHelper.get(ATTR_RENDER)).thenReturn(VAL_ALL_LIST);
        assertEquals(VAL_ALL_LIST, ajaxBehavior.getRender());
    }

    @Test
    public void testSetRender() {
        ajaxBehavior.setRender(VAL_ALL_LIST);
        verify(stateHelper, times(1)).put(ATTR_RENDER, VAL_ALL_LIST);
    }

    @Test
    public void testGetValueExpression() {
        when(stateHelper.get(PropertyKeys.bindings)).thenReturn(null);
        assertEquals(null, ajaxBehavior.getValueExpression("name"));
    }

    @Test
    public void testSetValueExpression() {
        ajaxBehavior.setValueExpression("name", null);
        verify(stateHelper, times(1)).remove(PropertyKeys.bindings, "name");
    }

    @Test
    public void testIsDisabled() {
        when(stateHelper.get(ATTR_DISABLED)).thenReturn(true);
        assertEquals(true, ajaxBehavior.isDisabled());
    }

    @Test
    public void testSetDisabled() {
        ajaxBehavior.setDisabled(true);
        verify(stateHelper, times(1)).put(ATTR_DISABLED, true);
    }

    @Test
    public void testIsImmediate() {
        when(stateHelper.get(ATTR_IMMEDIATE)).thenReturn(true);
        assertEquals(true, ajaxBehavior.isImmediate());
    }

    @Test
    public void testSetImmediate() {
        ajaxBehavior.setImmediate(true);
        verify(stateHelper, times(1)).put(ATTR_IMMEDIATE, true);
    }

    @Test
    public void testIsImmediateSet() {
        when(stateHelper.get(ATTR_IMMEDIATE)).thenReturn(true);
        assertEquals(true, ajaxBehavior.isImmediateSet());
    }

    @Test
    public void testIsResetValues() {
        when(stateHelper.get(ATTR_RESET_VALUES)).thenReturn(true);
        assertEquals(true, ajaxBehavior.isResetValues());
    }

    @Test
    public void testSetResetValues() {
        ajaxBehavior.setResetValues(true);
        verify(stateHelper, times(1)).put(ATTR_RESET_VALUES, true);
    }

    @Test
    public void testIsResetValuesSet() {
        when(stateHelper.get(ATTR_RESET_VALUES)).thenReturn(true);
        assertEquals(true, ajaxBehavior.isResetValuesSet());
    }
}
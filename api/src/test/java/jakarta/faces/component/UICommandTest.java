package jakarta.faces.component;

import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ActionEvent;
import jakarta.faces.event.ActionListener;
import jakarta.faces.event.FacesEvent;
import jakarta.faces.event.PhaseId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UICommandTest {

    @Mock
    private FacesContext facesContext;

    @Mock
    private ActionListener defaultActionListener;

    @Mock
    private ActionListener listener;

    @Mock
    private ActionEvent actionEvent;

    private UICommand uiCommand;

    @BeforeEach
    public void setup() {
        uiCommand = new UICommand();
        when(facesContext.getApplication()).thenReturn(new FacesContext());
        when(facesContext.getApplication().getActionListener()).thenReturn(defaultActionListener);
        when(facesContext.getApplication().getActionListener()).thenReturn(listener);
        when(facesContext.getApplication().getActionListener()).thenReturn(null);
    }

    @Test
    public void testBroadcast_ActionEvent() {
        uiCommand.broadcast(actionEvent);
        verify(defaultActionListener).processAction(actionEvent);
    }

    @Test
    public void testBroadcast_NullEvent() {
        assertThrows(AbortProcessingException.class, () -> uiCommand.broadcast(null));
    }

    @Test
    public void testQueueEvent_ActionEvent() {
        uiCommand.queueEvent(actionEvent);
        verify(actionEvent).setPhaseId(PhaseId.INVOKE_APPLICATION);
    }

    @Test
    public void testQueueEvent_NullEvent() {
        uiCommand.queueEvent(null);
        verify(uiCommand).queueEvent(any(FacesEvent.class));
    }

    @Test
    public void testIsImmediate_DefaultValue() {
        assertFalse(uiCommand.isImmediate());
    }

    @Test
    public void testIsImmediate_SetImmediate() {
        uiCommand.setImmediate(true);
        assertTrue(uiCommand.isImmediate());
    }

    @Test
    public void testGetValue_DefaultValue() {
        assertNull(uiCommand.getValue());
    }

    @Test
    public void testGetValue_SetValue() {
        uiCommand.setValue("test");
        assertEquals("test", uiCommand.getValue());
    }

    @Test
    public void testGetActionExpression_DefaultValue() {
        assertNull(uiCommand.getActionExpression());
    }

    @Test
    public void testGetActionExpression_SetActionExpression() {
        MethodExpression methodExpression = mock(MethodExpression.class);
        uiCommand.setActionExpression(methodExpression);
        assertEquals(methodExpression, uiCommand.getActionExpression());
    }

    @Test
    public void testAddActionListener() {
        uiCommand.addActionListener(listener);
        verify(uiCommand).addFacesListener(listener);
    }

    @Test
    public void testRemoveActionListener() {
        uiCommand.removeActionListener(listener);
        verify(uiCommand).removeFacesListener(listener);
    }

    @Test
    public void testGetActionListeners() {
        ActionListener[] actionListeners = uiCommand.getActionListeners();
        verify(uiCommand).getFacesListeners(ActionListener.class);
    }
}
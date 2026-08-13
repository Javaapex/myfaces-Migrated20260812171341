package jakarta.faces.component.behavior;

import jakarta.faces.component.behavior._AttachedDeltaWrapper;
import jakarta.faces.component.behavior._AttachedListStateWrapper;
import jakarta.faces.component.behavior._AttachedStateWrapper;
import jakarta.faces.component.behavior._DeltaList;
import jakarta.faces.component.PartialStateHolder;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.event.BehaviorEvent;
import jakarta.faces.event.BehaviorListener;
import org.apache.myfaces.core.api.shared.lang.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BehaviorBaseTest {

    @Mock
    private FacesContext facesContext;

    @Mock
    private BehaviorEvent event;

    @Mock
    private BehaviorListener listener;

    @InjectMocks
    private BehaviorBase behaviorBase;

    @BeforeEach
    public void setup() {
        when(facesContext.getPartialViewContext()).thenReturn(new jakarta.faces.context.PartialViewContextImpl());
    }

    @Test
    public void testBroadcast() {
        // Test with valid event
        behaviorBase.broadcast(event);
        verify(event).processListener(listener);

        // Test with null event
        assertThrows(AbortProcessingException.class, () -> behaviorBase.broadcast(null));
    }

    @Test
    public void testClearInitialState() {
        behaviorBase.clearInitialState();
        verify(behaviorBase).markInitialState();
    }

    @Test
    public void testInitialStateMarked() {
        behaviorBase.markInitialState();
        assertTrue(behaviorBase.initialStateMarked());
    }

    @Test
    public void testIsTransient() {
        behaviorBase.setTransient(true);
        assertTrue(behaviorBase.isTransient());
    }

    @Test
    public void testMarkInitialState() {
        behaviorBase.markInitialState();
        verify(behaviorBase).markInitialState();
    }

    @Test
    public void testRestoreState() {
        // Test with valid state
        _AttachedDeltaWrapper wrapper = new _AttachedDeltaWrapper(_DeltaList.class, new _DeltaList<>());
        behaviorBase.restoreState(facesContext, wrapper);
        verify(behaviorBase).restoreState(facesContext, wrapper.getWrappedStateObject());

        // Test with null state
        behaviorBase.restoreState(facesContext, null);
        verify(behaviorBase, never()).restoreState(any(FacesContext.class), any(Object.class));
    }

    @Test
    public void testSaveState() {
        // Test with valid state
        _DeltaList<BehaviorListener> listeners = new _DeltaList<>();
        listeners.add(listener);
        behaviorBase.saveState(facesContext);
        verify(behaviorBase).saveBehaviorListenersList(facesContext);

        // Test with null state
        behaviorBase.saveState(facesContext);
        verify(behaviorBase, never()).saveBehaviorListenersList(any(FacesContext.class));
    }

    @Test
    public void testSaveBehaviorListenersList() {
        // Test with valid state
        _DeltaList<BehaviorListener> listeners = new _DeltaList<>();
        listeners.add(listener);
        behaviorBase.saveBehaviorListenersList(facesContext);
        verify(behaviorBase).saveAttachedState(facesContext, listeners);

        // Test with null state
        behaviorBase.saveBehaviorListenersList(facesContext);
        verify(behaviorBase, never()).saveAttachedState(any(FacesContext.class), any(Object.class));
    }

    @Test
    public void testSaveAttachedState() {
        // Test with valid state
        Object state = new Object();
        behaviorBase.saveAttachedState(facesContext, state);
        verify(behaviorBase).saveAttachedState(facesContext, state);

        // Test with null state
        behaviorBase.saveAttachedState(facesContext, null);
        verify(behaviorBase, never()).saveAttachedState(any(FacesContext.class), any(Object.class));
    }

    @Test
    public void testRestoreAttachedState() {
        // Test with valid state
        _AttachedListStateWrapper wrapper = new _AttachedListStateWrapper(new ArrayList<>());
        behaviorBase.restoreAttachedState(facesContext, wrapper);
        verify(behaviorBase).restoreAttachedState(facesContext, wrapper.getWrappedStateList());

        // Test with null state
        behaviorBase.restoreAttachedState(facesContext, null);
        verify(behaviorBase, never()).restoreAttachedState(any(FacesContext.class), any(Object.class));
    }
}
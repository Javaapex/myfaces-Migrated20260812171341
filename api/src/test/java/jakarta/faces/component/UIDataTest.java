package jakarta.faces.component;

import jakarta.faces.component.visit.VisitContext;
import jakarta.faces.component.visit.VisitHint;
import jakarta.faces.component.visit.VisitResult;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.FacesEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UIDataTest {

    @Mock
    private FacesContext facesContext;

    @Mock
    private VisitContext visitContext;

    @Mock
    private FacesEvent facesEvent;

    @Mock
    private VisitResult visitResult;

    private UIData uidata;

    @BeforeEach
    public void setup() {
        uidata = new UIData();
    }

    @Test
    public void testSetRowIndex() {
        uidata.setRowIndex(1);
        assertEquals(1, uidata.getRowIndex());
    }

    @Test
    public void testSetRowIndexNegative() {
        assertThrows(IllegalArgumentException.class, () -> uidata.setRowIndex(-1));
    }

    @Test
    public void testSetRowIndexZero() {
        uidata.setRowIndex(0);
        assertEquals(0, uidata.getRowIndex());
    }

    @Test
    public void testGetRowStates() {
        Map<String, List<EditableValueHolderState>> rowStates = uidata.getRowStates();
        assertEquals(0, rowStates.size());
    }

    @Test
    public void testGetRowDeltaStates() {
        Map<String, Map<String, Object>> rowDeltaStates = uidata.getRowDeltaStates();
        assertEquals(0, rowDeltaStates.size());
    }

    @Test
    public void testGetRowTransientStates() {
        Map<String, Map<String, Object>> rowTransientStates = uidata.getRowTransientStates();
        assertEquals(0, rowTransientStates.size());
    }

    @Test
    public void testGetDataModel() {
        when(facesContext.getApplication()).thenReturn(null);
        assertThrows(NullPointerException.class, () -> uidata.getDataModel(facesContext));
    }

    @Test
    public void testProcessDecodes() {
        uidata.processDecodes(facesContext, visitContext, visitResult);
        assertEquals(1, uidata.getProcessCount());
    }

    @Test
    public void testProcessValidators() {
        uidata.processValidators(facesContext, visitContext, visitResult);
        assertEquals(2, uidata.getProcessCount());
    }

    @Test
    public void testProcessUpdates() {
        uidata.processUpdates(facesContext, visitContext, visitResult);
        assertEquals(3, uidata.getProcessCount());
    }
}
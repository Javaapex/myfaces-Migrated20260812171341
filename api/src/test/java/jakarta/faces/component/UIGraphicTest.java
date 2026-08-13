package jakarta.faces.component;

import jakarta.faces.component.UIGraphic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UIGraphicTest {

    @Mock
    private UIGraphic.StateHelper stateHelper;

    @InjectMocks
    private UIGraphic uIGraphic;

    @BeforeEach
    public void setup() {
        uIGraphic.setStateHelper(stateHelper);
    }

    @Test
    public void testGetFamily() {
        // Test happy path
        assertEquals("jakarta.faces.Graphic", uIGraphic.getFamily());
    }

    @Test
    public void testGetFamilyNullStateHelper() {
        // Test edge case: null state helper
        uIGraphic.setStateHelper(null);
        assertThrows(NullPointerException.class, () -> uIGraphic.getFamily());
    }

    @Test
    public void testGetUrl() {
        // Test happy path
        uIGraphic.setValue("test");
        assertEquals("test", uIGraphic.getUrl());
    }

    @Test
    public void testGetUrlNullValue() {
        // Test edge case: null value
        uIGraphic.setValue(null);
        assertEquals(null, uIGraphic.getUrl());
    }

    @Test
    public void testGetValue() {
        // Test happy path
        uIGraphic.setValue("test");
        assertEquals("test", uIGraphic.getValue());
    }

    @Test
    public void testGetValueNullValue() {
        // Test edge case: null value
        uIGraphic.setValue(null);
        assertEquals(null, uIGraphic.getValue());
    }

    @Test
    public void testSetValue() {
        // Test happy path
        uIGraphic.setValue("test");
        assertEquals("test", uIGraphic.getStateHelper().eval(UIGraphic.PropertyKeys.value));
    }

    @Test
    public void testSetValueNullValue() {
        // Test edge case: null value
        uIGraphic.setValue(null);
        assertEquals(null, uIGraphic.getStateHelper().eval(UIGraphic.PropertyKeys.value));
    }

    @Test
    public void testGetValueExpression() {
        // Test happy path
        when(stateHelper.eval(UIGraphic.PropertyKeys.value)).thenReturn("test");
        assertEquals("test", uIGraphic.getValueExpression("value"));
    }

    @Test
    public void testGetValueExpressionNullName() {
        // Test edge case: null name
        assertThrows(NullPointerException.class, () -> uIGraphic.getValueExpression(null));
    }

    @Test
    public void testSetValueExpression() {
        // Test happy path
        ValueExpression valueExpression = mock(ValueExpression.class);
        when(valueExpression.getValue(any())).thenReturn("test");
        uIGraphic.setValueExpression("value", valueExpression);
        assertEquals("test", uIGraphic.getStateHelper().eval(UIGraphic.PropertyKeys.value));
    }

    @Test
    public void testSetValueExpressionNullName() {
        // Test edge case: null name
        assertThrows(NullPointerException.class, () -> uIGraphic.setValueExpression(null, mock(ValueExpression.class)));
    }
}
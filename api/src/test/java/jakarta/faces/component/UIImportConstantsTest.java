package jakarta.faces.component;

import jakarta.faces.component.UIImportConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import jakarta.el.ValueExpression;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UIImportConstantsTest {

    @Mock
    private ValueExpression valueExpression;

    @InjectMocks
    private UIImportConstants uiImportConstants;

    @BeforeEach
    public void setup() {
        uiImportConstants = new UIImportConstants();
    }

    @Test
    public void testGetFamily() {
        assertEquals("jakarta.faces.ImportConstants", uiImportConstants.getFamily());
    }

    @Test
    public void testGetType() {
        uiImportConstants.setType("testType");
        assertEquals("testType", uiImportConstants.getType());
    }

    @Test
    public void testSetType() {
        uiImportConstants.setType("testType");
        assertEquals("testType", uiImportConstants.getType());
    }

    @Test
    public void testGetVar() {
        uiImportConstants.setVar("testVar");
        assertEquals("testVar", uiImportConstants.getVar());
    }

    @Test
    public void testSetVar() {
        uiImportConstants.setVar("testVar");
        assertEquals("testVar", uiImportConstants.getVar());
    }

    @Test
    public void testSetValueExpression() {
        when(valueExpression.getValue(any())).thenReturn("testValue");
        uiImportConstants.setValueExpression("testName", valueExpression);
        assertEquals("testValue", uiImportConstants.getStateHelper().eval("testName"));
    }

    @Test
    public void testSetValueExpressionThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> uiImportConstants.setValueExpression(PropertyKeys.var.toString(), valueExpression));
    }
}
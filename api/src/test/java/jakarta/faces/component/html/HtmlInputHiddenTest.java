package jakarta.faces.component.html;

import jakarta.faces.component.UIInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HtmlInputHiddenTest {

    @Mock
    private UIInput uiInput;

    @InjectMocks
    private HtmlInputHidden htmlInputHidden;

    @BeforeEach
    public void setup() {
        htmlInputHidden = new HtmlInputHidden();
    }

    @Test
    public void testGetFamily() {
        assertEquals("jakarta.faces.Input", htmlInputHidden.getFamily());
    }

    @Test
    public void testGetFamilyNull() {
        htmlInputHidden = null;
        assertThrows(NullPointerException.class, () -> htmlInputHidden.getFamily());
    }

    @Test
    public void testGetFamilyEmptyString() {
        htmlInputHidden.setFamily("");
        assertEquals("", htmlInputHidden.getFamily());
    }

    @Test
    public void testGetFamilyNonEmptyString() {
        htmlInputHidden.setFamily("jakarta.faces.Input");
        assertEquals("jakarta.faces.Input", htmlInputHidden.getFamily());
    }

    @Test
    public void testGetFamilyNonString() {
        htmlInputHidden.setFamily(123);
        assertEquals("jakarta.faces.Input", htmlInputHidden.getFamily());
    }

    @Test
    public void testGetFamilyNullFamily() {
        htmlInputHidden.setFamily(null);
        assertEquals("jakarta.faces.Input", htmlInputHidden.getFamily());
    }
}
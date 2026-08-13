package jakarta.faces.component;

import jakarta.faces.component.UIComponent;
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
public class UIColumnTest {

    @Mock
    private UIComponentBase uiComponentBase;

    @Mock
    private UIComponent footer;

    @Mock
    private UIComponent header;

    @InjectMocks
    private UIColumn uIColumn;

    @BeforeEach
    public void setup() {
        when(uiComponentBase.getFacets()).thenReturn(new UIComponentBase.Facets());
        uIColumn = new UIColumn();
        uIColumn.setUIComponentBase(uiComponentBase);
    }

    @Test
    public void testSetFooter() {
        uIColumn.setFooter(footer);
        assertEquals(footer, uIColumn.getFooter());
    }

    @Test
    public void testSetFooterNull() {
        assertThrows(NullPointerException.class, () -> uIColumn.setFooter(null));
    }

    @Test
    public void testGetFooter() {
        when(uiComponentBase.getFacet(FOOTER_FACET_NAME)).thenReturn(footer);
        assertEquals(footer, uIColumn.getFooter());
    }

    @Test
    public void testSetHeader() {
        uIColumn.setHeader(header);
        assertEquals(header, uIColumn.getHeader());
    }

    @Test
    public void testSetHeaderNull() {
        assertThrows(NullPointerException.class, () -> uIColumn.setHeader(null));
    }

    @Test
    public void testGetHeader() {
        when(uiComponentBase.getFacet(HEADER_FACET_NAME)).thenReturn(header);
        assertEquals(header, uIColumn.getHeader());
    }

    @Test
    public void testGetId() {
        assertEquals("someId", uIColumn.getId());
    }
}
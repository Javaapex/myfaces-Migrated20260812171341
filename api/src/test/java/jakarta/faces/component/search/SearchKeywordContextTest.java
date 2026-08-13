package jakarta.faces.component.search;

import jakarta.faces.component.ContextCallback;
import jakarta.faces.component.SearchExpressionContext;
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
public class SearchKeywordContextTest {

    @Mock
    private SearchExpressionContext searchExpressionContext;

    @Mock
    private ContextCallback callback;

    @Mock
    private UIComponent target;

    @InjectMocks
    private SearchKeywordContext searchKeywordContext;

    @BeforeEach
    public void setup() {
        searchKeywordContext = new SearchKeywordContext(searchExpressionContext, callback, "remainingExpression");
    }

    @Test
    public void testInvokeContextCallback() {
        // Test with valid UIComponent
        searchKeywordContext.invokeContextCallback(target);
        assertEquals(true, searchKeywordContext.isKeywordResolved());
        assertEquals(searchExpressionContext, searchKeywordContext.getSearchExpressionContext());
        assertEquals(callback, searchKeywordContext.getCallback());

        // Test with null UIComponent
        assertThrows(NullPointerException.class, () -> searchKeywordContext.invokeContextCallback(null));
    }

    @Test
    public void testGetSearchExpressionContext() {
        assertEquals(searchExpressionContext, searchKeywordContext.getSearchExpressionContext());
    }

    @Test
    public void testGetCallback() {
        assertEquals(callback, searchKeywordContext.getCallback());
    }

    @Test
    public void testIsKeywordResolved() {
        assertEquals(false, searchKeywordContext.isKeywordResolved());
        searchKeywordContext.setKeywordResolved(true);
        assertEquals(true, searchKeywordContext.isKeywordResolved());
    }

    @Test
    public void testSetKeywordResolved() {
        searchKeywordContext.setKeywordResolved(true);
        assertEquals(true, searchKeywordContext.isKeywordResolved());
    }

    @Test
    public void testGetRemainingExpression() {
        assertEquals("remainingExpression", searchKeywordContext.getRemainingExpression());
    }
}
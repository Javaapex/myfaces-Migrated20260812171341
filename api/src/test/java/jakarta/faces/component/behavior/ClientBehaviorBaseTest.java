package jakarta.faces.component.behavior;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.render.ClientBehaviorRenderer;
import org.apache.myfaces.core.api.shared.lang.Assert;
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
public class ClientBehaviorBaseTest {

    @Mock
    private FacesContext facesContext;

    @Mock
    private UIComponent uiComponent;

    @Mock
    private ClientBehaviorRenderer renderer;

    @InjectMocks
    private ClientBehaviorBase clientBehaviorBase;

    @BeforeEach
    public void setup() {
        when(facesContext.getRenderKit()).thenReturn(null);
    }

    @Test
    public void testDecode() {
        clientBehaviorBase.decode(facesContext, uiComponent);
        verifyRendererCalled();
    }

    @Test
    public void testDecode_NullContext() {
        assertThrows(AssertionError.class, () -> clientBehaviorBase.decode(null, uiComponent));
    }

    @Test
    public void testDecode_NullComponent() {
        assertThrows(AssertionError.class, () -> clientBehaviorBase.decode(facesContext, null));
    }

    @Test
    public void testGetHints() {
        Set<ClientBehaviorHint> hints = clientBehaviorBase.getHints();
        assertEquals(Collections.emptySet(), hints);
    }

    @Test
    public void testGetRendererType() {
        String rendererType = clientBehaviorBase.getRendererType();
        assertEquals(null, rendererType);
    }

    @Test
    public void testGetScript() {
        ClientBehaviorContext behaviorContext = new ClientBehaviorContext(facesContext);
        String script = clientBehaviorBase.getScript(behaviorContext);
        assertEquals(null, script);
    }

    @Test
    public void testGetScript_RendererAvailable() {
        when(renderer.getScript(any(ClientBehaviorContext.class), any(ClientBehavior.class))).thenReturn("script");
        when(facesContext.getRenderKit()).thenReturn(null);
        ClientBehaviorContext behaviorContext = new ClientBehaviorContext(facesContext);
        String script = clientBehaviorBase.getScript(behaviorContext);
        assertEquals("script", script);
    }

    @Test
    public void testGetRenderer() {
        when(facesContext.getRenderKit()).thenReturn(null);
        ClientBehaviorRenderer renderer = clientBehaviorBase.getRenderer(facesContext);
        assertEquals(null, renderer);
    }

    @Test
    public void testGetRenderer_RendererAvailable() {
        when(facesContext.getRenderKit()).thenReturn(null);
        when(facesContext.getRenderKit().getClientBehaviorRenderer(anyString())).thenReturn(renderer);
        ClientBehaviorRenderer renderer = clientBehaviorBase.getRenderer(facesContext);
        assertEquals(renderer, renderer);
    }

    @Test
    public void testGetFacesContext() {
        FacesContext facesContext = clientBehaviorBase.getFacesContext();
        assertEquals(FacesContext.getCurrentInstance(), facesContext);
    }

    @Test
    public void testIsCachedFacesContext() {
        clientBehaviorBase.setCachedFacesContext(facesContext);
        boolean cached = clientBehaviorBase.isCachedFacesContext();
        assertEquals(true, cached);
    }

    @Test
    public void testSetCachedFacesContext() {
        clientBehaviorBase.setCachedFacesContext(facesContext);
        FacesContext cachedFacesContext = clientBehaviorBase.getFacesContext();
        assertEquals(facesContext, cachedFacesContext);
    }

    private void verifyRendererCalled() {
        verify(renderer).decode(any(FacesContext.class), any(UIComponent.class), any(ClientBehavior.class));
    }
}
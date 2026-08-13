import java.io.ByteArrayInputStream;
import java.net.URI;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

class GeneratedSeleniumFunctionalTest {

    /**
     * Capture a screenshot and attach it to the Allure report.
     * Called automatically on test failure.
     */
    static void captureScreenshot(WebDriver driver) {
        try {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Screenshot on failure", "image/png",
                new ByteArrayInputStream(screenshot), ".png");
        } catch (Exception ignored) {
            // Driver may already be closed
        }
    }

    @Description("Verify /bar.xhtml renders with title test and expected content")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void Verify__barxhtml_renders_with_title_test_and_expected_content() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /bar.xhtml");
            driver.get(baseUrl + "/bar.xhtml");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Page /bar.xhtml renders without errors")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void Page__barxhtml_renders_without_errors() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /bar.xhtml");
            driver.get(baseUrl + "/bar.xhtml");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
            Allure.step("Assert text not visible: Internal Server Error");
            assertFalse(driver.getPageSource().contains("Internal Server Error"), "Text should not appear: Internal Server Error");
            Allure.step("Assert text not visible: NullPointerException");
            assertFalse(driver.getPageSource().contains("NullPointerException"), "Text should not appear: NullPointerException");
            Allure.step("Assert element visible: body");
            assertNotNull(driver.findElement(By.cssSelector("body")), "Element should be visible: body");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Verify /basictemplate renders with title Facelets Template and expected content")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void Verify__basictemplate_renders_with_title_Facelets_Template_and_expected_content() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /basictemplate");
            driver.get(baseUrl + "/basictemplate");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Page /basictemplate renders without errors")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void Page__basictemplate_renders_without_errors() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /basictemplate");
            driver.get(baseUrl + "/basictemplate");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
            Allure.step("Assert text not visible: Internal Server Error");
            assertFalse(driver.getPageSource().contains("Internal Server Error"), "Text should not appear: Internal Server Error");
            Allure.step("Assert text not visible: NullPointerException");
            assertFalse(driver.getPageSource().contains("NullPointerException"), "Text should not appear: NullPointerException");
            Allure.step("Assert element visible: body");
            assertNotNull(driver.findElement(By.cssSelector("body")), "Element should be visible: body");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Verify /foo.xhtml renders with title test and expected content")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void Verify__fooxhtml_renders_with_title_test_and_expected_content() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /foo.xhtml");
            driver.get(baseUrl + "/foo.xhtml");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Page /foo.xhtml renders without errors")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void Page__fooxhtml_renders_without_errors() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /foo.xhtml");
            driver.get(baseUrl + "/foo.xhtml");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
            Allure.step("Assert text not visible: Internal Server Error");
            assertFalse(driver.getPageSource().contains("Internal Server Error"), "Text should not appear: Internal Server Error");
            Allure.step("Assert text not visible: NullPointerException");
            assertFalse(driver.getPageSource().contains("NullPointerException"), "Text should not appear: NullPointerException");
            Allure.step("Assert element visible: body");
            assertNotNull(driver.findElement(By.cssSelector("body")), "Element should be visible: body");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Verify /foreach-readonly.xhtml renders with title foreach-readonly and expected content")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void Verify__foreachreadonlyxhtml_renders_with_title_foreachreadonly_and_expected_content() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /foreach-readonly.xhtml");
            driver.get(baseUrl + "/foreach-readonly.xhtml");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Page /foreach-readonly.xhtml renders without errors")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void Page__foreachreadonlyxhtml_renders_without_errors() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /foreach-readonly.xhtml");
            driver.get(baseUrl + "/foreach-readonly.xhtml");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
            Allure.step("Assert text not visible: Internal Server Error");
            assertFalse(driver.getPageSource().contains("Internal Server Error"), "Text should not appear: Internal Server Error");
            Allure.step("Assert text not visible: NullPointerException");
            assertFalse(driver.getPageSource().contains("NullPointerException"), "Text should not appear: NullPointerException");
            Allure.step("Assert element visible: body");
            assertNotNull(driver.findElement(By.cssSelector("body")), "Element should be visible: body");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Verify /form-inputs.xhtml renders with title form-inputs and expected content")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void Verify__forminputsxhtml_renders_with_title_forminputs_and_expected_content() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /form-inputs.xhtml");
            driver.get(baseUrl + "/form-inputs.xhtml");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Page /form-inputs.xhtml renders without errors")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void Page__forminputsxhtml_renders_without_errors() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /form-inputs.xhtml");
            driver.get(baseUrl + "/form-inputs.xhtml");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
            Allure.step("Assert text not visible: Internal Server Error");
            assertFalse(driver.getPageSource().contains("Internal Server Error"), "Text should not appear: Internal Server Error");
            Allure.step("Assert text not visible: NullPointerException");
            assertFalse(driver.getPageSource().contains("NullPointerException"), "Text should not appear: NullPointerException");
            Allure.step("Assert element visible: body");
            assertNotNull(driver.findElement(By.cssSelector("body")), "Element should be visible: body");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Verify /index.xhtml renders with title benchmark and expected content")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void Verify__indexxhtml_renders_with_title_benchmark_and_expected_content() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /index.xhtml");
            driver.get(baseUrl + "/index.xhtml");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
            Allure.step("Assert text visible: MyFaces / Mojarra lifecycle benchmark");
            assertTrue(driver.getPageSource().contains("MyFaces / Mojarra lifecycle benchmark"), "Expected text on page: MyFaces / Mojarra lifecycle benchmark");
            Allure.step("Assert element visible: a[href*='table-readonly.xhtml']");
            assertNotNull(driver.findElement(By.cssSelector("a[href*='table-readonly.xhtml']")), "Element should be visible: a[href*='table-readonly.xhtml']");
            Allure.step("Assert element visible: a[href*='repeat-readonly.xhtml']");
            assertNotNull(driver.findElement(By.cssSelector("a[href*='repeat-readonly.xhtml']")), "Element should be visible: a[href*='repeat-readonly.xhtml']");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Page /index.xhtml renders without errors")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void Page__indexxhtml_renders_without_errors() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /index.xhtml");
            driver.get(baseUrl + "/index.xhtml");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
            Allure.step("Assert text not visible: Internal Server Error");
            assertFalse(driver.getPageSource().contains("Internal Server Error"), "Text should not appear: Internal Server Error");
            Allure.step("Assert text not visible: NullPointerException");
            assertFalse(driver.getPageSource().contains("NullPointerException"), "Text should not appear: NullPointerException");
            Allure.step("Assert element visible: body");
            assertNotNull(driver.findElement(By.cssSelector("body")), "Element should be visible: body");
            Allure.step("Assert text visible: MyFaces / Mojarra lifecycle benchmark");
            assertTrue(driver.getPageSource().contains("MyFaces / Mojarra lifecycle benchmark"), "Expected text on page: MyFaces / Mojarra lifecycle benchmark");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Verify /myprotectedview.xhtml renders with title test and expected content")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void Verify__myprotectedviewxhtml_renders_with_title_test_and_expected_content() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /myprotectedview.xhtml");
            driver.get(baseUrl + "/myprotectedview.xhtml");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Page /myprotectedview.xhtml renders without errors")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void Page__myprotectedviewxhtml_renders_without_errors() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /myprotectedview.xhtml");
            driver.get(baseUrl + "/myprotectedview.xhtml");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
            Allure.step("Assert text not visible: Internal Server Error");
            assertFalse(driver.getPageSource().contains("Internal Server Error"), "Text should not appear: Internal Server Error");
            Allure.step("Assert text not visible: NullPointerException");
            assertFalse(driver.getPageSource().contains("NullPointerException"), "Text should not appear: NullPointerException");
            Allure.step("Assert element visible: body");
            assertNotNull(driver.findElement(By.cssSelector("body")), "Element should be visible: body");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Verify /nested-readonly.xhtml renders with title nested-readonly and expected content")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void Verify__nestedreadonlyxhtml_renders_with_title_nestedreadonly_and_expected_content() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /nested-readonly.xhtml");
            driver.get(baseUrl + "/nested-readonly.xhtml");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Page /nested-readonly.xhtml renders without errors")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void Page__nestedreadonlyxhtml_renders_without_errors() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /nested-readonly.xhtml");
            driver.get(baseUrl + "/nested-readonly.xhtml");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
            Allure.step("Assert text not visible: Internal Server Error");
            assertFalse(driver.getPageSource().contains("Internal Server Error"), "Text should not appear: Internal Server Error");
            Allure.step("Assert text not visible: NullPointerException");
            assertFalse(driver.getPageSource().contains("NullPointerException"), "Text should not appear: NullPointerException");
            Allure.step("Assert element visible: body");
            assertNotNull(driver.findElement(By.cssSelector("body")), "Element should be visible: body");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Verify /plainhtml.xhtml renders with title minimal test html and expected content")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void Verify__plainhtmlxhtml_renders_with_title_minimal_test_html_and_expected_content() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /plainhtml.xhtml");
            driver.get(baseUrl + "/plainhtml.xhtml");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Page /plainhtml.xhtml renders without errors")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void Page__plainhtmlxhtml_renders_without_errors() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /plainhtml.xhtml");
            driver.get(baseUrl + "/plainhtml.xhtml");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
            Allure.step("Assert text not visible: Internal Server Error");
            assertFalse(driver.getPageSource().contains("Internal Server Error"), "Text should not appear: Internal Server Error");
            Allure.step("Assert text not visible: NullPointerException");
            assertFalse(driver.getPageSource().contains("NullPointerException"), "Text should not appear: NullPointerException");
            Allure.step("Assert element visible: body");
            assertNotNull(driver.findElement(By.cssSelector("body")), "Element should be visible: body");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Verify /repeat-readonly.xhtml renders with title repeat-readonly and expected content")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void Verify__repeatreadonlyxhtml_renders_with_title_repeatreadonly_and_expected_content() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /repeat-readonly.xhtml");
            driver.get(baseUrl + "/repeat-readonly.xhtml");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Page /repeat-readonly.xhtml renders without errors")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void Page__repeatreadonlyxhtml_renders_without_errors() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /repeat-readonly.xhtml");
            driver.get(baseUrl + "/repeat-readonly.xhtml");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
            Allure.step("Assert text not visible: Internal Server Error");
            assertFalse(driver.getPageSource().contains("Internal Server Error"), "Text should not appear: Internal Server Error");
            Allure.step("Assert text not visible: NullPointerException");
            assertFalse(driver.getPageSource().contains("NullPointerException"), "Text should not appear: NullPointerException");
            Allure.step("Assert element visible: body");
            assertNotNull(driver.findElement(By.cssSelector("body")), "Element should be visible: body");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Verify /some-folder/bar.xhtml renders with title test and expected content")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void Verify__somefolder_barxhtml_renders_with_title_test_and_expected_content() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /some-folder/bar.xhtml");
            driver.get(baseUrl + "/some-folder/bar.xhtml");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Page /some-folder/bar.xhtml renders without errors")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void Page__somefolder_barxhtml_renders_without_errors() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /some-folder/bar.xhtml");
            driver.get(baseUrl + "/some-folder/bar.xhtml");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
            Allure.step("Assert text not visible: Internal Server Error");
            assertFalse(driver.getPageSource().contains("Internal Server Error"), "Text should not appear: Internal Server Error");
            Allure.step("Assert text not visible: NullPointerException");
            assertFalse(driver.getPageSource().contains("NullPointerException"), "Text should not appear: NullPointerException");
            Allure.step("Assert element visible: body");
            assertNotNull(driver.findElement(By.cssSelector("body")), "Element should be visible: body");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Verify /somefolder/bar.xhtml renders with title test and expected content")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void Verify__somefolder_barxhtml_renders_with_title_test_and_expected_content_2() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /somefolder/bar.xhtml");
            driver.get(baseUrl + "/somefolder/bar.xhtml");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Page /somefolder/bar.xhtml renders without errors")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void Page__somefolder_barxhtml_renders_without_errors_2() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /somefolder/bar.xhtml");
            driver.get(baseUrl + "/somefolder/bar.xhtml");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
            Allure.step("Assert text not visible: Internal Server Error");
            assertFalse(driver.getPageSource().contains("Internal Server Error"), "Text should not appear: Internal Server Error");
            Allure.step("Assert text not visible: NullPointerException");
            assertFalse(driver.getPageSource().contains("NullPointerException"), "Text should not appear: NullPointerException");
            Allure.step("Assert element visible: body");
            assertNotNull(driver.findElement(By.cssSelector("body")), "Element should be visible: body");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Verify /table-readonly.xhtml renders with title table-readonly and expected content")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void Verify__tablereadonlyxhtml_renders_with_title_tablereadonly_and_expected_content() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /table-readonly.xhtml");
            driver.get(baseUrl + "/table-readonly.xhtml");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Page /table-readonly.xhtml renders without errors")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void Page__tablereadonlyxhtml_renders_without_errors() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /table-readonly.xhtml");
            driver.get(baseUrl + "/table-readonly.xhtml");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
            Allure.step("Assert text not visible: Internal Server Error");
            assertFalse(driver.getPageSource().contains("Internal Server Error"), "Text should not appear: Internal Server Error");
            Allure.step("Assert text not visible: NullPointerException");
            assertFalse(driver.getPageSource().contains("NullPointerException"), "Text should not appear: NullPointerException");
            Allure.step("Assert element visible: body");
            assertNotNull(driver.findElement(By.cssSelector("body")), "Element should be visible: body");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Submit form on /test1-protocol.xhtml to boog.html and verify result")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void Submit_form_on__test1protocolxhtml_to_booghtml_and_verify_result() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /test1-protocol.xhtml");
            driver.get(baseUrl + "/test1-protocol.xhtml");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
            Allure.step("Assert text visible: Protocol Test");
            assertTrue(driver.getPageSource().contains("Protocol Test"), "Expected text on page: Protocol Test");
            Allure.step("Assert text visible: protocol testcase1");
            assertTrue(driver.getPageSource().contains("protocol testcase1"), "Expected text on page: protocol testcase1");
            Allure.step("Click element: #form1 button, #form1 input[type=submit]");
            btn = driver.findElement(By.cssSelector("#form1 button, #form1 input[type=submit]"));
            assertNotNull(btn, "Clickable element should exist: #form1 button, #form1 input[type=submit]");
            btn.click();
            Allure.step("Assert text not visible: 500");
            assertFalse(driver.getPageSource().contains("500"), "Text should not appear: 500");
            Allure.step("Assert text not visible: Exception");
            assertFalse(driver.getPageSource().contains("Exception"), "Text should not appear: Exception");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Page /test1-protocol.xhtml renders without errors")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void Page__test1protocolxhtml_renders_without_errors() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /test1-protocol.xhtml");
            driver.get(baseUrl + "/test1-protocol.xhtml");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
            Allure.step("Assert text not visible: Internal Server Error");
            assertFalse(driver.getPageSource().contains("Internal Server Error"), "Text should not appear: Internal Server Error");
            Allure.step("Assert text not visible: NullPointerException");
            assertFalse(driver.getPageSource().contains("NullPointerException"), "Text should not appear: NullPointerException");
            Allure.step("Assert element visible: body");
            assertNotNull(driver.findElement(By.cssSelector("body")), "Element should be visible: body");
            Allure.step("Assert text visible: Protocol Test");
            assertTrue(driver.getPageSource().contains("Protocol Test"), "Expected text on page: Protocol Test");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Verify /test2-viewbody.xhtml renders with title test and expected content")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void Verify__test2viewbodyxhtml_renders_with_title_test_and_expected_content() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /test2-viewbody.xhtml");
            driver.get(baseUrl + "/test2-viewbody.xhtml");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
            Allure.step("Assert text visible: Viewbody Test");
            assertTrue(driver.getPageSource().contains("Viewbody Test"), "Expected text on page: Viewbody Test");
            Allure.step("Assert text visible: After triggering this test the entire page should be replaced by the test result");
            assertTrue(driver.getPageSource().contains("After triggering this test the entire page should be replaced by the test result"), "Expected text on page: After triggering this test the entire page should be replaced by the test result");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Page /test2-viewbody.xhtml renders without errors")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void Page__test2viewbodyxhtml_renders_without_errors() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /test2-viewbody.xhtml");
            driver.get(baseUrl + "/test2-viewbody.xhtml");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
            Allure.step("Assert text not visible: Internal Server Error");
            assertFalse(driver.getPageSource().contains("Internal Server Error"), "Text should not appear: Internal Server Error");
            Allure.step("Assert text not visible: NullPointerException");
            assertFalse(driver.getPageSource().contains("NullPointerException"), "Text should not appear: NullPointerException");
            Allure.step("Assert element visible: body");
            assertNotNull(driver.findElement(By.cssSelector("body")), "Element should be visible: body");
            Allure.step("Assert text visible: Viewbody Test");
            assertTrue(driver.getPageSource().contains("Viewbody Test"), "Expected text on page: Viewbody Test");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Verify /test3-chain.xhtml renders with title test and expected content")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void Verify__test3chainxhtml_renders_with_title_test_and_expected_content() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /test3-chain.xhtml");
            driver.get(baseUrl + "/test3-chain.xhtml");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
            Allure.step("Assert text visible: Chain Test");
            assertTrue(driver.getPageSource().contains("Chain Test"), "Expected text on page: Chain Test");
            Allure.step("Assert text visible: This test case tests the faces.util.chain function");
            assertTrue(driver.getPageSource().contains("This test case tests the faces.util.chain function"), "Expected text on page: This test case tests the faces.util.chain function");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Page /test3-chain.xhtml renders without errors")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void Page__test3chainxhtml_renders_without_errors() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /test3-chain.xhtml");
            driver.get(baseUrl + "/test3-chain.xhtml");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
            Allure.step("Assert text not visible: Internal Server Error");
            assertFalse(driver.getPageSource().contains("Internal Server Error"), "Text should not appear: Internal Server Error");
            Allure.step("Assert text not visible: NullPointerException");
            assertFalse(driver.getPageSource().contains("NullPointerException"), "Text should not appear: NullPointerException");
            Allure.step("Assert element visible: body");
            assertNotNull(driver.findElement(By.cssSelector("body")), "Element should be visible: body");
            Allure.step("Assert text visible: Chain Test");
            assertTrue(driver.getPageSource().contains("Chain Test"), "Expected text on page: Chain Test");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Submit form on /test4-tablebasic.xhtml to boog.html and verify result")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void Submit_form_on__test4tablebasicxhtml_to_booghtml_and_verify_result() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /test4-tablebasic.xhtml");
            driver.get(baseUrl + "/test4-tablebasic.xhtml");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
            Allure.step("Assert text visible: Table Tests");
            assertTrue(driver.getPageSource().contains("Table Tests"), "Expected text on page: Table Tests");
            Allure.step("Click element: #form2 button, #form2 input[type=submit]");
            btn = driver.findElement(By.cssSelector("#form2 button, #form2 input[type=submit]"));
            assertNotNull(btn, "Clickable element should exist: #form2 button, #form2 input[type=submit]");
            btn.click();
            Allure.step("Assert text not visible: 500");
            assertFalse(driver.getPageSource().contains("500"), "Text should not appear: 500");
            Allure.step("Assert text not visible: Exception");
            assertFalse(driver.getPageSource().contains("Exception"), "Text should not appear: Exception");
            Allure.step("Assert element visible: table");
            assertNotNull(driver.findElement(By.cssSelector("table")), "Element should be visible: table");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Page /test4-tablebasic.xhtml renders without errors")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void Page__test4tablebasicxhtml_renders_without_errors() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /test4-tablebasic.xhtml");
            driver.get(baseUrl + "/test4-tablebasic.xhtml");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
            Allure.step("Assert text not visible: Internal Server Error");
            assertFalse(driver.getPageSource().contains("Internal Server Error"), "Text should not appear: Internal Server Error");
            Allure.step("Assert text not visible: NullPointerException");
            assertFalse(driver.getPageSource().contains("NullPointerException"), "Text should not appear: NullPointerException");
            Allure.step("Assert element visible: body");
            assertNotNull(driver.findElement(By.cssSelector("body")), "Element should be visible: body");
            Allure.step("Assert text visible: Table Tests");
            assertTrue(driver.getPageSource().contains("Table Tests"), "Expected text on page: Table Tests");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Verify /test5-viewbody-full-response.xhtml renders with title test and expected content")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void Verify__test5viewbodyfullresponsexhtml_renders_with_title_test_and_expected_content() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /test5-viewbody-full-response.xhtml");
            driver.get(baseUrl + "/test5-viewbody-full-response.xhtml");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
            Allure.step("Assert text visible: View Body replacement in Full Page Response");
            assertTrue(driver.getPageSource().contains("View Body replacement in Full Page Response"), "Expected text on page: View Body replacement in Full Page Response");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Page /test5-viewbody-full-response.xhtml renders without errors")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void Page__test5viewbodyfullresponsexhtml_renders_without_errors() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /test5-viewbody-full-response.xhtml");
            driver.get(baseUrl + "/test5-viewbody-full-response.xhtml");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
            Allure.step("Assert text not visible: Internal Server Error");
            assertFalse(driver.getPageSource().contains("Internal Server Error"), "Text should not appear: Internal Server Error");
            Allure.step("Assert text not visible: NullPointerException");
            assertFalse(driver.getPageSource().contains("NullPointerException"), "Text should not appear: NullPointerException");
            Allure.step("Assert element visible: body");
            assertNotNull(driver.findElement(By.cssSelector("body")), "Element should be visible: body");
            Allure.step("Assert text visible: View Body replacement in Full Page Response");
            assertTrue(driver.getPageSource().contains("View Body replacement in Full Page Response"), "Expected text on page: View Body replacement in Full Page Response");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Verify servlet /*.xhtml (FacesServlet) business logic")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void Verify_servlet__xhtml_FacesServlet_business_logic() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /*.xhtml");
            driver.get(baseUrl + "/*.xhtml");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
            Allure.step("Assert element visible: body");
            assertNotNull(driver.findElement(By.cssSelector("body")), "Element should be visible: body");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Verify servlet /*.xhtml (FacesServlet) business logic")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void Verify_servlet__xhtml_FacesServlet_business_logic_2() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /*.xhtml");
            driver.get(baseUrl + "/*.xhtml");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
            Allure.step("Assert element visible: body");
            assertNotNull(driver.findElement(By.cssSelector("body")), "Element should be visible: body");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Verify servlet /*.mockup (ResponseMockup22) business logic")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void Verify_servlet__mockup_ResponseMockup22_business_logic() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /*.mockup");
            driver.get(baseUrl + "/*.mockup");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
            Allure.step("Assert element visible: body");
            assertNotNull(driver.findElement(By.cssSelector("body")), "Element should be visible: body");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Verify servlet /*.mockup (ResponseMockup22) business logic")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void Verify_servlet__mockup_ResponseMockup22_business_logic_2() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /*.mockup");
            driver.get(baseUrl + "/*.mockup");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
            Allure.step("Assert element visible: body");
            assertNotNull(driver.findElement(By.cssSelector("body")), "Element should be visible: body");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Verify servlet /*.jsf (FacesServlet) business logic")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void Verify_servlet__jsf_FacesServlet_business_logic() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /*.jsf");
            driver.get(baseUrl + "/*.jsf");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
            Allure.step("Assert element visible: body");
            assertNotNull(driver.findElement(By.cssSelector("body")), "Element should be visible: body");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Verify servlet /*.jsf (FacesServlet) business logic")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void Verify_servlet__jsf_FacesServlet_business_logic_2() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /*.jsf");
            driver.get(baseUrl + "/*.jsf");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
            Allure.step("Assert element visible: body");
            assertNotNull(driver.findElement(By.cssSelector("body")), "Element should be visible: body");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Verify servlet /faces (FacesServlet) business logic")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void Verify_servlet__faces_FacesServlet_business_logic() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /faces");
            driver.get(baseUrl + "/faces");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
            Allure.step("Assert element visible: body");
            assertNotNull(driver.findElement(By.cssSelector("body")), "Element should be visible: body");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Verify servlet /faces (FacesServlet) business logic")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void Verify_servlet__faces_FacesServlet_business_logic_2() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /faces");
            driver.get(baseUrl + "/faces");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
            Allure.step("Assert element visible: body");
            assertNotNull(driver.findElement(By.cssSelector("body")), "Element should be visible: body");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Verify servlet /foo (FacesServlet) business logic")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void Verify_servlet__foo_FacesServlet_business_logic() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /foo");
            driver.get(baseUrl + "/foo");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
            Allure.step("Assert element visible: body");
            assertNotNull(driver.findElement(By.cssSelector("body")), "Element should be visible: body");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Verify servlet /foo (FacesServlet) business logic")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void Verify_servlet__foo_FacesServlet_business_logic_2() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /foo");
            driver.get(baseUrl + "/foo");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
            Allure.step("Assert element visible: body");
            assertNotNull(driver.findElement(By.cssSelector("body")), "Element should be visible: body");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
    @Description("Verify servlet /perf-stats (PerfStatsServlet) business logic")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void Verify_servlet__perfstats_PerfStatsServlet_business_logic() throws Exception {
        String remoteUrl = System.getenv().get("SELENIUM_REMOTE_URL");
        String baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:63313");
        WebDriver driver;
        if (remoteUrl != null && !remoteUrl.isBlank()) {
            driver = new RemoteWebDriver(URI.create(remoteUrl).toURL(), new ChromeOptions());
        } else {
            // Selenium 4.25+ has built-in SeleniumManager — no WebDriverManager needed
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        try {
            WebElement field = null;
            WebElement btn = null;
            Allure.step("Navigate to /perf-stats");
            driver.get(baseUrl + "/perf-stats");
            // Verify page loaded successfully
            String pageTitle = driver.getTitle();
            assertNotNull(pageTitle, "Page title should not be null");
            String source = driver.getPageSource();
            assertFalse(source.contains("404"), "Page should not return 404");
            assertFalse(source.contains("500"), "Page should not return 500 error");
            assertFalse(source.contains("Service Unavailable"), "Service should be available");
            Allure.step("Assert element visible: body");
            assertNotNull(driver.findElement(By.cssSelector("body")), "Element should be visible: body");
        } catch (Exception | AssertionError e) {
            captureScreenshot(driver);
            throw e;
        } finally {
            driver.quit();
        }
    }
}

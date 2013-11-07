package is.ru.helloworld;

import junit.framework.TestCase;
import com.thoughtworks.selenium.DefaultSelenium;

public class HelloWorldIT extends TestCase {

	protected DefaultSelenium createSeleniumClient(String url) throws Exception {
		return new DefaultSelenium("localhost", 4444, "*firefox", url);
	}

	public void testTitle() throws Exception {
		DefaultSelenium selenium = createSeleniumClient("http://localhost:4567");
		selenium.start();
		selenium.open("/");
		selenium.waitForPageToLoad("3000");
		assertEquals("Hello world", selenium.getTitle());
		selenium.stop();
	}
}
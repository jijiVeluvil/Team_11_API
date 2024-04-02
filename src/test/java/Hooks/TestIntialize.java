package Hooks;

import io.cucumber.java.Before;
import lms.Utils.RestassuredExtension;

public class TestIntialize {
	@Before 
	public void testSetup() {
		RestassuredExtension restassuredExtension = new RestassuredExtension();
		
		
	}
	

}

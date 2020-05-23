package Cashless;

import java.io.IOException;

import org.testng.annotations.Test;

public class CashlessTestTC extends CashlessTestFramework {
	
	@Test
	public void cashlessTC () throws InterruptedException, IOException{
		
		launchUrl();
		login();
		logOut();
		
		
	}

}

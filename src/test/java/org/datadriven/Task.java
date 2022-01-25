package org.datadriven;

import java.io.IOException;

public class Task{
	
	public static void main(String[] args) throws InterruptedException, IOException {
		Base b = new Base();
		
		b.enterRead("C:\\Users\\Hp\\eclipse-workspace\\datadriven\\excel\\mani1.xlsx", "Sheet1", 0, 1);
		b.browserLaunch("http://adactinhotelapp.com/");
		
		
		
		
		
		
}
}
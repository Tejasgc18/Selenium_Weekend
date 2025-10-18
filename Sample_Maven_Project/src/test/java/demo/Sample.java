package demo;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Sample {
	@Test
	public void launch()
	{
		Reporter.log("Sample is executed", true);
	}
	@Test
	public void gitTest()
	{
		Reporter.log("GitTest is executed", true);
	}
}


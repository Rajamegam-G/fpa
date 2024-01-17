package fpa.test;

import fpa.baseTest.TestComponents;
import fpa.pages.location;

public class Locationtestcases extends TestComponents {
	String locationcode = "Losangeles";
	String locationname = "Losangeles";
	String countryname = "United States";
	String companycode = "Ideas2IT0193";

	public void addlocationTest() throws InterruptedException {
		location loc = new location(driver);
		loc.addLocation(locationcode, locationname, countryname, companycode);

	}
	
	public void readlocationTest()
	{
		
	}
}

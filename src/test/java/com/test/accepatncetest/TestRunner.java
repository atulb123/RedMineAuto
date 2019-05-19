package com.test.accepatncetest;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
 features = "src/test/resources/feature"
 ,glue={"com.test"},tags= {"@XTP-001,@XTP-002"},
plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/Extent_Report/ExtentReport.html"}
 )
public class TestRunner {
	@AfterClass
	 public static void writeExtentReport() {
	 Reporter.loadXMLConfig(new File("./extent-config.xml"));
     Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
     Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
     Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
     Reporter.setSystemInfo("Selenium", "3.7.0");
     Reporter.setSystemInfo("Maven", "3.5.2");
     Reporter.setSystemInfo("Java Version", "1.8.0_151");
	 }
}

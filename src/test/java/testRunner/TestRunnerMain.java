package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		
		features = {"src\\test\\java\\features\\"},
		glue = {"steps"},
		plugin = {"pretty","json:target/json-report/cucumber.json", "rerun:failedtestcases/rerun.txt"},
		//"junit:junit_xml/cucumber.xml"
		//"html:target/html-report/cucumber.html", 
		dryRun = true,
		tags = "@p1 and not @P2",
		monochrome = true
		
		)


public class TestRunnerMain {

}

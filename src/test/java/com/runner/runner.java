package com.runner;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import com.stepdefinition.cyclostepdefinition;

import io.cucumber.java.After;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src/test/java/com/featurefile/cyclo_contacts.feature",
glue={"com.stepdefinition"},dryRun=false,plugin={"html:report/cycloreport.html","json:report/cyclojson.json","junit:report/cycloxml.xml"}
,tags="@cyclo")

public class runner {

	

}

package com.udemy.spring.springselenium.kelvin.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import com.udemy.spring.springselenium.kelvin.annotation.LazyConfiguration;
import com.udemy.spring.springselenium.kelvin.annotation.ThreadScopeBean;

import io.github.bonigarcia.wdm.WebDriverManager;

//@Profile("!remote")
@LazyConfiguration
public class WebDriverConfig {
	
	
    @ThreadScopeBean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "spring.application.browser", havingValue = "firefox")
    public WebDriver firefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    @ThreadScopeBean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "spring.application.browser", havingValue = "chrome")
    public WebDriver chromeDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

	@ThreadScopeBean
	@ConditionalOnMissingBean
	@ConditionalOnProperty(name = "spring.application.browser", havingValue = "edge")
	public WebDriver edgeDriver() {
		WebDriverManager.edgedriver().setup();
		return new EdgeDriver();
	}

}

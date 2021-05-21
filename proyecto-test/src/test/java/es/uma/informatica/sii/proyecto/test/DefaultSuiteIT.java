package es.uma.informatica.sii.proyecto.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class DefaultSuiteIT {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void pruebaSensillinite() {
    driver.get("http://localhost:8080/proyecto-war/");
    driver.manage().window().setSize(new Dimension(1552, 840));
    assertThat(driver.findElement(By.cssSelector("h1")).getText(), is("Bienvenido al Sistema Tutor de la asignatura 330"));
  }
}

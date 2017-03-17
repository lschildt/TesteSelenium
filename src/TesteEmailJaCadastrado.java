import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteEmailJaCadastrado {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  
	System.setProperty("webdriver.firefox.marionette","C:\\plugin\\geckodriver.exe");	  
	  
	  
    driver = new FirefoxDriver();
    baseUrl = "http://www.woundsmonitor.com.br/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testEEmailJaCadastradoJava() throws Exception {
    driver.get(baseUrl + "/Usuario/cadastrar");
    driver.findElement(By.name("Nome")).clear();
    driver.findElement(By.name("Nome")).sendKeys("Leandro Schildt");
    driver.findElement(By.name("Email")).clear();
    driver.findElement(By.name("Email")).sendKeys("leandro.schildt");
    driver.findElement(By.name("Email")).clear();
    driver.findElement(By.name("Email")).sendKeys("leandro.schildt@gmail.com");
    driver.findElement(By.name("Senha")).clear();
    driver.findElement(By.name("Senha")).sendKeys("123456");
    driver.findElement(By.name("Confirmar_senha")).clear();
    driver.findElement(By.name("Confirmar_senha")).sendKeys("123456");
    new Select(driver.findElement(By.id("UsuarioTipoId"))).selectByVisibleText("Enfermeiro");
    driver.findElement(By.name("Coren")).clear();
    driver.findElement(By.name("Coren")).sendKeys("123456");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

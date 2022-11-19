import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TematikaLogin{
	
	private final WebDriver driver;
	
	public TematikaLogin(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Realiza el login en la pagina
	 * @param username nombre de usuario para el sitio
	 * @param password contraseña para el sitio
	 */
	public void login(String mail, String password) {	
		WebDriverWait wait = new WebDriverWait(driver, 4000);
		WebElement userIcon = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"jm-quickaccess\"]/div[1]")));
		Actions action = new Actions(driver);
		//realiza hover sobre el icono
		action.moveToElement(userIcon).perform();	
		
		WebElement loginLink = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"myaccountscroll\"]/div/div/ul/li[1]/a")));
		loginLink.click();
		
		if (!"Acceso del cliente".equals(driver.getTitle())) {
			throw new IllegalStateException("This is not the login page");
		}
		PageFactory.initElements(driver, getClass());
		
		WebElement mailButton = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"email\"]")));
		mailButton.sendKeys(mail);	
		
		WebElement passwordButton = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pass\"]")));
		passwordButton.sendKeys(password);
		
		WebElement loginButton = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("send2")));
		loginButton.click();	
	}
	

}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TematikaAgregarAlCarrito {
	private final WebDriver driver;

	public TematikaAgregarAlCarrito(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Agrega un libro al carrito de compras
	 */
	public void addToCart() {
		WebDriverWait wait = new WebDriverWait(driver, 2000);
		WebElement buyButton = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product_addtocart_form\"]/div[2]/div[2]/div[5]/div/button")));
		buyButton.click();
	}

}

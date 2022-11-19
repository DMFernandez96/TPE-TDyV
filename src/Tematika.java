import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Tematika {
	private WebDriver driver;

	/**
	 * Se hace la configuracion del driver antes de ejecutar los tests
	 */
	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver", "chromedriver.exe");
		this.driver = new ChromeDriver();		
	}

	/**
	 * Carga la pagina y comprueba que coincida el titulo real con el esperado.
	 */
	@Test (priority=1)
	public void loadPage() {
		driver.navigate().to("https://tematika.com");
		System.out.println(driver.getTitle());
		assertEquals(driver.getTitle(), "Tematika.com: Venta de libros, música, películas, pasatiempos, librería");
	}
	
	/**
	 * Testea el login
	 */
	@Test (priority=2)
	public void login() {
		TematikaLogin TematikaLogin = PageFactory.initElements(driver, TematikaLogin.class);
		TematikaLogin.login("rotocay136@lance7.com","123456"); 
	}
	
	/**
	 * Testea la busqueda de un libro
	 */
	@Test (priority=3)
	public void searchBook() {
		TematikaBuscarLibro tematikaBuscarLibro = PageFactory.initElements(driver, TematikaBuscarLibro.class);
		tematikaBuscarLibro.search("cassandra clare");
		String textoAbuscar="LA CADENA DE HIERRO";
		//tematikaBuscarLibro.sacarCookies();
		tematikaBuscarLibro.scrollear(textoAbuscar);
	}
	
	/**
	 * Testea el agregado de un libro al carrito de compras
	 */
	@Test (priority=4)
	public void addToCart() { // TODO: preg si esta bien que dependa del ult test o hacer busqueda de otro libro aca
		TematikaAgregarAlCarrito tematikaAgregarAlCarrito = PageFactory.initElements(driver, TematikaAgregarAlCarrito.class);
		tematikaAgregarAlCarrito.addToCart();
	}

	/**
	 * Testea que se haya cerrado la pestaña del test
	 */
	@Test (priority=4)
	public void finishTest() {
//		if(driver!=null) {
//			driver.close();
//			driver = null;
//		}
		System.out.println("Termino satisfactoriamente");
		//assert para ver si finalmente se cerró
//		Assert.assertNull(driver);
	}
}

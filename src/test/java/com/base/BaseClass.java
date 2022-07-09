package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
RequestSpecification reqSpec;
Response response;
protected static WebDriver driver;
public void addHeader(String key , String value) {
	reqSpec=RestAssured.given();
	reqSpec=reqSpec.header(key, value);
	
}
public void addBody(Object reqBody) {
	reqSpec= reqSpec.body(reqBody);
}
public void addHeaders(Headers headers) {
	reqSpec=RestAssured.given().headers(headers);

}
public void queryparam(String key,String value) {
	reqSpec = reqSpec.queryParam(key, value);
}
public void pathParam(String key,String value) {
	reqSpec = reqSpec.pathParam(key, value);
}
public void addBody(String reqBody) {
	reqSpec=reqSpec.body(reqSpec);
}
public Response requestType(String reqType, String endpoint) {
	switch (reqType) {
	case "GET":
		response=reqSpec.get(endpoint);
		break;
	case "POST":
		response=reqSpec.post(endpoint);
	case "PUT":
		response=reqSpec.put(endpoint);
	case "DELETE":
		response=reqSpec.delete(endpoint);
	default:
		break;
	}
	return response;	
}
public int getStatusCode(Response response) {
	int statusCode = response.getStatusCode();
	return statusCode;
}
public ResponseBody getResponseBody(Response response) {
	ResponseBody body = response.getBody();
	return body;

}
public String getResBodyAsString(Response response ) {
	String asString=getResponseBody(response).asString();
	return asString;	
}
public String getResBodyAsPrettyString(Response response ) {
	String asPrettyString=getResponseBody(response).asPrettyString();
	return asPrettyString;

}
public void basicAuth(String username,String password) {
reqSpec = reqSpec.auth().preemptive().basic(username, password);
}

public String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
	Properties properties = new Properties();
	properties.load(new FileInputStream(System.getProperty("user.dir")+"\\config.properties"));    
	Object object = properties.get(key);
	String value = (String)object;
	return value;
}

public static void getDriver(String browserType) {
	switch (browserType) {
	case "chrome":
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		break;
	case "IE":
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
		break;
	case "firfox":
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		break;
	case "Edge":
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		break;
	default:
		break;
	}
	
}

public static void maximize() {
	driver.manage().window().maximize();
}

public static void loadUrl(String url) {
	driver.get(url);
}

public static void type(WebElement element, String data) {
	element.sendKeys(data);

}

public static WebElement findElementById(String attributeValue) {
	WebElement element = driver.findElement(By.id(attributeValue));
	return element;
}

public static WebElement findElemenyByXPath(String xpath) {
	WebElement element = driver.findElement(By.xpath(xpath));
	return element;

}

public static void sendKeys(WebElement element, String data) {
	element.sendKeys(data);
}

public static WebElement findElementByName(String attributeValue) {
	WebElement element = driver.findElement(By.name(attributeValue));
	return element;
}

public static void click(WebElement element) {
	element.click();
}

public static Alert switchToAlert() {
	Alert alert = driver.switchTo().alert();
	return alert;
}

public static void clickOk() {
	Alert alert = driver.switchTo().alert();
	alert.accept();
}

public static void clickCancel(Alert alert) {
	alert.dismiss();
}

public static void alertText(Alert alert, String text) {
	alert.sendKeys(text);
}

public static String alertText(Alert alert) {
	return alert.getText();
}

public static void selectByValue(WebElement element, String value) {
	Select select = new Select(element);
	select.selectByValue(value);
}

public static void selectOptionByText(WebElement element, String value) {
	Select select = new Select(element);
	select.selectByVisibleText(value);
}

public static void clear(WebElement element) {
	element.clear();

}

public static void closeWindow() {
	driver.close();

}

public static void closeAllWindow() {
	driver.quit();

}

public static String getAttribute(WebElement element) {
	String attribute = element.getAttribute("value");
	return attribute;

}

public static String getText(WebElement element) {
	String text = element.getText();
	return text;

}


public static String getData(String sheetname, int rownum, int cellnum) throws IOException {

	String res = null;
	File file = new File("C:\\Users\\Guest\\eclipse-workspace\\FrameWork\\Excel\\Baseclass.xlsx");
	FileInputStream stream = new FileInputStream(file);
	Workbook workbook = new XSSFWorkbook(stream);
	Sheet sheet = (Sheet) workbook.getSheet(sheetname);
	Row row = sheet.getRow(rownum);
	Cell cell = row.getCell(cellnum);
	CellType cellType = cell.getCellType();
	switch (cellType) {
	case STRING:
		res = cell.getStringCellValue();
		break;
	case NUMERIC:
		if (DateUtil.isCellDateFormatted(cell)) {
			String a = new SimpleDateFormat("dd/mm/yyyy").format(cell.getDateCellValue());
			System.out.println(a);
		} else {
			double numericCellValue = cell.getNumericCellValue();
			BigDecimal b = new BigDecimal(numericCellValue);
			res = b.toString();
		}
		break;

	default:
		break;
	}

	return res;
}

public static String UpdateData(String sheetname, int rownum, int cellnum, String olddata, String newdata)
		throws IOException {
	File file = new File("C:\\Users\\Guest\\eclipse-workspace\\FrameWork\\Excel\\Baseclass.xlsx");
	FileInputStream stream = new FileInputStream(file);
	Workbook workbook = new XSSFWorkbook(stream);
	Sheet sheet = workbook.getSheet(sheetname);
	Row row = sheet.getRow(rownum);
	Cell cell = row.getCell(cellnum);
	String stringCellValue = cell.getStringCellValue();
	if (stringCellValue.equals(olddata)) {
		cell.setCellValue(newdata);
	}
	FileOutputStream out = new FileOutputStream(file);
	workbook.write(out);
	return sheetname;

}

public static String insertValueInCell(String sheetName, int rownum, int cellnum, String data) throws IOException {
	File file = new File("C:\\Users\\Guest\\eclipse-workspace\\FrameWork\\Excel\\Baseclass.xlsx");
	FileInputStream stream = new FileInputStream(file);
	Workbook workbook = new XSSFWorkbook(stream);
	Sheet sheet = workbook.getSheet(sheetName);
	Row row = sheet.getRow(rownum);
	Cell cell = row.createCell(cellnum);
	cell.setCellValue(data);
	FileOutputStream out = new FileOutputStream(file);
	workbook.write(out);
	return sheetName;
}

public static void getinsertValueInCell(WebElement element, String sheetName, int rownum, int cellnum)
		throws IOException {
	File file = new File("C:\\Users\\Guest\\eclipse-workspace\\FrameWork\\Excel\\Baseclass.xlsx");
	FileInputStream stream = new FileInputStream(file);
	Workbook workbook = new XSSFWorkbook(stream);
	Sheet sheet = workbook.getSheet(sheetName);
	Row row = sheet.getRow(rownum);
	Cell cell = row.createCell(cellnum);
	String value = element.getAttribute("value");
	cell.setCellValue(value);
	FileOutputStream out = new FileOutputStream(file);
	workbook.write(out);

}



















}

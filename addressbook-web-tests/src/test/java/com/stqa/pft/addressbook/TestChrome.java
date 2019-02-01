package com.stqa.pft.addressbook;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestChrome {

  // this is made for testing purposes to run chrome driver
  public static void main(String [] args) throws InterruptedException{
    //System.setProperty("webdriver.chrome.driver",path of executable file "Chromedriver.exe")
    System.setProperty("webdriver.chrome.driver", "C:/Tools/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.softwaretestingmaterial.com/software-testing-interview-questions-free-ebook/");
    System.out.println("Selenium Webdriver Script in Chrome browser | Software Testing Material");
    driver.close();
  }
}
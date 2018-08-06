package com.ironman.demotest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.util.List;

import javax.xml.bind.Element;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class AndroidContactsTest {

    //Driver
//    private AppiumDriver<AndroidElement> driver;
    private AndroidDriver<AndroidElement> driver;

    /**
     * 配置启动driver
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {

        File classpathRoot = new File(System.getProperty("user.dir"));
        //app的目录
        File appDir = new File(classpathRoot, "/src/main/java/apps/");
        //app的名字，对应你apps目录下的文件
        File app = new File(appDir, "wotongzhishang_test.apk");
        //创建Capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //设置要调试的模拟器的名字
        capabilities.setCapability("deviceName", "Redmi 4A");
        //设置模拟器的系统版本
        capabilities.setCapability("platformVersion", "7.1.2");
        //设置app的路径
        capabilities.setCapability("app", app.getAbsolutePath());
        //设置app的包名
        capabilities.setCapability("appPackage", "com.culture.culturalexpo");
        //设置app的启动activity
        capabilities.setCapability("appActivity", ".UI.Public.WelcomeActivity");
        //设置app可以输入中文字符
        capabilities.setCapability("unicodeKeyboard", "True");
        capabilities.setCapability("resetKeyboard", "True");
        //启动driver
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    @After
    public void tearDown() throws Exception {
        //测试完毕，关闭driver，不关闭将会导致会话还存在，下次启动就会报错
        driver.quit();
    }


    /**
     * 要执行的的测试方法
     */
//    @Test
//    public void addContact() {
//        //利用Xpath的方法寻找text值为Add Contact的控件
//        WebElement el = driver.findElement(By.xpath(".//*[@text='Add Contact']"));
//        //点击这个控件
//        el.click();
//        //利用类名获取界面上所有的EditText
//        List<AndroidElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
//        //第一个EditText输入内容Some Name
//        textFieldsList.get(0).sendKeys("Some Name");
//        //第三个EditText输入内容Some Name
//        textFieldsList.get(2).sendKeys("Some@example.com");
//        //在坐(100,500)滑动到(100,100) 时间为2毫秒
////        driver.swipe(100, 500, 100, 100, 2);
//        //用xpath的方式寻找到text值为Save的控件，然后点击
//        driver.findElementByXPath(".//*[@text='Save']").click();
//    }
    @Test
    public void addContact() {
        //利用Xpath的方法寻找text值为Add Contact的控件
//        WebElement el = driver.findElement(By.xpath(".//*[@text='Add Contact']"));
//        //点击这个控件
//        el.click();
//        //利用类名获取界面上所有的EditText
//        List<AndroidElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
//        //第一个EditText输入内容Some Name
//        textFieldsList.get(0).sendKeys("Some Name");
//        //第三个EditText输入内容Some Name
//        textFieldsList.get(2).sendKeys("Some@example.com");
//        //在坐(100,500)滑动到(100,100) 时间为2毫秒
////        driver.swipe(100, 500, 100, 100, 2);
//        //用xpath的方式寻找到text值为Save的控件，然后点击
//        driver.findElementByXPath(".//*[@text='Save']").click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElementsById("com.culture.culturalexpo:id/tvLeft").get(0).click();
        driver.findElementsById("com.culture.culturalexpo:id/rbMarket").get(0).click();
        driver.findElementsById("com.culture.culturalexpo:id/tvSearch").get(0).click();
        driver.findElementsById("com.culture.culturalexpo:id/edSearch").get(0).sendKeys("zuny");
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
//        driver.findElementsById('R.id.tvSearch').click();
//        Espresso.onView(withId(R.id.tvSearch)).perform(click());
//        Espresso.onView(withText("钥匙扣")).perform(click());
//        Espresso.onView(withText("鲁迅经典")).perform(click());
//        Espresso.onView(withId(R.id.imgHideShare)).perform(click());
//        Espresso.onView(withText("微信好友")).perform(click());
    }
}

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
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
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
        File appDir = new File(classpathRoot, "/src/main/java/apps/release");
        //app的名字，对应你apps目录下的文件
        File app = new File(appDir, "app-release.apk");
        //创建Capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //设置要调试的模拟器的名字
        capabilities.setCapability("deviceName", "Android Emulator");
        //设置模拟器的系统版本
        capabilities.setCapability("platformVersion", "4.4.2");
        //设置app的路径
        capabilities.setCapability("app", app.getAbsolutePath());
        //设置app的包名
        capabilities.setCapability("appPackage", "com.ironman.autotestappium");
        //设置app的启动activity
        capabilities.setCapability("appActivity", ".MainActivity");
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


    @Test
    public void case1() {
        //进入case1(单选题，我最喜欢吃的食物是什么？，正确答案是：beer 啤酒) 进来先选择选项一、二、三。
        //最后断言 看最终选择的是不是正确答案 beer 啤酒
        driver.findElementsById("com.ironman.autotestappium:id/tvCase1").get(0).click();
        driver.findElementsById("com.ironman.autotestappium:id/rb1").get(0).click();
        driver.findElementsById("com.ironman.autotestappium:id/rb2").get(0).click();
        driver.findElementsById("com.ironman.autotestappium:id/rb3").get(0).click();
        String favoriteFood = driver.findElementsById("com.ironman.autotestappium:id/tvFavoriteFood").get(0).getText();
        assertEquals("beer", favoriteFood);
    }

    @Test
    public void case2() {
        //进入case1(单选题，我最喜欢吃的食物是什么？，正确答案是：beer 啤酒) 进来先选择选项一、二、三、四。
        //最后断言 看最终选择的是不是正确答案 beer 啤酒
        driver.findElementsById("com.ironman.autotestappium:id/tvCase1").get(0).click();
        driver.findElementsById("com.ironman.autotestappium:id/rb1").get(0).click();
        driver.findElementsById("com.ironman.autotestappium:id/rb2").get(0).click();
        driver.findElementsById("com.ironman.autotestappium:id/rb3").get(0).click();
        driver.findElementsById("com.ironman.autotestappium:id/rb4").get(0).click();
        String favoriteFood = driver.findElementsById("com.ironman.autotestappium:id/tvFavoriteFood").get(0).getText();
        assertEquals("beer", favoriteFood);
    }

    @Test
    public void case3() {
        driver.findElementById("com.ironman.autotestappium:id/tvJump").click();
        driver.findElementByXPath("//*[@text='登录']").click();
        driver.findElementById("com.tencent.mm:id/hz").sendKeys("17600000000");
        driver.findElementById("com.tencent.mm:id/alr").click();
        driver.findElementById("com.tencent.mm:id/hz").sendKeys("123456");
        driver.findElementById("com.tencent.mm:id/alr").click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }
}

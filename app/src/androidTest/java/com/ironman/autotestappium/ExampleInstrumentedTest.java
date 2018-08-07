package com.ironman.autotestappium;

import android.support.test.espresso.Espresso;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule(MainActivity.class);

    @Test
    public void case1() {
        //进入case1(单选题，我最喜欢吃的食物是什么？，正确答案是：beer 啤酒) 进来先选择选项一、二、三。
        //最后断言 看最终选择的是不是正确答案 beer 啤酒
        Espresso.onView(withId(R.id.tvCase1)).perform(click());
        Espresso.onView(withId(R.id.rb1)).perform(click());
        Espresso.onView(withId(R.id.rb2)).perform(click());
        Espresso.onView(withId(R.id.rb3)).perform(click());
        Espresso.onView(withId(R.id.tvFavoriteFood)).check(matches(withText("beer")));
    }

    @Test
    public void case2() {
        //进入case1(单选题，我最喜欢吃的食物是什么？，正确答案是：beer 啤酒) 进来先选择选项一、二、三、四。
        //最后断言 看最终选择的是不是正确答案 beer 啤酒
        Espresso.onView(withId(R.id.tvCase1)).perform(click());
        Espresso.onView(withId(R.id.rb1)).perform(click());
        Espresso.onView(withId(R.id.rb2)).perform(click());
        Espresso.onView(withId(R.id.rb3)).perform(click());
        Espresso.onView(withId(R.id.rb4)).perform(click());
        Espresso.onView(withId(R.id.tvFavoriteFood)).check(matches(withText("beer")));
    }

}

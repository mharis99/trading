
package com.haris.android.trade.test.view.activity;

import android.app.Fragment;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;

import com.haris.android.trade.presentation.R;
import com.haris.android.trade.presentation.view.activity.TradeActivity;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import static java.util.regex.Pattern.matches;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

public class TradeActivityTest extends ActivityInstrumentationTestCase2<TradeActivity> {


    private TradeActivity tradeActivity;

    public TradeActivityTest() {
        super(TradeActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        this.setActivityIntent(createTargetIntent());
        this.tradeActivity = getActivity();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testContainsTradeFragment() {
        Fragment tradeFragment =
                tradeActivity.getFragmentManager().findFragmentById(R.id.fragmentContainer);
        assertThat(tradeFragment, is(notNullValue()));
    }

    public void testContainsProperTitle() {
        String actualTitle = this.tradeActivity.getTitle().toString().trim();

        assertThat(actualTitle, is("Trade Details"));
    }

    public void testLoadTradeHappyCaseViews() {


        onView(withId(R.id.rl_retry)).check(matches(not(isDisplayed())));
        onView(withId(R.id.rl_progress)).check(matches(not(isDisplayed())));

        onView(withId(R.id.rv_coins)).check(matches(isDisplayed()));

    }


    private Intent createTargetIntent() {
        Intent intentLaunchActivity =
                TradeActivity.getCallingIntent(getInstrumentation().getTargetContext());

        return intentLaunchActivity;
    }
}

package com.haris.android.trade.test.view.activity;

import android.app.Fragment;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;

import com.haris.android.trade.presentation.R;
import com.haris.android.trade.presentation.view.activity.ChartActivity;
import com.haris.android.trade.presentation.view.activity.TradeActivity;

import static java.util.regex.Pattern.matches;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class ChartActivityTest extends ActivityInstrumentationTestCase2<ChartActivity> {

    private static final String FAKE_COIN_ID = "BTC_XMR";
    private ChartActivity chartActivity;

    public ChartActivityTest() {
        super(ChartActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        this.setActivityIntent(createTargetIntent());
        this.chartActivity = getActivity();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testContainsChartFragment() {
        Fragment chartFragment =
                chartActivity.getFragmentManager().findFragmentById(R.id.fragmentContainer);
        assertThat(chartFragment, is(notNullValue()));
    }

    public void testContainsProperTitle() {
        String actualTitle = this.chartActivity.getTitle().toString().trim();

        assertThat(actualTitle, is("Chart Details"));
    }

    public void testLoadChartHappyCaseViews() {


        onView(withId(R.id.rl_retry)).check(matches(not(isDisplayed())));
        onView(withId(R.id.rl_progress)).check(matches(not(isDisplayed())));

        onView(withId(R.id.chart)).check(matches(isDisplayed()));

    }


    private Intent createTargetIntent() {
        Intent intentLaunchActivity =
                ChartActivity.getCallingIntent(getInstrumentation().getTargetContext(),FAKE_COIN_ID);

        return intentLaunchActivity;
    }
}

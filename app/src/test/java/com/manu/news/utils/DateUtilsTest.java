package com.manu.news.utils;

import com.google.firebase.crash.FirebaseCrash;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;


/**
 * Created by Manu on 7/29/2017.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(FirebaseCrash.class)
public class DateUtilsTest
{
    String correctInputDate1 = "2017-07-29T11:25:27Z";
    String correctOutputDate1 = "Sat, 29 Jul 2017 11:25";

    String incorrectInputDate1 = "2017-07-29T11";

    @Test
    public void formatNewsApiDate_correctDate_outoutsCorrectDate()
    {
        String outputDate = DateUtils.formatNewsApiDate(correctInputDate1);
        assertEquals(outputDate, correctOutputDate1);
    }

    @Test
    public void formatNewsApiDate_nullInput_outputsNull()
    {
        String outputDate = DateUtils.formatNewsApiDate(null);
        assertEquals(outputDate, null);
    }

    @Test
    public void formatNewsApiDate_incorrectInputDate_returnsSame()
    {
        PowerMockito.mockStatic(FirebaseCrash.class);

        String outputDate = DateUtils.formatNewsApiDate(incorrectInputDate1);
        assertEquals(outputDate, incorrectInputDate1);

        PowerMockito.verifyStatic();
        FirebaseCrash.report(Matchers.isA(ParseException.class));
    }
}

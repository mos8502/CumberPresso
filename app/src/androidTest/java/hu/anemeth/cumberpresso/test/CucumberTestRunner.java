package hu.anemeth.cumberpresso.test;

import android.os.Bundle;
import android.support.test.runner.AndroidJUnitRunner;
import android.util.Log;

import cucumber.api.android.CucumberInstrumentationCore;

/**
 * Created by nemi on 2015.01.16..
 */
public class CucumberTestRunner extends AndroidJUnitRunner {
    private CucumberInstrumentationCore cucumberInstrumentationCore = new CucumberInstrumentationCore(this);

    @Override
    public void onCreate(final Bundle bundle) {
        cucumberInstrumentationCore.create(bundle);
        super.onCreate(bundle);
    }

    @Override
    public void onStart() {
        cucumberInstrumentationCore.start();
    }
}

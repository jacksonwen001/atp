package com.chancetop.atp.jmeter.listeners;

import cn.hutool.json.JSONUtil;
import org.apache.jmeter.engine.util.NoThreadClone;
import org.apache.jmeter.reporters.AbstractListenerElement;
import org.apache.jmeter.samplers.*;
import org.apache.jmeter.testelement.TestStateListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public class JMeterResultListener extends AbstractListenerElement implements SampleListener, Clearable, Serializable, TestStateListener, Remoteable, NoThreadClone {
    private static Logger logger = LoggerFactory.getLogger(JMeterResultListener.class);

    @Override
    public void clearData() {

    }

    @Override
    public void sampleOccurred(SampleEvent event) {
        SampleResult result = event.getResult();
        logger.info("result: " + JSONUtil.toJsonPrettyStr(result));
    }

    @Override
    public void sampleStarted(SampleEvent e) {

    }

    @Override
    public void sampleStopped(SampleEvent e) {

    }

    @Override
    public void testStarted() {

    }

    @Override
    public void testStarted(String host) {

    }

    @Override
    public void testEnded() {

    }

    @Override
    public void testEnded(String host) {

    }
}

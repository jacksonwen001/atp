package com.chancetop.atp.utils;

import org.apache.jmeter.testelement.TestPlan;
import org.apache.jmeter.threads.ThreadGroup;
import org.apache.jorphan.collections.HashTree;

public class JMeterAssistUtil {
    private TestPlan createTestPlan(){
        TestPlan testPlan = new TestPlan();
        return  testPlan;
    }

    private ThreadGroup createThreadGroup(){
        ThreadGroup threadGroup = new ThreadGroup();
        return threadGroup;
    }


    public HashTree generate(){
        HashTree rootHashTree = new HashTree();

        return rootHashTree;
    }
}

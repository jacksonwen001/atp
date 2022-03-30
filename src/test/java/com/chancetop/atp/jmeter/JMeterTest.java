package com.chancetop.atp.jmeter;

import cn.hutool.core.io.resource.ResourceUtil;
import com.chancetop.atp.jmeter.core.LocalRunner;
import com.chancetop.atp.jmeter.listeners.JMeterResultListener;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.control.LoopController;
import org.apache.jmeter.control.gui.LoopControlPanel;
import org.apache.jmeter.control.gui.TestPlanGui;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.protocol.http.control.gui.HttpTestSampleGui;
import org.apache.jmeter.protocol.http.sampler.HTTPSamplerProxy;
import org.apache.jmeter.protocol.java.control.gui.JavaTestSamplerGui;
import org.apache.jmeter.protocol.java.sampler.JavaSampler;
import org.apache.jmeter.report.config.ConfigurationException;
import org.apache.jmeter.report.dashboard.ReportGenerator;
import org.apache.jmeter.reporters.ResultCollector;
import org.apache.jmeter.samplers.SampleSaveConfiguration;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.testelement.TestPlan;
import org.apache.jmeter.testelement.property.ObjectProperty;
import org.apache.jmeter.threads.ThreadGroup;
import org.apache.jmeter.threads.gui.ThreadGroupGui;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jmeter.visualizers.ViewResultsFullVisualizer;
import org.apache.jorphan.collections.HashTree;
import org.apache.jorphan.collections.ListedHashTree;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Locale;

import static cn.hutool.core.util.CharsetUtil.UTF_8;

public class JMeterTest {
    public static TestPlan createTestPlan(){
        TestPlan testPlan = new TestPlan();
        testPlan.setName("Test Plan 1");
        testPlan.setProperty(TestElement.TEST_CLASS, TestPlan.class.getName());
        testPlan.setProperty(TestElement.GUI_CLASS, TestPlanGui.class.getName());
        testPlan.setEnabled(true);
        testPlan.setComment("测试-1");
        testPlan.setFunctionalMode(false);
        testPlan.setTearDownOnShutdown(true);
        testPlan.setSerialized(false);
        testPlan.setProperty("TestPlan.user_define_classpath", "");
        //  user defined variable
        testPlan.setUserDefinedVariables(new Arguments());
        return testPlan;
    }
    public static ThreadGroup createThreadGroup(){
        ThreadGroup threadGroup = new ThreadGroup();
        LoopController loopController = new LoopController();
        loopController.setProperty(TestElement.TEST_CLASS, LoopController.class.getName());
        loopController.setProperty(TestElement.GUI_CLASS, LoopControlPanel.class.getName());
        loopController.setEnabled(true);
        loopController.setLoops(1);
        threadGroup.setName("HttpBin Test");
        threadGroup.setComment("Just For Test");
        threadGroup.setEnabled(true);
        threadGroup.setProperty(TestElement.TEST_CLASS, ThreadGroup.class.getName());
        threadGroup.setProperty(TestElement.GUI_CLASS, ThreadGroupGui.class.getName());
        threadGroup.setProperty(ThreadGroup.ON_SAMPLE_ERROR, ThreadGroup.ON_SAMPLE_ERROR_CONTINUE);
        threadGroup.setProperty(ThreadGroup.IS_SAME_USER_ON_NEXT_ITERATION, true);
        threadGroup.setNumThreads(1);
        threadGroup.setRampUp(1);
        threadGroup.setDelay(0);
        threadGroup.setDuration(0);
        threadGroup.setScheduler(false);
        threadGroup.setSamplerController(loopController);
        return threadGroup;
    }
    public static SampleSaveConfiguration createSampleSaveConfiguration(){
        SampleSaveConfiguration sampleSaveConfiguration = new SampleSaveConfiguration();
        sampleSaveConfiguration.setResponseHeaders(true);
        sampleSaveConfiguration.setRequestHeaders(true);
        sampleSaveConfiguration.setAssertions(true);
        sampleSaveConfiguration.setCode(true);
        sampleSaveConfiguration.setDataType(true);
        sampleSaveConfiguration.setEncoding(true);
        sampleSaveConfiguration.setLabel(true);
        sampleSaveConfiguration.setLatency(true);
        sampleSaveConfiguration.setConnectTime(true);
        sampleSaveConfiguration.setMessage(true);
        sampleSaveConfiguration.setResponseData(true);
        sampleSaveConfiguration.setSamplerData(false);
        sampleSaveConfiguration.setSubresults(true);
        sampleSaveConfiguration.setSuccess(true);
        sampleSaveConfiguration.setThreadName(true);
        sampleSaveConfiguration.setTime(true);
        sampleSaveConfiguration.setTimestamp(true);
        sampleSaveConfiguration.setAsXml(false);
        sampleSaveConfiguration.setFieldNames(true);
        sampleSaveConfiguration.setUrl(true);
        sampleSaveConfiguration.setBytes(true);
        sampleSaveConfiguration.setSentBytes(true);
        sampleSaveConfiguration.setAssertionResultsFailureMessage(true);
        sampleSaveConfiguration.setHostname(true);
        sampleSaveConfiguration.setIdleTime(true);

        return sampleSaveConfiguration;
    }
    public static ResultCollector createResultCollector(){
        ResultCollector resultCollector = new ResultCollector();
        resultCollector.setProperty(TestElement.TEST_CLASS, ResultCollector.class.getName());
        resultCollector.setProperty(TestElement.GUI_CLASS, ViewResultsFullVisualizer.class.getName());
        resultCollector.setProperty("ResultCollector.error_logging", false);
        resultCollector.setProperty(new ObjectProperty("saveConfig", createSampleSaveConfiguration()));
        resultCollector.setName("view results");
        resultCollector.setComment("");
        resultCollector.setFilename("result.jtl");
        return resultCollector;
    }
    public static HTTPSamplerProxy createRequest(){
        HTTPSamplerProxy httpSampler = new HTTPSamplerProxy();
        httpSampler.setName("简单的 HTTP Bin 测试");
        httpSampler.setComment("简单测试");
        httpSampler.setEnabled(true);
        httpSampler.setProperty(TestElement.TEST_CLASS, HTTPSamplerProxy.class.getName());
        httpSampler.setProperty(TestElement.GUI_CLASS, HttpTestSampleGui.class.getName());
        httpSampler.setProperty(TestElement.COMMENTS, "");
        httpSampler.setContentEncoding(UTF_8);
        httpSampler.setFollowRedirects(true);
        httpSampler.setAutoRedirects(false);
        httpSampler.setUseKeepAlive(true);
        httpSampler.setDoMultipart(false);
        httpSampler.setConnectTimeout("");
        httpSampler.setResponseTimeout("");
        httpSampler.setEmbeddedUrlRE("");

        httpSampler.setMethod("GET");
        try {
            URL url = new URL("https://httpbin.org/get");
            httpSampler.setDomain(URLDecoder.decode(url.getHost(), UTF_8));
            httpSampler.setPath(URLDecoder.decode(url.getPath(), UTF_8));
            httpSampler.setProtocol(URLDecoder.decode(url.getProtocol(), UTF_8));
        } catch (UnsupportedEncodingException | MalformedURLException e) {
            e.printStackTrace();
        }
//        if(request.getArguments() != null) {
//            Arguments argumentsConf = new Arguments();
//            Map<String, String> arguments = request.getArguments();
//            arguments.keySet().forEach(key -> {
//                HTTPArgument httpArgument = new HTTPArgument(key, arguments.get(key));
//                httpArgument.setAlwaysEncoded(true);
//                argumentsConf.addArgument(httpArgument);
//            });
//            httpSampler.setArguments(argumentsConf);
//        }
//
//
//        if(request.getBody() != null) {
//            httpSampler.addNonEncodedArgument("", request.getBody(),"",
//                    HTTPConstants.APPLICATION_JSON);
//        }
        return httpSampler;
    }


    @Test
    public void testHttpbin(){
        String JMETER_HOME = ResourceUtil.getResource("./jmeter").getPath();
        String JMETER_PROPERTIES = JMETER_HOME + "/bin/jmeter.properties";
        JMeterUtils.loadJMeterProperties(JMETER_PROPERTIES);
        JMeterUtils.setJMeterHome(JMETER_HOME);
        JMeterUtils.setLocale(Locale.ENGLISH);

        HashTree rootTree = new ListedHashTree();
        HashTree groupTree = new ListedHashTree();
        HashTree resultTree = new ListedHashTree();
        HashTree requestTree = new ListedHashTree();

        ResultCollector resultCollector = createResultCollector();
        resultTree.add(resultCollector);
        ThreadGroup threadGroup = createThreadGroup();
        groupTree.put(threadGroup, resultTree);
//        groupTree.add(createRequest());
        requestTree.add(createRequest());
        requestTree.add(new JMeterResultListener());
        groupTree.add(requestTree);

        rootTree.put(createTestPlan(), groupTree);
//        StandardJMeterEngine engine = new StandardJMeterEngine();
//        engine.configure(rootTree);
//        engine.run();
        LocalRunner localRunner = new LocalRunner(rootTree);
        localRunner.run("test-1");
    }
}

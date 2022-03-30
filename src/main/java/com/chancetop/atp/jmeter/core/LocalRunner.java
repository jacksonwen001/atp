package com.chancetop.atp.jmeter.core;

import lombok.Getter;
import lombok.Setter;
import org.apache.jmeter.engine.JMeterEngineException;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jorphan.collections.HashTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
@Setter
public class LocalRunner {
    private static Logger logger = LoggerFactory.getLogger(LocalRunner.class);
    private HashTree jmxHasTree;

    public LocalRunner(HashTree jmxHasTree) {

        this.jmxHasTree = jmxHasTree;
    }

    /**
     * 开始执行脚本
     * @param name
     */
    public void run(String name){
        StandardJMeterEngine engine = new StandardJMeterEngine();
        engine.configure(this.jmxHasTree);
        JMeterCaches.engineCaches.put(name, engine);
        logger.info("开始执行测试： " +  name);
        engine.run();
    }

    /**
     * 停止执行测试脚本
     * @param name
     */
    public void stop(String name) {
        if(name.isEmpty()){
           return ;
        }
        StandardJMeterEngine engine = (StandardJMeterEngine)JMeterCaches.engineCaches.get(name);
        if(engine != null) {
            engine.stopTest(true);
        }
    }
}

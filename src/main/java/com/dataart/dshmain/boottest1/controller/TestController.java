package com.dataart.dshmain.boottest1.controller;

import com.dataart.dshmain.boottest1.properties.ExternalProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RefreshScope
@RestController
@RequestMapping(path="/test")
public class TestController {


    @Value("${testprop.prop1}")
    private String prop1;

    @Value("${testprop.prop2}")
    private String prop2;

    @Value("${testprop.prop3}")
    private String prop3;

    private ExternalProperties propsConfig;

    public TestController(ExternalProperties propsConfig) {
        this.propsConfig = propsConfig;
    }

    @RequestMapping(path="/props", method=RequestMethod.GET)
    public List<String> testExtrenalProp() {
        List<String> props = new ArrayList<>();
        props.add("@Value prop1: " + prop1);
        props.add("@Value prop2: " + prop2);
        props.add("@Value prop3: " + prop3);
        props.add("Configuration prop1:" + propsConfig.getProp1());
        props.add("Configuration prop2:" + propsConfig.getProp2());
        props.add("Configuration prop3:" + propsConfig.getProp3());
        return props;
    }

}

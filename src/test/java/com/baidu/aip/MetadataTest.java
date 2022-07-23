package com.baidu.aip;

import com.baidu.aip.config.BaiduProperties;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.FileSystemResource;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class MetadataTest {

    @Test
    public void checkSpringConfigurationMetadataJson() throws IOException {
        DocumentContext documentContext = JsonPath.parse(new FileSystemResource("target/classes/META-INF/spring-configuration-metadata.json").getInputStream());
        List<Map<String, String>> properties = documentContext.read("$.properties");
        Map<String, Metadata> metadataMap = properties.stream().map(map -> new Metadata(map.get("name"), map.get("type"), map.get("sourceType"))).collect(Collectors.toMap(Metadata::getName, metadata -> metadata));
        metadataMap.keySet().forEach(System.err::println);
        Assert.assertEquals(metadataMap.get("baidu.sdk.socket-timeout"), new Metadata("baidu.sdk.socket-timeout", Integer.class.getName(), BaiduProperties.class.getName()));
    }

    @Data
    @AllArgsConstructor
    private static class Metadata {
        private String name;
        private String type;
        private String sourceType;
    }


}

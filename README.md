##### application.yml文件配置
```yml
baidu:
  sdk:
    socket-timeout: 10000
    connection-timeout: 10000
    face:
      group-id: xxx
      app-id: 521650789
      api-key: bhaMq1aE5ADmt2odIumBxvkD
      secret-key: eEZU8IYQVwvNgMHYFlu4AafmGrb5ETQx
    orc:
      app-id: 320651799
      api-key: xhaMq1aE5ADmt2cdIumBxvkE
      secret-key: zEZU8IYQVsvNgMHYFlu4AafmGrb5ETQs
```

##### maven配置
```xml
        <dependency>
            <groupId>com.baidu.aip</groupId>
            <artifactId>java-sdk</artifactId>
            <version>4.16.10</version>
            <exclusions>
                <exclusion>
                    <artifactId>slf4j-simple</artifactId>
                    <groupId>org.slf4j</groupId>
                </exclusion>
            </exclusions>
        </dependency>
```

##### gradle配置
```groovy
dependencies {
    
    implementation('com.baidu.aip:java-sdk:4.16.10') {
        exclude group: 'org.slf4j'
    }
    
    implementation fileTree(dir: "lib", include: ['*.jar'])
}
```


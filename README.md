链路追踪服务
================
        sleuthServer提供请求路由追踪功能
     
## 配置
## 引入jar包
```
compile group: 'org.springframework.cloud', name: 'spring-cloud-starter-sleuth', version: '1.3.0.RELEASE'
compile group: 'org.springframework.cloud', name: 'spring-cloud-sleuth-zipkin-stream', version: '1.3.0.RELEASE'
compile group: 'org.springframework.cloud', name: 'spring-cloud-stream-binder-kafka', version: '1.3.0.RELEASE'
compile group: 'org.springframework.boot', name: 'spring-boot-starter-log4j', version: '1.3.0.RELEASE' /*如果不报错可不引入log4j*/
```
## 配置文件<br>
  格式如下
#### yml方式
```
spring:
  sleuth:
    enabled: false
    sampler:
      percentage: 1.0
  cloud:
    stream:
      kafka:
        binder:
          brokers: 172.16.105.145:9092 #kafka
          zkNodes: 172.16.105.145:2181 #zookeeper
```
#### groovy方式

```
spring {
            ......
            
            mqPath = "kafka.production.svc.cluster.local"#各环节的kafka地址
            sleuth{
                enabled = true
                sampler {
                    percentage = 1
                }
            }
            cloud{
                stream{
                    kafka{
                        binder{
                            brokers = "${mqPath}:9092"
                            zkNodes = "${mqPath}:2181"
                        }
                    }
                }
            }
        }
```
#### kafka消息序列号修改

```
producer
valueSerializer = org.apache.kafka.common.serialization.StringSerializer
改成
valueSerializer = org.apache.kafka.common.serialization.ByteArraySerializer

consumer
valueDeserializer = org.apache.kafka.common.serialization.StringDeserializer
改成
valueDeserializer = org.apache.kafka.common.serialization.ByteArrayDeserializer
```


## cloudjar升级
spring-cloud-starter-eureka和spring-cloud-starter-hystrix升级到1.4.5.RELEASE
```
compile ('org.springframework.cloud:spring-cloud-starter-eureka:1.4.5.RELEASE'){
        exclude group:"io.reactivex"
        exclude group:"com.google.inject.extensions"
    }
compile "org.springframework.cloud:spring-cloud-starter-hystrix:1.4.5.RELEASE"
```

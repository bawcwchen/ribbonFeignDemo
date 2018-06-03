# ribbonFeignDemo
利用ribbon和Feign调用服务2种方法
各模块说明：  
eurekaServer：注册中心集群  
serviceProvider:服务提供者集群，注册到注册中心集群  
serviceConsumerByRibbon：通过restTemplate+ribbon方式调用服务,并加入断路器功能，对调用失败的服务兜底  
serviceConsumerByFeign：通过Feign的接口方式调用服务，并加入断路器功能，对调用失败的服务兜底  
hystrixTurbine：各应用的断路器监控中心。  

thrift RPC 客户端。对应的服务端是book-service-drift。  
主要RPC相关逻辑在com.xiuwei.douban.rpc.BookConfig，它生成了book RPC服务的客户端代理(bookRpcService)，并注册到了Spring容器中，供controller使用。  
同时，本服务提供了一个Http接口，供外部用户调用。本服务再调用Book服务获取数据。  
链路： 浏览器—http-->douban-service --rpc--> book-service

启动方法：  
1、在book-service-drift项目，运行DriftServerRunner，来启动RPC服务。  
2、在本项目，运行DoubanApplication，启动SpringBoot程序，程序暴露了一个HTTP接口。  

效果：  
在浏览器访问：http://localhost:8080/api/book/1  
界面展示：{"id":1,"name":"红楼梦","author":{"id":1,"name":"曹雪芹","country":"中国"},"publishTime":1698917580039}
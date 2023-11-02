thrift RPC 客户端。对应的服务端是book-service-drift。  
同时，本服务提供了一个Http接口，共外部用户调用。本服务再调用Book服务获取数据。  
链路： 浏览器—http-->douban-service --rpc--> book-service

启动方法：  
1、在book-service-drift项目，运行DriftServerRunner，来启动服务。  
2、在本项目，运行DoubanApplication，启动SpringBoot程序。  

效果：  
在浏览器访问：http://localhost:8080/api/book/1  
界面展示：{"id":1,"name":"红楼梦","author":{"id":1,"name":"曹雪芹","country":"中国"},"publishTime":1698917580039}
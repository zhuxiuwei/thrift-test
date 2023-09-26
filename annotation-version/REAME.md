基于注解版本的。
thrift-server、thrift-client是IDL的。  

[Thrift 注解开发规范](https://km.sankuai.com/page/28187066)  
[Thrift(二)：Thrift注解](https://blog.csdn.net/mingyuli/article/details/118464964)  

1、Thrift注解开发介绍
Java服务开发流程上，取消IDL。  
注解方式和IDL方式一样，不支持泛型。
使用注解开发方式时，应避免IDL和注解混用。  

3、注解和IDL规范
service       --     @ThriftService  
struct          --     @ThriftStruct  
struct属性   --     @ThriftField  
enum          --      @ThriftEnumValue  

4、编码规范
在swift中service一般以接口的形式存在  
整个类用@ThriftService注解  
方法用@ThriftMethod注解  
异常用@ThriftMethod(exception = {@ThriftException(type = InvalidException.class, id = 1)})  
@ThriftStruct注解类、枚举、异常  
成员变量的get方法用@ThriftField(1)注解，括号里面的表示字段的ID，这个在thrift文件里有体现。set方法不需要ID  
构造器用@ThriftConstructor注解  
枚举用@ThriftEnum注解  
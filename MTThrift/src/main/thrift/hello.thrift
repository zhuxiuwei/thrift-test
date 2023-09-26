namespace java com.meituan.mtthrift.test
service HelloService
{
    string sayHello(1:string username)
    string sayBye(1:string username)
}
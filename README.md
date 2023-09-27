# 背景
thrift学习。  
java注解版确实可以完全不使用IDL文件。

# 工程子module说明
| ID  | 工程                 | 说明                                                                                                                                        | 参考                                                                                                                                                                                                  |
| --- | -------------------- | ------------------------------------------------------------------------------------------------------------------------------------------- |-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1   | thrift-server        | IDL版的Server和service                                                                                                                      | [B站视频](https://www.bilibili.com/video/BV1f54y1o7Cm)                                                                                                                                                 |
| 2   | thrift-client        | IDL版的客户端                                                                                                                               | [B站视频](https://www.bilibili.com/video/BV1f54y1o7Cm)                                                                                                                                                 |
| 3   | annotation-version   | facebook注解版尝试。跑不通，参考材料太少                                                                                                    | [facebook swift](https://github.com/facebookarchive/swift/tree/master),18年停止维护; [thrift:swift项目笔记](https://blog.csdn.net/weixin_33701294/article/details/90305200)                                  |
| 4   | airlift-drift-server | drfit注解版的Server+service，能跑通 。[drift](https://github.com/airlift/drift/tree/master)是facebook swift的替代，资料不多，用的人也不太多 | [drift-server文档](https://github.com/airlift/drift/tree/master/drift-server#creating-a-server) ； [一些示例代码](https://www.tabnine.com/code/java/classes/io.airlift.drift.server.DriftServer), presto有用到； |
| 5   | airlift-drift-client | drfit注解版的client，能跑通                                                                                                                 | [drift-client文档](https://github.com/airlift/drift/tree/master/drift-client)                                                                                                                         |


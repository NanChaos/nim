# NIM
N: nanchaos
IM: 即时通讯
这个主要是想将自己学到的技术都融合在一起，也不知道能做多久......

### PART
#### PART ONE
主要是记录一些想法, 会很杂乱（预计）
基于SpringBoot，暂时不使用微服务，手头服务器数量较少，配置也较低
- 配置中心：Apollo，不考虑Nacos
- Dubbo注册中心：Zookeeper
- 数据库：MySQL 8.x, MongoDB, Redis
- 消息队列：Kafka, 消息发送失败，需要重发，所以需要有用户是否接收到的状态，以及消息队列的重发
- 搜索ElasticSearch：有必要吗? ES的性能是很强，但是IM暂时没想到有什么地方会用到
- 定时任务：esJob

###### 模块 IDEA
user model:NUS(nanchaos user system)
为了长远考虑，决定将用户模块独立出来,用户模块独立出来，未来考虑连接到nanchaos.cn, 但是用户信息还是存储在NUS，但是NIM会存储用户的好友关系等等各种信息


###### 关于用户的状态
使用Redis保存用的在线、离线状态, 用户登录会主动触发上线操作，连接断开认为离线，Redis有hash结构
```text
USER_${UID}_ONLINE_STATUS:0
USER_${UID}_ONLINE_STATUS:1
eg: USER_113:0
```
```json
{
  "USER_ONLINE_STATUS": [
    {
      "USER_113": "1"
    },
    {
      "USER_109": "0"
    },
    {
      "USER_145": "1"
    }
  ]
}
```

###### 关于消息的存储
消息分为未读/已读，  
消息的存储也是问题，使用mongoDB存储，因为MongoDB的特殊性，消息记录可以按表划分
Message_${sender_uid}_To_Receiver_${uid},   msg_record_112_to_301
```text
大致需要以下几个字段
msgId               消息ID
msgBody             消息体
msgType             消息类型：文本（包括emoji、链接）、img、video、file、specialType（特殊类型、代指一些可以暂时没有考虑到的、可拓展的）
receiverUid         谁发的
senderUid           发给谁
sendTime            发送时间
receiverReadStatus  阅读状态

```

#### PART TWO
文本消息体
```
message ChatMsg {
  id = 1;
  // 消息id
  fromId = Alice
  // 发送者userId
  destId = Bob
  // 接收者userId
  msgBody = hello
  // 消息体
}
```

回执
```
message AckMsg {
    id;
    //消息id
    fromId;
    //发送者id
    destId;
    //接收者id
    msgType;
    //消息类型
    ackMsgId;
    //确认的消息id
}
```
**消息发送状态**
```
enum MsgSendStatus {
    DELIVERED;
    READED;
}
```

#### PART THREE
上手，这一部分会同步至[nanchaos的个人空间](http://blog.nanchaos.cn), 可以参考一下

###### 搭建Apollo
先暂停，等待服务器到手

##### 搭建Zookeeper



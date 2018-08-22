# Singleton Pattern
## 1 饥汉模式
> 全局的单例实例在类装载时创建

* 私有构造器
* private static修饰成员变量
* 对外暴露一个public方法，返回成员变量

> 优点：线程安全
---
> 缺点：在类加载时初始化实例,如果不用，就会造成资源浪费 
---
## 2 懒汉模式
> 全局的单例实例在第一次使用时构建

## 3 在方法上加锁单例模式

## 4 Double-check

## 5 Static Inner Class

## 6 Enum



## 参考文档
* [https://blog.csdn.net/qq_34337272/article/details/80455972](https://blog.csdn.net/qq_34337272/article/details/80455972)
* [https://github.com/CyC2018/CS-Notes/blob/master/notes/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F.md#1-%E5%8D%95%E4%BE%8Bsingleton](https://github.com/CyC2018/CS-Notes/blob/master/notes/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F.md#1-%E5%8D%95%E4%BE%8Bsingleton)
* [https://mp.weixin.qq.com/s?__biz=MzI4Njc5NjM1NQ==&mid=2247485196&idx=1&sn=777aabdd20d10b1256a7dfcb163e034f&chksm=ebd63820dca1b13693e388860764852702c46d56c25052b84ab7f93b179a1194326f01726307&mpshare=1&scene=1&srcid=0413oZI7weUxgxbty24RG3br#rd](https://mp.weixin.qq.com/s?__biz=MzI4Njc5NjM1NQ==&mid=2247485196&idx=1&sn=777aabdd20d10b1256a7dfcb163e034f&chksm=ebd63820dca1b13693e388860764852702c46d56c25052b84ab7f93b179a1194326f01726307&mpshare=1&scene=1&srcid=0413oZI7weUxgxbty24RG3br#rd)
# Singleton Pattern
## 1 饥汉模式
> 全局的单例实例在类装载时创建;典型的空间换时间,每次调用时,不用再去判断,直接调用;这种实现方式适合那些在初始化时就要用到单例的情况，这种方式简单粗暴，如果单例对象初始化非常快，而且占用内存非常小的时候这种方式是比较合适的，可以直接在应用启动时加载并初始化

> 优点：线程安全

> 缺点：在类加载时初始化实例,如果不用,就会造成资源浪费 
* 私有构造器
* private static修饰成员变量
* 对外暴露一个public方法，返回成员变量

```
public class HungryMode {

	private static HungryMode hungryMode = new HungryMode();

	private HungryMode() {

	}
	
	public static HungryMode getInstance() {
		return hungryMode;
	}
	
}
```

* 典型应用:Java Runtime

```
public class Runtime {
    private static Runtime currentRuntime = new Runtime();

    /**
     * Returns the runtime object associated with the current Java application.
     * Most of the methods of class <code>Runtime</code> are instance
     * methods and must be invoked with respect to the current runtime object.
     *
     * @return  the <code>Runtime</code> object associated with the current
     *          Java application.
     */
    public static Runtime getRuntime() {
        return currentRuntime;
    }

    /** Don't let anyone else instantiate this class */
    private Runtime() {}
    //省略剩下代码
```
---

## 2 懒汉模式
> 全局的单例实例在第一次使用时构建,典型的时间换空间

> 优点：在第一次使用时才实例化该对象,节省资源

> 缺点：单线程没问题,多线程会出现线程不安全问题;当有多个线程一起工作的时候，如果有两个线程同时运行到 if (mode == null)，都判断为null（第一个线程判断为空之后，并没有继续向下执行，当第二个线程判断的时候instance依然为空），最终两个线程就各自会创建一个实例出来。

* 一个静态成员变量，初始化为null
* 一个private修饰的构造器
* 在getInstance()返回实例化对象

```
public class LazyMode {

	private static LazyMode mode = null;

	private LazyMode() {
		super();
	}
	
	public LazyMode getInstance() {
		if(mode == null) {
			mode = new LazyMode();
		}
		return mode;
	}
}
```
---

## 3 懒汉模式下,在方法上加锁或者方法内添加同步代码块
> 针对第二个提到的懒汉模式线程不安全问题,可以在getInstance()方法上加上`synchronized`,保证当有一个线程访问getInstance()方法时,其他的线程不能访问

> 优点：线程安全

> 缺点：虽然在jdk1.6之后进行了包括自旋锁,锁消除,锁粗化,偏向锁,轻量级锁等优化,但synchronized关键字偏重量级锁。当有线程访问时，其他的线程只能等待该线程执行完成,释放了锁，才可以再次进入，降低了程序的执行效率

```
synchronized method
// Optimize method1:method add synchronized keyword.
public synchronized LazyMode getInstanceOptimize1() {
	if (mode == null) {
		mode = new LazyMode();
	}
	return mode;
}

synchronized block
// Optimize method2:add synchronized block.
public LazyMode getInstanceOptimize2() {
	synchronized (LazyMode.class) {
		if (mode == null) {
			mode = new LazyMode();
		}
	}
	return mode;
}
```
* [synchronized method VS synchronized block](https://www.cnblogs.com/signheart/p/0a8548258725cb8812768d2b3e1a2aef.html)

* JDK InputMethodManager  sample

```
public final class InputMethodManager {

    static InputMethodManager sInstance;
    
     /**
     * Retrieve the global InputMethodManager instance, creating it if it
     * doesn't already exist.
     * @hide
     */
    public static InputMethodManager getInstance() {
        synchronized (InputMethodManager.class) {
            if (sInstance == null) {
                IBinder b = ServiceManager.getService(Context.INPUT_METHOD_SERVICE);
                IInputMethodManager service = IInputMethodManager.Stub.asInterface(b);
                sInstance = new InputMethodManager(service, Looper.getMainLooper());
            }
            return sInstance;
        }
    }
}
```
---

## 4 Double-check
```
public class DoubleCheckSingleton {

	// 禁止JVM指令重排
	private static volatile DoubleCheckSingleton singleton = null;

	private DoubleCheckSingleton() {
		super();
	}

	public static DoubleCheckSingleton getInstance() {
		// 检查实例是否存在
		if (singleton == null) <1>{
			// 只有当第一次创建时才会进入
			synchronized (DoubleCheckSingleton.class) {
				// 进入同步代码块,如果还是null,创建实例
				if (singleton == null)<2> {
					singleton = new DoubleCheckSingleton();
				}
			}
		}
		return singleton;
	}
}
```
* <1> 处的if(singleton == null)是为了解决4中加锁代码的效率问题,只有instance为null的时候，才进入synchronized的代码段大大减少了几率
* <2> 第二个if(instance==null),则是为了防止可能出现多个实例的情况
* 原子操作:一个或多个操作要么都执行成功,要么都不执行,并且执行的过程不会被任何因素打断
 * Java只保证了基本数据类型的变量和赋值操作才是原子 性的(在32位的JDK环境下,对64位数据的读取不是原子操作：long,double)
* 指令重排:在不影响最终结果的情况下,就是计算机为了提高执行效率,编译器和处理器会做的一些优化,可能会对一些语句的执行顺序进行调整,即重新排序.如下代码,正常执行时,1-2-3-4;但是由于指令重排的原因,在不影响最终结果的情况下,实际的执行顺序可能是3-1-2-4或者1-3-2-4

```
int i; //1
i = 2; //2
int j = 5; //3
int z = i + j; //4
```

---

## 5 Static Inner Class

```
public class Singleton {

	//静态内部类
	private static class SingletonHolder {
		private static final Singleton INSTANCE = new Singleton();
	}

	private Singleton() {
	}

	public static final Singleton getInstance() {
		return SingletonHolder.INSTANCE;
	}
}
```
---

## 6 Enum
* 无偿地提供了序列化机制
* 《Effective Java》作者推荐方式
* 由JVM从根本上提供保障
* 是更简洁、高效、安全的实现单例的方式

```
public enum SingletonEnum {

	//定义一个枚举类型的元素,它就是SingletonEnum的一个实例
	INSTANCE;
		
	public void fun() {
		System.out.println("Do something.");
	}
}
```
---

## 7 参考文档
* [https://blog.csdn.net/qq_34337272/article/details/80455972](https://blog.csdn.net/qq_34337272/article/details/80455972)
* [https://github.com/CyC2018/CS-Notes/blob/master/notes/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F.md#1-%E5%8D%95%E4%BE%8Bsingleton](https://github.com/CyC2018/CS-Notes/blob/master/notes/%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F.md#1-%E5%8D%95%E4%BE%8Bsingleton)
* [https://mp.weixin.qq.com/s?__biz=MzI4Njc5NjM1NQ==&mid=2247485196&idx=1&sn=777aabdd20d10b1256a7dfcb163e034f&chksm=ebd63820dca1b13693e388860764852702c46d56c25052b84ab7f93b179a1194326f01726307&mpshare=1&scene=1&srcid=0413oZI7weUxgxbty24RG3br#rd](https://mp.weixin.qq.com/s?__biz=MzI4Njc5NjM1NQ==&mid=2247485196&idx=1&sn=777aabdd20d10b1256a7dfcb163e034f&chksm=ebd63820dca1b13693e388860764852702c46d56c25052b84ab7f93b179a1194326f01726307&mpshare=1&scene=1&srcid=0413oZI7weUxgxbty24RG3br#rd)
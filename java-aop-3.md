## AOP (面向切面编程) 系列之三
上接 `java 注解（annotation）`、`AOP (面向切面编程) 系列之一 spring xml 配置方式` 、`AOP (面向切面编程) 系列之二 AspectJ 注解方式`，Pointcut expression 祥解。

### AspectJ expression
- **execution**      
匹配方法的切入点，最为常用,`*` 是通配符。    
格式：     
```
execution(方法返回值类型 方法名(形参类型，…))
```
形参可以有多个（根据实际情况而定），不写无法匹配带参函数；        
方法返回值类型 可由 `*` 匹配所有；        
方法名 可以精确到 包名.类名.方法名 ，每一部分都可以用 `*` 匹配所有。     
类名需要是绝对路径，不能是父类或者接口的路径。         
示例：
```
    @Pointcut("execution(* com.hxx.api.impl.*.*(*)))")
    public void doPointExecution() {
    }
```
- **within**      
使用类型匹配切入点       
格式： 
```
within(类绝对路径)
```
以类名绝对路径作为匹配条件，若是父类或接口路径则不起效。可用  `*` 匹配包下所有类。        
示例：
```
    @Pointcut("within(com.hxx.api.impl.*)")
    public void doPointWithIn() {
    }
```

- **this**    
使用实例类型匹配切入点         
this 后跟类（或者接口）的绝对路径
示例：
```
    @Pointcut("this(com.hxx.api.ApiDemo)")
    public void doPointThis() {
    }
```


- **args**        
- **@target**        
- **@args**        
- **@within**        
- **@annotation**        


### spring expression

- **@Pointcut**     
定义切入点，类似 xml 配置方式中的 `aop:pointcut` 标签。     
参数是切入点的表达式（expression），上例中 `"@annotation(com.hxx.annotation.AnnotationTwo)"` 是指代所有被 AnnotationTwo 注解标注的地方。 expression 的写法有很多种，此处继续挖坑，以后填。       
`@Pointcut` 标注的方法名会作为切入点在下面的注解中使用到，但本身这个注解非必需，且方法体并不会被执行。

### 补遗
1. 无论是 AspectJ 注解方式还是 Spring xml 配置方式，在 spring-aop 中都只支持 Spring beans；      
2. `@Pointcut` 标注的方法，方法名不重要，返回值一定要是 `void`;     
3. 只列举了在 Spring 中支持的 Pointcut expression，AspectJ 中还有其他种类的 expression 在 Spring 中不支持，比如：`call, get, set, preinitialization, staticinitialization, initialization, handler, adviceexecution, withincode, cflow, cflowbelow, if, @this, and @withincode`，在 Spring 中使用会抛出 `IllegalArgumentException` 异常；     
4. 

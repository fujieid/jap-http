# jap-http

## 介绍

抽象 javax.servlet.http 包下的类，包括：request、response、cookie、session，用来适配第三方框架，比如：blade、jakarta等

- http 接口：https://gitee.com/fujieid/jap-http
- http 适配器：https://gitee.com/fujieid/jap-http-adapter

## 快速开始

1. 引入依赖
```xml
<dependency>
    <groupId>com.fujieid.jap.http</groupId>
    <artifactId>jap-http</artifactId>
    <version>1.0.0</version>
</dependency>
```
2. 引入需要适配的第三方框架，此处以 `jakarta.servlet` 为例
```xml
<dependency>
    <groupId>jakarta.servlet</groupId>
    <artifactId>jakarta.servlet-api</artifactId>
    <version>4.0.4</version>
</dependency>
```
3. 实现 `jap-http` 的接口，以 `request` 为例
```java
public class JakartaRequestAdapter implements JapHttpRequest {

    private final HttpServletRequest request;

    public JakartaRequestAdapter(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public String getParameter(String name) {
        return this.request.getParameter(name);
    }
    // ...
}
```
4. 在需要适用 `HttpServletRequest` 的地方，替换为

```java
new JakartaRequestAdapter(HttpServletRequest);
```

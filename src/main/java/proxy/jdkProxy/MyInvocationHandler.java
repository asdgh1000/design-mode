package proxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/** @author ltw on 10/10/2018. */
public class MyInvocationHandler implements InvocationHandler {
  private Object target;

  MyInvocationHandler(Object target) {
    this.target = target;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println(
        "begin to increase------------" + target.getClass().getName() + "." + method.getName());

    Object result = method.invoke(target, args);

    System.out.println(
        "end increased------------" + target.getClass().getName() + "." + method.getName());
    return result;
  }

  public Object getProxy() {

    return Proxy.newProxyInstance(
        Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces(), this);
  }
}

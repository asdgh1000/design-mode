package proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/** @author ltw on 10/10/2018. */
public class CglibProxy implements MethodInterceptor {

  private Enhancer enhancer = new Enhancer();

  public Object getProxy(Class clazz) {

    enhancer.setSuperclass(clazz);
    enhancer.setCallback(this);
    // enhancer.setCallbackType(clazz);;
    return enhancer.create();
  }

  @Override
  public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy)
      throws Throwable {
    System.out.println(
        "begin to increase------------" + o.getClass().getName() + "." + method.getName());

    Object result = methodProxy.invokeSuper(o, args);
    //  Object result = method.invoke(obj, args);  proxy by jdk proxy

    System.out.println(
        "end increased------------" + o.getClass().getName() + "." + method.getName());
    return result;
  }
}

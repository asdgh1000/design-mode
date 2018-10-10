package proxy.jdkProxy;

/** @author ltw on 10/10/2018. */
public class Test {
  public static void main(String[] args) {
    // save proxy class in disk
    System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

    TargetInterface target = new TargerImpl();
    MyInvocationHandler handler = new MyInvocationHandler(target);
    TargetInterface proxy = (TargetInterface) handler.getProxy();
    proxy.save();
  }
}

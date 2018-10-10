package proxy.cglib;

/** @author ltw on 10/10/2018. */
public class Test {

  public static void main(String[] args) {

    // save proxy class in disk
    System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

    TargetInterface service = new TargerImpl();
    CglibProxy cp = new CglibProxy();
    TargetInterface proxy = (TargetInterface) cp.getProxy(service.getClass());
    proxy.save();
//    proxy.toString();
  }
}

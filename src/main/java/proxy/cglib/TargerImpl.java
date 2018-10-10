package proxy.cglib;

/** @author ltw on 10/10/2018. */
public class TargerImpl implements TargetInterface {

  /**
   * implemented target method
   */
  @Override
  public void save() {
    System.out.println("--------------save entrust in db");
  }

}

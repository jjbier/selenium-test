import junit.framework.Test;
import junit.framework.TestSuite;

public class Google_exports {

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTestSuite(Untitled.class);
    return suite;
  }

  public static void main(String[] args) {
    junit.textui.TestRunner.run(suite());
  }
}

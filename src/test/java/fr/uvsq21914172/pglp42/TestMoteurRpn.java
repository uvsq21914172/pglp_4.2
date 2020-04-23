package fr.uvsq21914172.pglp42;

import static org.junit.Assert.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import org.junit.Test;

public class TestMoteurRpn {

  @Test
  public void testShow() throws UnsupportedEncodingException {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    TestControleurRpn tcr = new TestControleurRpn(os);
    tcr.show();
    assertTrue("Stack:\r\n\r\n".equals(os.toString("UTF-8")));
  }

  @Test
  public void testPush() throws UnsupportedEncodingException {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    TestControleurRpn tcr = new TestControleurRpn(os);
    tcr.push(1.0);
    tcr.show();
    assertTrue("Stack:\r\n1.0 \r\n".equals(os.toString("UTF-8")));
  }
  
  @Test
  public void testAddition() throws UnsupportedEncodingException {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    TestControleurRpn tcr = new TestControleurRpn(os);
    tcr.push(1.0);
    tcr.push(0);
    tcr.add();
    tcr.show();
    assertTrue("Stack:\r\n1.0 \r\n".equals(os.toString("UTF-8")));
  }
  
  @Test
  public void testMultiply() throws UnsupportedEncodingException {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    TestControleurRpn tcr = new TestControleurRpn(os);
    tcr.push(2.0);
    tcr.push(0.5);
    tcr.multiply();
    tcr.show();
    assertTrue("Stack:\r\n1.0 \r\n".equals(os.toString("UTF-8")));
  }
  
  @Test
  public void testSubstract() throws UnsupportedEncodingException {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    TestControleurRpn tcr = new TestControleurRpn(os);
    tcr.push(2.0);
    tcr.push(1.0);
    tcr.substract();
    tcr.show();
    assertTrue("Stack:\r\n1.0 \r\n".equals(os.toString("UTF-8")));
  }
  
  @Test
  public void testDivide() throws UnsupportedEncodingException {
    ByteArrayOutputStream os = new ByteArrayOutputStream();
    TestControleurRpn tcr = new TestControleurRpn(os);
    tcr.push(2.0);
    tcr.push(2.0);
    tcr.divide();
    tcr.show();
    assertTrue("Stack:\r\n1.0 \r\n".equals(os.toString("UTF-8")));
  }
}


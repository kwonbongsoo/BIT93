package step16;


import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MyArrayInputStream extends ByteArrayInputStream{
  
 

  public MyArrayInputStream(byte[] buf) {
    super(buf);
    // TODO Auto-generated constructor stub
  }

  public byte readByte() throws IOException{
    byte b;
    return (byte) this.read();
  }
  
  public short readShort() throws IOException{
    short s;
    
    s = (short)(this.read() << 8);
    s |= (short)(this.read());
    return s;
  }
  public int readInt() throws IOException{
    int i;
    i = (int)(this.read() << 24);
    i |= (int)(this.read() << 16);
    i |= (int)(this.read() << 8);
    i |= (int)(this.read());
    
    return i;
  }
  
  public String readUTF() throws IOException{
    int len;
    len = (int)(this.read() << 8);
    len |= (int)(this.read());
    
    byte[] buf = new byte[len];
    
     this.read(buf);
     String str1 = new String(buf, "UTF-8");
     return str1;
  }
}

package step16;



import java.io.IOException;
import java.io.InputStream;

public class DataInputStream {
  InputStream in;
 

  public DataInputStream(InputStream in)  {
    this.in = in;
    // TODO Auto-generated constructor stub
  }

  public byte readByte() throws IOException{
    byte b;
    return (byte) in.read();
  }
  
  public short readShort() throws IOException{
    short s;
    
    s = (short)(in.read() << 8);
    s |= (short)(in.read());
    return s;
  }
  public int readInt() throws IOException{
    int i;
    i = (int)(in.read() << 24);
    i |= (int)(in.read() << 16);
    i |= (int)(in.read() << 8);
    i |= (int)(in.read());
    
    return i;
  }
  
  public String readUTF() throws IOException{
    int len;
    len = (int)(in.read() << 8);
    len |= (int)(in.read());
    
    byte[] buf = new byte[len];
    
     in.read(buf);
     String str1 = new String(buf, "UTF-8");
     System.out.println(str1);
     return str1;
  }
  
  public void close() throws IOException {
    in.close();
  }
}

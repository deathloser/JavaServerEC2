import java.io.*;
import java.net.*;

/**
* The ServerProgram accepts a single client and sends a word
* based on the integer received from the client. This is part
* of the demo program for the video How to Test a Java Network App on an
* AWS EC2 Linux 2 Instance (https://youtu.be/_j5jyOXYPms).
*
* YT: youtube.com/choobtorials
* Twitter: twitter.com/choobtorials
*
* @author choob
*/

public class ServerProgram2 {

  public ServerProgram2() {
    try {
      ServerSocket ss = new ServerSocket(55556);
      System.out.println("Waiting for a client to connect...");
      Socket s = ss.accept();
      DataInputStream in = new DataInputStream(s.getInputStream());
      DataOutputStream out = new DataOutputStream(s.getOutputStream());
      System.out.println("A client has now connected.");
      String[] words = {"bunny", "pizza", "mushroom", "banana", "turtle"};
      int i = in.readInt();
      String chosenWord = words[i-1];
      out.writeUTF(chosenWord);
      out.flush();
      System.out.println("The client has been sent the word " + chosenWord + ".");
    } catch(IOException ex) {
      System.out.println(ex);
    }
  }

  public static void main(String[] args) {
    ServerProgram2 sp = new ServerProgram2();
  }

}
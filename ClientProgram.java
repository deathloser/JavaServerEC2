import java.io.*;
import java.net.*;
import java.util.*;

/**
* The ClientProgram connects to a server and then sends an integer
* to receive a word from the server. This is part of the demo program
* for the video How to Test a Java Network App on an AWS EC2 Linux 2 Instance
* (https://youtu.be/_j5jyOXYPms).
*
* YT: youtube.com/choobtorials
* Twitter: twitter.com/choobtorials
*
* @author choob
*/

public class ClientProgram {

  public ClientProgram() {
    try {
      Scanner console = new Scanner(System.in);
      System.out.print("IP Address: ");
      String ipAddress = console.nextLine();
      System.out.print("Port Number: ");
      int portNumber = Integer.parseInt(console.nextLine());
      Socket s = new Socket(ipAddress,portNumber);
      DataInputStream in = new DataInputStream(s.getInputStream());
      DataOutputStream out = new DataOutputStream(s.getOutputStream());
      System.out.println("You have connected to the server.");
      System.out.print("Input a number from 1 to 5 to receive a word: ");
      int i = console.nextInt();
      out.writeInt(i);
      String word = in.readUTF();
      System.out.println("The server has sent you the word " + word + ".");
    } catch(IOException ex) {
      System.out.println("Exception from ClientProgram constructor.");
    }
  }

  public static void main(String[] args) {
    ClientProgram cp = new ClientProgram();
  }

}
package Lesson2.Chat;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientAppOne {
    public static void main(String[] args) {

        try {
            Socket socket = new Socket("127.0.0.1",8080);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());


            new Thread(()->{
                while (true){
                    try {
                        ChatFileWriter fileWriter = new ChatFileWriter();
                        System.out.println(in.readUTF());

                        File myfile = new File("fileClientOne.txt");
                        fileWriter.fileWriteHystory(in.readUTF(), "", myfile);

                        //fileWriter.getHystory(myfile);
                        fileWriter.getHystoryTypeLines(myfile, 10);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            Scanner scanner = new Scanner(System.in);
            while (!socket.isClosed()){
                out.writeUTF(scanner.nextLine());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

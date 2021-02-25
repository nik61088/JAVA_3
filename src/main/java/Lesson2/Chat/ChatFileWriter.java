package Lesson2.Chat;
import java.io.*;

public class ChatFileWriter {

    public void fileWriteHystory(String message, String name, File myfile) throws IOException {
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(myfile, true)));
        printWriter.println(name+": "+ message);
        printWriter.flush();
        printWriter.close();
    }


    public void getHystory(File myfile) throws IOException {
        if (!myfile.exists()){ //если файла нет, то он создается
            myfile.createNewFile();
        }
        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(myfile))){
            System.out.println(new String(bufferedInputStream.readAllBytes()));//вывод всех символов в файле
        }
    }

    public void getHystoryTypeLines(File myfile, Integer lines) throws IOException {
        if (!myfile.exists()){ //если файла нет, то он создается
            myfile.createNewFile();
        }
        try{
            FileReader fileReader = new FileReader(myfile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            for (int i = 0; i < lines; i++) {
                line = bufferedReader.readLine();
                System.out.println(line);//вывод построчно
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}

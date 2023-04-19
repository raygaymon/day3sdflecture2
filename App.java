package sg.nus.edu.iss;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Paths;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws IOException
    {   
        if (args.length == 2) {
            String directory = args[0];
            String file = args[1];
            System.out.println("Wassup loser " + file + " is in " + directory);
        } else {
            System.out.println("WTF you trying to do");
        }

        String dirPath = args[0];
        String fileName = args[1];
        String directoryPath =  dirPath + File.separator + fileName;

        //use file object to check if directory exists
        //create directory if it doesn't exist
        // Slide 2-3 day 3

        File newDirectory = new File(dirPath);
        if (newDirectory.exists()) {
            System.out.println("The directory already exists bruh");
        } else if (!newDirectory.exists()) {
            newDirectory.mkdir();
        } else {
            System.out.println("WTF you trying to do");
        }

        File newFile = new File(fileName);
        if (newFile.exists()) {
            System.out.println("This shit's here bruh it's at " + directoryPath + "\n");
        } else if (!newFile.exists()) {
            newFile.createNewFile();
        } else {
            System.out.println("WTF you trying to do");
        }


            String content = "Pornhub saves the planet by planting trees";
            String content2 = "Fap today for a brighter tomorrow";
            // output stream is where we write to files, input is to read files
            
            FileWriter phubMarketing = new FileWriter(directoryPath, true);
            phubMarketing.write(content);
            phubMarketing.write("\n");
            phubMarketing.write(content2 + "\n");
            phubMarketing.flush();
            phubMarketing.close();

            //decorator pattern
            String content3 = "Porn is not bad for you the bible is worse";
            FileWriter fw2 = new FileWriter(directoryPath, true);
            BufferedWriter bw = new BufferedWriter(fw2);
            bw.append(content3 + "\n");
            bw.flush();
            bw.close();
            fw2.close();

            //example again
            String content4 = "A jizz a day keeps the demons at bay\n";
            FileOutputStream fos = new FileOutputStream(directoryPath, true);
            byte[] byteContent = content4.getBytes();
            fos.write(byteContent);
            fos.flush();
            fos.close();

            //using decorator output pattern
            String content5 = "Come let us cum\n\n";
            FileOutputStream fos2 = new FileOutputStream(directoryPath, true);
            DataOutputStream dos = new DataOutputStream(fos2);
            dos.writeBytes(content5);
            dos.flush();
            dos.close();
            fos2.close();

        //file reading
        //reader only need to close no need to flush
        File file2 = new File(dirPath + File.separator + fileName);
        FileReader fr = new FileReader(file2);
        int reading = fr.read();
        while (reading != -1) {
            //if here is println the characters come out individually like a b c so fucking weird
            System.out.print((char) reading);
            reading = fr.read();
        }
        fr.close();

        //read file using buffered reader
        FileReader fr2 = new FileReader (file2);
        BufferedReader br = new BufferedReader (fr2);
        String line = "";
        line = br.readLine();

        while (line != null) {
            System.out.println(line);
            line = br.readLine();
        }
        br.close();
        fr2.close();

        //reading method 3
        FileInputStream fis = new FileInputStream(file2);
        DataInputStream dis = new DataInputStream(fis);

        int disData = dis.read();
        while (disData != -1) {
            System.out.print((char) disData);
            disData = dis.read();
        }

        dis.close();
        fis.close();


    }
}

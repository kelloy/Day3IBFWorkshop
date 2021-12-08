package workshopday3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ShoppingCartDb{
    public static void main(String[] args) throws IOException {
        Path p = Paths.get("src\\main\\java\\workshopday3\\cartdb");
        File file = p.toFile();
        Scanner scan = new Scanner(System.in);
        String command = scan.next();
        String arguments = scan.next();

      
        if ("login".equals(command)){
            StringBuilder sb = new StringBuilder();
            String line;
        for (File f:file.listFiles()){
                if ((f.getName()).contains(arguments)){
                    try(Reader reader = new FileReader(f)){
                        BufferedReader br = new BufferedReader(reader);
                        while(null != (line= br.readLine()))
                        sb.append(line).append("\n");}
                        catch (FileNotFoundException e){
                            e.printStackTrace();
                        }
                        String text = sb.toString();
                        String[] textarray = text.trim().split("\n");
                        for (int i = 0; i < textarray.length;i++)
                        System.out.println((i+1)+"."+textarray[i]);
                    
                    }
                    else {
                    FileOutputStream os = new FileOutputStream("db");
                    os.flush();
                    os.close();
                    }
                }
            }
            else{

            }
        }
    }

                    
                    /**
                System.out.println("file already exist");
                BufferedReader reader = new BufferedReader(new FileReader(f));
                String currentLine = reader.readLine();
                while (null!=(currentLine))
                System.out.printf("%s\n", currentLine);
                }else{
                FileOutputStream os = new FileOutputStream("db");
                os.flush();
                os.close();
                }**/
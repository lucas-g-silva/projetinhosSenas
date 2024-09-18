
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author lucas-gabreil_silva
 */
public class Arquivo {

    public static String read(String path) {
        String content = "";
        try {
            FileReader file = new FileReader(path);
            BufferedReader reading = new BufferedReader(file);
            String line = "";
            try {
                line = reading.readLine();
                while (line != null) {
                    content += line + "\n";
                    line = reading.readLine();
                }
                file.close();
                return content;
            } catch (IOException ex) {
                System.err.println("Erro: Erro na leitura do arquivo.");
                return "";
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Erro: Arquivo não encontrado.");
            return "";
        }
    }

    public static boolean write(String path, String txt) {
        try {
            FileWriter file = new FileWriter(path);
            PrintWriter writing = new PrintWriter(file);
            writing.append(txt);
            writing.close();
            return true;
        } catch (IOException ex) {
            System.err.println("Erro: " + ex.getMessage());
            return false;
        }
    }
}

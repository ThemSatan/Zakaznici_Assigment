import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final String oddelovac = "";
    public static void main(String[] args) throws Exception {
        List<Zakaznik> zaznamy = new ArrayList<>();
        zaznamy.add(new Zakaznik(
                "Aleš Plawro",
                6254
        ));
        zaznamy.add(new Zakaznik(
                "Karla Kyom",
                1743
        ));
        zaznamy.add(new Zakaznik(
                "Kars Sata",
                5839
        ));
        zaznamy.remove(zaznamy.size()-1);
        zaznamy.get(0).zvysPocetProdeju(3);
        writeToFile(zaznamy, "seznam.txt",":");
    }
    private static void writeToFile(List<Zakaznik> seznam,
                                    String soubor,
                                    String oddelovac){
        try (PrintWriter pw = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(soubor)
                )
        )) {
            for (Zakaznik z : seznam){
                pw.println(
                z.getJmeno()+oddelovac+z.getPocetProdeju());
            }
        }

        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

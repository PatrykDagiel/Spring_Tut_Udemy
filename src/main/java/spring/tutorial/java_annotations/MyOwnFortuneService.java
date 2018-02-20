package spring.tutorial.java_annotations;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class MyOwnFortuneService implements FortuneService {

    List<String> lista = new ArrayList<String>();
    private String fileName = "D:\\userdata\\dagiel\\Downloads\\Spring_Udemy\\src\\main\\resources\\lista.txt";
    private Random losowanie = new Random();

    public MyOwnFortuneService() {
        File plik = new File(fileName);
        try {
            BufferedReader odczyt = new BufferedReader(new FileReader(plik));
            String linia;
            while((linia = odczyt.readLine()) != null) {
                lista.add(linia);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getFortune() {
        int index = losowanie.nextInt(lista.size());
        String odpowiedz = lista.get(index);
        return odpowiedz;
    }
}

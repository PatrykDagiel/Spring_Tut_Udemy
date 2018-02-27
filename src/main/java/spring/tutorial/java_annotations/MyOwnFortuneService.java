package spring.tutorial.java_annotations;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class MyOwnFortuneService implements FortuneService {

    List<String> lista = new ArrayList<String>();
    private String fileName = "S:\\Projekty_Coding\\Spring_Tut_Udemy\\src\\main\\resources\\lista.txt";
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

    @PostConstruct
    public void PostConstructMethod() {
        System.out.println("Something happens after creation of this bean");
        for (String x : lista) {
            System.out.println("Linia wypisana: " + x);
        }

    }

    @Override
    public String getFortune() {
        int index = losowanie.nextInt(lista.size());
        String odpowiedz = lista.get(index);
        return odpowiedz;
    }

}

package edu.ktu.ds.lab3.demo;

import edu.ktu.ds.lab3.utils.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static edu.ktu.ds.lab3.utils.HashMap.DEFAULT_INITIAL_CAPACITY;
import static edu.ktu.ds.lab3.utils.HashMap.DEFAULT_LOAD_FACTOR;

public class ManualTest {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US); // suvienodiname skaičių formatus
        //executeTest();
        //hashMapMethodsTest();
        //hashMapOaMethodsTest();
        ValuesMethods();
    }
    public static void ValuesMethods(){
        HashMap<String, Integer> hashMap = new HashMap<>();
        Ks.ounn("");
        Ks.ounn("HashMap Values:");
        hashMap.put("Pirmas", 1);
        hashMap.put("Antras", 2);
        hashMap.put("Trečias", 3);
        hashMap.put("Ketvirtas", 4);
        hashMap.put("Penktas", 5);
        hashMap.put("Septint", 7);
        hashMap.put("Šeštas", 6);
        hashMap.put("Septintas", 7);
        Ks.ounn(hashMap);


        //java.util.List<Integer> valueList = hashMap.values();//veikia
        //java.util.Set<String> keyList = hashMap.keySet();//veikia
        //Ks.ounn(keyList);//veikia
        //Ks.ounn(valueList);//veikia
        //Ks.ounn(hashMap.getNumberOfCollisions());//neveikia
        //Ks.ounn(hashMap.replace("trelsa", 99));//veikia
        //hashMap.replaceAll(7,8);//veikia
        //Ks.ounn(hashMap.putIfAbsent("Septintas", 7));//veikia
        Ks.ounn(hashMap);


    }
    public static void hashMapMethodsTest() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        Ks.ounn("");
        Ks.ounn("HashMap:");
        hashMap.put("Pirmas", 1);
        hashMap.put("Antras", 2);
        hashMap.put("Trečias", 3);
        hashMap.put("Ketvirtas", 4);
        hashMap.put("Penktas", 5);
        hashMap.put("Šeštas", 6);
        hashMap.put("Septintas", 7);

        Ks.ounn(hashMap);

        hashMap.remove("Antras");
        hashMap.remove("Pirmas");
        hashMap.remove("Septintas");

        Ks.ounn("\nPo (Antras, Pirmas, Septintas) trynimų: ");
        Ks.ounn(hashMap);

        Ks.ounn("\ncontainsValue tikrinimas: ");
        System.out.println(6 + " " + hashMap.containsValue(6));
        System.out.println(7 + " " + hashMap.containsValue(7));

        Ks.ounn("\nreplace tikrinimas (į Šeštas įrašoma 60, į Penkta 50): ");
        System.out.println(hashMap.replace("Šeštas", 6, 60));
        System.out.println(hashMap.replace("Penkta", 5, 50));

        Ks.ounn("\n" + hashMap);
    }

    public static void hashMapOaMethodsTest() {
        Ks.ounn("");
        HashMapOa<String, Integer> hashMapOa = new HashMapOa<>();
        Ks.ounn("HashMap OA:");
        hashMapOa.put("Pirmas", 1);
        hashMapOa.put("Antras", 2);
        hashMapOa.put("Trečias", 3);
        hashMapOa.put("Ketvirtas", 4);
        hashMapOa.put("Penktas", 5);
        hashMapOa.put("Šeštas", 6);
        hashMapOa.put("Septintas", 7);

        Ks.ounn(hashMapOa);

        hashMapOa.remove("Antras");
        hashMapOa.remove("Pirmas");
        hashMapOa.remove("Septintas");

        Ks.ounn("\nPo (Antras, Pirmas, Septintas) trynimų: ");
        Ks.ounn( hashMapOa);

        Ks.ounn("\ncontainsValue tikrinimas: ");
        System.out.println(6 + " " + hashMapOa.containsValue(6));
        System.out.println(7 + " " + hashMapOa.containsValue(7));

        Ks.ounn("\nreplace tikrinimas (į Šeštas įrašoma 60, į Penktas 50): ");
        System.out.println(hashMapOa.replace("Šeštas", 6, 60));
        System.out.println(hashMapOa.replace("Penktas", 5, 50));

        Ks.ounn("\n" + hashMapOa);
    }

    public static void executeTest() {
        Car car1 = new Car("Renault", "Laguna", 1997, 50000, 1700);
        Car car2 = new Car("Renault", "Megane", 2001, 20000, 3500);
        Car car3 = new Car("Toyota", "Corolla", 2001, 20000, 8500.8);
        Car car4 = new Car("Renault Laguna 2001 115900 7500");
        Car car5 = new Car.Builder().buildRandom();
        Car car6 = new Car("Honda   Civic  2007  36400 8500.3");
        Car car7 = new Car("Renault Laguna 2001 115900 7500");

        // Atvaizdžio raktų masyvas
        String[] carsIds = {"TA156", "TA102", "TA178", "TA126", "TA105", "TA106", "TA107", "TA108"};
        // Atvaizdžio reikšmių masyvas
        Car[] cars = {car1, car2, car3, car4, car5, car6, car7};

        executeCarMapTests(carsIds, cars);
        executeCarMapOaTests(carsIds, cars);
    }

    private static void executeCarMapTests(String[] carsIds, Car[] cars) {
        ParsableMap<String, Car> carsMap = new ParsableHashMap<>(
                String::new,
                Car::new,
                DEFAULT_INITIAL_CAPACITY,
                DEFAULT_LOAD_FACTOR,
                HashManager.HashType.DIVISION
        );

        for (int id = 0; id < cars.length; id++) {
            carsMap.put(carsIds[id], cars[id]);
        }

        Ks.oun("Porų išsidėstymas atvaizdyje pagal raktus:");
        carsMap.println("");
        Ks.oun("Ar egzistuoja pora atvaizdyje?");
        Ks.oun(carsMap.contains(carsIds[6]));
        Ks.oun(carsMap.contains(carsIds[7]));
        Ks.oun("Porų išsidėstymas atvaizdyje pagal raktus. Vaizduojami tik raktai:");
        carsMap.println("=");

        Ks.oun("Atliekame porų paiešką atvaizdyje:");
        Ks.oun(carsMap.get(carsIds[2]));
        Ks.oun(carsMap.get(carsIds[7]));
        Ks.oun("Išspausdiname atvaizdžio poras String eilute:");
        Ks.ounn(carsMap);
    }

    private static void executeCarMapOaTests(String[] carsIds, Car[] cars) {
        ParsableMap<String, Car> carsMapOa = new ParsableHashMapOa<>(
                String::new,
                Car::new,
                DEFAULT_INITIAL_CAPACITY,
                DEFAULT_LOAD_FACTOR,
                HashManager.HashType.DIVISION,
                HashMapOa.OpenAddressingType.LINEAR
        );

        for (int id = 0; id < cars.length; id++) {
            carsMapOa.put(carsIds[id], cars[id]);
        }

        Ks.oun("Porų išsidėstymas atviros adresacijos atvaizdyje pagal raktus:");
        carsMapOa.println("");
        Ks.oun("Ar egzistuoja pora atviros adresacijos atvaizdyje?");
        Ks.oun(carsMapOa.contains(carsIds[6]));
        Ks.oun(carsMapOa.contains(carsIds[7]));
        Ks.oun("Porų išsidėstymas atviros adresacijos atvaizdyje pagal raktus. Vaizduojami tik raktai:");
        carsMapOa.println("=");

        Ks.oun("Atliekame porų paiešką atviros adresacijos atvaizdyje:");
        Ks.oun(carsMapOa.get(carsIds[2]));
        Ks.oun(carsMapOa.get(carsIds[7]));
        Ks.oun("Išspausdiname atviros adresacijos atvaizdžio poras String eilute:");
        Ks.ounn(carsMapOa);
    }
}

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

public class TestMaven {
    public static void main(String[] args) {
        //4.2
        List<String> fruits = Lists.newArrayList("orange", "banana", "kiwi");
        fruits.forEach(System.out::println);

        List<String> reverseFruits = Lists.reverse(fruits);
        reverseFruits.forEach(System.out::println);

        //4.3
        Multimap<String, String> map = ArrayListMultimap.create();
        map.put("key", "firstValue");
        map.put("key", "secondValue");
        System.out.println(map);

        //5.9.1
        Properties properties = new Properties();

        try(InputStream resourceAsStreem = TestMaven.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(Objects.requireNonNull(resourceAsStreem));

            //5.9.2
            System.out.println(properties.get("props.local.hello"));
            System.out.println(properties.get("props.mvn.hello"));

        }catch (IOException e){
            System.out.println(e);
        }
    }
}

package io.zipcoder;

import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemParser {
    public List<Item> parseItemList(String valueToParse) {
        List<Item> list = new ArrayList<>();
        String[] items = valueToParse.split("##");

        for (String item : items){
//            parseSingleItem(item);
        }
        return list;
    }

    public Item parseSingleItem(String singleItem) throws ItemParseException {
        ArrayList<String> list = new ArrayList<>();
        String[] asStrArr = singleItem.split(";");
        //System.out.println(Arrays.toString(asStrArr));

        for (String element : asStrArr){
//            Pattern p = Pattern.compile(":$*");
//            Matcher m = p.matcher(element);
//            boolean b = m.matches();
//            if (b) {list.add(element);}

            String[] foo = element.split("[:@^%]$*");
            list.add(foo[1]);
            //System.out.println(Arrays.toString(foo));
        }

        //System.out.println(list);
        //System.out.println(Arrays.toString(asStrArr));

        String name = list.get(0).toLowerCase();
        Double price = Double.valueOf(list.get(1));
        String type = list.get(2).toLowerCase();
        String exp = list.get(3).replaceAll("#", "");
        return new Item(name, price  , type, exp);
    }
}

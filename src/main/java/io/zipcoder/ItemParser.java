package io.zipcoder;

import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemParser {
    public List<Item> parseItemList(String valueToParse) throws ItemParseException {
        List<Item> list = new ArrayList<>();
        String[] items = valueToParse.split("##");
        //System.out.println(Arrays.toString(items));

        for (String item : items) {
            //if (!item.matches(".*[:@^%*].*;.*[:@^%*].*;.*[:@^%*].*;.*[:@^%*].*")){continue;}
            try {
                list.add(parseSingleItem(item));
            }catch (ItemParseException ignored) {}
        }
        //System.out.println(list);
        return list;
    }

    public Item parseSingleItem(String singleItem) throws ItemParseException {

        if (!singleItem.matches(".*[;:@^%*!].+[;:@^%*!].*[;:@^%*!].+[;:@^%*!].*[;:@^%*!].+[;:@^%*!].*[;:@^%*!].+")){throw new ItemParseException();}

        ArrayList<String> list = new ArrayList<>();
        String[] asStrArr = singleItem.split("[;:@^%*!]");
        //System.out.println(Arrays.toString(asStrArr));

        for (int i = 0; i < asStrArr.length; i++) {
            if (i % 2 != 0){list.add(asStrArr[i]);}
        }
        //System.out.println(list);
        //System.out.println(Arrays.toString(asStrArr));
        String name = list.get(0).toLowerCase();
        double price;
        try {
            price = Double.parseDouble(list.get(1));
        }catch (NumberFormatException e){ throw new ItemParseException();}
        String type = list.get(2).toLowerCase();
        String exp = list.get(3).replaceAll("#", "");
        return new Item(name, price, type, exp);
    }


}

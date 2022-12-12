package io.zipcoder;

import io.zipcoder.utils.FileReader;
import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;

import java.util.List;

public class GroceryReporter {
    private final String originalFileText;

    public GroceryReporter(String jerksonFileName) {
        this.originalFileText = FileReader.readFile(jerksonFileName);
    }

    @Override
    public String toString() {
        ItemParser ip = new ItemParser();
        try {
            List<Item> list = ip.parseItemList(originalFileText);
            for (Item it : list) {
                System.out.println(it);
            }
            System.out.println(ip.parseItemList(originalFileText).size());
        } catch (ItemParseException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}

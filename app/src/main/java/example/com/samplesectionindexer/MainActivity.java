package example.com.samplesectionindexer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    // an array of countries to display in the list
    static final String[] BRANDNAMES = {
            "Volatiles", "Austin Reed",
            "BCB Girls", "Beston", "Akoo", "Polo",
            "Converse", "Cookies",
            "Dansko", "David Spencer",
            "Easy Spirit", "Ellie",
            "Fila", "Fit Flop", "Funtasma",
            "Gabor", "Gentle Souls", "Grazie",
            "Haflinger", "Henry Ferrera", "Hitec",
            "Hush Puppies","Ilse Jacobsen", "Isotoner",
            "Jambu", "Jordan", "J Renee",
            "Kamik", "Keen", "Kensie Girl",
            "Laura Ashley", "Lowa",
            "Nike", "Nomad",
            "Olukai", "Onesole", "Ortho Feet",
            "Ralph Lauren",
            "Sean John", "Shoe Queen", "Sperry",
            "Timberland", "Twsteel",
            "Ugg", "Umi",
            "Walking Cradles", "Wonders",
            "Xelero", "Xoxo",
            "Yellow Box",
            "Zooligans", "Mauri"
    };

    private HashMap<String,Integer> mAlphaIndexer;
    private List<String> mBrandNames;
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.listview);

        mBrandNames = Arrays.asList(BRANDNAMES);

        Collections.sort(mBrandNames);
        getIndexList(mBrandNames);

        displayData();
    }

    private void getIndexList(List<String> list) {
        mAlphaIndexer = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i);
            String index = name.substring(0, 1);

            if (!mAlphaIndexer.containsKey(index))
                mAlphaIndexer.put(index, i);
        }
    }

    private void displayData() {

        ContactsAdapter contactsAdapter = new ContactsAdapter(this,mBrandNames,mAlphaIndexer);

        listview.setAdapter(contactsAdapter);

        listview.setFastScrollEnabled(true);
    }
}

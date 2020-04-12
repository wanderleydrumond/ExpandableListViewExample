package com.drumond.expandablelistviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> listGroup;
    private HashMap<String, List<String>> listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buildList();

        ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.elv_expandableListView);
        expandableListView.setAdapter(new ExpandableAdapter(MainActivity.this, listGroup, listData));

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(MainActivity.this, "Group: " + groupPosition + " | Item: " + childPosition, Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(MainActivity.this, "Group: " + groupPosition + " opened", Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(MainActivity.this, "Group: " + groupPosition + " closed", Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setGroupIndicator(getResources().getDrawable(R.drawable.icon_group));
    }

    public void buildList() {
        listGroup = new ArrayList<String>();
        listData = new HashMap<String, List<String>>();

        //GROUP
        listGroup.add("Group 1");
        listGroup.add("Group 2");
        listGroup.add("Group 3");
        listGroup.add("Group 4");

        //ITEM
        List<String> auxiliaryList= new ArrayList<String>();
        auxiliaryList.add("Item 1");
        auxiliaryList.add("Item 2");
        auxiliaryList.add("Item 3");
        auxiliaryList.add("Item 4");
        listData.put(listGroup.get(0), auxiliaryList);

        auxiliaryList= new ArrayList<String>();
        auxiliaryList.add("Item 5");
        auxiliaryList.add("Item 6");
        auxiliaryList.add("Item 7");
        auxiliaryList.add("Item 8");
        listData.put(listGroup.get(1), auxiliaryList);

        auxiliaryList= new ArrayList<String>();
        auxiliaryList.add("Item 9");
        auxiliaryList.add("Item 10");
        auxiliaryList.add("Item 11");
        auxiliaryList.add("Item 12");
        listData.put(listGroup.get(2), auxiliaryList);

        auxiliaryList= new ArrayList<String>();
        auxiliaryList.add("Item 13");
        auxiliaryList.add("Item 14");
        auxiliaryList.add("Item 15");
        auxiliaryList.add("Item 16");
        listData.put(listGroup.get(3), auxiliaryList);
    }
}
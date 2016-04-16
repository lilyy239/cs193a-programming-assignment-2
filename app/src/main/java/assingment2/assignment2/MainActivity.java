package assingment2.assignment2;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import stanford.androidlib.SimpleActivity;
import stanford.androidlib.SimpleList;

public class MainActivity extends SimpleActivity {

    private ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<String>();
        SimpleList.with(this).setItems(findListView(R.id.listView), list);
        findListView(R.id.listView).setOnItemClickListener(this);
    }

    public void addToList(View view) {
        String newItem = findEditText(R.id.editText).getText().toString();
        list.add(newItem);
        SimpleList.with(this).setItems(findListView(R.id.listView), list);
        toast(newItem + " added to To Do List");
    }

    public void onItemClick(ListView listView, int index) {
        String oldItem = list.get(index);
        list.remove(index);
        SimpleList.with(this).setItems(findListView(R.id.listView), list);
        toast(oldItem + " removed from To Do List");
    }

}

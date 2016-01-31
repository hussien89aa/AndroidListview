package com.example.hussienalrubaye.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      final   ArrayList<ListItem> Items=new  ArrayList<ListItem> ();
        Items.add(new ListItem("hussien","he is good man"));
        Items.add(new ListItem("ahmed","he is ban man"));
        Items.add(new ListItem("jasim","he is okey man"));
        Items.add(new ListItem("jena","he is well man"));
       final MyCustomAdapter myadpter= new MyCustomAdapter(Items);

        ListView ls=(ListView)findViewById(R.id.listView);
        ls.setAdapter(myadpter);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView txtname =(TextView) view.findViewById(R.id.txt_name);
                TextView txtdes =(TextView) view.findViewById(R.id.txt_desc);
                Toast.makeText(getApplicationContext(),txtname.getText(),Toast.LENGTH_LONG).show();
                Items.add(new ListItem("rana", "he is okey "));
                Items.add(new ListItem("sama", "he is well "));
              myadpter.notifyDataSetChanged();

            }
        });

    }


    class MyCustomAdapter extends BaseAdapter
    {
       ArrayList<ListItem> Items=new ArrayList<ListItem>();
        MyCustomAdapter(ArrayList<ListItem> Items ) {
        this.Items=Items;

        }


        @Override
        public int getCount() {
            return Items.size();
        }

        @Override
        public String getItem(int position) {
            return Items.get(position).Name;

        }

        @Override
        public long getItemId(int position) {
return  position;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
         LayoutInflater linflater =getLayoutInflater();
            View view1=linflater.inflate(R.layout.row_view, null);

            TextView txtname =(TextView) view1.findViewById(R.id.txt_name);
            TextView txtdes =(TextView) view1.findViewById(R.id.txt_desc);
            txtname.setText(Items.get(i).Name);
            txtdes.setText(Items.get(i).Desc);
            return view1;

        }



    }
}

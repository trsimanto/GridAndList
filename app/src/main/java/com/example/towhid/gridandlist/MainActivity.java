package com.example.towhid.gridandlist;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewStub stubGrid;
    private ViewStub stubList;
    private ListView listView;
    private GridView gridView;
    private ListViewAdapter listViewAdapter;
    private GridViewAdapter gridViewAdapter;
    private List<Product> productList;
    private int currentViewMode=0;


    static final int VIEW_MODE_LISTVIEW=0;
    static final int VIEW_MODE_GRIDVIEW=1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        stubList=(ViewStub) findViewById(R.id.stub_list);
        stubGrid=(ViewStub) findViewById(R.id.stub_grid);

        //inflate ViewStub before get view
        stubList.inflate();
        stubGrid.inflate();

        listView=(ListView)findViewById(R.id.mylistview);
        gridView=(GridView)findViewById(R.id.mygridview);




        //get list of product

        getProductList();

        //get current view mode in share reference
        SharedPreferences sharedPreferences=getSharedPreferences("ViewMode",MODE_PRIVATE);
        currentViewMode=sharedPreferences.getInt("currentViewMode",VIEW_MODE_LISTVIEW); //default is listview
        switchView();


    }

    private void switchView() {
        if (VIEW_MODE_LISTVIEW==currentViewMode) {
            //display list view
            stubList.setVisibility(View.VISIBLE);
            //hide grid view
            stubGrid.setVisibility(View.GONE);
        }
        else {
            //display grid view
            stubGrid.setVisibility(View.VISIBLE);
            //hide list view
            stubList.setVisibility(View.GONE);

        }

        setAdapters();
    }

    private void setAdapters() {
        if (VIEW_MODE_LISTVIEW==currentViewMode){
            listViewAdapter =new ListViewAdapter(this,R.layout.list_items,productList);
            listView.setAdapter(listViewAdapter);
        }
        else{
            gridViewAdapter =new GridViewAdapter(this,R.layout.grid_item,productList);
            gridView.setAdapter(gridViewAdapter);
        }
    }

    private List<Product> getProductList() {
        //pseudo code to get product,replace your code to get real product here
        productList=new ArrayList<>();
        productList.add(new Product(R.drawable.ic_launcher_background,"Title 1","It  is discription 1"));
        productList.add(new Product(R.drawable.ic_launcher_background,"Title 2","It  is discription 2"));
        productList.add(new Product(R.drawable.ic_launcher_background,"Title 3","It  is discription 3"));
        productList.add(new Product(R.drawable.ic_launcher_background,"Title 4","It  is discription 4"));
        productList.add(new Product(R.drawable.ic_launcher_background,"Title 5","It  is discription 5"));
        productList.add(new Product(R.drawable.ic_launcher_background,"Title 6","It  is discription 6"));
        productList.add(new Product(R.drawable.ic_launcher_background,"Title 7","It  is discription 7"));
        productList.add(new Product(R.drawable.ic_launcher_background,"Title 8","It  is discription 8"));
        productList.add(new Product(R.drawable.ic_launcher_background,"Title 9","It  is discription 9"));
        productList.add(new Product(R.drawable.ic_launcher_background,"Title 10","It  is discription 10"));
        productList.add(new Product(R.drawable.ic_launcher_background,"Title 11","It  is discription 11"));
        productList.add(new Product(R.drawable.ic_launcher_background,"Title 12","It  is discription 12"));
        productList.add(new Product(R.drawable.ic_launcher_background,"Title 13","It  is discription 13"));
        productList.add(new Product(R.drawable.ic_launcher_background,"Title 14","It  is discription 14"));
        productList.add(new Product(R.drawable.ic_launcher_background,"Title 15","It  is discription 15"));
        productList.add(new Product(R.drawable.ic_launcher_background,"Title 16","It  is discription 16"));
        productList.add(new Product(R.drawable.ic_launcher_background,"Title 17","It  is discription 17"));
        productList.add(new Product(R.drawable.ic_launcher_background,"Title 18","It  is discription 18"));
        productList.add(new Product(R.drawable.ic_launcher_background,"Title 19","It  is discription 19"));
        productList.add(new Product(R.drawable.ic_launcher_background,"Title 20","It  is discription 20"));
        productList.add(new Product(R.drawable.ic_launcher_background,"Title 21","It  is discription 21 "));
        productList.add(new Product(R.drawable.ic_launcher_background,"Title 22","It  is discription 22"));
        productList.add(new Product(R.drawable.ic_launcher_background,"Title 23","It  is discription 23"));
        productList.add(new Product(R.drawable.ic_launcher_background,"Title 24","It  is discription 24"));
        productList.add(new Product(R.drawable.ic_launcher_background,"Title 25","It  is discription 25"));
        return productList;
    }

    AdapterView.OnItemClickListener onItemClick=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(getApplicationContext(), ""+productList.get(position).getTitle(), Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_manu_1:
                if (VIEW_MODE_LISTVIEW==currentViewMode)
                    currentViewMode=VIEW_MODE_GRIDVIEW;
                else currentViewMode=VIEW_MODE_LISTVIEW;
                //switch view
                switchView();
                // save view mode in share reference
                SharedPreferences sharedPreferences= getSharedPreferences("ViewMode",MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putInt("currentViewMode",currentViewMode);
                editor.commit();
                break;
        }
        return true;
    }
}

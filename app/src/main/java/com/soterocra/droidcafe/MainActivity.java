package com.soterocra.droidcafe;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.soterocra.droidcafe.config.RetrofitService;
import com.soterocra.droidcafe.entities.Products;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    int[] images = {R.drawable.donut_circle, R.drawable.icecream_circle, R.drawable.froyo_circle};

    List<String> desc = new ArrayList<>();

    List<String> val = new ArrayList<>();

    List<Products> products;

    ListView lView;

    ListAdapter lAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lView = (ListView) findViewById(R.id.androidList);

        searchData();

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(MainActivity.this, desc.get(i) +" "+ val.get(i), Toast.LENGTH_SHORT).show();

            }
        });


//        lView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                User user = userList.get(position);
//                textView.setText("Nome: " + user.getName()+"\n\nemail: "+ user.getEmail());
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

    }

    private void searchData() {
        RetrofitService.getServico().getProducts().enqueue(new Callback<List<Products>>() {
            @Override
            public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
                products = response.body();

                for (Products p : products) {

                    desc.add(p.getDescricao());
                    val.add("R$ " + p.getValor() + ".00");
                }

                lAdapter = new ListAdapter(MainActivity.this, desc, val, images);

                lView.setAdapter(lAdapter);

            }

            @Override
            public void onFailure(Call<List<Products>> call, Throwable t) {
                Log.e("aula", t.getMessage());
            }
        });
    }
}
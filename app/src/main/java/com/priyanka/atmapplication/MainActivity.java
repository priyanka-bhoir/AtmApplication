package com.priyanka.atmapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int totalatmamt = 20000;
    int _100rs = 20;
    int _200rs = 20;
    int _500rs = 12;
    int _2000rs = 4;

    int totalatmamtafter ;
    int _100rsAfter;
    int _200rsAfter ;
    int _500rsAfter ;
    int _2000rsAfter ;
    EditText editText;
    Button button;
    int amtEntered;
    TextView tAmtV,t_100V,t_200V,t_500V,t_2000V;
    TextView bAmtV,b_100V,b_200V,b_500V,b_2000V;
    ArrayList<model> list;
    String TAG ="MainClass";
    ListView lv;
    AdapterMoney adapter;
    model model;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.enteramttxt);
        button = findViewById(R.id.widraw);

        tAmtV = findViewById(R.id.ttotalamt);
        t_100V = findViewById(R.id.t100rsnote);
        t_200V = findViewById(R.id.t200rsnote);
        t_500V = findViewById(R.id.t500rsnote);
        t_2000V = findViewById(R.id.t2000rsnote);
        lv = findViewById(R.id.lv);

        bAmtV = findViewById(R.id.btotalamt);
        b_100V = findViewById(R.id.b100rsnote);
        b_200V = findViewById(R.id.b200rsnote);
        b_500V = findViewById(R.id.b500rsnote);
        b_2000V = findViewById(R.id.b2000rsnote);
//        lv.findViewById(R.id.lv);

        tAmtV.setText(String.valueOf(_2000rs));
        t_100V.setText(String.valueOf(_100rs));
        t_200V.setText(String.valueOf(_200rs));
        t_500V.setText(String.valueOf(_500rs));
        t_2000V.setText(String.valueOf(_2000rs));
        list= new ArrayList<>();


        button.setOnClickListener(view -> {
            amtEntered = Integer.parseInt(editText.getText().toString());
            totalatmamtafter = totalatmamt - amtEntered;
            if (totalatmamtafter > 0){
                int tempamt = amtEntered;
                Log.e(TAG, "onCreate:tempamt "+tempamt );
                do{
                    if (tempamt / 2000 > 0) {
                        int temp = tempamt / 2000;
                        _2000rsAfter = temp;
                        Log.e(TAG, "onCreate:_2000rsAftertemp--: " + temp);
                        _2000rs = _2000rs - _2000rsAfter;
                        tempamt = tempamt - (2000-temp);

                    } else if (tempamt / 500 > 0) {
                        int temp = tempamt / 500;
                        _500rsAfter = temp;
                        Log.e(TAG, "onCreate:_500rsAftertemp--: " + temp);
                        _500rs = _500rs - _500rsAfter;
                        tempamt = tempamt - (500-temp);

                    } else if (tempamt /200 > 0) {
                        int temp = tempamt / 200;
                        _200rsAfter = temp;
                        Log.e(TAG, "onCreate:_200rsAftertemp--: " + temp);
                        _200rs = _200rs - _200rsAfter;
                        tempamt = tempamt - (200-temp);

                    } else if (100 - amtEntered > 0) {
                        int temp = tempamt / 100;
                        _100rsAfter = temp;
                        Log.e(TAG, "onCreate:_100rsAftertemp--: " + temp);
                        _100rs = _100rs - _100rsAfter;
                        tempamt = tempamt - (100-temp);

                    }
                    else {
                        break;
                    }
                }while (tempamt>0);
                tAmtV.setText(String.valueOf(totalatmamtafter));
                t_2000V.setText(String.valueOf(_2000rs));
                t_500V.setText(String.valueOf(_500rs));
                t_200V.setText(String.valueOf(_200rs));
                t_100V.setText(String.valueOf(_100rs));
                bAmtV.setText(String.valueOf(amtEntered));
                b_100V.setText(String.valueOf(_100rsAfter));
                b_200V.setText(String.valueOf(_200rsAfter));
                b_500V.setText(String.valueOf(_500rsAfter));
                b_2000V.setText(String.valueOf(_2000rsAfter));
                model = new model(String.valueOf(amtEntered),String.valueOf(_100rsAfter),String.valueOf(_200rsAfter),String.valueOf(_500rsAfter),String.valueOf(_2000rsAfter));
                list.add(count,model);
                count++;

            }else {
                Toast.makeText(MainActivity.this,"Enter A valid Text",Toast.LENGTH_LONG);
            }
            if (list.size()>0) {
                adapter = new AdapterMoney(list, MainActivity.this);
                lv.setAdapter(adapter);
            }
        });

    }
}
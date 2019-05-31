package com.example.shreevatsa.kalkulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     int angka1 = 0;
     int angka2 = 0;
    Button tambah,kurang,kali,bagi;
    EditText number1,number2;
    TextView hasil;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tambah = findViewById(R.id.button2);
        kurang = findViewById(R.id.button3);
        kali   = findViewById(R.id.button4);
        bagi   = findViewById(R.id.button5);
        number1 = findViewById(R.id.editText);
        number2 = findViewById(R.id.editText1);
        hasil = findViewById(R.id.textView2);

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(number1.getText().toString().equals("") || number2.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "please input the numbers", Toast.LENGTH_SHORT).show();
                }
                else{
                    angka1 = Integer.parseInt(number1.getText().toString());
                    angka2 = Integer.parseInt(number2.getText().toString());

                    int Result = angka1 + angka2;

                    hasil.setText(String.valueOf(Result));

                }



            }
        });

        kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(number1.getText().toString().equals("") || number2.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "please input the numbers", Toast.LENGTH_SHORT).show();
                }
                else{

                    angka1 = Integer.parseInt(number1.getText().toString());
                    angka2 = Integer.parseInt(number2.getText().toString());

                    int Result = angka1 - angka2;

                    hasil.setText(String.valueOf(Result));
                }



            }
        });

        kali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(number1.getText().toString().equals("") || number2.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "please input the numbers", Toast.LENGTH_SHORT).show();
                }
                else{

                    angka1 = Integer.parseInt(number1.getText().toString());
                    angka2 = Integer.parseInt(number2.getText().toString());

                    int Result = angka1 * angka2;

                    hasil.setText(String.valueOf(Result));
                }



            }
        });

        bagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(number1.getText().toString().equals("") || number2.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "please input the numbers", Toast.LENGTH_SHORT).show();
                }
                else{
                    angka1 = Integer.parseInt(number1.getText().toString());
                    angka2 = Integer.parseInt(number2.getText().toString());

                    if(angka2 != 0){
                        if(angka1 % angka2 == 0){
                            int Result = angka1 / angka2;
                            hasil.setText(String.valueOf(Result));
                        }
                        else{
                            double Result = (double)angka1 / angka2;
                            hasil.setText(String.valueOf(Result));
                        }
                    } else{
                        hasil.setText("Can't divide by zero");
                    }


                }





            }
        });
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}

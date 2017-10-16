package com.a5.ngenemichael.btcexchanger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ConversionBoard extends AppCompatActivity {
    int p, count =1,mainflag,bitcoinflag,ethflag;
    ImageView img1, img2;
    TextView tx1, tx2, result;
    EditText edt;
    Button btconvert;
    int [] flags ={R.drawable.asustreia,R.drawable.belgium,R.drawable.canada,R.drawable.china,R.drawable.denmark_flag,
            R.drawable.france,R.drawable.gemany,R.drawable.india,R.drawable.israel,R.drawable.japan,
            R.drawable.mexico,R.drawable.new_zealand,R.drawable.nigeria,R.drawable.poland,R.drawable.south_korea,
            R.drawable.switzerland2,R.drawable.turkey,R.drawable.uk,R.drawable.ukraine,R.drawable.us};
    String [] currency = {"AUD","EUR","CAD","CNY","DKK","EUR","EUR","INR","ILS","JPY","MXN","NZD","NGN","PLN","KRW",
            "CHF","TRY","GBP","UAH","USD"};

    Double [] btcvalues = {7_030.49,4_688.42,6_997.72,36_001.67,39_865.41,4_688.42,4_688.42,345_570.49,19_779.50,665_466.26,
            103_239.93,7_435.84,2_027_366.27,20_420.65,6_518_305.17,5_466.77,20_315.87,4_343.74,139_020.60,5_742.89};

    Double [] ethvalues = {421.98,277.41,412.92,2_154.10,2_087.0,277.41,277.41,21_086.20,1_159.0,37_963.60,
            5_999.9,475.0,138_742.69,1_074.80,376_763.25,331.08,1_207.0,240.55,8_275.0,331.31};
    String sign= "",btcsign, ethsign;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_board);
        img1 = (ImageView)findViewById(R.id.imageView1);
        img2 = (ImageView)findViewById(R.id.imageView2);
        tx1 = (TextView)findViewById(R.id.tx1);
        tx2 = (TextView)findViewById(R.id.tx2);
        btconvert = (Button)findViewById(R.id.convert);
        edt= (EditText) findViewById(R.id.editText);
        result =  (TextView)findViewById(R.id.result);


        Intent i = getIntent();
        p= i.getIntExtra("key",1);

        mainflag = flags[p];
        sign = currency[p];
        bitcoinflag = R.drawable.images;
        ethflag = R.drawable.eth;
        btcsign = "BTC";
        ethsign = "ETH";
        img2.setImageResource(mainflag);
        tx2.setText(sign);


        Toast.makeText(ConversionBoard.this, String.valueOf(p), Toast.LENGTH_SHORT).show();
    }

    public void switcher(View view) {
        count ++;
        if (count>4){count=1;}
        switch (count){
            case 1:
                img1.setImageResource(bitcoinflag);
                img2.setImageResource(mainflag);
                tx1.setText(btcsign);
                tx2.setText(sign);

                break;
            case 2:
                img1.setImageResource(mainflag);
                img2.setImageResource(bitcoinflag);
                tx1.setText(sign);
                tx2.setText(btcsign);
                break;
            case 3:
                img1.setImageResource(ethflag);
                img2.setImageResource(mainflag);
                tx1.setText(ethsign);
                tx2.setText(sign);

                break;
            case  4:
                img1.setImageResource(mainflag);
                img2.setImageResource(ethflag);
                tx1.setText(sign);
                tx2.setText(ethsign);
                break;
        }
    }

    public void calculate(View view) {
        String s = null;
        switch (count){
            case 1:
            case 3:
                s= sign;
                break;
            case 2:
                s= btcsign;
                break;
            case 4:
                s=ethsign;
                break;

        }

        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(edt.getWindowToken(),0);

        if(TextUtils.isEmpty(edt.getText().toString())){
            Toast.makeText(ConversionBoard.this, "Enter a Value", Toast.LENGTH_SHORT).show();
        }else{
        Double amount = Double.parseDouble(edt.getText().toString());
        Calculator calculator = new Calculator(p,amount,count,btcvalues,ethvalues);
        result.setText(calculator.getResult().toString()+" "+s);
        }
    }
}

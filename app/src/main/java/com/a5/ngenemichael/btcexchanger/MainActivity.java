package com.a5.ngenemichael.btcexchanger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // currency representation of 20 major countries
    String [] currency = {"AUD","EUR","CAD","CNY","DKK","EUR","EUR","INR","ILS","JPY","MXN","NZD","NGN","PLN","KRW",
            "CHF","TRY","GBP","UAH","USD"};

    // names of 20  major countries
    String [] countries = {"Australia","Belgium","Canada","China","Denmark","France","Germany","India","Israel",
            "Japan","Mexico","New_Zealand","Nigeria","Poland","South_Korea","Switzerland","Turkey","United_Kingdom","Ukarine",
            "USA"};

    // Flags of 20 major  Countries
    int [] flags ={R.drawable.asustreia,R.drawable.belgium,R.drawable.canada,R.drawable.china,R.drawable.denmark_flag,
            R.drawable.france,R.drawable.gemany,R.drawable.india,R.drawable.israel,R.drawable.japan,
            R.drawable.mexico,R.drawable.new_zealand,R.drawable.nigeria,R.drawable.poland,R.drawable.south_korea,
            R.drawable.switzerland2,R.drawable.turkey,R.drawable.uk,R.drawable.ukraine,R.drawable.us};

    // An array contain the values of BitCoins in 20 different countries.
    Double [] btcvalues = {7_030.49,4_688.42,6_997.72,36_001.67,39_865.41,4_688.42,4_688.42,345_570.49,19_779.50,665_466.26,
            103_239.93,7_435.84,2_027_366.27,20_420.65,6_518_305.17,5_466.77,20_315.87,4_343.74,139_020.60,5_742.89};

    // An array contain the values of Ethereum in 20 different countries.
    Double [] ethvalues = {421.98,277.41,412.92,2_154.10,2_087.0,277.41,277.41,21_086.20,1_159.0,37_963.60,
            5_999.9,475.0,138_742.69,1_074.80,376_763.25,331.08,1_207.0,240.55,8_275.0,331.31};


    private RecyclerView recycler;
    private List<Countries> mCountries = new ArrayList<>();
    private CountriesAd cAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recycler = (RecyclerView) findViewById(R.id.recycler_view);
        cAdapter = new CountriesAd(mCountries);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
        recycler.setLayoutManager(manager);
        recycler.setItemAnimator(new DefaultItemAnimator());
        recycler.setAdapter(cAdapter);

        prepareCountries();
    }

    private void prepareCountries() {
        Countries c;
        // Saving the Countries their btc values and Ethereum values in to a list
        DecimalFormat format = new DecimalFormat("#,###.######");
        for (int i = 0; i < countries.length; i++) {
            c = new  Countries(countries[i],"BTC/"+currency[i]+": "+String.valueOf(format.format(btcvalues[i])),
                   "ETH/"+currency[i]+": "+String.valueOf(format.format(ethvalues[i])),flags[i],flags[i]);
            mCountries.add(c);
        }
        cAdapter.notifyDataSetChanged();
    }
}

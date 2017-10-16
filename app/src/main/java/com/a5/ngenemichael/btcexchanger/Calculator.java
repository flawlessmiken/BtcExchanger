package com.a5.ngenemichael.btcexchanger;

/**
 * Created by Flawless on 10/15/2017.
 */
public class Calculator {

    private int name;
    private Double amount, result, btc, eth;
    private Double [] btcArray,ethArray;
    private  int id;
    public Calculator(){

    }

    public Calculator(int name, Double amount, int id, Double [] btcarray,Double [] etharray ){
        this.name =  name;
        this.amount = amount;
        this.id=id;
        this.btcArray= btcarray;
        this.ethArray=etharray;


                switch (id){
                    case 1:
                       result= btcArray[name]*amount;
                        break;
                    case 2:
                        result= amount/btcArray[name];
                        break;
                    case 3:
                        result= ethArray[name]*amount;
                        break;
                    case 4:
                        result= amount/ethArray[name];
                        break;
                }


    }

    public Double getResult() {
        return result;
    }
}

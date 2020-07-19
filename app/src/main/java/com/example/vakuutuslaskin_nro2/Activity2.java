package com.example.vakuutuslaskin_nro2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {


    String amount, ins_percentage, vendor_share_percentage, min_cost_precent;
    EditText a1, a2, a3, a4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

         a1 = (EditText)findViewById(R.id.Amount);
         a2 = (EditText)findViewById(R.id.ins_percentage);
         a3 = (EditText)findViewById(R.id.vendor_share_percentage);
         a4 = (EditText)findViewById(R.id.min_cost_precent);
        Button button2 = (Button) findViewById(R.id.button2);
        TextView result;



         result =(TextView) findViewById(R.id.result);

         button2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 double agreemntAmount = Double.parseDouble(a1.getText().toString());
                 double insurancePercentage = Double.parseDouble(a2.getText().toString());
                 double vendorSharePercentage = Double.parseDouble(a3.getText().toString());
                 double minCostPrecent = Double.parseDouble(a4.getText().toString());


                 double wholeYearResult = agreemntAmount * (insurancePercentage/100);
                 double threeMonthsResult = wholeYearResult / 4.0;
                 double oneMonthResult = wholeYearResult / 12.0;
                 double splitProcent = (insurancePercentage - minCostPrecent);
                 double vendorSharePerYear = agreemntAmount * ((vendorSharePercentage /100) * (splitProcent / 100));
                 double vendorSharePer3Months = vendorSharePerYear  / 4;
                 double vendorSharePer1Month = vendorSharePerYear  / 12;
                 double result =  vendorSharePer1Month;


                 System.out.println("wholeYearResult " + wholeYearResult);
                 System.out.println("threeMonthsResult " + threeMonthsResult);
                 System.out.println("oneMonthResult " + oneMonthResult);
                 System.out.println("splitProcent " + splitProcent);
                 System.out.println("vendorSharePerYear =  " + vendorSharePerYear);
                 System.out.println("vendorSharePer3Months " + vendorSharePer3Months);
                 System.out.println("vendorSharePer1Month " + vendorSharePer1Month);




                 // amount 6564.76 x 0.02 = 131.2952 koko vuoden vak maksu
                 // laskutusväli 3 k
                 //131/4 = 32.82 (3 kk summa)

                 // split
                 //vakuutusprosentti 2 % - ilmoitettu min 1.0 = 1%
                 // vendor split osuus 35.7 * 0.01 = 0,.356 (Split prosentti)

                 // p564.76 * 0.00357 = 23.43 (tämä on koko vuoden osuus
                 //23.43 / 4 = 5.86 eur (huom. split listään miinus merkkisenä)
                 //Huom. yli 10 v ei vakuuteta


             };
         });
    };
}

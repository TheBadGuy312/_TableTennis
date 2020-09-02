package com.example.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;
    TextView t1;
    static int score1=0,score2=0,f=0,ten=0,s=0;
    String resetToast="Please change the players name according to the service";
    String WinnerToast="If necessary, take a Screenshot";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.player1);
        e2=(EditText)findViewById(R.id.player2);
        t1=(TextView)findViewById(R.id.Winner);
        Toast.makeText(getApplicationContext(),"Enter the players names",Toast.LENGTH_LONG).show();
    }

    public void onclick1(View view) {
        ++f; //switch case variable
        ++score1;
        display1(score1);

    }
    public void onclick2(View view) {
        ++f; //switch case variable
        ++score2;
        display2(score2);
    }
    public void switchcaseodd() {
       //if(s==1){changeServeto1();}
       //if(s==2){changeServeto2();}
       if(s%2==0){changeServeto2();}
       else if(s%2==1){changeServeto1();}
    }
    public void switchcaseeven() {
        switch (f) {
            case 2:
                changeServeto2();
                break;

            case 4:
                changeServeto1();
                break;
            case 6:
                changeServeto2();
                break;

            case 8:
                changeServeto1();
                break;

            case 10:
                changeServeto2();
                break;

            case 12:
                changeServeto1();
                break;

            case 14:
                changeServeto2();
                break;

            case 16:
                changeServeto1();
                break;

            case 18:
                changeServeto2();
                break;

            case 20:
                changeServeto1();
                break;
        }
    }
    public void tenAll() {
        if(score1 ==10 && score2==10)
        {
           ten=1;
        }
    }
    public void display1(int n) {
        TextView t= (TextView) findViewById(R.id.s1);
        t.setText(""+n);
        tenAll();
        if (ten==1) { ++s; switchcaseodd(); }
        else       { switchcaseeven(); }
        winner();

    }
    public void display2(int n) {
        TextView textView = (TextView) findViewById(R.id.s2);
        textView.setText(""+n);
        tenAll();
            if(ten==1) { ++s;switchcaseodd(); }
            else       { switchcaseeven(); }
        winner();
    }
    public void changeServeto1() {
        TextView t= (TextView) findViewById(R.id.Serve1);
        t.setText("^");
        TextView te= (TextView) findViewById(R.id.Serve2);
        te.setText(" ");
    }
    public void changeServeto2() {
        TextView t= (TextView) findViewById(R.id.Serve2);
        t.setText("^");
        TextView te= (TextView) findViewById(R.id.Serve1);
        te.setText(" ");
    }
    public void winner() {
    String name1= e1.getText().toString();
    String name2= e2.getText().toString();
    if (ten==1)
    {
        if(score1-score2==2) { t1.setText(name1);
        Toast.makeText(getApplicationContext(),"Congratulations "+ name1+"."+WinnerToast,Toast.LENGTH_LONG).show();}
        if(score2-score1==2) { t1.setText(name2);
            Toast.makeText(getApplicationContext(),"Congratulations "+ name2+"."+WinnerToast,Toast.LENGTH_LONG).show();}

    }
    else if(ten==0)
    {
        if (score1==11){
            TextView textView =(TextView)findViewById(R.id.Winner);
            textView.setText(name1);
            Toast.makeText(getApplicationContext(),"Congratulations "+ name1+"."+WinnerToast,Toast.LENGTH_LONG).show();}
        if (score2==11){ TextView textView =(TextView)findViewById(R.id.Winner);
            textView.setText(name2);
            Toast.makeText(getApplicationContext(),"Congratulations "+ name2+"."+WinnerToast,Toast.LENGTH_LONG).show();}

    }

}
    public void reset(View view) {
    display1(0);
    display2(0);
    changeServeto1();
    TextView textView =(TextView)findViewById(R.id.Winner);
    textView.setText(" ");
    Toast.makeText(getApplicationContext(),resetToast,Toast.LENGTH_LONG).show();
        score1=0;score2=0;f=0;ten=0;s=0;
}
}


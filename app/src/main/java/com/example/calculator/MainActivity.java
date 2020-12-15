package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private TextView Screen;
private Button AC,Power,Back,Ans,Equal,Div,Mul,Sub,Add,Point,One,Two,Three,Four,Five,Six,Seven,Eight,Nine,Zero;
private String Input,Answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Screen=(TextView)findViewById(R.id.screen);
        AC=(Button)findViewById(R.id.AC);
        Power=(Button)findViewById(R.id.power);
        Back=(Button)findViewById(R.id.back);
        Div=(Button)findViewById(R.id.div);
        Seven=(Button)findViewById(R.id.seven);
        Eight=(Button)findViewById(R.id.eight);
        Nine=(Button)findViewById(R.id.nine);
        Mul=(Button)findViewById(R.id.mul);
        Four=(Button)findViewById(R.id.four);
        Five=(Button)findViewById(R.id.five);
        Six= (Button)findViewById(R.id.six);
        Sub=(Button)findViewById(R.id.sub);
        One=(Button)findViewById(R.id.one);
        Two=(Button)findViewById(R.id.two);
        Three=(Button)findViewById(R.id.three);
        Add=(Button)findViewById(R.id.add);
        Zero =(Button)findViewById(R.id.zero);
        Point=(Button)findViewById(R.id.point);
        Ans=(Button)findViewById(R.id.ans);
        Equal=(Button)findViewById(R.id.equal);
    }
    public void ButtonClick(View view) {
        Button button=(Button) view;
        String data=button.getText().toString();
        switch (data){
            case "AC":
                Input="";
                break;
            case "Ans":
                Input+=Answer;
                break;
            case "*":
                Solve();
                Input+="*";
                break;
            case "^" :
                Solve();
                Input+="^";
                break;
            case "=":
                Solve();
                Answer=Input;
                break;
            case "DEL" :
                String newText=Input.substring(0,Input.length()-1);
                Input=newText;
                break;
            default:
                if(Input==null){
                    Input="";
                }
                if(data.equals("+") || data.equals("-") || data.equals("/")){
                    Solve();
                }
             Input+=data;
        }
        Screen.setText(Input);
    }
    private void Solve(){
      if(Input.split("\\*").length==2){
          String number[]=Input.split("\\*");
          try{
             double Mul=Double.parseDouble(number[0])*Double.parseDouble(number[1]);
             Input= Mul+"";
           }
          catch (Exception e){

          }
       }
       else if(Input.split("/").length==2){
            String number[]=Input.split("/");
            try{
                double Div=Double.parseDouble(number[0])/Double.parseDouble(number[1]);
                Input= Div+"";
            }
            catch (Exception e){

            }
        }
        else if(Input.split("\\^").length==2){
            String number[]=Input.split("\\^");
            try{
                double Power=Math.pow( Double.parseDouble(number[0]),Double.parseDouble(number[1]));
                Input= Power+"";
            }
            catch (Exception e){

            }
        }
        if(Input.split("\\+").length==2){
            String number[]=Input.split("\\+");
            try{
                double Sum=Double.parseDouble(number[0])+Double.parseDouble(number[1]);
                Input= Sum+"";
            }
            catch (Exception e){

            }
        }
        if(Input.split("-").length>1){
            String number[]=Input.split("-");
            //to subtract from negative number
            if(number[0]=="" &&number.length==2){
                number[0]=0+"";
            }
            try{
                double Sub=0;
                if(number.length==2){
                     Sub = Double.parseDouble(number[0])-Double.parseDouble(number[1]);

                }
                else if(number.length==3){
                    Sub = -Double.parseDouble(number[1])-Double.parseDouble(number[2]);
                }
                Input= Sub+"";
            }
            catch (Exception e){

            }
        }
        //to remove last digit .0 from integer result like 9 instead of 9.0
        String n[]=Input.split("\\.");
        if(n.length>1){
            if(n[1].equals("0")){
                Input=n[0];
            }
        }
        Screen.setText(Input);
    }

}
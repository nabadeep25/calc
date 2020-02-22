package com.nabadeep.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {
private double firstOperand;
private double secondOperand;
private int index;
private boolean isOperatorPressed=false;
private boolean isDotPressed=false;
private char currentOperator;
 private    String res;
   private TextView screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);
        screen=findViewById(R.id.screen);
        final  Button num1=findViewById(R.id.num1);
        final  Button num2=findViewById(R.id.num2);
        final  Button num3=findViewById(R.id.num3);
        final   Button num4=findViewById(R.id.num4);
        final  Button num5=findViewById(R.id.num5);
        final  Button num6=findViewById(R.id.num6);
        final   Button num7=findViewById(R.id.num7);
        final  Button num8=findViewById(R.id.num8);
        final   Button num9=findViewById(R.id.num9);
        final  Button num0=findViewById(R.id.num0);
        final  Button point=findViewById(R.id.point);
        final   Button equal=findViewById(R.id.equal);
        final   Button add=findViewById(R.id.add);
        final   Button sub=findViewById(R.id.sub);
        final  Button mul=findViewById(R.id.mul);
        final  Button div=findViewById(R.id.div);
       final  Button clrall=findViewById(R.id.clrall);
       final Button clr=findViewById(R.id.clr);
       clr.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String s=screen.getText().toString();
               int l=s.length();
               if(l>0)
               {
                   s=s.substring(0,l-1);
                   screen.setText(s);
               }
               if(!s.contains("."))
                   isDotPressed=false;

           }
       });
        View.OnClickListener keypress=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                switch (id) {
                    case R.id.num0:
                        screen.append("0");
                        break;
                    case R.id.num1:
                        screen.append("1");
                        break;
                    case R.id.num2:
                        screen.append("2");
                        break;
                    case R.id.num3:
                        screen.append("3");
                        break;
                    case R.id.num4:
                        screen.append("4");
                        break;
                    case R.id.num5:
                        screen.append("5");
                        break;
                    case R.id.num6:
                        screen.append("6");
                        break;
                    case R.id.num7:
                        screen.append("7");
                        break;
                    case R.id.num8:
                        screen.append("8");
                        break;
                    case R.id.num9:
                        screen.append("9");
                        break;
                    case R.id.point:
                        screen.append(".");
                        isDotPressed=true;
                        break;
                    case R.id.equal:
                       calculate();
                        break;
                    case R.id.div:
                        operatorPressed('/');
                        break;
                    case R.id.mul:
                        operatorPressed('*');
                        break;
                    case R.id.add:

                        operatorPressed('+');
                        break;
                    case R.id.sub:
                        operatorPressed('-');
                        break;
                   case R.id.clrall:
                        screen.setText("");
                        isDotPressed=false;
                        isOperatorPressed=false;
                        break;

                }
            }
        };
        num0.setOnClickListener(keypress);
        num1.setOnClickListener(keypress);
        num2.setOnClickListener(keypress);
        num3.setOnClickListener(keypress);
        num4.setOnClickListener(keypress);
        num5.setOnClickListener(keypress);
        num6.setOnClickListener(keypress);
        num7.setOnClickListener(keypress);
        num8.setOnClickListener(keypress);
        num9.setOnClickListener(keypress);
        point.setOnClickListener(keypress);
        equal.setOnClickListener(keypress);
        add.setOnClickListener(keypress);
        sub.setOnClickListener(keypress);
        mul.setOnClickListener(keypress);
        div.setOnClickListener(keypress);
        clrall.setOnClickListener(keypress);


    }

    private void calculate() {
        String s=screen.getText().toString();
        s=s.substring(index);
        secondOperand=Double.parseDouble(s);
        if(currentOperator=='+')
        {
            secondOperand+=firstOperand;

        }else if(currentOperator=='-')
        {secondOperand=firstOperand-secondOperand;

        }else if(currentOperator=='*')
        {
           secondOperand*=firstOperand;
        }else if(currentOperator=='/')
        {
         secondOperand=firstOperand/secondOperand;
        }
       res=String.valueOf(secondOperand);
        if(res.endsWith(".0"))
        {
            res=res.substring(0,res.length()-2);
        }
        if(res.length()>15)
        {
            res=res.substring(0,15);
        }
        screen.setText(res);

    }

    private void operatorPressed(char c) {
        String s=screen.getText().toString();
        index=s.length();
        s=s.substring(0,index);

        char lc=s.charAt(index-1);
        if((lc=='+'&&lc=='-'&&lc=='/'&&lc=='*')) {
            return;
        }
        if(isOperatorPressed)
            calculate();


        currentOperator=c;
      firstOperand=Double.parseDouble(s);
        screen.append(String.valueOf(c));
        index+=1;
        isOperatorPressed=true;
        isDotPressed=false;
    }


}

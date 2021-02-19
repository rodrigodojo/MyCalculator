package com.dojo.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView campoTexto ;
    float numeroA = 0 ;
    String operacao = "",aux = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoTexto = findViewById(R.id.display);
        campoTexto.setText("0");

    }

    @SuppressLint("NonConstantResourceId")
    public void ClicaBotao(View view) {
        switch(view.getId()){
            case R.id.buttonClear:
                campoTexto.setText("0");
                numeroA=0;
                operacao="";
                break;
            case R.id.buttonMore:
                calculaNumeros("+");
                break;
            case R.id.buttonLess:
                calculaNumeros("-");
                break;
            case R.id.buttonMulti:
                calculaNumeros("x");
                break;
            case R.id.buttonDiv:
                calculaNumeros("/");
                break;
            case R.id.buttonEquals:
                mostraResultado();
                break;
            default:
                aux = ((Button) view).getText().toString();
                getKeyboard(aux);
                break;
        }
    }

    public void calculaNumeros(String tipoOperacao){
        numeroA = Float.parseFloat(campoTexto.getText().toString());
        operacao = tipoOperacao;
        campoTexto.setText("0");
    }

    public void getKeyboard(String str){
        if(campoTexto.getText().toString().equals("0")){
            campoTexto.setText(str);
        }else if(campoTexto.length() < 4){
            campoTexto.append(str);
        }
    }

    public void mostraResultado(){
        float numeroB = Integer.parseInt(campoTexto.getText().toString());
        float result = 0;
        if(operacao.equals("+")){
            result = numeroA + numeroB;
        }
        if(operacao.equals("-")){
            result = numeroA - numeroB;
        }
        if(operacao.equals("x")){
            result = numeroA * numeroB;
        }
        if(operacao.equals("/")){
            result = numeroA / numeroB;
        }
        campoTexto.setText(String.valueOf(result));
    }
}
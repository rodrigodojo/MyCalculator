package com.dojo.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView campoTexto ;
    float numeroA = 0 ;
    String operacao = "" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoTexto = findViewById(R.id.display);
        campoTexto.setText("0");

    }

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
                //mostrarResultado();
                break;
            default:
                String numb;
                numb = ((Button)view).getText().toString();
                getKeyboard(numb);
                break;
        }
    }

    public void calculaNumeros(String tipoOperacao){
        numeroA = Float.parseFloat(campoTexto.getText().toString());
        operacao = tipoOperacao;
        campoTexto.setText("0");
    }

    public void getKeyboard(String str){
        String ScrCurrent = campoTexto.getText().toString();
        ScrCurrent += str;
        campoTexto.setText(ScrCurrent);
    }
}
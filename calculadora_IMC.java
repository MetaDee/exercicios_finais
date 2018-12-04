package com.domain.gustavoc.imc;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    private EditText editPeso;
    private EditText editAltura;
    private Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPeso =  findViewById(R.id.editPeso);
        editAltura =  findViewById(R.id.editAltura);
        btnOk =  findViewById(R.id.btnOk);
        btnOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        this.calcularImc();
    }

    public void calcularImc() {

        try {
            float peso = Float.parseFloat(editPeso.getText().toString());
            float altura = Float.parseFloat(editAltura.getText().toString());
            float imc = peso / (altura * altura);
            String resultado = situacaoIMC(imc);

            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("Vamos Calcular o IMC... ");
            alertDialog.setMessage(resultado);
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }catch (Exception ex){

        }
    }

    public String situacaoIMC(float imc){

        String situacao;

        if(imc < 17){
            situacao = "Muito Abaixo do Peso";
        }else if(imc >= 17 && imc < 18.49){
            situacao = "Abaixo do Peso";
        }else if(imc > 18.49 && imc <= 24.99){
            situacao = "Peso Normal";
        }else if(imc > 24.99 && imc <= 29.99){
            situacao = "Acima do Peso";
        }else if (imc > 29.99 && imc <= 34.99){
            situacao = "Obesidade I";
        }else if (imc > 34.99 && imc <= 39.99){
            situacao = "Obesidade II";
        }else{
            situacao = "Parametros Invalidos";
        }
        return  situacao;
    }
}
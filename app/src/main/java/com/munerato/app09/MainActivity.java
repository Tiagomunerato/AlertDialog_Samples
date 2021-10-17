package com.munerato.app09;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bt1,bt2,bt3,bt4;
    private AlertDialog alerta;

    CheckBox mCheckBox;
    View mView;
    Boolean check = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CarregarAlertDialog();
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CarregaMultiplosCheboxs();
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                InflarAlertView();
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (check == true)
                {
                    Toast.makeText(getApplicationContext(),"Check is selected", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Check is not selected",Toast.LENGTH_SHORT).show();
                }


            }
        });



    }

    private void InflarAlertView() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        mView = getLayoutInflater().inflate(R.layout.layout_alert,null);

        mCheckBox = mView.findViewById(R.id.checkBox1);

        builder.setTitle("Exemplo View");
        builder.setView(mView);

        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {


                check = false;

                if(isChecked)
                {
                    check = true;
                }
                else
                {
                    check = false;
                }
            }
        });

        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                dialogInterface.dismiss();
            }
        });

        alerta = builder.create();
        alerta.show();


    }


    private void CarregaMultiplosCheboxs() {

        CharSequence[] charSequences = new CharSequence[]{"Rock","Pop","Rap"};
        final boolean[] checked = new boolean[charSequences.length];

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Qual é seu genero musical ?");
        builder.setMultiChoiceItems(charSequences, checked, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean isChecked) {

                checked[i] = isChecked;
            }
        });

        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int i) {


                StringBuilder texto = new StringBuilder("Checked");

                        if(checked[0])
                        {
                            texto.append("Rock").append(";");
                        }

                        if(checked[1])
                        {
                            texto.append("Pop").append(";");
                        }

                        if(checked[2])
                        {
                            texto.append("Rap").append(";");
                        }

                        Toast.makeText(getApplicationContext(),texto,Toast.LENGTH_LONG).show();


            }

        });

        alerta = builder.create();
        alerta.show();


    }


    private void CarregarAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Titulo da caixa");
        builder.setMessage("Teste 01");

        builder.setPositiveButton("BOM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(getApplicationContext(),"Bom",Toast.LENGTH_SHORT).show();

            }
        });
        builder.setNegativeButton("Ruim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(getApplicationContext(),"Ruim",Toast.LENGTH_SHORT).show();
            }
        });
        alerta = builder.create();
        alerta.show();

    }
}
package com.example.davide.pickgroup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText et1 = (EditText)findViewById(R.id.etUsername);
        final EditText et2 = (EditText)findViewById(R.id.etPassword);

            Button b1 = (Button)findViewById(R.id.btLogin);

        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(et1.getText().length()==0)
                {
                    et1.setError("Inserisci nome");
                }
                else if (et2.getText().length()==0)
                {
                    et2.setError("Inserisci password");
                }
                else if(et1.getText().toString().equals("admin") && et2.getText().toString().equals("admin") )
                {
                    Intent i = new Intent(MainActivity.this,Homepage.class);
                    Toast.makeText(getApplicationContext(),"Login effettuato con successo!",Toast.LENGTH_LONG).show();

                    startActivity(i);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"UserName o Password errati.",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

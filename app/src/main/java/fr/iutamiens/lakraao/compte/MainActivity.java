package fr.iutamiens.lakraao.compte;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button bt_toogle;
    private EditText txt_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_toogle = findViewById(R.id.toogle);
        txt_input = findViewById(R.id.input_time);
        
        bt_toogle.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Log.d("click", "ok");
            }
        });

    }
}

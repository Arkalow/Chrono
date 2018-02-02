package fr.iutamiens.lakraao.compte;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_toogle;
    private EditText edit_input;
    private TextView txt_time;
    private Task task = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_toogle = findViewById(R.id.toogle);
        edit_input = findViewById(R.id.input_time);
        txt_time = findViewById(R.id.time);

        bt_toogle.setOnClickListener(this);
        Log.d("tag", "onCreate");
    }
    @Override
    public void onClick(View v){
        Log.d("tag", "click");
        if(task == null){
            task = new Task(this, txt_time, Integer.parseInt(edit_input.getText().toString()));
            task.execute();
            bt_toogle.setText("Stop");
        }else{
            task.cancel(true);
            task = null;
            bt_toogle.setText("Start");
        }

    }


}

package fr.iutamiens.lakraao.compte;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

    /*
    Interaction avec l'utilisateur
     */
    @Override
    public void onClick(View v){
        Log.d("tag", "click");
        if(task == null){
            start(Integer.parseInt(edit_input.getText().toString()));
            Toast.makeText(this, "Démarage", Toast.LENGTH_LONG).show();
        }else{
            task.cancel(true);
            Toast.makeText(this, "Fin", Toast.LENGTH_LONG).show();
            task = null;
        }
    }

    /*
    Lancement du chrono
     */
    public void start(int val){
        task = new Task(this, txt_time, val);
        task.execute();
        bt_toogle.setText("Stop");
    }
    public void stop(){
        bt_toogle.setText("Start");
        Log.d("statut", "stop");
        task.cancel(true);
        task = null;
    }







    /*
    Réorientation de l'écran
     */
    @Override
    public void onSaveInstanceState (Bundle outState){
        super.onSaveInstanceState(outState);
        Log.d("statut", "save");
        outState.putInt("val", Integer.parseInt(txt_time.getText().toString()));
        stop();
    }

    @Override
    public void onRestoreInstanceState (Bundle savedInstanceState){
        Log.d("statut", "restore");
        start(Integer.parseInt(savedInstanceState.get("val").toString()));
    }



}

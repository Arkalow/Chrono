package fr.iutamiens.lakraao.compte;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_toogle;
    private EditText edit_input;
    private TextView txt_time;
    private Task task = null;
    private long dateEnd;

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
    
    /**
     * Interaction avec l'utilisateur
     * @param v
     */
    @Override
    public void onClick(View v){
        Log.d("tag", "click");
        if(task == null){
            dateEnd = dateNow() + edit_input();
            start(dateEnd);
            Toast.makeText(this, "Start", Toast.LENGTH_LONG).show();
        }else{
            stop();
            Toast.makeText(this, "Stop", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Lancement du chrono
     * @param val
     */
    public void start(long val){

        Log.d("date", dateNow() + "");
        Log.d("date", dateNow() + "");
        Log.d("date", dateNow() + "");
        Log.d("date", dateNow() + "");
        Log.d("date", dateNow() + "");
        Log.d("date", "val : " + val + "| dateNow : " + dateNow());
        task = new Task(this, (int)(val - dateNow()));
        task.execute();
        bt_toogle.setText("Stop");
    }

    /**
     * Arrêt du chrono
     */
    public void stop(){
        bt_toogle.setText("Start");
        Log.d("statut", "stop");
        task.cancel(true);
        task = null;
    }

    /**
     * Accesseur de la textView txt_time
     * @return la valeur de txt_time
     */
    private Integer txt_time(){
        return Integer.parseInt(txt_time.getText().toString());
    }

    /**
     * Accesseur de la textView txt_time
     * @return la valeur de txt_time
     */
    public Integer txt_time(Integer value){
        txt_time.setText(value.toString());
        return value;
    }

    /**
     * Accesseur de l'input
     * @return
     */
    private long edit_input(){return Long.parseLong(edit_input.getText().toString()); }


    /**
     * Sauvegarde
     * @param outState
     */
    @Override
    public void onSaveInstanceState (Bundle outState){
        super.onSaveInstanceState(outState);
        if(task != null){
            Log.d("statut", "save");
            outState.putInt("val", txt_time());
            stop();
        }
    }

    /**
     * Restauration
     * @param savedInstanceState
     */
    @Override
    public void onRestoreInstanceState (Bundle savedInstanceState){
        try{
            Log.d("statut", "restore");
            start(Integer.parseInt(savedInstanceState.get("val").toString()));
        }catch(Exception e){
            Log.e("restoreInstance", "Impossible de recréer une instance qui n'existe pas");
        }

    }

    /**
     * Retourne la date actuelle en seconde
     * @return
     */
    public long dateNow(){
        Date currentTime = Calendar.getInstance().getTime();
        String str = currentTime.getTime()+"";
        return Long.parseLong(str);
    }


}

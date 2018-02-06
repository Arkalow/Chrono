package fr.iutamiens.lakraao.compte;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by omer on 02/02/18.
 */

public class Task extends AsyncTask <Object ,Integer, String>{

    private final Context context;

    private final TextView textView;

    private final Integer input;

    /*
    Constructeur
     */
    public Task(Context context, TextView text, Integer input){
        Log.d("Task", "Task: constructeur");
        this.context = context;
        this.textView = text;
        this.input = input;
    }

    @Override
    protected String doInBackground(Object[] objects) {
        Integer compteur = input;
        try {
        while(compteur > 0){
            Thread.sleep(1000);
            compteur --;
            Log.d("Task", "Task: increment");
            publishProgress(compteur);
        }
        }catch(InterruptedException e){
            e.printStackTrace();
            Log.e("Thread", e.getMessage());
        }
        return "Done";
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String str) {
        super.onPostExecute(str);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        Log.d("Task", "Task: Progress");
        textView.setText(values[0] + "");
        super.onProgressUpdate(values);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        Log.d("Task", "Task: Cancelled");
    }
}

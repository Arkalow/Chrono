package fr.iutamiens.lakraao.compte;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by omer on 02/02/18.
 */

public class Task extends AsyncTask <Object ,Integer, String>{

    private final MainActivity context;

    private final TextView textView;

    private final Integer input;

    /*
    Constructeur
     */
    public Task(MainActivity context, TextView text, Integer input){
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
        Log.d("Task", "onPreExecute");
    }

    @Override
    protected void onPostExecute(String str) {
        super.onPostExecute(str);
        Log.d("Task", "onPostExecute");
        context.stop();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        Log.d("Task", "Task: Progress");
        textView.setText(values[0] + "");
        super.onProgressUpdate(values);
    }

    @Override
    protected void onCancelled() {
        Log.d("Task", "Task: Cancelled");
        super.onCancelled();
    }
}

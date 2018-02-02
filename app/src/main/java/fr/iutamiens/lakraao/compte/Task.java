package fr.iutamiens.lakraao.compte;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

/**
 * Created by omer on 02/02/18.
 */

public class Task extends AsyncTask {

    /*
    Champs
     */
    private final Context context;

    private final TextView textView;

    /*
    Constructeur
     */
    public Task(Context context, TextView text){
        this.context = context;
        this.textView = text;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
    }

    @Override
    protected void onProgressUpdate(Object[] values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }
}

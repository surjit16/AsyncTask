package com.example.surjit.asynctaskwithprogressbar;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;

/**
 * Created by surjit on 22-02-2018.
 */

public class MyAsyncTask extends AsyncTask<Void, Integer, String> {

    Context mContext;
    ProgressDialog bar;
    final int MAX = 100;
    View inflater;

    public MyAsyncTask(Context context) {
        super();
        mContext = context;
    }

    @Override
    protected void onPreExecute() {
        bar = new ProgressDialog(mContext);
        bar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        bar.setMax(MAX);
        bar.setMessage("Hello ");
        bar.setTitle("ASSSSSSSs");
        bar.show();
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Void... voids) {
        try {

            for (int i =0; i<=100; i++)
            {
                Thread.sleep(200);
                publishProgress(i);
            }
        } catch (Exception e) {

        }
        return "Sucess";
    }

    @Override
    protected void onPostExecute(String s) {

        bar.cancel();
        super.onPostExecute(s);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        bar.setProgress(values[0]);

    }
}

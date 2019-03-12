package edu.wit.mobileapp.myhttpclient;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static String TAG = "myApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetData getData = new GetData(this);
        getData.execute();
    }
}
class GetData extends AsyncTask<String, Void, String> {
    private Context mContext;
    GetData(Context context){
        this.mContext = context;
    }
    @Override
    protected String doInBackground(String... params) {
        String result = "";
        try {
            URL url = new URL("https://www.wit.edu");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            StringBuffer sb = new StringBuffer();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String read;
            while((read = br.readLine())!=null){
                sb.append(read);
            }
            br.close();
            result = sb.toString();
        } catch (IOException e) {
            Log.d(TAG, "Error: " + e.toString());
        }
        return result;
    }
    @Override
    protected void onPostExecute(String data){
        Log.v(TAG, "data = " + data);
    }
}
package kr.co.woobi.imyeon.countdowntimerwithasynctask403;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {
private CountTask mCountTask;
private TextView mTextTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextTime=findViewById(R.id.text_time_activity);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EventStart event) {
        mCountTask = new CountTask();
        mCountTask.execute();
    }

    public  class CountTask extends AsyncTask<Integer, Integer, Integer> {

        @Override
        protected Integer doInBackground(Integer... params) {
            for (int i = 1; i <=10; i++) {

                try {
                    Thread.sleep(1000);
                    publishProgress(i);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
//            mTextTime.setText(String.valueOf(values[0]));
            EventBus.getDefault().post(new EventItem(values[0]));
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
        }

        @Override
        protected void onCancelled() {

            super.onCancelled();

        }
    }
    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EventCancel event) {
        mTextTime.setText("0");
        mCountTask.cancel(true);
    }
}

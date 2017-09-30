package mx.devf.cintanegra1gdl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("myLog","onCreate");
    }



    @Override
    protected void onStart() {
       super.onStart();
        Log.i("myLog","OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("myLog","OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("myLog","OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("myLog","onStop");
    }

    @Override
    protected void onDestroy() {
        Log.i("myLog","OnDestroy");
        super.onDestroy();

    }


}

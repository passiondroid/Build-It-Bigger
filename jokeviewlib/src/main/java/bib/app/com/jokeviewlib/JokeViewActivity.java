package bib.app.com.jokeviewlib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeViewActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_view);
        textView = (TextView)findViewById(R.id.text);
        String joke = getIntent().getStringExtra("joke");
        if(null != joke ){
            textView.setText(joke);
        }
    }
}

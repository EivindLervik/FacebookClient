package no.hvl.dat153.facebookclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.login.LoginManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button logout = (Button)findViewById(R.id.login_button);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginManager.getInstance().logOut();
                Intent login = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(login);
                finish();
            }
        });
    }

    public void graphClick(View view){
        Intent intent = new Intent(this, GraphApi.class);
        startActivity(intent);
    }

    public void postClick(View view){
        // TODO Add intent
    }

    public void shareClick(View view){
        Intent intent = new Intent(this, ShareThis.class);
        startActivity(intent);
    }

    public void likeClick(View view){
        Intent intent = new Intent(this, Like.class);
        startActivity(intent);
    }
}

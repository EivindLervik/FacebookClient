package no.hvl.dat153.facebookclient;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.login.widget.LoginButton;

public class LoginActivity extends AppCompatActivity {

    LoginButton login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}

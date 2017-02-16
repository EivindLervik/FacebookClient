package no.hvl.dat153.facebookclient;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.login.LoginManager;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

public class MainActivity extends AppCompatActivity {

    private ShareDialog shareDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shareDialog = new ShareDialog(this);
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
        ShareLinkContent content = new ShareLinkContent.Builder()
                .build();
        shareDialog.show(content);
    }

    public void shareClick(View view){
        ShareLinkContent content = new ShareLinkContent.Builder()
                .setContentTitle("This app is great!")
                .setContentDescription(
                        "I just used this app that lets you see your facebook profile. Learn about facebook API today!")
                .setContentUrl(Uri.parse("http://developers.facebook.com/android"))
                .build();
        shareDialog.show(content);

    }

    public void likeClick(View view){
        Intent intent = new Intent(this, Like.class);
        startActivity(intent);
    }

}

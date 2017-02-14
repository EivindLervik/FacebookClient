package no.hvl.dat153.facebookclient;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.facebook.share.widget.LikeView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Like extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_like);

        // Add values to the like-view
        LikeView likeView = (LikeView) findViewById(R.id.like_view);
        likeView.setObjectIdAndType(
                "https://www.facebook.com/HiBinfo/?fref=ts",
                LikeView.ObjectType.PAGE);
    }
}

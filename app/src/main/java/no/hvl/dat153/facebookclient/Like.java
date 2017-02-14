package no.hvl.dat153.facebookclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.share.widget.LikeView;

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

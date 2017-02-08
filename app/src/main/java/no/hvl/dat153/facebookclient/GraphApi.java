package no.hvl.dat153.facebookclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

import org.json.JSONArray;
import org.json.JSONObject;

public class GraphApi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_api);


    }

    public void showLikes(View view){
        //TODO - Make a request. Display results
    }
    public void showInformation(View view){
        //TODO - Make a request. Display results
    }
    public void requestHandlerLikes(){
        GraphRequest request = GraphRequest.newMeRequest(
                AccessToken.getCurrentAccessToken(),
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted (
                            JSONObject object,
                            GraphResponse response) {
                        try {
                            JSONArray likes = object.getJSONArray("data");
                        }
                        catch (Exception e){

                        }

                        //TODO - add items to view
                        //likes{data[{name},{name}]}
                    }
                });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "likes");
        request.setParameters(parameters);
        request.executeAsync();
    }
    public void requestHandlerInformation(){
        GraphRequest request = GraphRequest.newMeRequest(
                AccessToken.getCurrentAccessToken(),
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(
                            JSONObject object,
                            GraphResponse response) {

                        //TODO - add items to view
                    }
                });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,link");
        request.setParameters(parameters);
        request.executeAsync();
    }

}

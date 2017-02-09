package no.hvl.dat153.facebookclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class GraphApi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_api);


    }

    public void showLikes(View view){
        requestHandlerLikes();
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
                            updateListCallback(likes);
                        }
                        catch (Exception e){
                            Toast.makeText(GraphApi.this, "Could not find likes", Toast.LENGTH_LONG).show();
                        }

                    }
                });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "friends");
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

    public void updateListCallback(JSONArray likes){
        ListView lw = (ListView) findViewById(R.id.item_list);
        ArrayList<String> likesList = new ArrayList<String>();
        try {
            for (int i = 0; i < likes.length(); i++) {
                likesList.add(likes.getJSONObject(i).getString("name"));
            }
        } catch (JSONException e){
            e.printStackTrace();
        }

        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, likesList);
    }

}

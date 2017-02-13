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

    public void showInformation(View view){
        requestHandlerLikes();
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

                            updateListCallback(object);
                        }
                        catch (Exception e){
                            Toast.makeText(GraphApi.this, "Could not find likes", Toast.LENGTH_LONG).show();
                        }

                    }
                });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "friends, name, id, gender");
        request.setParameters(parameters);
        request.executeAsync();
    }


    public void updateListCallback(JSONObject object){
        ListView lw = (ListView) findViewById(R.id.item_list);
        ArrayList<String> arrayList = new ArrayList<String>();

       // {"friends":{"data":[],"summary":{"total_count":718}},"id":"10154893173101760"}
        try {
            String totalFriends = "friends: " + object.getJSONObject("friends").getJSONObject("summary").getString("total_count");
            String name = "name: " + object.getString("name");
            String gender = "gender: " + object.getString("gender");
            arrayList.add(totalFriends);
            arrayList.add(name);
            arrayList.add(gender);
        } catch (JSONException e){
            Toast.makeText(GraphApi.this, "oh darn", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        lw.setAdapter(adapter);
    }

}

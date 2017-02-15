package no.hvl.dat153.facebookclient;

import android.graphics.drawable.Drawable;
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
import com.facebook.login.widget.ProfilePictureView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
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
            String totalFriends = "total friends: " + object.getJSONObject("friends").getJSONObject("summary").getString("total_count");
            String name = "name: " + object.getString("name");
            String gender = "gender: " + object.getString("gender");
            ProfilePictureView profilePicture = (ProfilePictureView) findViewById(R.id.profilePicView);
            String profileId = object.getString("id");
            profilePicture.setProfileId(profileId);

            JSONArray friends = object.getJSONObject("friends").getJSONArray("data");
            arrayList.add(totalFriends);
            arrayList.add(name);
            arrayList.add(gender);
            arrayList.add("friends using this app: ");
            for(int i = 0; i<friends.length(); i++){
                String friend = friends.getJSONObject(i).getString("name");
                arrayList.add(friend);
            }

        } catch (JSONException e){
            Toast.makeText(GraphApi.this, "oh darn", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        lw.setAdapter(adapter);
    }

    public static Drawable LoadImageFromWebOperations(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, "src name");
            return d;
        } catch (Exception e) {
            return null;
        }
    }

}

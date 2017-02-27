package com.tincio.spotifyproject.presentation.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.tincio.spotifyproject.R;

import org.json.JSONObject;


public class LoginActivity extends AppCompatActivity {

    String name = "prueba_name";
    String apellido = "prueba_apellido";
    Uri uri = null;
    Intent intent = null;
    SharedPreferences prefs = null;

    CallbackManager callbackManager;

    private AccessTokenTracker accessTokenTracker;
    private ProfileTracker profileTracker;
    Profile profile = null;
    Button btn = null;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
   // private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_login);
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


      //  LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        // loginButton.setReadPermissions(Arrays.asList("public_profile, email, user_birthday"));
        Log.e("Oncreate", "Oncreate");

      //  loginButton.setBackgroundResource(R.mipmap.ic_launcher);
        callbackManager = CallbackManager.Factory.create();



        /*
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        if(accessToken!=null){
            Log.e("AccesTokenCurrent",accessToken.getToken());
        }

        */
        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldToken, AccessToken newToken) {
                Log.e("TokenChanged", "Entro");

            }
        };

        profileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile newProfile) {

                Log.e("ProfileChanged", "Entro");
               /*
         if(oldProfile.getName()!=null){
                    Log.e("TokenOld","Entro"+oldProfile.getName());
                }
                if(newProfile.getName()!=null){
                    Log.e("TokenNew","Entro"+newProfile.getName());
                }
                */
            }
        };

        accessTokenTracker.startTracking();
        profileTracker.startTracking();

        profile = Profile.getCurrentProfile();
        if (profile != null) {
            if (intent != null)

                startActivity(intent);
            Log.e("OtraActivity", "Other activity");
        }


       /* loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                GraphRequest request = GraphRequest.newMeRequest(
                        loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(
                                    JSONObject object,
                                    GraphResponse response) {
                                // Application code
                                Log.e("LoginActivity1111", "hhh" + response.toString());
                                String name = object.optString("name");
                                String email = object.optString("email");
                                String id = object.optString("id");
                                prefs = getSharedPreferences("Login", getApplicationContext().MODE_PRIVATE);
                                SharedPreferences.Editor editor = prefs.edit();
                                editor.putString("name", name);
                                editor.putString("email", email);
                                editor.putString("id", id);
                                editor.commit();


                                intent = new Intent(LoginActivity.this, MainActivity.class);
                                intent.putExtra("name", name);
                                intent.putExtra("email", email);
                                intent.putExtra("id", id);
                                Log.e("LoginActivity22j2", "hhh" + name + "||||" + email + "|||" + id);
                                finish();
                                startActivity(intent);

                            }
                        });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,email,gender, birthday");
                request.setParameters(parameters);
                request.executeAsync();


            }

            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(), "Cancelado", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();

            }
        });*/

        // && AccessToken.getCurrentAccessToken()!=null;
        /*
        if(Profile.getCurrentProfile() == null) {
            mProfileTracker = new ProfileTracker() {
                @Override
                protected void onCurrentProfileChanged(Profile profile, Profile profile2) {
                    Log.e("facebook - profilenull", profile2.getFirstName()+"+++"+profile2.getLinkUri());
                    mProfileTracker.stopTracking();
                }
            };
            mProfileTracker.startTracking();
        }
        else {
            Profile profile = Profile.getCurrentProfile();
            Log.e("facebook - profile!null", profile.getFirstName()+profile.getLinkUri());

        }*/
        //intent


      /*  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

       /* try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.example.alberto.loginfacebook",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }*/


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
       // client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        Log.e("result", "Onactivityresult");
        if (callbackManager.onActivityResult(requestCode, resultCode, data)) {
            return;
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Onresume", "Onresume");
        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);
        if (profile != null) {
            prefs = getSharedPreferences("Login", getApplicationContext().MODE_PRIVATE);
            intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra("name", prefs.getString("name", "123"));
            intent.putExtra("email", prefs.getString("email", "12"));
            intent.putExtra("id", prefs.getString("id", "1"));
            //   Log.e("LoginActivity22j2", "hhh" + name + "||||" + email + "|||" + id);
            finish();
            startActivity(intent);
        }
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
      //  client.connect();
      //  AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
      //  AppIndex.AppIndexApi.end(client, getIndexApiAction());
      //  client.disconnect();
    }
}

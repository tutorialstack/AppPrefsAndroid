package in.tutorialstack.appprefs;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String TAG = MainActivity.class.getSimpleName();

    Context context;
    EditText edtString, edtUserId, edtFirstName, edtLastName;
    TextView txtString, txtUser;
    AppPrefs appPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            context = this;
            edtString = (EditText)findViewById(R.id.edt_string);
            edtUserId = (EditText)findViewById(R.id.edt_id);
            edtFirstName = (EditText)findViewById(R.id.edt_first_name);
            edtLastName = (EditText)findViewById(R.id.edt_last_name);

            txtString = (TextView)findViewById(R.id.txt_string);
            txtUser = (TextView)findViewById(R.id.txt_user);

            appPrefs = AppPrefs.getAppPrefs(context);
        } catch (Exception ex) {
            Log.e(TAG, ex.getMessage());
        }
    }

    public void saveString(View view){
        appPrefs.setString("City", edtString.getText().toString());
    }

    public void getString(View view){
        txtString.setText(appPrefs.getString("City"));
    }

    public void saveUser(View view){
        UserModel userModel = new UserModel();
        if(edtUserId.getText().length() > 0) {
            userModel.setId(Integer.valueOf(edtUserId.getText().toString()));
        }
        userModel.setFirstName(edtFirstName.getText().toString());
        userModel.setLastName(edtLastName.getText().toString());
        appPrefs.setUser(userModel);
    }

    public void getUser(View view){
        UserModel userModel = appPrefs.getUser();
        if(userModel != null){
            txtUser.setText("Id: "+userModel.getId() + " First Name: "+ userModel.getFirstName()+ " Last Name "+ userModel.getLastName());
        }else{
            txtUser.setText("User is not saved");
        }
    }
}

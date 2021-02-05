package in.bitcode.resources;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnSetData;
    private TextView txtMessage;
    private EditText edtInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSetData = findViewById(R.id.btnSetData);
        edtInfo = findViewById(R.id.edtInfo);
        txtMessage = findViewById(R.id.txtMessage);

        btnSetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtMessage.setText(edtInfo.getText().toString());
            }
        });

        if(savedInstanceState != null) {

        }


        MyData myData = (MyData) getLastCustomNonConfigurationInstance();
        if(myData != null) {
            txtMessage.setText(myData.data + " Updated");
        }





        //R.string.welcome_message

        /*
        Resources res = getResources();
        String welcomeMessage = res.getString(R.string.welcome_message);
        log(welcomeMessage);

        Drawable drawable = res.getDrawable(R.drawable.flag);
        int code = res.getInteger(R.integer.comp_code);
        int colorCode = res.getColor(R.color.bg_color);
        boolean isPassword = res.getBoolean(R.bool.is_password);
        float width = res.getDimension(R.dimen.txt_width);
        String [] cities = res.getStringArray(R.array.cities);
        int [] codes = res.getIntArray(R.array.city_codes);

        Configuration config = res.getConfiguration();
        log(config.locale.getDisplayCountry());
        log(config.locale.getDisplayLanguage());

        log("font scale: " + config.fontScale);
        //log("color mode: " + config.colorMode);
        log("keyboard: " + config.keyboard);
        */

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("code", 101);

    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Nullable
    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        //code to backup the data
        MyData myData = new MyData();
        myData.data = txtMessage.getText().toString();
        return myData;
    }

    private void log(String text) {
        Log.e("tag", text);
    }
}











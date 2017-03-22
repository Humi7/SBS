package eu.humidesign.sbs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AddSuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_success);


        final Button addrowbutton = (Button) findViewById(R.id.add_row_button);
        addrowbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                EditText myEditText = new EditText(AddSuccessActivity.this);
                myEditText.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                LinearLayout myLayout = (LinearLayout) findViewById(R.id.listasukcesow);
                myEditText.setText("success "+(myLayout.getChildCount()+1));
                myLayout.addView(myEditText);

            }
        });

        final Button donebutton = (Button) findViewById(R.id.done_button);
        donebutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                LinearLayout myLayout = (LinearLayout) findViewById(R.id.listasukcesow);
                int total = myLayout.getChildCount();
                List<String> sukcesy = new ArrayList();
                for (int i =0;i<total;i++) {
                    EditText myEditText = (EditText) myLayout.getChildAt(i);
                    sukcesy.add(myEditText.getText().toString());
                }
                String happymsg = "Will store " + String.valueOf(sukcesy.size());
                Toast.makeText(AddSuccessActivity.this, happymsg , Toast.LENGTH_LONG).show();
                finish();
            }
        });

    }



}

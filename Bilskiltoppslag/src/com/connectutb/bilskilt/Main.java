package com.connectutb.bilskilt;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class Main extends Activity {
	static final private int ABOUT_ID = Menu.FIRST;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        /* Set up the listener for the submit button */
        final ImageButton button = (ImageButton) findViewById(R.id.imageButton_Submit);
        button.setOnClickListener(new ImageButton.OnClickListener() {

            public void onClick(View v) {
                // Run the sendRequest method 
            	sendRequest();
            }
        });
    }
    
    public void sendRequest(){
    	/* Send the license info on SMS */
    		final EditText regfield = (EditText) findViewById(R.id.regEdit);
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(String.valueOf(R.string.sms_nr), null, regfield.getText().toString(), null, null); 

    }
    
    public boolean onCreateOptionsMenu(Menu menu) {
        /**
         * Create our menu options
         */
    	super.onCreateOptionsMenu(menu);
    	
    	menu.add(0, ABOUT_ID, 0, R.string.option_about).setShortcut('0', 'o').setIcon(android.R.drawable.ic_dialog_info);
    	return true;
    }
}
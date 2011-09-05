package com.connectutb.bilskilt;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

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
    	/* First we check if the license plate is in a valid format */
    	if (regfield.length() == 7) {
    		
            SmsManager sms = SmsManager.getDefault();
            //sms.sendTextMessage(getResources().getString((R.string.sms_nr)), null, "REGNR " + regfield.getText().toString(), null, null); 
            
            /* Notify user that the message was sent */
            dialogSuccess();
            /* Clear the submission text edit field */
            regfield.setText("");
    	}
    	else{
    		/* Notify user of invalid license plate */
    		Toast.makeText(this, getString(R.string.invalid_license), Toast.LENGTH_SHORT).show();
    	}
    }
    public void dialogSuccess(){
    	/* Notify the user that the submission was sucessful */
    	 
    		 AlertDialog.Builder builder = new AlertDialog.Builder(this);
    		 builder.setMessage(R.string.success_text)
    		 		.setTitle(R.string.success_title)
    		 		.setIcon(android.R.drawable.ic_dialog_info)
    		 		.setCancelable(false);
    		 
    		 		builder.setNeutralButton(R.string.ok, 
    		 				new DialogInterface.OnClickListener(){
    		 			public void onClick(DialogInterface dialog, int which){
    		 				dialog.dismiss();
    		 			}
    		 		});
    		 AlertDialog alert = builder.create();
    		 alert.show();
    		 /* Show the dialog */
    	 	}
    public boolean onCreateOptionsMenu(Menu menu) {
        /**
         * Create our menu options
         */
    	super.onCreateOptionsMenu(menu);
    	
    	menu.add(0, ABOUT_ID, 0, getResources().getString(R.string.option_about)).setShortcut('0', 'o').setIcon(android.R.drawable.ic_dialog_info);
    	return true;
    }
}
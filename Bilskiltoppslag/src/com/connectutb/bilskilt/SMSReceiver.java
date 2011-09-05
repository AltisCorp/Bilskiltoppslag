package com.connectutb.bilskilt;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class SMSReceiver extends BroadcastReceiver
{
	@Override
	public void onReceive(Context context, Intent intent) 
       {	
        //---get the SMS message passed in---
        Bundle bundle = intent.getExtras();        
        SmsMessage[] msgs = null;
        String str = "";    
        
        if (bundle != null)
        {
        	/* If the sender is the information service, we do something with it */
        }
	}
}

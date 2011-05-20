package se.mah.k3.cheng.alan.pfi3_assignment_4;

import se.k3.goransson.andreas.essemmesslib.Essemmess;
import se.k3.goransson.andreas.essemmesslib.EssemmessHelper;
import se.k3.goransson.andreas.essemmesslib.EssemmessListener;
import se.k3.goransson.andreas.essemmesslib.EssemmessLoginEvent;
import se.k3.goransson.andreas.essemmesslib.EssemmessPublishEvent;
import se.k3.goransson.andreas.essemmesslib.EssemmessReadEvent;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Pfi3_assignment_4 extends Activity implements OnClickListener, EssemmessListener{
    /** Called when the activity is first created. */
    Essemmess mServer = EssemmessHelper.getServer(this);
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
        mServer.addEssemmessEventListener(this);
        Button button= (Button) findViewById(R.id.loginbutton1);
        button.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		EditText text1 = (EditText) findViewById(R.id.editText1);
    	EditText text2 = (EditText) findViewById(R.id.editText2);

    	String msg = text1.getText().toString();
    	String tag = text2.getText().toString();
    	
    	mServer.login(msg, tag);
    	text1.setText("");
    	text2.setText("");
		
    	
    	
	}

	@Override
	public void NewEssemmessPosts(EssemmessReadEvent evt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void NewEssemmessLogin(EssemmessLoginEvent evt) {
		// TODO Auto-generated method stub
		if (evt.getLoggedin()){
			Intent texting = new Intent (this,Send.class );
			startActivity(texting);
			finish();
		}
	}

	@Override
	public void NewEssemmessPublish(EssemmessPublishEvent evt) {
		// TODO Auto-generated method stub
		
	}
	
}
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
import android.widget.Toast;

public class Send extends Activity implements OnClickListener,
		EssemmessListener {
	Essemmess mServer = EssemmessHelper.getServer(this);

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		mServer.addEssemmessEventListener(this);

		Button button = (Button) findViewById(R.id.sendbutton1);
		button.setOnClickListener(this);

		Button button2 = (Button) findViewById(R.id.toread);
		button2.setOnClickListener(this);
	}

	@Override
	public void NewEssemmessPosts(EssemmessReadEvent evt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void NewEssemmessLogin(EssemmessLoginEvent evt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void NewEssemmessPublish(EssemmessPublishEvent evt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {
		case R.id.sendbutton1:

			EditText text1 = (EditText) findViewById(R.id.editText1);
			EditText text2 = (EditText) findViewById(R.id.editText2);

			String msg = text1.getText().toString();
			String tag = text2.getText().toString();

			mServer.post(msg, tag);

			Toast t = Toast.makeText(this, "Posted", Toast.LENGTH_LONG);
			t.show();
			text1.setText("");
			text2.setText("");

			break;

		case R.id.toread:

			Intent view = new Intent(this, Read.class);
			startActivity(view);
			finish();
			break;
		}

	}
}
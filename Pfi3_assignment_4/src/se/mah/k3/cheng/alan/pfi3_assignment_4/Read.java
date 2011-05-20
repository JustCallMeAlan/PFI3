package se.mah.k3.cheng.alan.pfi3_assignment_4;

import java.util.ArrayList;

import se.k3.goransson.andreas.essemmesslib.Essemmess;
import se.k3.goransson.andreas.essemmesslib.EssemmessHelper;
import se.k3.goransson.andreas.essemmesslib.EssemmessListener;
import se.k3.goransson.andreas.essemmesslib.EssemmessLoginEvent;
import se.k3.goransson.andreas.essemmesslib.EssemmessPublishEvent;
import se.k3.goransson.andreas.essemmesslib.EssemmessReadEvent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Read extends Activity implements OnClickListener, EssemmessListener {
 
	Essemmess mServer = EssemmessHelper.getServer(this) ;

	ArrayList<String> arraylist = new ArrayList <String>();
	
	ListView listView1;
	ArrayAdapter <String> adapter;
	
	protected void onCreate (Bundle savedInstance){
		super.onCreate (savedInstance);
		setContentView(R.layout.read);
		
		mServer.addEssemmessEventListener(this);
		Button update = (Button) findViewById(R.id.update1);
		update.setOnClickListener(this);
		
		listView1=(ListView)findViewById(R.id.listView1);
		listView1.setAdapter (adapter = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, arraylist));

		mServer.read ("");


	}
	
	@Override
	public void NewEssemmessPosts(EssemmessReadEvent evt) {
		
		arraylist.clear();
		for ( int i=0; i< evt.getPosts().size(); i++){
			arraylist.add(evt.getPosts().get(i).getUser() + ": " + evt.getPosts().get(i).getMessage());
		}
		adapter.notifyDataSetChanged();
		
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
		
		mServer.read("");
		
	}
	
}

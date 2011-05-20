package se.mah.k3.alan.cheng.pfi_assignment_3_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Pfi_assignment_3_5 extends Activity implements OnClickListener, Callback {
	int[] ID={R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, 
			R.id.button6, R.id.button7, R.id.button8, R.id.button9};
	List<Moles> hole;
			
	
    private GameUpdateThread t;
    private Handler handler;
    public int score =0;
    
    private int counter =30;
	private final int START_VALUE = 30;
	

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    
    handler = new Handler (this);
    
    hole = new ArrayList<Moles>();
    Button Start= (Button) findViewById(R.id.button10);
    Start.setOnClickListener(this);
    for(int i=0;i<9; i++){
    	hole.add((Moles) findViewById(ID[i]));
    	hole.get(i).setOnClickListener(this);
    }
    }
    public void onClick(View v) {
		// TODO Auto-generated method stub
		Button start= (Button) findViewById(R.id.button10);
		for(int i=0;i<9;i++){
        	hole.add((Moles) findViewById(ID[i]));
        }
		switch(v.getId()){
		case R.id.button1:
			if(hole.get(0).alive){
				score++;
				hole.get(0).setImage();}
			break;
		case R.id.button2:
			if(hole.get(1).alive){
				score++;
				hole.get(1).setImage();}
		break;
		case R.id.button3:
			if(hole.get(2).alive){
				score++;
				hole.get(2).setImage();}
		break;
		case R.id.button4:
			if(hole.get(3).alive){
				score++;
				hole.get(3).setImage();}
		break;
		case R.id.button5:
			if(hole.get(4).alive){
				score++;
				hole.get(4).setImage();}
		break;
		case R.id.button6:
			if(hole.get(5).alive){
				score++;
				hole.get(5).setImage();}
		break;
		case R.id.button7:
			if(hole.get(6).alive){
				score++;
				hole.get(6).setImage();}
		break;
		case R.id.button8:
			if(hole.get(7).alive){
				score++;
				hole.get(7).setImage();}
		break;
		case R.id.button9:
			if(hole.get(8).alive){
				score++;
				hole.get(8).setImage();}
		break;
		case R.id.button10:
			startNewCounter(START_VALUE);
		break;
    	}
		
	}
	
	public boolean handleMessage(Message msg) {
		//No information in msg that interests us in this application
		updateUI();
		return false;
	}	
	
	//Method for handling UI updating
	private void updateUI() {
		TextView textView = (TextView)findViewById(R.id.textView1);
		if (counter == 0){ 
			counter = START_VALUE;
			stopCounter();
			textView.setText("\t\t Time's Up!!"+"\n"+"You whacked "+String.valueOf(score)+" moles!");
			//Please redraw as soon as possible
			textView.invalidate();
			Button b = (Button)findViewById(R.id.button10);
			b.setText("Start");
			//Please redraw as soon as possible
			b.invalidate();
		}else{
			
			//Update the UI component
			textView.setText("Time: "+String.valueOf(counter)+ "\n"+"score: "+String.valueOf(score));
			
			for(int i=0;i<9;i++){
	        	if(hole.get(i).alive){
	        		hole.get(i).setImage();
	        	}
	        }
			int j=new Random().nextInt(9);
			int h=new Random().nextInt(9);
			hole.get(j).setImage();
			hole.get(h).setImage();
			//Please redraw as soon as possible
			textView.invalidate();
			--counter;
		}
	}
	
	private void startNewCounter(int startValue){
		counter= startValue;
		score=0;
		if (t!=null){
			t.stopCountDown();
			t=null;
		}
	    t = new GameUpdateThread(handler);
	    t.start();
	    //Change text on button
	    Button b = (Button)findViewById(R.id.button10);
	    b.setText("Restart");
	    //Please redraw as soon as possible
	    b.invalidate();
	}
	
	private void stopCounter(){
		if (t!=null){
			t.stopCountDown();
			t=null;
		}
	}
	
	
}
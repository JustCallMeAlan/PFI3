package se.mah.k3.alan.cheng.pfi_assignment_3_5;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.Button;

public class Moles extends Button {
	boolean alive= false;
	List<Integer> myList;
	
	public Moles(Context context, AttributeSet attrs) {
		super (context, attrs);
		this.setText("");
		myList = new ArrayList<Integer>();
		myList.add(R.drawable.mole_1);
		myList.add(R.drawable.mole_2);
		setImage();
	}

	public void setImage(){
		if(alive){
			alive=false;
			this.setBackgroundResource(myList.get(0));
			invalidate();
		}else{
			alive=true;
			this.setBackgroundResource(myList.get(1));
			invalidate();
		}
	}
protected void onDraw(Canvas canvas) {
	super.onDraw(canvas);
}
}


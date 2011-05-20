package se.mah.k3.alan.cheng.pfi_assignment_3_5;

import android.os.Handler;
import android.util.Log;

public class GameUpdateThread extends Thread{
	private Handler _ui;
	private boolean _running =true;
	
	public void stopCountDown(){
		_running = false;
	}
	public GameUpdateThread(Handler ui){
		_ui = ui;
	}
	public void run() {
		super.run();
		
		while (_running){
			try{
				Log.i("k3", "Thread Runnig");
				_ui.sendEmptyMessage(NORM_PRIORITY);
				Thread.sleep(1000);
			} catch (InterruptedException e){
				Log.i("k3", e.getMessage());
			}
		}
	}
	
}

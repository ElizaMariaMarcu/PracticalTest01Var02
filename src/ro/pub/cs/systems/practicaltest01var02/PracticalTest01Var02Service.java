package ro.pub.cs.systems.practicaltest01var02;

import java.util.Random;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class PracticalTest01Var02Service extends Service {
	public class ProcessingThread extends Thread {
		 
		  private Context context;

		 
		  public ProcessingThread(Context context) {
		    this.context = context;

		  }
		 
		  @Override
		  public void run() {
		    while(true){ 
		      sendMessage();
		      sleep();

		    }
		  }
		 
		  private void sleep() {
		    try {
		      Thread.sleep(10000);
		    } catch (InterruptedException interruptedException) {
		      interruptedException.printStackTrace();
		    }
		  }
		 
		  private void sendMessage() {
		    Intent intent = new Intent();
		    Random randX = new Random();

		         intent.putExtra("nr1", randX.nextInt(10) );
		         intent.putExtra("nr2", randX.nextInt(5) );
		         intent.putExtra("nr3", randX.nextInt(10));
		         intent.putExtra("nr4", randX.nextInt(5));
		         Log.d("gf","numere generate");
		    context.sendBroadcast(intent);
		  }


		}


	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	  @Override
	  public int onStartCommand(Intent intent, 
	                            int flags,
	                            int startId) {

		  Log.d("started service", "serviciul a pornit");
		  ProcessingThread th = new ProcessingThread(this);
		  th.start();
		  return Service.START_REDELIVER_INTENT;
	  }
	 

}

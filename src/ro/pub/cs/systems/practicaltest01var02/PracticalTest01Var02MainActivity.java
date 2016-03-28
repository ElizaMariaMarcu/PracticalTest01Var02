package ro.pub.cs.systems.practicaltest01var02;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class PracticalTest01Var02MainActivity extends Activity {
	private EditText text1, text2, text3, text4;
	private Button set;
	
	
	private SomeEventBroadcastReceiver bcast = new SomeEventBroadcastReceiver();
	private IntentFilter intentFilter = new IntentFilter();
	public class SomeEventBroadcastReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
	        EditText text1 = (EditText)findViewById(R.id.editText1);
	        EditText text2 = (EditText)findViewById(R.id.editText2);
	        EditText text3 = (EditText)findViewById(R.id.editText3);
	        EditText text4 = (EditText)findViewById(R.id.editText4);
			text1.setText(intent.getStringExtra("nr1"));
			text2.setText(intent.getStringExtra("nr2"));
			text3.setText(intent.getStringExtra("nr3"));
			text4.setText(intent.getStringExtra("nr4"));
			Log.d("ads", "a intrat aici");
		}
		}
	private ClickList list = new ClickList();
	
	public class ClickList implements View.OnClickListener {
		@Override
		public void onClick(View v) {
	        EditText text1 = (EditText)findViewById(R.id.editText1);
	        EditText text2 = (EditText)findViewById(R.id.editText2);
	        EditText text3 = (EditText)findViewById(R.id.editText3);
	        EditText text4 = (EditText)findViewById(R.id.editText4);
	      ;
	        if (text1.getText().toString().isEmpty()!= true && text1.getText().toString().isEmpty() != true  &&
	        		text1.getText().toString().isEmpty() != true  && text1.getText().toString().isEmpty() != true ){
	        	Intent intent = new Intent(getApplicationContext(), PracticalTest01Var02SecondaryActivity.class);
	        	intent.putExtra("key1", text1.getText().toString());
	        	intent.putExtra("key2", text2.getText().toString());
	        	intent.putExtra("key3", text3.getText().toString());
	        	intent.putExtra("key4", text4.getText().toString());
	        	Log.d("fkg", "suma e facuta");
	        	startActivity(intent);
	        }
		}
	}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var02_main);
        text1 = (EditText)findViewById(R.id.editText1);
		text2 = (EditText)findViewById(R.id.editText2);
        text3 = (EditText)findViewById(R.id.editText3);
		text4 = (EditText)findViewById(R.id.editText4);
		set = (Button)findViewById(R.id.button);
		set.setOnClickListener(list);
		Intent intent = new Intent(this, PracticalTest01Var02Service.class);
		startService(intent);
    }
    
    @Override
    protected void onResume() {
    	// TODO Auto-generated method stub
    	super.onResume();
    	registerReceiver(bcast, intentFilter);
    }
    
@Override
protected void onSaveInstanceState(Bundle outState) {
	// TODO Auto-generated method stub
	super.onSaveInstanceState(outState);
	outState.putString("key1", text1.getText().toString());
	outState.putString("key2", text2.getText().toString());
	outState.putString("key3", text3.getText().toString());
	outState.putString("key4", text4.getText().toString());
}
@Override
protected void onRestoreInstanceState(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onRestoreInstanceState(savedInstanceState);
	text1.setText(savedInstanceState.getString("key1"));
	text2.setText(savedInstanceState.getString("key2"));
	text3.setText(savedInstanceState.getString("key3"));
	text4.setText(savedInstanceState.getString("key4"));
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.practical_test01_var02_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    @Override
    protected void onPause() {
    	// TODO Auto-generated method stub
    	 unregisterReceiver(bcast);
    	super.onPause();
    }
	@Override
	protected void onDestroy() {
		Intent intent = new Intent(this, PracticalTest01Var02Service.class);
		stopService(intent);
		// TODO Auto-generated method stub
		super.onDestroy();
	}
}

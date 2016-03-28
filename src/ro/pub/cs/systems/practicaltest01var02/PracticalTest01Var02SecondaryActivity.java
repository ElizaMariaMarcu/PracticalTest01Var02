package ro.pub.cs.systems.practicaltest01var02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var02SecondaryActivity extends Activity {
	private EditText text1, text2, text3, text4;
	private Button sum, product;
	Intent intent;
	private ClickList list = new ClickList();
	
	public class ClickList implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			EditText text1 = (EditText)findViewById(R.id.editText1);
			EditText text2 = (EditText)findViewById(R.id.editText2);
			EditText text3 = (EditText)findViewById(R.id.editText3);
			EditText text4 = (EditText)findViewById(R.id.editText4);
			int nr1 = Integer.parseInt(text1.getText().toString());
			int nr2 = Integer.parseInt(text2.getText().toString());
			int nr3 = Integer.parseInt(text3.getText().toString());
			int nr4 = Integer.parseInt(text4.getText().toString());
			switch (v.getId()) {
			case R.id.sum:

				int sum = nr1 + nr2 + nr3 + nr4;
				Toast.makeText(getApplicationContext(), "Suma celor 4 numere este: " + sum, Toast.LENGTH_LONG).show();
				break;
			case R.id.product:

				int product = nr1 * nr2 * nr3 * nr4;
				Toast.makeText(getApplicationContext(), "Produsul celor 4 numere este: " + product, Toast.LENGTH_LONG).show();
				break;
			}
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var02_secondary);
        text1 = (EditText)findViewById(R.id.editText1);
		text2 = (EditText)findViewById(R.id.editText2);
        text3 = (EditText)findViewById(R.id.editText3);
		text4 = (EditText)findViewById(R.id.editText4);
		sum = (Button)findViewById(R.id.sum);
		product  = (Button)findViewById(R.id.product);
		sum.setOnClickListener(list);
		product.setOnClickListener(list);
		
		intent = getIntent();
		text1.setText(intent.getStringExtra("key1"));
		text2.setText(intent.getStringExtra("key2"));
		text3.setText(intent.getStringExtra("key3"));
		text4.setText(intent.getStringExtra("key4"));

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater()
				.inflate(R.menu.practical_test01_var02_secondary, menu);
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

}

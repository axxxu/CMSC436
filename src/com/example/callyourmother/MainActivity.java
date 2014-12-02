package com.example.callyourmother;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	String currentSelection = "";
	ListView contactList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//List of contacts for the user to see 
		contactList = (ListView) findViewById(R.id.contact_list);
      		String[] values = new String[] { "Android List View", 
				"Adapter implementation",
				"Simple List View In Android",
				"Create List View Android", 
				"Android Example", 
				"List View Source Code", 
				"List View Array Adapter", 
				"Android Example List View" 
		};

		//Creates a new list adapter to load the contacts into
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,android.R.id.text1,values);

		contactList.setAdapter(adapter);
		contactList.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				int itemPosition = position;
				String  itemValue    = (String) contactList.getItemAtPosition(position);
				Toast.makeText(getApplicationContext(),
						"Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
						.show();
				currentSelection = itemValue;
				Intent viewContactIntent = new Intent(MainActivity.this, ViewContactActivity.class);
				viewContactIntent.putExtra("CONTACT", currentSelection);
				startActivity(viewContactIntent);
				
			}

		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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

package com.gmail.pemapmodder.nbtbrowser;

import java.io.File;
import java.io.IOException;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class BrowseActivity extends ActionBarActivity{
	public final static String MY_NAME =
			"com.gmail.pemapmodder.nbtbrowser.BrowseActivity";
	public final static String INTENT_RESULT_STATUS =
			MY_NAME + ".intent_status";
	public final static String INTENT_RESULT_STATUS_NOTFILE =
			"NOTFILE";
	public final static String INTENT_RESULT_STATUS_CORRUPTION =
			"FILE_CORRUPTION";
	public final static String INTENT_RESULT_STATUS_IOEXCEPTION =
			"IOEXCEPTION";
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_browse);
		Uri uri = getIntent().getData();
		String path = uri.getPath();
		File nbtFile = new File(path);
		if(!nbtFile.isFile()){
			try{
				toastLong(R.string.browse_not_file, nbtFile.getCanonicalPath());
			}
			catch(IOException e){
				e(e);
			}
			Intent data = new Intent();
			data.putExtra(INTENT_RESULT_STATUS, INTENT_RESULT_STATUS_NOTFILE);
			setResult(RESULT_CANCELED, data);
			finish();
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		int id = item.getItemId();
		if(id == R.id.action_settings){
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void toastLong(int resId, Object... args){
		Toast.makeText(this, String.format(getString(resId).replace('$', '%'),
				args), Toast.LENGTH_LONG).show();
	}
	public void toastLong(String msg, Object... args){
		Toast.makeText(this, String.format(msg.replace('$', '%'), args),
				Toast.LENGTH_LONG).show();
	}
	public void e(Throwable e){
		toastLong("Exception caught: $s", e.getMessage());
	}
}

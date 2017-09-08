package course.labs.activitylab;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class ActivityOne extends Activity {

		// string for logcat documentation
		private final static String TAG = "Lab-ActivityOne";

		// lifecycle counts
		protected int counterCreate = 0;
		protected int counterStart = 0;
		protected int counterResume = 0;
		protected int counterPause = 0;
		protected int counterStop = 0;
		protected int counterDestroy = 0;
		protected int counterRestart = 0;
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_one);
			
			//Log cat print out
			Log.i(TAG, "onCreate called");

			// update counter
			counterCreate++;
			updateCounters();
		}

		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.activity_one, menu);
			return true;
		}
		
		// lifecycle callback overrides
		
		@Override
		public void onStart(){
			super.onStart();

			//Log cat print out
			Log.i(TAG, "onStart called");

			// update counter
			counterStart++;
			updateCounters();
		}

		@Override
		public void onResume(){
			super.onResume();

			//Log cat print out
			Log.i(TAG, "onResume called");

			// update counter
			counterResume++;
			updateCounters();
		}

	@Override
	public void onPause(){
		super.onPause();

		//Log cat print out
		Log.i(TAG, "onPause called");

		// update counter
		counterPause++;
		updateCounters();
	}

	@Override
	public void onDestroy(){
		super.onDestroy();

		//Log cat print out
		Log.i(TAG, "onDestroy called");

		// update counter
		counterDestroy++;
		updateCounters();
	}

	@Override
	public void onRestart(){
		super.onRestart();

		//Log cat print out
		Log.i(TAG, "onRestart called");

		// update counter
		counterRestart++;
		updateCounters();
	}

	@Override
	public void onStop(){
		super.onStop();

		//Log cat print out
		Log.i(TAG, "onStop called");

		// update counter
		counterStop++;
		updateCounters();
	}


	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		Log.d(TAG, "onSaveInstanceState()");
		outState.putInt("counterCreate", counterCreate);
		outState.putInt("counterStart", counterStart);
		outState.putInt("counterResume", counterResume);
		outState.putInt("counterStop", counterStop);
		outState.putInt("counterRestart", counterRestart);
		outState.putInt("counterPause", counterPause);
		outState.putInt("counterDestroy", counterDestroy);
	}

	// only called if activity killed
	// restore savedInstanceState here or in onCreate(Bundle)
	protected void onRestoreInstanceState(Bundle inState) {
		super.onRestoreInstanceState(inState);
		Log.d(TAG, "onRestoreInstanceState()");
		// restore savedInstanceState here or in onCreate(Bundle)
		counterCreate = inState.getInt("counterCreate");
		counterStart = inState.getInt("counterStart");
		counterResume = inState.getInt("counterResume");
		counterStop = inState.getInt("counterStop");
		counterRestart = inState.getInt("counterRestart");
		counterPause = inState.getInt("counterPause");
		counterDestroy = inState.getInt("counterDestroy");

		updateCounters();
	}

		/*
		it would absolutely be more efficient to put this in an array but we're just testing things here so don't judge my code
		 */
		private void updateCounters() {
			TextView textView = (TextView) findViewById(R.id.createCounter);
			textView.setText(counterCreate+"");
			textView = (TextView) findViewById(R.id.startCounter);
			textView.setText(counterStart+"");
			textView = (TextView) findViewById(R.id.resumeCounter);
			textView.setText(counterResume+"");
			textView = (TextView) findViewById(R.id.destroyCounter);
			textView.setText(counterDestroy+"");
			textView = (TextView) findViewById(R.id.pauseCounter);
			textView.setText(counterPause+"");
			textView = (TextView) findViewById(R.id.restartCounter);
			textView.setText(counterRestart+"");
			textView = (TextView) findViewById(R.id.stopCounter);
			textView.setText(counterStop+"");

		}
		public void launchActivityTwo(View view) {
			startActivity(new Intent(this, ActivityTwo.class));
		}
		

}

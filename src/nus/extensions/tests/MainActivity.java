package nus.extensions.tests;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public abstract class MainActivity extends Activity {

	public static final String CONNECTION_STRING = null;
	SourceEmulator source;
	SinkEmulator sink;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.answer_layout);
		
		TextView answerView = (TextView) findViewById(R.id.answer_view);
		answerView.setText("Hello world!");
		main(source, sink);
	}
	
	protected abstract void main(SourceEmulator source, SinkEmulator sink);
	public abstract String getDescription();
	public abstract int getVulnerabilityCount();
}

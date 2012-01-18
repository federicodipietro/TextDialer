package textdialer.namespace;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class TextDailerActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        EditText etext = (EditText)findViewById(R.id.editText1);
        etext.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
        
        Button btnDial = (Button)findViewById(R.id.btnDial);
        btnDial.setOnClickListener(new OnClickListener()
        {	
     @Override
		public void onClick(View arg0) 
     		{
    		EditText etext = (EditText)findViewById(R.id.editText1);
    	//**salva numero textbox nella stringa telString
    		String telString = etext.getText().toString();
    	//**trasforma etext in una Uri
    		String telUriString = "tel: " + telString;
    		Uri telUri = Uri.parse(telUriString);
    	//**creo intent con azione action_dial e Uri telUri
    		Intent intent = new Intent(Intent.ACTION_DIAL);
    		intent.setData(telUri);
    		startActivity(intent);
			}
        });
        Button btnCall = (Button) findViewById(R.id.btnCall);
        btnCall.setOnClickListener(new OnClickListener()
        {
			@Override
			public void onClick(View arg0) 
			{	
				EditText etext = (EditText)findViewById(R.id.editText1);
				Intent intent = new Intent(Intent.ACTION_CALL);
			//**salva numero textbox nella stringa telString
	    		String telString = etext.getText().toString();
	    	//**trasforma etext in una Uri
	    		String telUriString = "tel: " + telString;
	    		Uri telUri = Uri.parse(telUriString);
	    		intent.setData(telUri);
	    		startActivity(intent);
			}
        });
        
    }
}
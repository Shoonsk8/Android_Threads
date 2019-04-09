package com.lambda.android_threads;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowInsets;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et;
    TextView tv;
    String str;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        tv=findViewById( R.id.text_main );
        str=getResources().getString( R.string.contents_shifted);
        bt=findViewById( R.id.button_for_result );

        tv.setText(str);
        et=findViewById( R.id.input_number );
        bt.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String debug="";
                String s =  et.getText().toString();
                if (s.equals( "" ))return;

                int shift=Integer.parseInt( s );
                s="";
               int len = str.length();
               // shift=8;
                char c;
                for(int x = 0; x < len; x++){
                    c=str.charAt(x);
                    if(c>=65&&c<=90){
                        c=(char)(c+shift);
                        debug+=(char)(c-shift); //debug
                        if (c > 'Z') {
                            s += (char) (c-26);
                        }else{
                            s +=(char)c;
                        }
                    }else if(c>=97&&c<=122){
                        c=(char)(c+shift);
                        debug+=(char)(c-shift); //debug
                        if (c > 'z') {
                            s += (char) (c-26);
                        }else {
                            s += (char) c;
                        }
                    }else{

                        s+=(char)c;
                    }
                }
                tv.setText( s );
                tv.invalidate();
            }
        } );
  /*      et.setOnKeyListener( new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode==34) {

                    tv.setText( et.getText() );
                }

                return true;
            }
        } );*/
/*        et.setOnApplyWindowInsetsListener( new View.OnApplyWindowInsetsListener() {
                                               @Override
                                               public WindowInsets onApplyWindowInsets(View v, WindowInsets insets) {
                                                   tv.setText( et.getText() );
                                                   return null;
                                               }
                                           }
        );
*/
    }


}



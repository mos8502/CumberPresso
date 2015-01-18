package hu.anemeth.cumberpresso;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {
    private static final String TAG_DIALOG = "dialog";

    private EditText messageText;
    private Button actionShowMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageText = (EditText)findViewById(R.id.message_text);
        actionShowMessage = (Button)findViewById(R.id.action_show_dialog);
        actionShowMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment f = fm.findFragmentByTag(TAG_DIALOG);
                if(f != null) {
                    ft.remove(f);
                }
                MessageDialog d = new MessageDialog();
                Bundle args = new Bundle();
                args.putString("message", messageText.getText().toString());
                d.setArguments(args);
                d.show(ft, TAG_DIALOG);
            }
        });
    }

    public static class MessageDialog extends DialogFragment {
        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            return new AlertDialog.Builder(getActivity()).setMessage(getArguments().getString("message")).setPositiveButton("Hide", null).create();
        }
    }
}

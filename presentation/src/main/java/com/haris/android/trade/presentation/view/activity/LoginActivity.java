package com.haris.android.trade.presentation.view.activity;



import android.os.Bundle;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.haris.android.trade.presentation.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginActivity extends BaseActivity  {




    @Bind(R.id.username)
    AutoCompleteTextView mEmailView;

    @Bind(R.id.password)
    EditText mPasswordView;

    @Bind(R.id.email_sign_in_button)
    Button mEmailSignInButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);



        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });




    }




    private void attemptLogin() {


        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            return;
        }

        if (TextUtils.isEmpty(password)) {
            mPasswordView.setError(getString(R.string.error_field_required));
            return;
        }



        if (email.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")){
            this.navigator.navigateToTrade(this);
            this.finish();
        } else {

            Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show();
        }


    }



    @OnClick(R.id.email_sign_in_button)
    void navigateToApp() {attemptLogin();

    }



}


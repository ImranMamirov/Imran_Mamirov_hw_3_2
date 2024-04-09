package com.example.imran_mamirov_hw_3_2;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class MainFragment extends Fragment {

    private Button sendBtn;
    private EditText emailEditText;
    private EditText themeEditText;
    private EditText textEditText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sendBtn = requireActivity().findViewById(R.id.sendBtn);
        emailEditText = requireActivity().findViewById(R.id.emailEditText);
        themeEditText = requireActivity().findViewById(R.id.themeEditText);
        textEditText = requireActivity().findViewById(R.id.textEditText);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String subject = themeEditText.getText().toString();
                String message = textEditText.getText().toString();

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, message);
                intent.setPackage("com.google.android.gm");


                startActivity(Intent.createChooser(intent, "Send Email"));
            }
        });
    }
}
package com.example.baitap2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private EditText editTextCorrected;
    private Button buttonSubmitBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        editTextCorrected = findViewById(R.id.edit_corrected);
        buttonSubmitBack = findViewById(R.id.btn_submit_back);

        // Nhận nội dung từ học sinh
        String studentText = getIntent().getStringExtra("student_text");
        editTextCorrected.setText(studentText);

        // Khi cô giáo chỉnh sửa xong và gửi lại
        buttonSubmitBack.setOnClickListener(v -> {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("corrected_text", editTextCorrected.getText().toString());
            setResult(88, resultIntent);
            finish();
        });
    }
}

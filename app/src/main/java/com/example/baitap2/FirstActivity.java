package com.example.baitap2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {

    private EditText editTextStudent;
    private EditText editTextTeacher;
    private Button buttonSubmit;

    private static final int REQUEST_CODE_EDIT = 99; // Mã request để nhận dữ liệu từ cô giáo

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // Ánh xạ giao diện
        editTextStudent = findViewById(R.id.edit_student);
        editTextTeacher = findViewById(R.id.edit_teacher);
        buttonSubmit = findViewById(R.id.btn_submit);

        // Khi học sinh ấn "Nộp Bài"
        buttonSubmit.setOnClickListener(v -> {
            String studentText = editTextStudent.getText().toString(); // Lấy nội dung học sinh nhập

            // Chuyển dữ liệu sang SecondActivity để cô giáo sửa bài
            Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
            intent.putExtra("student_text", studentText);
            startActivityForResult(intent, REQUEST_CODE_EDIT);
        });
    }

    // Nhận kết quả sau khi cô giáo sửa bài
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_EDIT && resultCode == 88 && data != null) {
            String correctedText = data.getStringExtra("corrected_text");
            editTextTeacher.setText(correctedText); // Hiển thị bài đã sửa
        }
    }
}

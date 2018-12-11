package ua.com.zzz.dmytrokutko.sqlite_list3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import ua.com.zzz.dmytrokutko.sqlite_list3.db.MyDatabase;
import ua.com.zzz.dmytrokutko.sqlite_list3.model.Student;

public class MainActivity extends AppCompatActivity {

    EditText etName, etSurname, etGroup, etUniversity;
    Button btnAdd, btnList;

    MyDatabase mydb;
    ArrayList<Student> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Student student = new Student();
                student.setName(etName.getText().toString().trim());
                student.setSurname(etSurname.getText().toString().trim());
                student.setGroup(etGroup.getText().toString().trim());
                student.setUniversity(etUniversity.getText().toString().trim());

                mydb.insertData(student);
                Toast.makeText(MainActivity.this, "New student added", Toast.LENGTH_SHORT).show();

            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, StudentsList.class);
                startActivity(intent);

            }
        });

    }

    private void initComponents() {
        etName = findViewById(R.id.etName);
        etSurname = findViewById(R.id.etSurname);
        etGroup = findViewById(R.id.etGroup);
        etUniversity = findViewById(R.id.etUniversity);
        btnAdd = findViewById(R.id.btnAdd);
        btnList = findViewById(R.id.btnList);

        mydb = new MyDatabase(MainActivity.this);
        list = new ArrayList<>();
    }
}

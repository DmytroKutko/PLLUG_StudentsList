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
    Button btnAdd, btnList, btnDel;

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

                if (etName.getText().toString().trim().equals("") ||
                        etSurname.getText().toString().trim().equals("") ||
                        etGroup.getText().toString().trim().equals("") ||
                        etUniversity.getText().toString().trim().equals("")) {

                    Toast.makeText(MainActivity.this, "Enter all fields", Toast.LENGTH_SHORT).show();

                } else {
                    Student student = new Student();
                    student.setName(etName.getText().toString().trim());
                    student.setSurname(etSurname.getText().toString().trim());
                    student.setGroup(etGroup.getText().toString().trim());
                    student.setUniversity(etUniversity.getText().toString().trim());

                    mydb.insertData(student);

                    etName.setText("");
                    etSurname.setText("");
                    etGroup.setText("");
                    etUniversity.setText("");

                    Toast.makeText(MainActivity.this, "New student added", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StudentsList.class);
                startActivity(intent);
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mydb.deleteAll();
                    Toast.makeText(MainActivity.this, "Data removed", Toast.LENGTH_SHORT).show();
                } catch (Exception e){
                    Toast.makeText(MainActivity.this, "Data is empty", Toast.LENGTH_SHORT).show();
                }
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
        btnDel = findViewById(R.id.btnDel);

        mydb = new MyDatabase(MainActivity.this);
        list = new ArrayList<>();
    }
}

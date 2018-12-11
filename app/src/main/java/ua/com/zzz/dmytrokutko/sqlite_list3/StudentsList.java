package ua.com.zzz.dmytrokutko.sqlite_list3;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

import ua.com.zzz.dmytrokutko.sqlite_list3.adapter.StudentsAdapter;
import ua.com.zzz.dmytrokutko.sqlite_list3.db.MyDatabase;
import ua.com.zzz.dmytrokutko.sqlite_list3.model.Student;

public class StudentsList extends AppCompatActivity {

    RecyclerView recyclerView;
    StudentsAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Student> list;
    Context context;
    Cursor cursor;
    Student student;
    MyDatabase myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        initComponents();

        recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No data!", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String surname = cursor.getString(2);
                String group = cursor.getString(3);
                String university = cursor.getString(4);
                student = new Student(id, name, surname, group, university);
                list.add(student);
            }
        }

        adapter = new StudentsAdapter(this, list);
        recyclerView.setAdapter(adapter);
    }

    private void initComponents() {
        list = new ArrayList<>();
        myDB = new MyDatabase(StudentsList.this);
        cursor = myDB.getData();
        context = this;
    }
}

package ua.com.zzz.dmytrokutko.sqlite_list3.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ua.com.zzz.dmytrokutko.sqlite_list3.R;
import ua.com.zzz.dmytrokutko.sqlite_list3.model.Student;


public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.ViewHolder> {

    private ArrayList<Student> list;
    Context context;

    public StudentsAdapter(Context context, ArrayList<Student> list) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentsAdapter.ViewHolder viewHolder, int i) {
        viewHolder.tvName.setText(list.get(i).getName());
        viewHolder.tvSurname.setText(list.get(i).getSurname());
        viewHolder.tvGroup.setText(list.get(i).getGroup());
        viewHolder.tvUniversity.setText(list.get(i).getUniversity());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvSurname, tvGroup, tvUniversity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvSurname = itemView.findViewById(R.id.tvSurname);
            tvGroup = itemView.findViewById(R.id.tvGroup);
            tvUniversity = itemView.findViewById(R.id.tvUniversity);
        }
    }
}

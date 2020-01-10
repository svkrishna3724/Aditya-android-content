package com.example.moviesinfo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler1);

        int images[]={R.drawable.a,R.drawable.b,R.drawable.c,
        R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,
        R.drawable.h,R.drawable.i,R.drawable.j};

        String movies[] = {"Ala Vaikuntapuramlo","Bahubali","Chatrapati","Dookudu",
        "Eega","F2","Gangleader","Happy Days","I Manoharudu","Josh"};

        String actors[] = {"Allu Arjun","Prabhas","Prabhas","Mahesh Babu","Nani",
        "Venkatesh - Varun Tej","Nani","Varun - Nikhil","Vikram","Naga Chaitanya"};

        RVAdapter r = new RVAdapter(images,movies,actors);
        recyclerView.setAdapter(r);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
    class RVAdapter extends RecyclerView.Adapter<RVViewHolder> {
        int images[];
        String names[];
        String actors[];

        public RVAdapter(int[] images, String[] names, String[] actors) {
            this.images = images;
            this.names = names;
            this.actors = actors;
        }

        @NonNull
        @Override
        public RVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(MainActivity.this)
                    .inflate(R.layout.design_item,parent,false);

            return new RVViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RVViewHolder holder, int position) {
         holder.img.setImageResource(images[position]);
         holder.t1.setText(names[position]);
         holder.t2.setText(actors[position]);

        }

        @Override
        public int getItemCount() {
            return images.length;
        }
    }
    class RVViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView t1,t2;

        public RVViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img1);
            t1=itemView.findViewById(R.id.text1);
            t2=itemView.findViewById(R.id.text2);
        }
    }
}

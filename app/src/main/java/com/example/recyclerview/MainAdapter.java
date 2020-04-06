package com.example.recyclerview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//Adatper는 리사이클러뷰에 표시될 아이템들을 하나의 뷰로 만들어주는 역할을 한다.

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CustomViewHolder> {

    /**
     * RecyclerView는  RecyclerView.Adapter를 상속받아 Adapter를 직접 구현해야 한다.
     * ->RecyclerView.Adapter<MainAdapter.CustomViewHolder>
     */

    private int layout; //부분화면을 구성하는 xml을 생성자로 받는다.
    private ArrayList<MainData> list; //부분화면에 들어갈 데이터 클래스를 ArrayList 타입으로 정의한다.

    public MainAdapter(int layout, ArrayList<MainData> list) {
        this.layout = layout;
        this.list = list;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        /**
         * inflate(resource, root, attachToRoot)
         * -resource : View로 만들 레이아웃
         * -root : 생성될 view의 부모를 명시해준다.
         *         null일 경우 XML내의 최상위 android:layout_width등의 값들이 무시된다.
         * -attachToRoot를 true로 설정해주면 root의 자식 View로 자동으로 추가된다.
         *
         * return이 true이면 root가 리턴되고, false이면 xml내의 최상의 뷰가 리턴된다.
         */
        CustomViewHolder viewHolder=new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final CustomViewHolder holder, final int position) {
        holder.imgProfile.setImageResource(list.get(position).getImgProfile());
        holder.tvName.setText(list.get(position).getTvName());
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentName=holder.tvName.getText().toString().trim();
                Toast.makeText(view.getContext(), currentName, Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                int positionNum=holder.getAdapterPosition();
                list.remove(positionNum);
                notifyItemChanged(positionNum);
                Toast.makeText(view.getContext(), positionNum+"삭제완료", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return (list !=null) ? list.size() : 0;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        /**
         * ViewHolder는 item에 표시할 View를 관리한다.
         *
         */

        public ImageView imgProfile;
        public TextView tvName;

        public CustomViewHolder(@NonNull View itemView) {
            //itemView에는
            super(itemView);
            imgProfile=itemView.findViewById(R.id.imgView);
            tvName=itemView.findViewById(R.id.tvName);
        }
    }
}

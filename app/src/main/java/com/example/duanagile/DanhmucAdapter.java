//package com.example.duanagile;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class DanhmucAdapter extends RecyclerView.Adapter<DanhmucAdapter.ViewHolder> {
//
//    private List<DanhMuc> list;
//    private Context context;
//
//    public DanhmucAdapter(Context context, List<DanhMuc> list) {
//        this.context = context;
//        this.list = list;
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(context)
//                .inflate(R.layout.item_danh_muc, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        DanhMuc dm = list.get(position);
//        holder.tvTen.setText(dm.ge());
//    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//    static class ViewHolder extends RecyclerView.ViewHolder {
//        TextView tvTen;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            tvTen = itemView.findViewById(R.id.tvTenDanhMuc);
//        }
//    }
//}
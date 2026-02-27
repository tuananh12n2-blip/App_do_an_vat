//package com.example.duanagile;
//
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class quan_ly_danh_muc extends AppCompatActivity {
//
//    private RecyclerView rvDanhMuc;
//    private DanhmucAdapter adapter;
//    private List<DanhMuc> danhMucList;
//    private Apiserver apiServices;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_quan_ly_danh_muc);
//
//        // Ánh xạ
//        rvDanhMuc = findViewById(R.id.rvDanhMuc);
//
//        // Setup RecyclerView
//        danhMucList = new ArrayList<>();
//        adapter = new DanhmucAdapter(this, danhMucList);
//        rvDanhMuc.setLayoutManager(new LinearLayoutManager(this));
//        rvDanhMuc.setAdapter(adapter);
//
//        // API
//        apiServices = RetrofitClient.getInstance().getApiServices();
//
//        // Load danh mục
//        loadCategories();
//    }
//
//    private void loadCategories() {
//        apiServices.getAllCategories().enqueue(new Callback<ApiResponse<List<DanhMuc>>>() {
//            @Override
//            public void onResponse(Call<ApiResponse<List<DanhMuc>>> call,
//                                   Response<ApiResponse<List<DanhMuc>>> response) {
//
//                if (response.isSuccessful() && response.body() != null) {
//                    danhMucList.clear();
//                    danhMucList.addAll(response.body().getData());
//                    adapter.notifyDataSetChanged();
//                } else {
//                    Toast.makeText(quan_ly_danh_muc.this,
//                            "Không tải được danh mục", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ApiResponse<List<DanhMuc>>> call, Throwable t) {
//                Toast.makeText(quan_ly_danh_muc.this,
//                        "Lỗi kết nối API", Toast.LENGTH_SHORT).show();
//                Log.e("API", t.getMessage());
//            }
//        });
//    }
//}

package com.example.kiemtra.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kiemtra.Activity.MainActivity;
import com.example.kiemtra.R;
import com.example.kiemtra.DAO.ProductDAO;
import com.example.kiemtra.Model.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private Context context;
    private List<Product> ProductList;

    public ProductAdapter(Context context, List<Product> ProductList) {
        this.context = context;
        this.ProductList = ProductList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Product Product = this.ProductList.get(position);
        holder.txtName.setText(Product.getTenSP());
        holder.txtPrice.setText(Product.getGiaTien().toString());
        Picasso picasso = Picasso.get();
        picasso.load(Product.getImage())
                .into(holder.productImage);
        holder.deleteImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Bạn có chắc chắn muốn xóa không?")
                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ProductDAO ProductDAO = new ProductDAO(context);
                                ProductDAO.deleteSP(Product.getMaSP());
                                refreshRecyclerView();
                            }
                        })
                        .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
            }
        });
    }
    private void refreshRecyclerView() {
        ProductDAO ProductDAO = new ProductDAO(context);
        ProductList = ProductDAO.getListProduct();
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return ProductList.size();
    }
    public static  class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtPrice;
        ImageView productImage, deleteImage ;
        public ProductViewHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            productImage = itemView.findViewById(R.id.productImage);
            deleteImage = itemView.findViewById(R.id.deleteImage);
        }
    }
}
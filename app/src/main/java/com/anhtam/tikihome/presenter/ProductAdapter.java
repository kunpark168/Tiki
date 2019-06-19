package com.anhtam.tikihome.presenter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.anhtam.tikihome.R;
import com.anhtam.tikihome.model.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private Context mContext;
    private List<Product> products;

    public ProductAdapter(Context mContext, List<Product> products) {
        this.mContext = mContext;
        this.products = products;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        if (products == null || products.get(position) != null)
            return;
        Product product = products.get(position);

        holder.tvDescription.setText(product.getName());

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void setList (List<Product> arrProduct){
        this.products = arrProduct;
        notifyDataSetChanged();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgTikiNow;
        private TextView tvDescription, tvPrice, tvDiscount;
        private TextView tvOptionDevilery, tvNumberDevilvery, tvOptionColor;
        private ConstraintLayout csFastDelivery;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            initView (itemView);
        }

        private void initView (View view){
            imgTikiNow = view.findViewById(R.id.imgTikiNow);
            tvDescription = view.findViewById(R.id.tvDescription);
            tvDiscount = view.findViewById(R.id.tvDiscount);
            csFastDelivery = view.findViewById(R.id.csFastDelivery);
            tvNumberDevilvery = view.findViewById(R.id.tvNumberDevilvery);
            tvOptionDevilery = view.findViewById(R.id.tvOptionDevilery);
            tvOptionColor = view.findViewById(R.id.tvOptionColor);
        }
    }
}

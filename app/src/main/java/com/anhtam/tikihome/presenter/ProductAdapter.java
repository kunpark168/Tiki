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
import com.anhtam.tikihome.custom.RatingBarCustom;
import com.anhtam.tikihome.model.Product;
import com.anhtam.tikihome.utils.Strings;
import com.bumptech.glide.Glide;

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
        if (products == null || products.get(position) == null)
            return;
        Product product = products.get(position);
        holder.tvDescription.setText(product.getName());
        holder.imgTikiNow.setVisibility(product.hasTikiNow() ? View.VISIBLE : View.INVISIBLE);
        holder.csFastDelivery.setVisibility(product.hasFastDelivery() ? View.VISIBLE : View.GONE);
        holder.tvDiscount.setVisibility(product.hasDiscount() ? View.VISIBLE : View.GONE);
        holder.tvOptionColor.setVisibility(product.hasOptionColor() ? View.VISIBLE : View.GONE);
        holder.tvDiscount.setText("-" +product.getDiscountRate() + "%");

        if (product.hasFastDelivery()){
            holder.tvOptionDevilery.setText(product.getTextFastDelivery());
            holder.tvNumberDevilvery.setText(product.getNumberFastDelivery());
        }

        holder.tvPrice.setText(Strings.moneyFormat(String.valueOf(product.getPrice())) + " đ");
        Glide.with(mContext).load(product.getThumbnailUrl()).into(holder.imgProduct);
        holder.tvRating.setText("(" + product.getReviewCount() + ")");
        holder.csRating.init(product.getRatingAverage());

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
        private TextView tvDescription, tvPrice, tvDiscount, tvRating;
        private TextView tvOptionDevilery, tvNumberDevilvery, tvOptionColor;
        private ConstraintLayout csFastDelivery;
        private ImageView imgProduct;
        private RatingBarCustom csRating;
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
            tvPrice = view.findViewById(R.id.tvPrice);
            imgProduct = view.findViewById(R.id.imgProduct);
            csRating = view.findViewById(R.id.csRating);
            tvRating = view.findViewById(R.id.tvRating);
        }
    }
}

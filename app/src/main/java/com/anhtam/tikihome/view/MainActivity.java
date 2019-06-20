package com.anhtam.tikihome.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.anhtam.tikihome.R;
import com.anhtam.tikihome.base.BaseActivity;
import com.anhtam.tikihome.model.Badge;
import com.anhtam.tikihome.model.IProduct;
import com.anhtam.tikihome.model.Product;
import com.anhtam.tikihome.presenter.ProductAdapter;
import com.anhtam.tikihome.presenter.ProductPresenter;
import com.anhtam.tikihome.services.GPSService;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements IProduct.view {

    private ConstraintLayout csCheckBox;
    private boolean isTikiNow = true;
    private ImageView imgCheckBox;
    private TextView tvLocation;
    private RecyclerView rvProduct;
    private RecyclerView.LayoutManager layoutManager;
    private ProductAdapter mAdapter;
    private List<Product> arrProduct;
    private ProductPresenter mPresenter;
    private String currentAddress = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initControls();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    private void initView() {
        csCheckBox = findViewById(R.id.csCheckBox);
        imgCheckBox = findViewById(R.id.imgCheckBox);
        tvLocation = findViewById(R.id.tvLocation);
        rvProduct = findViewById(R.id.rvProduct);
        mPresenter = new ProductPresenter(this);
    }

    private void initData() {
        setCurrentAddress();
        layoutManager = new LinearLayoutManager(this);
        arrProduct = new ArrayList<>();
        mAdapter = new ProductAdapter(this, arrProduct);
        rvProduct.setLayoutManager(layoutManager);
        rvProduct.setAdapter(mAdapter);
        mPresenter.getListProduct();
    }

    private void initControls() {
        csCheckBox.setOnClickListener(v -> onCheckTikiNow());
    }

    private void onCheckTikiNow() {
        isTikiNow = !isTikiNow;
        imgCheckBox.setImageDrawable(isTikiNow ? getResources().getDrawable(R.drawable.ic_tick) : getResources().getDrawable(R.drawable.ic_untick));
        if (mAdapter != null)
            mAdapter.setList(getListProductSorted(arrProduct));
    }

    @Override
    public void onGetListProductSuccess(List<Product> arrProduct) {
        this.arrProduct = arrProduct;
        mAdapter.setList(getListProductSorted(arrProduct));
    }

    @Override
    public void onGetListProductFail(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private List<Product> getListProductSorted(List<Product> arrProduct) {
        List<Product> products = new ArrayList<>();
        for (Product product : arrProduct) {
            if (isTikiNow && product.hasTikiNow())
                products.add(product);
            else if (!isTikiNow && !product.hasTikiNow())
                products.add(product);
        }
        return products;
    }

    @Override
    public void onLocationChange() {
       //setCurrentAddress();
    }

    public void setCurrentAddress (){
        currentAddress = GPSService.getInstance().getAddress();
        String htmlString = "<u>" + currentAddress + "</u>";
        tvLocation.setText(Html.fromHtml(htmlString));
    }

    @Override
    public void onBackPressed() {

    }
}

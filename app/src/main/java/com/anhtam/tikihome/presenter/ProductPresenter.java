package com.anhtam.tikihome.presenter;

import com.anhtam.tikihome.model.IProduct;
import com.anhtam.tikihome.model.Product;
import com.anhtam.tikihome.services.ApiClient;
import com.anhtam.tikihome.services.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductPresenter implements IProduct.prensenter {
    private IProduct.view mView;

    public ProductPresenter(IProduct.view mView) {
        this.mView = mView;
    }

    @Override
    public void getListProduct() {
        ApiService apiService = ApiClient.getInstanse().getRetrofit().create(ApiService.class);
        Call<List<Product>> call = apiService.getListProduct();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (response.isSuccessful()){
                    mView.onGetListProductSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                mView.onGetListProductFail(t != null && t.getMessage() != null ? t.getMessage() : "Unknow error!");
            }
        });
    }
}

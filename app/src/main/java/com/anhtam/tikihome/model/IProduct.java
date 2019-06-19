package com.anhtam.tikihome.model;

import java.util.List;

public interface IProduct {
    interface view {
        void onGetListProductSuccess (List<Product> arrProduct);
        void onGetListProductFail (String message);
    }

    interface prensenter {
        void getListProduct ();
    }
}

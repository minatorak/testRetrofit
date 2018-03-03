package com.example.minatorak.testjsonplace;

import okhttp3.ResponseBody;
import retrofit2.Retrofit;

/**
 * Created by minatorak on 3/3/2018 AD.
 */

public interface OnNetworkCallbackListener {
    public void onResponse(Pojo pojo);
    public void onBodyError(ResponseBody responseBodyError);
    public void onBodyErrorIsNull();
    public void onFailure(Throwable t);
}

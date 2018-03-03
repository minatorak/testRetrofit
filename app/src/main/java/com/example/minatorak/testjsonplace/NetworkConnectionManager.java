package com.example.minatorak.testjsonplace;

import android.util.Log;

import com.example.minatorak.testjsonplace.api.JsonplaceholderService;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkConnectionManager {

    public NetworkConnectionManager(){

    }

    public void connect(final OnNetworkCallbackListener listener,String number){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonplaceholderService service = retrofit.create(JsonplaceholderService.class);
        Call<Pojo> call = service.getposts(number);
        call.enqueue(new Callback<Pojo>() {
            @Override
            public void onResponse(Call<Pojo> call, Response<Pojo> response) {
                    Log.d("issuccessful","yes");
                    Pojo pojo = response.body();
                    if (pojo != null){
                        listener.onResponse(pojo);
                    }else if (pojo == null){
                        ResponseBody responseBody = response.errorBody();
                        if (responseBody != null){
                            listener.onBodyError(responseBody);
                        } else {
                            listener.onBodyErrorIsNull();
                        }
                    }

            }

            @Override
            public void onFailure(Call<Pojo> call, Throwable t) {
                listener.onFailure(t);
            }
        });
    }

}

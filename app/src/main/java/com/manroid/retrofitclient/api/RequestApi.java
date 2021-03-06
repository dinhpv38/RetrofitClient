package com.manroid.retrofitclient.api;

import com.manroid.retrofitclient.result.Country;
import com.manroid.retrofitclient.result.CountryFromCode;
import com.manroid.retrofitclient.result.GeoNames;
import com.manroid.retrofitclient.result.User;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;


public interface RequestApi {

    @GET("rest/v1/all")
    Call<List<Country>> getCountry();

    @GET("/rest/v1/alpha?")
    Call<List<CountryFromCode>> getTasks(@Query("codes") String order);

    @Multipart
    @POST("media/UploadToServer.php")
    Call<ResponseBody> upload(@Part MultipartBody.Part file);

    @FormUrlEncoded
    @POST("citiesJSON?/")
    Call<GeoNames> createUser(@Field("north") String north, @Field("south") String south, @Field("east") String east,
                              @Field("west") String west, @Field("lang") String lang, @Field("username") String username);


    @Headers("Content-Type: application/json")
    @POST("/api/users")
    Call<User> createUserJson(@Body Map<String,String> request);


}

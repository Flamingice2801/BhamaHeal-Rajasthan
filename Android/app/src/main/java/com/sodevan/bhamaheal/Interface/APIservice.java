package com.sodevan.bhamaheal.Interface;

import com.sodevan.bhamaheal.Models.BhamData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by ronaksakhuja on 17/03/17.
 */

public interface APIservice {
    @GET("basic.php?")
    Call<String> writebasic(@Query("bhid")String a,@Query("aadhar")String aadhar,@Query("name") String name);

    @GET("health_one.php")
    Call<String> writeHealthOne(@Query("bhid")String a,@Query("aadhar") String ad,@Query("cholestrol") String ch,@Query("blood") String blood,@Query("hb") String hb,@Query("rbc") String rbc,@Query("platelets") String plate);

    @GET("health_two.php?")
    Call<String> writeHealthTwo(@Query("bhid")String a,@Query("aadhar") String aaad,@Query("lefteye") String lefteye,@Query("righteye") String righteye,@Query("height")String height,@Query("weight")String wght,@Query("sugar")String sugar,@Query("remarks")String remarks);

    @GET("health_three.php?")
    Call<String> writeHealthThree(@Query("bhamashah") String bham,@Query("aadhar") String aadaad,@Query("remark")String remark,@Query("type")String type);

    @GET("app/live/Service/hofAndMember/ForApp/{x}?client_id=ad7288a4-7764-436d-a727-783a977f1fe1")
    Call<BhamData> callbham(@Path("x") String bham);
}

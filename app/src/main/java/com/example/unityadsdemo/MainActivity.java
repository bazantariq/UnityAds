package com.example.unityadsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.services.banners.IUnityBannerListener;
import com.unity3d.services.banners.UnityBanners;

public class MainActivity extends AppCompatActivity{

    private String GameID="4245531";
    private String bannerPlacement="CpuBanner";
    private  boolean testMode=true;
    Button banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        banner=findViewById(R.id.banner);

        UnityAds.initialize(this,GameID, testMode);

        IUnityBannerListener bannerListener = new IUnityBannerListener() {
            @Override
            public void onUnityBannerLoaded(String s, View view) {
                ((ViewGroup)findViewById(R.id.banner_ad)).removeView(view);
                ((ViewGroup)findViewById(R.id.banner_ad)).addView(view);
            }

            @Override
            public void onUnityBannerUnloaded(String s) {

            }

            @Override
            public void onUnityBannerShow(String s) {

            }

            @Override
            public void onUnityBannerClick(String s) {

            }

            @Override
            public void onUnityBannerHide(String s) {

            }

            @Override
            public void onUnityBannerError(String s) {

            }
        };

        UnityBanners.setBannerListener(bannerListener);
       // UnityBanners.loadBanner(this,bannerPlacement);

        banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UnityBanners.loadBanner(MainActivity.this,bannerPlacement);
            }
        });




    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        UnityBanners.destroy();
    }
}
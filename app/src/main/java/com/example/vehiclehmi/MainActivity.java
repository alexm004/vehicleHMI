package com.example.vehiclehmi;


import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.IBinder;

import androidx.appcompat.app.AppCompatActivity;


import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;



import com.google.android.material.tabs.TabLayout;

import java.util.List;

import ServicePackage.aidlInterface;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private FragmentAdapter FragmentAdapter;
    private aidlInterface aidlObject;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout =  findViewById(R.id.tabLayout);
        viewPager2 =  findViewById(R.id.viewPager2);
        FragmentManager fm = getSupportFragmentManager();

        FragmentAdapter = new FragmentAdapter(fm, getLifecycle());
        viewPager2.setAdapter(FragmentAdapter);


        tabLayout.addTab(tabLayout.newTab().setText("Controls"));
        tabLayout.addTab(tabLayout.newTab().setText("Settings"));


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {


            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        bindtoAIDLService();

    }

    private void bindtoAIDLService() {

        Intent aidlServiceIntent = new Intent("connect_to_aidl_service");
        bindService(implicitIntentToExplicitIntent(aidlServiceIntent,this),serviceConnectionObject,BIND_AUTO_CREATE);
    }

    ServiceConnection serviceConnectionObject = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            aidlObject = aidlInterface.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    public static Intent implicitIntentToExplicitIntent(Intent implicitIntent, Context context) {
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> resolveInfoList = pm.queryIntentServices(implicitIntent, 0);

        if (resolveInfoList == null || resolveInfoList.size() != 1) {
            return null;
        }

        ResolveInfo serviceInfo = resolveInfoList.get(0);
        ComponentName component = new ComponentName(serviceInfo.serviceInfo.packageName, serviceInfo.serviceInfo.name);
        Intent explicitIntent = new Intent(implicitIntent);
        explicitIntent.setComponent(component);
        return explicitIntent;
    }
}
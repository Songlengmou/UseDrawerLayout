package com.example.admin.usedrawerlayout;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import static android.support.v4.widget.DrawerLayout.LOCK_MODE_LOCKED_CLOSED;

/**
 * 点击某一按钮实现右侧的侧滑显示
 */
public class MainActivity extends AppCompatActivity {
    private Button button;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        drawerLayout = findViewById(R.id.activity_na);
        navigationView = findViewById(R.id.nav);

        drawerLayout.setDrawerLockMode(LOCK_MODE_LOCKED_CLOSED);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerOpen(navigationView)) {
                    drawerLayout.closeDrawer(navigationView);
                } else {
                    drawerLayout.openDrawer(navigationView);
                }
            }
        });

        //Menu里的每个item监听
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.favorite:

                        break;
                }
                menuItem.setChecked(true); //设置菜单选中
                drawerLayout.closeDrawers();//当选中菜单后，就要关闭抽屉
                return false;
            }
        });
    }
}

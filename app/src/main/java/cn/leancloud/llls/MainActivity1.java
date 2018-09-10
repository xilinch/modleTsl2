package cn.leancloud.llls;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import cn.leancloud.llls.fragment.MainFragment;
import cn.leancloud.llls.fragment.SettingFragment;

/**
 *
 * describe 该类主要完成以下功能
 */

public class MainActivity1 extends AppCompatActivity {

    private LinearLayout ll_container;

    private RadioButton rg_main;

    private RadioButton rg_settings;

    private RadioGroup rg_tab;

    private MainFragment mainFragment;
    private SettingFragment settingFragment;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_main);
        rg_tab= (RadioGroup) findViewById(R.id.rg_tab);
        rg_settings= (RadioButton) findViewById(R.id.rg_settings);
        rg_main= (RadioButton) findViewById(R.id.rg_main);
        ll_container= (LinearLayout)findViewById(R.id.ll_container);
        rg_tab.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rg_main:
                        showFragment(0);
                        break;
                    case R.id.rg_settings:
                        showFragment(1);
                        break;
                }
            }
        });
        showFragment(0);
    }

    private void showFragment(int index){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        hideFragment(fragmentTransaction);
        if(index == 0){
            if(mainFragment == null){
                mainFragment = new MainFragment();
                fragmentTransaction.add(R.id.ll_container, mainFragment).commit();
            } else {
                fragmentTransaction.show(mainFragment).commit();
            }


        } else if(index == 1){
            if(settingFragment == null){
                settingFragment = new SettingFragment();
                fragmentTransaction.add(R.id.ll_container, settingFragment).commit();
            } else {
                fragmentTransaction.show(settingFragment).commit();
            }
        }
    }

    private void hideFragment(FragmentTransaction fragmentTransaction){
        if(mainFragment != null){
            fragmentTransaction.hide(mainFragment);
        }
        if(settingFragment != null){
            fragmentTransaction.hide(settingFragment);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
